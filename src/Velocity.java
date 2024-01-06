/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 *the class Velocity
 * the class give our ball some speed and direction.
 */
public class Velocity {
    private double dx;
    private double dy;
    /**
     * constructor.
     * Initialize a ball with velocity
     * @param dx1 the x value of the ball velocity.
     * @param dy1 the y value of the ball velocity.
     */
    public Velocity(double dx1, double dy1) {
        dx = dx1;
        dy = dy1;
    }
    /**
     * this method give access to the x value of the ball velocity.
     * @return dx the x value of the velocity.
     */
    public double getDx() {
        return dx;
    }
    /**
     * this method give access to the y value of the ball velocity.
     * @return dy the y value of the velocity.
     */
    public double getDy() {
        return dy;
    }
    /**
     * applyToPoint a method that receiving a point with position (x, y)
     * and returning a new point with with position (x+dx, y+dy).
     * @param p a point .
     * @return new point .
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }
    /**
     * this method setting a new value for the ball velocity.
     * @param y the given y value for the ball velocity.
     */
    public void setDy(double y) {
        dy = y;
    }
    /**
     * this method setting a new value for the ball velocity.
     * @param x the given x value.
     */
    public void setDx(double x)  {
        dx = x;
    }
    /**
     * a static method that converts angles to (dx, dy).
     * @param angle the direction the ball.
     * @param speed is the distance between two edges.
     * @return a new velocity for the ball.
     */
   public static Velocity fromAngleAndSpeed(double angle, double speed) {
       //converting the angles and multiplying by the distance of the edge.
       double dx1 = 1 * speed * Math.cos(Math.toRadians(angle));
       double dy1 = -1 * speed * Math.sin(Math.toRadians(angle));
       return new Velocity(dx1, dy1);
   }
}