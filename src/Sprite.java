import biuoop.DrawSurface;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the Sprite interface.
 * Sprite is implemented by several classes.it has the signatures of drawOn an
 * timePassed which the classes that implements Sprite are implementing.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d the given surface.
     */
    void drawOn(DrawSurface d);

    /**
     * this method notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * this method adding collidables or sprites to the game.
     *
     * @param g the given game environment.
     */
    void addToGame(GameLevel g);
}
