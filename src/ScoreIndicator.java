import biuoop.DrawSurface;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the class ScoreIndicator.
 * The class in charge of displaying the current score
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    private Point location;
    private LevelInformation levelInformation;

    /**
     * Constructor.
     *
     * @param score1           given score.
     * @param location1        given location.
     * @param levelInformation .
     */
    public ScoreIndicator(Counter score1, Point location1, LevelInformation levelInformation) {
        this.score = score1;
        this.location = location1;
        this.levelInformation = levelInformation;
    }

    @Override
    public void drawOn(DrawSurface d) {
        //drawing the score to the screen.
        d.drawText((int) location.getX(), (int) location.getY(), "Score: " + score.getValue(), 20);
        d.drawText((int) location.getX() + 200, (int) location.getY(),
                "Level Name: " + levelInformation.levelName(), 20);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
    }
}
