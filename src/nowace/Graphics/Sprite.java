package nowace.Graphics;

import javafx.scene.canvas.GraphicsContext;
import nowace.Entities.Entity;
import nowace.Math.Vector;

import java.util.List;

/**
 * Created by enpie on 7/5/2017.
 */
public class Sprite extends Entity{
    private Texture texture;

    public Sprite(Texture texture, Vector position, Vector velocity, Vector origin, double speed, double rotation, boolean dead){
        this.texture = texture;
        this.position = position;
        this.velocity = velocity;
        this.origin = origin;
        this.speed = speed;
        this.rotation = rotation;
        this.dead = dead;
    }

    public Sprite(Texture texture, Vector position, Vector velocity, Vector origin, double speed, double rotation){
        this(texture,position,velocity,origin,speed,rotation, false);
    }

    public Sprite(Texture texture, Vector position, Vector velocity, Vector origin, double speed){
        this(texture,position,velocity,origin,speed,0);
    }

    public Sprite(Texture texture, Vector position, Vector velocity, Vector origin){
        this(texture,position,velocity,origin,0);
    }

    public Sprite(Texture texture, Vector position, Vector velocity){
        this(texture,position,velocity,new Vector());
    }

    public Sprite(Texture texture, Vector position){
        this(texture,position,new Vector());
    }

    public Sprite(Texture texture){
        this(texture,new Vector());
    }

    @Override
    public void draw(GraphicsContext context) {
        super.draw(context);
        context.drawImage(texture.getImage(),0-origin.getX(),0-origin.getY());
        context.restore();
    }

    @Override
    public void update(double deltaTime) {
        super.update(deltaTime);
    }

    @Override
    public void takeDamage(int amount) {

    }

    @Override
    public boolean checkCollisions(List<Entity> entities) {
        return false;
    }
}
