/*
 * Summer 2017
 * ENG
 * Eric Nowac
 * Created 6/5/2017
 */
package nowace.Game;

import javafx.animation.AnimationTimer;

/**
 * @author nowace
 * @version 2017.06.05
 */
public class Loop extends AnimationTimer {

    private long previous = 0;
    protected double deltaTime = 0;
    private int i = 0;
    private double averageFPS = 0;

    @Override
    public void handle(long now) {
        deltaTime = (now - previous) * 1e-9;
        previous = now;
    }

    private void printFPS(){
        if(i == 50) {
            System.out.println("Average fps: " + (averageFPS/i));
            i = 0;
            averageFPS = 0;
        }else{
            averageFPS+=(1/deltaTime);
            i++;
        }
    }
}
