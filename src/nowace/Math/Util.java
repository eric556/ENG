/*
 * CS2852.011
 * Spring 2017
 * SmallWorld
 * Eric Nowac
 * Created 5/21/2017
 */
package nowace.Math;

import nowace.Entities.Entity;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author nowace
 * @version 2017.05.21
 */
public final class Util {

    public static Vector PointOnCircle(double radius, Vector position){
        double randomRotation = RandomDouble(0,2 * Math.PI);
        return (new Vector(Math.cos(randomRotation) + position.getX(),Math.sin(randomRotation) + position.getY())).scalar(radius);
    }

    public static double RandomDouble(double lower, double upper){
        return ThreadLocalRandom.current().nextDouble(lower, upper);
    }

    public static int RandomInt(int lower, int upper){
        return ThreadLocalRandom.current().nextInt(lower, upper);
    }

    public static Vector AngleToVector(double angle){
        double rad = Math.toRadians(angle);
        return new Vector(Math.cos(rad),Math.sin(rad));
    }

    public static Vector VectorRelativeToEntity(Vector other, Entity entity){
        return VectorRelativeToEntity(other,entity,0);
    }

    public static Vector VectorRelativeToEntity(Vector other, Entity entity, double rotOffset){
        double rot = other.getTheta();
        return AngleToVector(rotOffset + rot + entity.getRotation()).scalar(other.magnitude());
    }
}
