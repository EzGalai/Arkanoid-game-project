import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the class LevelBackground.
 * this class in charge on the levels background.
 */
public class LevelBackground implements Sprite {
    private Color color;

    /**
     * constructor.
     *
     * @param color1 the back ground color.
     */
    public LevelBackground(Color color1) {
        this.color = color1;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle((int) GameLevel.BORDER_THICK, (int) GameLevel.BORDER_THICK, Point.WIDTH
                - (int) GameLevel.BORDER_THICK, Point.HEIGHT - (int) GameLevel.BORDER_THICK);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);

    }
}
