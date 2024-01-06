import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * The class GameLevel .
 * The class hold the sprites and the Collidables ,
 * and in charge of the animation.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Sleeper sleeper;
    public static final double BORDER_THICK = 25;
    public static final double BORDER_LENGTH = 50;
    private Counter blockCounter;
    private BlockRemover blockRemover;
    private Counter ballCounter;
    private BallRemover ballRemover;
    private Counter score;
    private ScoreTrackingListener scoreTrackingListener;
    private ScoreIndicator scoreIndicator;
    private double width = Point.WIDTH;
    private double height = Point.HEIGHT;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * constructor.
     * this method initializing a window with objects.
     *
     * @param gui1              a given gui screen.
     * @param sleeper1          a given Sleeper.
     * @param animationRunner   an animation.
     * @param score1            a score.
     * @param levelInformation1 an information on a level.
     */
    public GameLevel(GUI gui1, Sleeper sleeper1, AnimationRunner animationRunner, Counter score1,
                     LevelInformation levelInformation1) {
        this.gui = gui1;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.sleeper = sleeper1;
        blockCounter = new Counter();
        blockRemover = new BlockRemover(this, blockCounter);
        ballCounter = new Counter();
        ballRemover = new BallRemover(this, ballCounter);
        score = score1;
        scoreTrackingListener = new ScoreTrackingListener(score);
        scoreIndicator = new ScoreIndicator(score, new Point((int) (width / 2) - 50, 20), levelInformation1);
        runner = animationRunner;
        running = true;
        keyboard = gui.getKeyboardSensor();
        levelInformation = levelInformation1;
    }

    /**
     * this method adding collidable object to the game.
     *
     * @param c given Collidable.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * this method is adding a given sprite to the list.
     *
     * @param s the given sprite.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * this method Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            balls.add(i, new Ball(new Point(width / 2, 520), 3, Color.white,
                    levelInformation.initialBallVelocities().get(i), environment));
        }
        //adding the count to the balls counter.
        ballCounter.increase(levelInformation.numberOfBalls());
        //craeting the borders on the screen.
        Block borderLeft = new Block(new Rectangle(new Point(0, BORDER_THICK), BORDER_THICK,
                height), Color.gray);
        Block borderRight = new Block(new Rectangle(new Point(width - BORDER_THICK, BORDER_THICK),
                BORDER_THICK, height), Color.gray);
        Block borderUp = new Block(new Rectangle(new Point(0, BORDER_THICK), width, BORDER_THICK), Color.gray);
        Block scoreboard = new Block(new Rectangle(new Point(0, 0), Point.WIDTH, BORDER_THICK), Color.white);
        Block borderBottom = new Block(new Rectangle(new Point(0, height), width,
                BORDER_THICK), Color.gray);
        //let the ball know that he is out of the game.
        borderBottom.addHitListener(ballRemover);

        //creating the paddle.
        Paddle gamePaddle = new Paddle(gui.getKeyboardSensor(), levelInformation.paddleSpeed(),
                new Rectangle(new Point(width / 2 - ((double) levelInformation.paddleWidth() / 2),
                        Point.HEIGHT - 2 * BORDER_THICK), levelInformation.paddleWidth(),
                        BORDER_THICK), Color.yellow);

        for (Ball ball : balls) {
            ball.addToGame(this);
        }

        List<Block> blocksList = levelInformation.blocks();
        for (Block b : blocksList) {
            blockCounter.increase(1);
            b.addHitListener(blockRemover);
            b.addHitListener(scoreTrackingListener);
            b.addToGame(this);
        }
        gamePaddle.addToGame(this);
        borderBottom.addToGame(this);
        borderUp.addToGame(this);
        scoreboard.addToGame(this);
        borderRight.addToGame(this);
        borderLeft.addToGame(this);
        sprites.addSprite(scoreIndicator);
    }


    /**
     * this method Run the game .
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, sprites, sleeper));
        this.running = true;
        this.runner.run(this);
    }


    /**
     * removing Collidable.
     *
     * @param c a Collidable.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * removing Sprite.
     *
     * @param s a given Sprite.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        levelInformation.getBackground().drawOn(d);
        sprites.drawAllOn(d);
        sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, keyboard.SPACE_KEY, new PauseScreen()));
        }
        if (ballCounter.getValue() == 0) {
            this.running = false;
        }
        if (blockCounter.getValue() == 0) {
            this.running = false;
        }
        if (ballCounter.getValue() > 0 && blockCounter.getValue() == 0) {
            //if you win get 100 pt extra.
            score.increase(100);
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * this method returns true if number of balls larger then zero.
     *
     * @return true or false.
     */
    public boolean hasMoreBalls() {
        return ballCounter.getValue() > 0;
    }

    /**
     * this method returns true if number of blocks larger then zero.
     *
     * @return true or false.
     */
    public boolean hasMoreBlocks() {
        return blockCounter.getValue() > 0;
    }
}
