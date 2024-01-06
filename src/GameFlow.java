import biuoop.GUI;
import biuoop.Sleeper;

import java.util.List;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the class GameFlow.
 * this class in charge of moving from one level to the next.
 */
public class GameFlow {
    private GUI gui;
    private AnimationRunner runner;
    private Counter score;
    private Sleeper sleeper;

    /**
     * constructor.
     * initializing the game.
     */
    public GameFlow() {
        gui = new GUI("Arkanoid", Point.WIDTH, Point.HEIGHT);
        sleeper = new Sleeper();
        score = new Counter();
        runner = new AnimationRunner(gui, sleeper);
    }

    /**
     * this method switching between levels.
     *
     * @param levels a given level.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean isRemainingBalls = true;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(gui, sleeper, runner, score, levelInfo);

            level.initialize();

            while (level.hasMoreBalls() && level.hasMoreBlocks()) {
                level.run();
            }

            if (!level.hasMoreBalls()) {
                isRemainingBalls = false;
                break;
            }

        }
        runner.run(new KeyPressStoppableAnimation(gui.getKeyboardSensor(), gui.getKeyboardSensor().SPACE_KEY,
                new EndScreen(score.getValue(), isRemainingBalls)));
        gui.close();
    }
}
