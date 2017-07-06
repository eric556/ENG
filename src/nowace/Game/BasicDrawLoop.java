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
import javafx.scene.paint.Color;
import nowace.Entities.Entity;

import java.util.List;

/**
 * @author nowace
 * @version 2017.05.12
 */
public class BasicDrawLoop extends Loop {

    private Canvas canvas;
    private List<Entity> entities;
    private Color clearColor;

    public BasicDrawLoop(Canvas canvas, List<Entity> entities){
        this.canvas = canvas;
        this.entities = entities;
        this.clearColor = Color.BLACK;
    }

    @Override
    public void handle(long now) {
        super.handle(now);
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.getGraphicsContext2D().setStroke(clearColor);
        canvas.getGraphicsContext2D().setFill(clearColor);
        canvas.getGraphicsContext2D().fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        entities.forEach(entity -> {
            entity.draw(canvas.getGraphicsContext2D());
        });
        //printFPS();
    }

    public void setClearColor(Color color){
        clearColor = color;
    }
}
