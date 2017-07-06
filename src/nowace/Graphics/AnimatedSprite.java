package nowace.Graphics;

import nowace.Math.Vector;

/**
 * Created by enpie on 7/5/2017.
 */
public class AnimatedSprite extends Sprite {
    public AnimatedSprite(Texture initial, Vector position, Vector velocity, Vector origin, double speed, double rotation, boolean dead) {
        super(initial, position, velocity, origin, speed, rotation, dead);
    }
}
