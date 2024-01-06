import java.util.ArrayList;
import java.util.List;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * The class GameEnvironment.
 * As is name indicate this class is a collection of object that are in the game environment.
 */
public class GameEnvironment {
    private List<Collidable> collidableList;

    /**
     * Constructor.
     * initalzing a list of collidables.
     */
    public GameEnvironment() {
        this.collidableList = new ArrayList<>();
    }

    /**
     * the method the given collidable to the environment.
     *
     * @param c a given Collidable.
     */
    public void addCollidable(Collidable c) {
        collidableList.add(c);
    }

    /**
     * the method check if there's any collidables items in a given trajectory.
     *
     * @param trajectory the object movement.
     * @return null if there is no collision with any of the collidables
     * or Collision info if there is a collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //there's no collidables at all.
        if (collidableList.isEmpty()) {
            return null;
        } else {
            Collidable minCollidable = collidableList.get(0);
            //iterating the list of collidables.
            for (Collidable c : collidableList) {
                //if the collision point of minCollidable is bigger then other collision point in collidableList.
                if (trajectory.start().distance(trajectory.closestIntersectionToStartOfLine(minCollidable.
                        getCollisionRectangle())) > trajectory.start().distance(trajectory.
                        closestIntersectionToStartOfLine(c.getCollisionRectangle()))) {
                    //update
                    minCollidable = c;
                }
            }
            //the collision point of minCollidable is null there's no collision.
            if (trajectory.closestIntersectionToStartOfLine(minCollidable.getCollisionRectangle()) == null) {
                return null;
            }
            //returning the object and the collision point.
            return new CollisionInfo(trajectory.closestIntersectionToStartOfLine(minCollidable.
                    getCollisionRectangle()), minCollidable);
        }
    }

    /**
     * This method checks if we have more then one rectangle we collide with, and if so then we return multiple
     * collision infos, for the hit method in ball to deal with.
     *
     * @param trajectory  .
     * @param minDistance .
     * @return .
     */
    public List<CollisionInfo> getClosestCollisions(Line trajectory, double minDistance) {
        List<CollisionInfo> collisionInfos = new ArrayList<>();
        //there's no collidables at all.
        if (collidableList.isEmpty()) {
            return null;
        } else {
            //iterating the list of collidables.
            for (Collidable c1 : collidableList) {
                double epsilon = Math.pow(10, -10);
                //value of accurate for further check.
                double accurate = Math.abs(minDistance - (trajectory.start().distance(trajectory.
                        closestIntersectionToStartOfLine(c1.getCollisionRectangle()))));
                //checking if the point in on the line.
                if (accurate < epsilon) {
                    collisionInfos.add(new CollisionInfo(trajectory.
                            closestIntersectionToStartOfLine(c1.getCollisionRectangle()), c1));
                }
            }
            return collisionInfos;
        }
    }

    /**
     * removing Collidable.
     *
     * @param c a Collidable.
     */
    public void removeCollidable(Collidable c) {
        collidableList.remove(c);
    }
}
