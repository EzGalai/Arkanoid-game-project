import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the class WideEasy. the second level of the game
 */
public class WideEasy implements LevelInformation {
    private List<Color> blockColor;

    /**
     * constructor.
     * initializing the blocks on the level.
     */
    public WideEasy() {
        blockColor = new ArrayList<>();
        blockColor.add(Color.red);
        blockColor.add(Color.red);
        blockColor.add(Color.orange);
        blockColor.add(Color.orange);
        blockColor.add(Color.yellow);
        blockColor.add(Color.yellow);
        blockColor.add(Color.green);
        blockColor.add(Color.green);
        blockColor.add(Color.green);
        blockColor.add(Color.blue);
        blockColor.add(Color.blue);
        blockColor.add(Color.pink);
        blockColor.add(Color.pink);
        blockColor.add(Color.cyan);
        blockColor.add(Color.cyan);
    }


    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        int angle = 0;
        for (int i = 1; i <= numberOfBalls(); i++) {
            angle = 16 * (i);
            Velocity val = Velocity.fromAngleAndSpeed(angle, 2);
            velocityList.add(val);
        }
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 4;
    }

    @Override
    public int paddleWidth() {
        return 500;
    }

    @Override
    public String levelName() {
        return "Wide Eazy";
    }

    @Override
    public Sprite getBackground() {
        return new LevelBackground(Color.WHITE.brighter());
    }

    @Override
    public List<Block> blocks() {
        List<Block> wideBlock = new ArrayList<>();

        for (int i = 0; i < numberOfBlocksToRemove(); i++) {
            Block b = new Block(new Rectangle(new Point(GameLevel.BORDER_THICK
                    + (50 * i), 200), 50, 25), blockColor.get(i));
            wideBlock.add(b);
        }

        return wideBlock;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
