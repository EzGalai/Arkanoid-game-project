/**
 * @author Ezra Galya
 * @version 13.0.2
 * @since 2020-01-14
 * The class HitListener .
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is .
     *
     * @param beingHit the block that's been hit.
     * @param hitter   the Ball that's doing the hitting
     */
    void hitEvent(Block beingHit, Ball hitter);
}