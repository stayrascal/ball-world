package ball.behavior;

import ball.Ball;
import ball.model.CompositionBall;

public class ElasticBehavior implements Behavior {
    public static final int GROWTH_RATE = 2;

    private static final int GROW = 1;
    private static final int SHRINK = -1;

    private int growthDirection;

    public ElasticBehavior(int growthDirection) {
        this.growthDirection = growthDirection;
    }

    public static Behavior shrink() {
        return new ElasticBehavior(SHRINK);
    }

    @Override
    public void changeStatus(CompositionBall ball) {
        growthDirection = reverseGrowthDirectionIfNecessary(ball);
        ball.setRadius(nextRadius(ball));
    }

    private int reverseGrowthDirectionIfNecessary(CompositionBall ball) {
        if (growingTooBig(ball) || shrinkingTooSmall(ball)) {
            return switchDirection();
        }

        return this.growthDirection;
    }

    private boolean shrinkingTooSmall(CompositionBall ball) {
        return ball.getRadius() <= 0 && shrinking();
    }

    private boolean growingTooBig(CompositionBall ball) {
        return ball.getRadius() >= Ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    private int nextRadius(CompositionBall ball) {
        return ball.getRadius() + (GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == SHRINK;
    }

    private boolean growing() {
        return growthDirection == GROW;
    }
}
