/*
 * CS2852.011
 * Spring 2017
 * SmallWorld
 * Eric Nowac
 * Created 5/21/2017
 */
package nowace.Entities.ParticleSystems.Particles;

import nowace.Entities.Entity;

/**
 * @author nowace
 * @version 2017.05.21
 */
public abstract class Particle extends Entity {
    protected double lifeSpan;

    @Override
    public void update(double deltaTime) {
        lifeSpan-=deltaTime;
        if(lifeSpan<=0){
            this.dead = true;
        }
    }
}
