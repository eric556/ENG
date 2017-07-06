/*
 * Summer 2017
 * SmallWorld
 * Eric Nowac
 * Created 6/21/2017
 */
package nowace.Game;

import javafx.beans.NamedArg;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import nowace.Entities.Entity;
import nowace.Math.Vector;

import java.util.LinkedList;
import java.util.List;

/**
 * @author nowace
 * @version 2017.06.21
 */
public abstract class Game extends Scene {

    protected UpdateLoop updateLoop;
    protected DrawLoop drawLoop;
    protected List<Entity> entities;
    public static Vector windowSize;


    public Game(@NamedArg("root") Parent root, Canvas canvas, @NamedArg("width") double width, @NamedArg("height") double height) {
        super(root, width, height);
        entities = new LinkedList<>();
        updateLoop = new UpdateLoop(entities);
        drawLoop = new DrawLoop(canvas, entities);
        windowSize = new Vector(canvas.getWidth(),canvas.getHeight());
    }

    public void start(){
        updateLoop.start();
        drawLoop.start();
    }
}
