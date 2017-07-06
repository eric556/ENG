/*
 * CS2852.011
 * Spring 2017
 * SmallWorld
 * Eric Nowac
 * Created 5/12/2017
 */
package nowace.Game;

import javafx.animation.AnimationTimer;
import nowace.Entities.Entity;
import nowace.Math.Vector;

import java.util.LinkedList;
import java.util.List;

/**
 * @author nowace
 * @version 2017.05.12
 */
public class UpdateLoop extends AnimationTimer {
    private long previous = 0;
    private double deltaTime = 0;
    private int i = 0;
    private double averageFPS = 0;

    private List<Entity> entities;
    public static List<Entity> spawnList = new LinkedList<>();

    public UpdateLoop(List<Entity> entities){
        this.entities = entities;
    }

    @Override
    public void handle(long now) {
        deltaTime = (now - previous) * 1e-9;
        previous = now;
        List<Entity> forRemoval = new LinkedList<>();
        entities.forEach(entity -> {
            entity.update(deltaTime);
            entity.checkCollisions(entities);
            if(entity.isDead()){
                forRemoval.add(entity);
            }
        });

        entities.removeAll(forRemoval);
        if(!spawnList.isEmpty()){
            entities.addAll(spawnList);
            spawnList.clear();
        }

        //printFPS();
        keepInBounds(Game.windowSize);
        capSpeed(300);
    }

    private void printFPS(){
        if(i == 50) {
            System.out.println("Updates: " + (averageFPS/i));
            i = 0;
            averageFPS = 0;
        }else{
            averageFPS+=(1/deltaTime);
            i++;
        }
    }

    private void keepInBounds(Vector bounds){
        entities.forEach(entity -> {
            if(entity.getPosition().getX() > bounds.getX()){
                entity.setPosition(new Vector(0,entity.getPosition().getY()));
            }
            if(entity.getPosition().getY() > bounds.getY()){
                entity.setPosition(new Vector(entity.getPosition().getX(),0));
            }
            if(entity.getPosition().getX() < 0){
                entity.setPosition(new Vector(bounds.getX(),entity.getPosition().getY()));
            }
            if(entity.getPosition().getY() < 0){
                entity.setPosition(new Vector(entity.getPosition().getX(), bounds.getY()));
            }
        });
    }

    private void capSpeed(double speedCap){
        entities.forEach(entity -> {
            if(Math.abs(entity.getVelocity().getX()) > speedCap){
                entity.setVelocity(new Vector(Math.copySign(speedCap,entity.getVelocity().getX()),entity.getVelocity().getY()));
            }
            if(Math.abs(entity.getVelocity().getY()) > speedCap){
                entity.setVelocity(new Vector(entity.getVelocity().getX(),Math.copySign(speedCap,entity.getVelocity().getY())));
            }
        });
    }
}
