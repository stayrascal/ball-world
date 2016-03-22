package ball.model;

import ball.Ball;
import ball.behavior.Behavior;

import java.awt.*;

public class CompositionBall implements Ball {

    private int centerX;
    private int centerY;
    private Behavior[] behaviors;
    private int radius;

    public CompositionBall(int centerX, int centerY, Behavior... behaviors) {
        this(centerX, centerY, DEFAULT_RADIUS, behaviors);
    }

    public CompositionBall(int centerX, int centerY, int radius,  Behavior[] behaviors) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.behaviors = behaviors;
        this.radius = radius;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public int radius() {
        return radius;
    }

    @Override
    public Point center() {
        return new Point(centerX, centerY);
    }

    @Override
    public void update() {
        for (Behavior behavior : behaviors){
            behavior.changeStatus(this);
        }
    }
}
