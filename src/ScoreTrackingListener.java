/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the Class ScoreTrackingListener.
 * update this counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Constructor.
     *
     * @param scoreCounter a score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.addHitListener(this);
        currentScore.increase(5);
    }
}
