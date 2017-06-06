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
public class BoundingBox extends Bound {
    private Vector size;

    public BoundingBox(Vector position, Vector size){
        this.position = position;
        this.size = size;
    }

    @Override
    public boolean intersects(Bound other) {

        if(other instanceof BoundingBox){
            BoundingBox box = (BoundingBox)other;

            if(this.position.getX() < box.position.getX() + box.size.getX() &&
                    this.position.getX() + this.size.getX() > box.position.getX() &&
                    this.position.getY() < box.position.getY() + box.size.getY() &&
                    this.size.getY() + this.position.getY() > box.position.getY()){
                return true;
            }else{
                return false;
            }
        }else if(other instanceof BoundingCircle){

        }

        return false;
    }

    @Override
    public void draw(GraphicsContext context) {

    }

    public Vector getSize() {
        return size;
    }

    public void setSize(Vector size) {
        this.size = size;
    }
}
