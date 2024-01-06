import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the class KeyPressStoppableAnimation .
 * this class in charge of the keyboard operations in the game.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * constructor.
     *
     * @param sensor    keyboard.
     * @param key       the key to be pressed.
     * @param animation an animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (!this.sensor.isPressed(key)) {
            isAlreadyPressed = false;
        }
        if (this.sensor.isPressed(key) && !isAlreadyPressed) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}