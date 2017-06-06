/*
 * CS2852.011
 * Spring 2017
 * SmallWorld
 * Eric Nowac
 * Created 5/13/2017
 */
package nowace.Math.BoundingGeometry;

import javafx.scene.canvas.GraphicsContext;
import nowace.Math.Vector;

/**
 * @author nowace
 * @version 2017.05.13
 */
public abstract class Bound {
    protected Vector position;
    public abstract boolean intersects(Bound other);
    public abstract void draw(GraphicsContext context);

    public Vector getPosition(){
        return position;
    }

    public void setPosition(Vector position){
        this.position = position;
    }
}
