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
public class BasicUpdateLoop extends Loop {

    private List<Entity> entities;
    public static List<Entity> spawnList = new LinkedList<>();

    public BasicUpdateLoop(List<Entity> entities){
        this.entities = entities;
    }

    @Override
    public void handle(long now) {
        super.handle(now);
        List<Entity> forRemoval = new LinkedList<>();
        entities.forEach(entity -> {
            entity.update(deltaTime);
            entity.checkCollisions(entities);
            if (entity.isDead()) {
                forRemoval.add(entity);
            }
        });

        entities.removeAll(forRemoval);
        if (!spawnList.isEmpty()) {
            entities.addAll(spawnList);
            spawnList.clear();
        }
    }
}
