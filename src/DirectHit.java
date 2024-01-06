import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the class DirectHit. the first level of the game
 */
public class DirectHit implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsVelocity = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            ballsVelocity.add(i, Velocity.fromAngleAndSpeed(90, 4));
        }
        return ballsVelocity;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 80;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new LevelBackground(Color.black);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocksList = new ArrayList<>();
        blocksList.add(new Block(new Rectangle(new Point(390, 200), 30, 30),
                Color.red));
        return blocksList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
