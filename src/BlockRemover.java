/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the Class BlockRemover.
 * BlockRemover is in charge of removing blocks from the gameLevel, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Constructor.
     *
     * @param gameLevel1         given gameLevel.
     * @param removedBlocks block to be removed.
     */
    public BlockRemover(GameLevel gameLevel1, Counter removedBlocks) {
        gameLevel = gameLevel1;
        remainingBlocks = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(gameLevel);
        remainingBlocks.decrease(1);
    }
}
