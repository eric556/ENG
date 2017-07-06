package nowace.Entities;

import javafx.scene.canvas.GraphicsContext;
import nowace.Math.BoundingGeometry.Bound;
import nowace.Math.Vector;

import java.util.List;

public abstract class Entity {

    protected Vector position;
    protected Vector velocity;
    protected Vector origin;
    protected double rotation;
    protected double speed;
    protected boolean dead;
    protected Bound bound;

    public void draw(GraphicsContext context){
        context.save();
        context.translate(position.getX(),position.getY());
        context.rotate(rotation);
    }
    public void update(double deltaTime){
        position = position.add(velocity.scalar(deltaTime));
    }
    public abstract void takeDamage(int amount);

    public abstract boolean checkCollisions(List<Entity> entities);

    public boolean isDead(){
        return dead;
    }

    public Vector getPosition(){
        return position;
    }

    public void setPosition(Vector position){
        this.position = position;
    }

    public Vector getOrigin(){
        return origin;
    }

    public void setOrigin(Vector origin){
        this.origin = origin;
    }

    public Vector getVelocity(){
        return velocity;
    }

    public void setVelocity(Vector vel){
        this.velocity = vel;
    }

    public double getRotation(){
        return this.rotation;
    }

    public void setRotation(double rotation){
        this.rotation = rotation;
    }

    public Bound getBound(){
        return this.bound;
    }
}
