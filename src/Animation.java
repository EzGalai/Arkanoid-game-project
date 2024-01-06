import biuoop.DrawSurface;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the interface Animation.
 */
public interface Animation {
    /**
     * this method handling the game-specific logic .
     *
     * @param d a given DrawSurface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * this method handling the stopping conditions.
     *
     * @return true or false.
     */
    boolean shouldStop();
}
