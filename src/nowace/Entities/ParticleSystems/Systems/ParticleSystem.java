/*
 * Spring 2017
 * SmallWorld
 * Eric Nowac
 * Created 5/21/2017
 */
package nowace.Entities.ParticleSystems.Systems;

import nowace.Entities.Entity;
import nowace.Entities.ParticleSystems.Particles.Particle;

import java.util.List;

/**
 * @author nowace
 * @version 2017.05.21
 */
public abstract class ParticleSystem extends Entity{

    protected List<Particle> particles;
    protected double particleLifeSpan;
    protected boolean repeating;

    @Override
    public void update(double deltaTime) {
        super.update(deltaTime);
    }
}

