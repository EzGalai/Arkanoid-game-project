import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

// The CountdownAnimation will

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the class CountdownAnimation.
 * this class display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private int counter;
    private Sleeper sleeper;

    /**
     * constructor.
     *
     * @param numOfSeconds given seconds.
     * @param countFrom    from which number start counting.
     * @param gameScreen   a given screen.
     * @param sleeper      .
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, Sleeper sleeper) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.counter = 0;
        this.sleeper = sleeper;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (countFrom - counter == 0) {
            stop = true;
        }
        if (counter != 0) {
            sleeper.sleepFor((long) ((numOfSeconds / countFrom) * 2000));
        }
        gameScreen.drawAllOn(d);
        d.setColor(Color.black);
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, Integer.toString(countFrom - counter), 60);
        counter++;
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }
}