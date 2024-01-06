import biuoop.DrawSurface;
/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the class PauseScreen.
 * this class pausing the screen by pressing on a keyboard.
 */
public class PauseScreen implements Animation {
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}