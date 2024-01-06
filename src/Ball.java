import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;
import java.util.Random;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the class ball.
 * the class creating balls (which are circles) and move them across the screen.
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private Color color;
    private Velocity vel;
    private GameEnvironment gameEnvironment;

    /**
     * constructor.
     * Initialize a ball with a given point, radius and color gameEnvironment
     *
     * @param center1 center point of this ball.
     * @param radius1 radius of this ball.
     * @param color1  color of this ball.
     * @param vel1    velocity of this ball.
     * @param game    the environment.
     */
    public Ball(Point center1, int radius1, Color color1, Velocity vel1, GameEnvironment game) {
        center = center1;
        radius = radius1;
        color = color1;
        vel = vel1;
        gameEnvironment = game;

    }

    /**
     * constructor number 1.
     * Initialize a ball with a given point, radius and color.
     *
     * @param center the middle point of the ball
     * @param r      the radios of the ball.
     * @param color1 the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color1) {
        this.center = center;
        this.radius = r;
        this.color = color1;
    }

    /**
     * constructor number 2.
     * initialize a ball with x and y values, radius value and color.
     *
     * @param i1     the x value of a point.
     * @param i2     the y value of a points.
     * @param r      the radius of the ball.
     * @param color2 the color of the ball.
     */
    public Ball(int i1, int i2, int r, Color color2) {
        this.radius = r;
        this.center = new Point(i1, i2);
        this.color = color2;
    }

    /**
     * constructor number 3.
     * Initialize a ball with a given point and radius values, color and velocity.
     *
     * @param p       the middle point of the ball.
     * @param radius1 the radius of the ball.
     * @param v       the velocity of the ball.
     * @param color3  the color of the ball.
     */
    public Ball(Point p, int radius1, Velocity v, Color color3) {
        this.center = p;
        this.radius = radius1;
        this.vel = v;
        this.color = color3;
    }

    /**
     * return the x coordinate of the ball's center.
     *
     * @return int the x coordinate
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * return the y coordinate of the ball's center.
     *
     * @return int the y coordinate
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * return the ball's radios.
     *
     * @return int the radios.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * return the ball's center color.
     *
     * @return this ball color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @return the game environment.
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface the given surface which will display the balls.
     */
    public void drawOn(DrawSurface surface) {
        Point.drawPoint(center, radius, color, surface);
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * this method setting a new velocity for this ball.
     *
     * @param v the given velocity.
     */
    public void setVelocity(Velocity v) {
        this.vel = v;
    }

    /**
     * this method setting a new object type velocity .
     *
     * @param dx the x value for velocity
     * @param dy the y value for velocity
     */
    public void setVelocity(double dx, double dy) {
        this.vel = new Velocity(dx, dy);
    }

    /**
     * this method gives access to the value of the velocity of this ball.
     *
     * @return the given velocity.
     */
    public Velocity getVelocity() {
        return this.vel;
    }

    /**
     * this method keeps the within the bounds if
     * it touch the corners the ball wll bounce back.
     */
    public void moveOneStep() {
        //the given trajectory of this ball.
        Line trajectory = new Line(center, vel.applyToPoint(center));
        //the collision info of this ball.
        CollisionInfo collisionInfo = gameEnvironment.getClosestCollision(trajectory);
        //theres collision.
        if (collisionInfo != null) {
            //updating this ball new location after the collision, plus we check if there are any more collisions
            // with other rectangles.
            List<CollisionInfo> collisionInfos = gameEnvironment.getClosestCollisions(trajectory,
                    trajectory.closestIntersectionToStartOfLine(collisionInfo.collisionObject().
                            getCollisionRectangle()).distance(trajectory.start()));
            center = collisionInfo.collisionPoint();
            //iterating the infos we got from the new method and changing the velocity accordingly.
            for (CollisionInfo c : collisionInfos) {
                vel = c.collisionObject().hit(this, collisionInfo.collisionPoint(), vel);
            }
        }
        center = vel.applyToPoint(center);
    }

    /**
     * the method creating a random ball
     * with random color velocity and direction ,the bigger the ball the slower it moves.
     *
     * @param radius determining the size of the ball
     * @return new random ball.
     */
    public static Ball createRandomBall(int radius) {
        //getting a random point
        Point randP = Point.getRandomPoint();
        //getting a random color,
        Color randColor = new Color(new Random().nextInt(0xFFFFFF));
        //setting velocity according to the size of the ball and a random angle to each ball.
        Velocity randVel = Velocity.fromAngleAndSpeed(new Random().nextInt(360), Math.min(49 / radius + 1, 10));
        return new Ball(randP, radius, randVel, randColor);
    }

    /**
     * the method creating a random ball
     * with random color velocity and direction ,
     * the bigger the ball the slower it moves.
     *
     * @param radius determining the size of the ball
     * @param startX the starting range of x
     * @param endX   the ending range of x
     * @param startY the starting range of y.
     * @param endY   the ending range of y.
     * @return a new point in a new range with random color size and velocity.
     */
    public static Ball createRandomBall(int radius, int startX, int endX, int startY, int endY) {
        //creating a random ball within a given rectangle.
        Point randP = Point.getRandomPoint(startX, endX, startY, endY);
        //setting a random color for the ball.
        Color randColor = new Color(new Random().nextInt(0xFFFFFF));
        //setting a new velocity according to ball size.
        Velocity randVel = Velocity.fromAngleAndSpeed(new Random().nextInt(360), Math.min(49 / radius + 1, 10));
        //returning a new ball in a given rectangle.
        return new Ball(randP, radius, randVel, randColor);
    }

    /**
     * removing this from gameLevel.
     *
     * @param gameLevel a given GameLevel.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}