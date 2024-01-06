/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the Class BlockRemover.
 * BallRemover is in charge of removing balls from the gameLevel, as well as keeping count
 * of the number of balls that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Constructor.
     *
     * @param gameLevel1        given gameLevel.
     * @param removedBalls balls to be removed.
     */
    public BallRemover(GameLevel gameLevel1, Counter removedBalls) {
        gameLevel = gameLevel1;
        remainingBalls = removedBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(gameLevel);
        remainingBalls.decrease(1);
    }
}
