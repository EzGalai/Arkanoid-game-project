import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * The class line connects two points -- a start point and an end point. Lines have lengths,
 * and may intersect with other lines. It can also tell if it is the same as another line segment.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * constructors number 1.
     * @param start1 starting point of a line.
     * @param end1 ending point of a line.
     */
    public Line(Point start1, Point end1) {
        this.start = start1;
        this.end = end1;

    }

    /**
     * constructor number 2.
     * @param x1 x value of the starting point.
     * @param y1 y value of the starting point.
     * @param x2 x value of the ending point.
     * @param y2 y value of the ending point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * The method Return the length of the line.
     * @return the distance between starting point and ending point in a Line.
     */
     public double length() {
         return start.distance(end);
     }

    /**
     * The method Returns the middle point of the line.
     * @return middle point in a Line.
     */
    public Point middle() {
        return new Point((start.getX() + end.getX()) / 2, ((start.getY() + end.getY()) / 2));
    }

    /**
     * the method Returns the start point of the line.
     * @return starting point of a Line.
     */
    public Point start() {
        return  this.start;
    }

    /**
     *  the method Returns the end point of the line.
     * @return ending point of a Line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * The method checks if two line intersect.
     * @param other a line.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        if (intersectionWith(other) != null) {
            return true;
            //end case if the intersection is in the end/start point of each line
        } else {
            return (this.end.equals(other.start())) || ((this.start.equals(other.end())));
        }
    }

    /**
     * this method checking if two lines intersect with each other.
     * @param other  the line on which we want to see if this line intersect with.
     * @return Returns the intersection point if the lines intersect,
     * and null otherwise.
     */
    public Point intersectionWith(Line other) {
        //the y's variables in the end and start points of this line .
        double aMe = end.getY() - start.getY();
        //the x's variables in the end and start points of this line.
        double bMe = start.getX() - end.getX();
        // the equation of a line for this line.
        double cMe = aMe * start.getX() + bMe * start.getY();
        //the y variables in the end and start points of other line .
        double aOther = other.end().getY() - other.start().getY();
        //the x variable in the end and start points of other line.
        double bOther = other.start().getX() - other.end().getX();
        // the equation of a line for other.
        double cOther = aOther * other.start().getX() + bOther * other.start().getY();
        //the incline.
        double delta = aMe * bOther - aOther * bMe;

        if (delta != 0) {
            Point intersection = new Point((bOther * cMe - bMe * cOther) / delta,
                    (aMe * cOther - aOther * cMe) / delta);
            //if the point is in both lines then its intersecting.
            if (this.onTheLine(intersection) && other.onTheLine(intersection)) {
                return intersection;
            }

        }
        return null;
    }

    /**
     * the method return true is the lines are equal, false otherwise.
     * @param other a given Line.
     * @return true if lines are the same otherwise false.
     */
    public boolean equals(Line other) {
        return start.equals(other.start()) && end.equals(other.end());
    }

    /**
     * this method checking if a given point in on this line.
     * @param p a point on a given line.
     * @return  true if p on the or false if not .
     */
    public boolean onTheLine(Point p) {
        //variable for a better accurate check
        double epsilon = Math.pow(10, -9);
        //value of accurate for further check.
        double accurate = Math.abs(start.distance(end) - (start.distance(p) + p.distance(end)));
        //checking if the point in on the line.
        if (accurate < epsilon) {
            return true;

        }
        return false;
    }
    /**
     * this method delivering a line from two random points.
     * @return a random line.
     */
    public static Line generateRandomLine() {
        return new Line(Point.getRandomPoint(), Point.getRandomPoint());
    }
    /**
     * this method is drawing a line on a given surface.
     * @param l the given line to draw.
     * @param d the given surface to draw on .
     */
    public void drawLine(Line l, DrawSurface d) {
        d.setColor(Color.black);
        d.drawLine((int) l.start().getX(), (int) l.start().getY(), (int) l.end().getX(), (int) l.end().getY());
    }

    /**
     * the method checks if this Line intersect with the rectangle.
     * @param rect the given rectangle.
     * @return point return the closest intersection point to the
     * start of the line if there isn't any it returns null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Point minPoint;
        if (rect.intersectionPoints(this).size() == 0) {
            return null;
        } else {
            minPoint = rect.intersectionPoints(this).get(0);
             for (Point p : rect.intersectionPoints(this)) {
                 if (start.distance(minPoint) > start.distance(p)) {
                     minPoint = p;
                 }
             }
        }
        return minPoint;
    }
}
