import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * The class SpriteCollection.
 * The class hold a collection of sprites.
 */
public class SpriteCollection {
    private List<Sprite> spriteList;

    /**
     * constructor.
     * this method initializing a list of sprite.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<>();
    }

    /**
     * this method is adding a given sprite to the list.
     *
     * @param s the given sprite.
     */
    public void addSprite(Sprite s) {
        spriteList.add(s);
    }

    /**
     * notifying that time passed.
     */
    public void notifyAllTimePassed() {
        List<Sprite> copySprites = new ArrayList<>(spriteList);
        for (Sprite s : copySprites) {
            s.timePassed();
        }
    }

    /**
     * this call drawOn on all sprites.
     *
     * @param d the given surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite c : spriteList) {
            c.drawOn(d);
        }
    }

    /**
     * removing Sprite.
     *
     * @param s a given Sprite.
     */
    public void removeSprite(Sprite s) {
        spriteList.remove(s);
    }
}

