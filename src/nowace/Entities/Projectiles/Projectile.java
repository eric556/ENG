/*
 * CS2852.011
 * Spring 2017
 * SmallWorld
 * Eric Nowac
 * Created 5/12/2017
 */
package nowace.Entities.Projectiles;

import nowace.Entities.Entity;
import nowace.Math.Vector;

/**
 * @author nowace
 * @version 2017.05.12
 */
public abstract class Projectile extends Entity {
    protected Entity sender;
    protected double speed;

    @Override
    public void update(double deltaTime) {
        super.update(deltaTime);
    }
}
