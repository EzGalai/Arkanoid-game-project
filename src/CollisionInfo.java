/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * The class CollisionInfo.
 * the class holds the information for the location and objects
 * of where the collision occurred.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collidable;

    /**
     * initialing collision info with collaidable and location.
     *
     * @param collisionPoint1 the location of collision.
     * @param collidable1     the collidable object.
     */
    public CollisionInfo(Point collisionPoint1, Collidable collidable1) {
        this.collisionPoint = collisionPoint1;
        this.collidable = collidable1;
    }

    /**
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collidable;

    }
}