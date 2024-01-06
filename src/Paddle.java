import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * The class Paddle .
 * The class creating a paddle the can be collidable using rectangle
 * the paddle can move left and right in a given area.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private int movingSpeed;
    private Rectangle rectangle;
    private Color color;

    /**
     * constructor.
     * initializing this paddle with keyboard, shape,color and movement
     *
     * @param keyboard1    paddle keyboard to be used.
     * @param movingSpeed1 determining the paddle movement.
     * @param rectangle1   shape of paddle.
     * @param color1       color of paddle.
     */
    public Paddle(KeyboardSensor keyboard1, int movingSpeed1, Rectangle rectangle1, Color color1) {
        this.keyboard = keyboard1;
        this.movingSpeed = movingSpeed1;
        this.rectangle = rectangle1;
        this.color = color1;
    }

    /**
     * this method moves the paddle to the left using the keyboard.
     */
    public void moveLeft() {
        if (rectangle.getUpperLeft().getX() > GameLevel.BORDER_THICK) {
            rectangle.getUpperLeft().setX(rectangle.getUpperLeft().getX() - movingSpeed);
        }
    }

    /**
     * this method moves the paddle to the right using the keyboard.
     */
    public void moveRight() {
        if (rectangle.getUpperLeft().getX() + rectangle.getWidth() + movingSpeed <= (Point.WIDTH
                - GameLevel.BORDER_THICK)) {
            rectangle.getUpperLeft().setX(rectangle.getUpperLeft().getX() + movingSpeed);
        }
    }

    /**
     * this method checks if the "left" or "right" keys are pressed,
     * and if so move it accordingly.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * this method drawing the paddle on a given surface.
     *
     * @param d the given surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    /**
     * @return the "collision shape" of the object.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * the method changes the velocity of an object after a collision with a paddle .
     *
     * @param hitter          the hitting ball.
     * @param collisionPoint  collision point of the object with paddle
     * @param currentVelocity the given velocity.
     * @return a new velocity after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double widthCut = rectangle.getWidth() / 5;

        //bordering the width of the paddle.
        double area2 = rectangle.getUpperLeft().getX() + widthCut;
        double area3 = rectangle.getUpperLeft().getX() + (2 * widthCut);
        double area4 = rectangle.getUpperLeft().getX() + (3 * widthCut);
        double area5 = rectangle.getUpperLeft().getX() + (4 * widthCut);

        //creating left and right line according to paddle.
        double dX = Math.pow(currentVelocity.getDx(), 2);
        double dY = Math.pow(currentVelocity.getDy(), 2);
        double ballSpeed = Math.sqrt(dX + dY);

        //checking if the collision occurred in the first area of the paddle if so
        // change velocity according to the given angle.
        if ((collisionPoint.getX() < area2)) {
            return Velocity.fromAngleAndSpeed(150, ballSpeed);
        }

        //checking if the collision occurred in the second area of the paddle if so
        // change velocity according to the given angle.
        if ((collisionPoint.getX() > area2) && (collisionPoint.getX() < area3)) {

            return Velocity.fromAngleAndSpeed(120, ballSpeed);
        }
        //checking if the collision occurred in the  middle area of the paddle if so
        // change velocity according to the given angle.
        if ((collisionPoint.getX() > area3) && (collisionPoint.getX() < area4)) {

            return Velocity.fromAngleAndSpeed(90, ballSpeed);
        }
        //checking if the collision occurred in the forth area of the paddle if so
        // change velocity according to the given angle.
        if ((collisionPoint.getX() > area4) && (collisionPoint.getX() < area5)) {

            return Velocity.fromAngleAndSpeed(60, ballSpeed);
        }
        //checking if the collision occurred in the last area of the paddle if so
        // change velocity according to the given angle.
        if ((collisionPoint.getX() > area5)) {

            return Velocity.fromAngleAndSpeed(30, ballSpeed);
        }
        return currentVelocity;
    }

    /**
     * this method add this paddle to the game.
     *
     * @param g a given game environment.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);

    }
}
