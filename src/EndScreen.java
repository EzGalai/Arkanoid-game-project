import biuoop.DrawSurface;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the class EndScreen.
 * this class displaying a message to screen if a game is won or lost.
 */
public class EndScreen implements Animation {
    private int score;
    private boolean isRemainingBalls;

    /**
     * constructor.
     *
     * @param score            a given score.
     * @param isRemainingBalls number of remaining balls.
     */
    public EndScreen(int score, boolean isRemainingBalls) {
        this.score = score;
        this.isRemainingBalls = isRemainingBalls;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (!isRemainingBalls) {
            d.drawText(10, d.getHeight() / 2, "Game Over. your score is " + score, 32);
        } else {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + score, 32);
        }

    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}