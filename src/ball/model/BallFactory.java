package ball.model;

import ball.Ball;
import ball.behavior.BouncingBehavior;
import ball.behavior.ElasticBehavior;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 150),
                elasticBall(275, 150),
                bouncingElasticBall(475, 150),
        };
    }

    private static Ball bouncingElasticBall(int centerX, int centerY) {
        return new CompositionBall(centerX, centerY, ElasticBehavior.shrink(), BouncingBehavior.down());
    }

    public static Ball bouncingBall(int centerX, int centerY) {
        return new CompositionBall(centerX, centerY, BouncingBehavior.down());
    }

    public static Ball elasticBall(int centerX, int centerY) {
        return new CompositionBall(centerX, centerY,  ElasticBehavior.shrink());
    }
}
