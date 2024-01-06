import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the class AnimationRunner.
 * this class takes an Animation object and runs it.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * Constructor.
     *
     * @param gui     a given GUI.
     * @param sleeper a given Sleeper
     */
    public AnimationRunner(GUI gui, Sleeper sleeper) {
        this.gui = gui;
        this.framesPerSecond = 60;
        this.sleeper = sleeper;
    }

    /**
     * this method combines game-specific logic with frame-rate and time-tracking code.
     *
     * @param animation a given animation.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}