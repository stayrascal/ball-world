package ball.behavior;

import ball.model.CompositionBall;
import ball.ui.BallWorld;

public class BouncingBehavior implements Behavior {

    public static final int MOVEMENT_SPEED = 12;

    public static final int DOWN = 1;
    public static final int UP = -1;

    private int direction;

    public BouncingBehavior(int direction) {
        this.direction = direction;
    }

    public static Behavior down() {
        return new BouncingBehavior(DOWN);
    }

    @Override
    public void changeStatus(CompositionBall ball) {
        ball.setCenterY(ball.getCenterY() + MOVEMENT_SPEED * direction);
        direction = reverseDirectionIfNecessary(ball);
    }


    private int reverseDirectionIfNecessary(CompositionBall ball) {
        if (movingTooHigh(ball) || movingTooLow(ball)) {
            return switchDirection();
        }

        return this.direction;
    }

    private boolean movingTooLow(CompositionBall ball) {
        return ball.getCenterY() + ball.getRadius() >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh(CompositionBall ball) {
        return ball.getCenterY() - ball.getRadius() <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? UP : DOWN;
    }

    private boolean movingDown() {
        return direction == DOWN;
    }

    private boolean movingUp() {
        return direction == UP;
    }
}
