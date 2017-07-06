/*
 * CS2852.011
 * Spring 2017
 * SmallWorld
 * Eric Nowac
 * Created 5/12/2017
 */
package nowace.Game;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import nowace.Entities.Entity;

import java.util.List;

/**
 * @author nowace
 * @version 2017.05.12
 */
public class DrawLoop extends AnimationTimer {

    private Canvas canvas;
    private List<Entity> entities;
    private int i = 0;
    private double averageFPS = 0;
    private long previous = 0;
    private double deltaTime = 0;

    public DrawLoop(Canvas canvas, List<Entity> entities){
        this.canvas = canvas;
        this.entities = entities;
    }

    @Override
    public void handle(long now) {
        deltaTime = (now - previous) * 1e-9;
        previous = now;

        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.getGraphicsContext2D().fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        entities.forEach(entity -> {
            entity.draw(canvas.getGraphicsContext2D());
        });
        //printFPS();
    }

    private void printFPS(){
        if(i == 50) {
            System.out.println("Draw Updates: " + (averageFPS/i));
            i = 0;
            averageFPS = 0;
        }else{
            averageFPS+=(1/deltaTime);
            i++;
        }
    }

}
