import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the class Green3. the third level of the game
 */
public class Green3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        for (int i = 1; i <= numberOfBalls(); i++) {
            Velocity val = Velocity.fromAngleAndSpeed(60 * i, 2);
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
        return 80;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new LevelBackground(Color.green.darker());
    }

    @Override
    public List<Block> blocks() {
        List<Block> wideBlock = new ArrayList<Block>();
        List<Block> temp = new ArrayList<Block>();
        wideBlock = getBlocks(11, 1, Color.GRAY);
        temp.addAll(wideBlock);
        wideBlock = getBlocks(10, 2, Color.RED);
        temp.addAll(wideBlock);
        wideBlock = getBlocks(9, 3, Color.YELLOW);
        temp.addAll(wideBlock);
        wideBlock = getBlocks(8, 4, Color.BLUE);
        temp.addAll(wideBlock);
        wideBlock = getBlocks(7, 5, Color.WHITE);
        temp.addAll(wideBlock);
        return temp;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }

    /**
     * This method setting the number and location of the blocks.
     *
     * @param n     number of blocks.
     * @param i     how many blocks to subtract from max blocks.
     * @param color the color of the blocks.
     * @return list of blocks.
     */
    public static List<Block> getBlocks(int n, int i, Color color) {
        List<Block> temp = new ArrayList<>();
        for (int j = 1; j < n; j++) {
            Block b = new Block(new Rectangle(new Point(Point.WIDTH - GameLevel.BORDER_THICK
                    - (50 * j), 200 + (25 * i)), 50, 25), color);
            temp.add(b);
        }

        return temp;
    }
}

