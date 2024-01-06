import java.util.ArrayList;
/**
 *@author Ezra Galya.
 *  @version 13.0.2
 *  @since 2020-01-14
 *  The class Rectangle
 *  the class creating an object in the shape of rectangle and placing
 *   it on the screen according to a given a point height and width.
 */
public class Rectangle {
    private  Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor.
     * Create a new rectangle with location and width/height.
     * @param upperLeft the upper left point of the rectangle.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     *  Return a (possibly empty) List of intersection points
     *  with the specified line.
     * @param line a given line.
     * @return A List of intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> intersectionPoints = new ArrayList<>();
        Line leftWidth = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX(), upperLeft.getY() + height);
        Line rightWidth = new Line(upperLeft.getX() + width, upperLeft.getY(), upperLeft.getX() + width,
                upperLeft.getY() + height);
        Line upper = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX() + width, upperLeft.getY());
        Line bottom = new Line(upperLeft.getX(), upperLeft.getY() + height, upperLeft.getX() + width,
                upperLeft.getY() + height);
        if (line.isIntersecting(leftWidth)) {
            intersectionPoints.add(line.intersectionWith(leftWidth));
        }
        if (line.isIntersecting(rightWidth)) {
            intersectionPoints.add(line.intersectionWith(rightWidth));
        }
        if (line.isIntersecting(upper)) {
            intersectionPoints.add(line.intersectionWith(upper));
        }
        if (line.isIntersecting(bottom)) {
            intersectionPoints.add(line.intersectionWith(bottom));
        }
        return intersectionPoints;


    }

    /**
     * @return the width of the rectangle.
     */
 double getWidth() {
     return this.width;
    }

    /**
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;

    }
}