/*
 * CS2852.011
 * Spring 2017
 * SmallWorld
 * Eric Nowac
 * Created 5/13/2017
 */
package nowace.Math.BoundingGeometry;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import nowace.Math.Vector;

/**
 * @author nowace
 * @version 2017.05.13
 */
public class BoundingCircle extends Bound {
    private double radius;


    public BoundingCircle(Vector position, double radius){
        this.position = position;
        this.radius = radius;
    }

    @Override
    public boolean intersects(Bound other) {
        if(other instanceof BoundingCircle){
            BoundingCircle circle = (BoundingCircle)other;
            double distance = this.position.distanceSQRT(circle.position);
            if(distance < this.radius+circle.radius){
                return true;
            }else{
                return false;
            }
        }else if(other instanceof BoundingBox){
            BoundingBox box = (BoundingBox)other;

        }
        return false;
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setStroke(Color.RED);
        context.strokeOval(position.getX()-radius,position.getY()-radius,radius*2,radius*2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
