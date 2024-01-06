import java.util.List;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the interface LevelInformation.
 */
public interface LevelInformation {
    /**
     * @return number of balls.
     */
    int numberOfBalls();

    /**
     * The method initials velocity of each ball.
     *
     * @return a list of Balls.
     */
    List<Velocity> initialBallVelocities();

    /**
     * This method handling the speed of the paddle.
     *
     * @return the speed.
     */
    int paddleSpeed();

    /**
     * This method setting the width of the paddle.
     *
     * @return the speed.
     */
    int paddleWidth();

    /**
     * The level name will be displayed at the top of the screen.
     *
     * @return a String.
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return a Sprite.
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return a List of Blocks.
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed.
     *
     * @return int.
     */
    int numberOfBlocksToRemove();
}