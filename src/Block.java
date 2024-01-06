import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * The class Block.
 * the class creating blocks with color that can be collidable.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * constructor.
     * initializing this block with rectangle and color.
     *
     * @param rect1  the shape of the block.
     * @param color1 the color of the block.
     */
    public Block(Rectangle rect1, Color color1) {
        rect = rect1;
        color = color1;
        hitListeners = new ArrayList<>();
    }

    /**
     * @return the "collision shape" of the object.
     */
    public Rectangle getCollisionRectangle() {
        return rect;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     *
     * @param hitter          the hitting ball.
     * @param collisionPoint  the coordinate at which the collision occurs.
     * @param currentVelocity the current velocity of the object.
     * @return the new velocity expected after the hit
     * (based on the force the object inflicted on us).
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //The lines of this block.
        Line upper = new Line(rect.getUpperLeft().getX(), rect.getUpperLeft().getY(), rect.getUpperLeft().getX()
                + rect.getWidth(), rect.getUpperLeft().getY());
        Line bottom = new Line(rect.getUpperLeft().getX(), rect.getUpperLeft().getY() + rect.getHeight(),
                rect.getUpperLeft().getX() + rect.getWidth(), rect.getUpperLeft().getY() + rect.getHeight());
        Line leftWidth = new Line(rect.getUpperLeft().getX(), rect.getUpperLeft().getY(), rect.getUpperLeft().getX(),
                rect.getUpperLeft().getY() + rect.getHeight());
        Line rightWidth = new Line(rect.getUpperLeft().getX() + rect.getWidth(), rect.getUpperLeft().getY(),
                rect.getUpperLeft().getX() + rect.getWidth(), rect.getUpperLeft().getY() + rect.getHeight());
        //changing y direction of the object
        if ((upper.onTheLine(collisionPoint) && currentVelocity.getDy() > 0)
                || (bottom.onTheLine(collisionPoint) && currentVelocity.getDy() < 0)) {
            currentVelocity.setDy(currentVelocity.getDy() * -1);
        }
        //changing x direction of object.
        if ((rightWidth.onTheLine(collisionPoint) && currentVelocity.getDx() < 0)
                || (leftWidth.onTheLine(collisionPoint) && currentVelocity.getDx() > 0)) {
            currentVelocity.setDx(currentVelocity.getDx() * -1);
        }
        this.notifyHit(hitter);
        //no collision occur
        return currentVelocity;
    }

    /**
     * this method drawing a rectangle.
     *
     * @param d the given surface.
     */
    public void drawOn(DrawSurface d) {
        //setting a color.
        d.setColor(color);
        d.fillRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(), (int) rect.getWidth(),
                (int) rect.getHeight());
        //bordering the rectangles.
        d.setColor(Color.black);
        d.drawRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(), (int) rect.getWidth(),
                (int) rect.getHeight());
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * removing this from gameLevel.
     *
     * @param gameLevel a given GameLevel.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    /**
     * notify all of the registered HitListener objects by calling their hitEvent method.
     *
     * @param hitter the hitting ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}
