/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the Collidable interface.
 * Collidable is implemented by several classes.it has the signatures of getCollisionRectangle
 * and hit, which the classes that implements Collidable are implementing.
 */
public interface Collidable {
    /**
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * the method changes the velocity of an object after a collision with an object.
     *
     * @param hitter          the hitting ball.
     * @param collisionPoint  the coordinate at which the collision occurs.
     * @param currentVelocity the current velocity of the object.
     * @return the new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}