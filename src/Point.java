import biuoop.DrawSurface;
import java.awt.Color;
import java.util.Random;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 *the class point
 * the class receives A point has an x and a y value, and can measure
 *  the distance to other points, and if it is equal to another point etc' .
 */
public class Point {
    private double x;
    private double y;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    /**
     *  constructor.
     * @param x the x.
     * @param y the y.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *The method returns the distance of this point to the other point.
     * @param other a given Point.
     * @return distance between two points.
     */
    public double distance(Point other) {
        if (other == null) {
            return Double.POSITIVE_INFINITY;
        }
        return Math.sqrt(Math.pow(other.getX() - this.x, 2) + Math.pow(other.getY() - this.y, 2));
    }


    /**
     * The method returns true is the points are equal, false otherwise.
     * @param other a given Point.
     * @return true if equal otherwise false.
     */
    public boolean equals(Point other) {
        return (other.x == x) && (other.y == y);
    }

    /**
     *The method return the x values of this point.
     * @return the x value of Point.
     */
    public double getX() {
        return this.x;
    }

    /**
     *The method return the y values of this point.
     * @return the y value of Point.
     */
    public double getY() {
        return this.y;
    }
    /**
     * this method that delivering a random x and y in a given range.
     * @return a new random point in a givem range.
     */
    public static Point getRandomPoint() {
        Random rand = new Random();
        return new Point(rand.nextInt(WIDTH) + 1, rand.nextInt(HEIGHT) + 1);
    }

    /**
     * the method drawing a point or a ball with size and color.
     * @param p the given point .
     * @param radius determining the size of the point / ball.
     * @param color the color of the point / ball.
     * @param d a given surface we can draw the point / ball on it.
     */
    public static void drawPoint(Point p, int radius, Color color, DrawSurface d) {
        d.setColor(color);
        d.fillCircle((int) p.getX(), (int) p.getY(), radius);
        d.setColor(Color.black);
        d.drawCircle((int) p.getX(), (int) p.getY(), radius);
    }
    /**
     * this method delivering a random x and y values in a specific range inside the window.
     * @param startX start range of x.
     * @param endX end range of x.
     * @param startY start range of y.
     * @param endY end range of y.
     * @return a new random point in the given range.
     */
    public static Point getRandomPoint(int startX, int endX, int startY, int endY) {
        Random rand = new Random();
        // get integer in range
        int x = rand.nextInt(endX - startX) + startX;
        // get integer in range .
        int y = rand.nextInt(endY - startY) + startY;
        return new Point(x, y);
    }

    /**
     * setting a new value for this x.
     * @param v th new value.
     */
    public void setX(double v) {
        this.x = v;
    }
}
