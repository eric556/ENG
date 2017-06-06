/*
 * CS2852.011
 * Spring 2017
 * SmallWorld
 * Eric Nowac
 * Created 5/10/2017
 */
package nowace.Math;

/**
 * @author nowace
 * @version 2017.05.10
 */
public class Vector {
    private final double x;
    private final  double y;

    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector(Vector other){
        this.x = other.x;
        this.y = other.y;
    }

    public Vector(){
        this.x = 0;
        this.y = 0;
    }

    public double distanceSQRT(Vector other){
        return Math.sqrt(Math.pow(other.getX()-this.getX(),2)+Math.pow(other.getY()-this.getY(),2));
    }

    public double distanceSQR(Vector other){
        return Math.pow(other.getX()-this.getX(),2)+Math.pow(other.getY()-this.getY(),2);

    }

    public double magnitude(){
        return Math.sqrt(Math.pow(this.getX(),2)+Math.pow(this.getY(),2));
    }

    public Vector add(Vector other){
        return new Vector(this.x + other.x, this.y + other.y);
    }

    public Vector subtract(Vector other){
        return new Vector(other.x - this.x, other.y - this.y);
    }

    public Vector scalar(double scalar){
        return new Vector(this.x * scalar, this.y * scalar);
    }

    public double dot(Vector other){
        return other.x * this.x + other.y * this.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR(){
        return this.distanceSQRT(new Vector());

    }

    public double getTheta(){
        return Math.atan2(this.getY(),this.getX());
    }
}
