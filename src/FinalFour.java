import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the class FinalFour. the final level of the game
 */
public class FinalFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        int angle = 0;
        for (int i = 1; i <= numberOfBalls(); i++) {
            angle = 45 * (i);
            Velocity val = Velocity.fromAngleAndSpeed(angle, 2);
            velocityList.add(val);
        }
        return velocityList;
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new LevelBackground(Color.blue.brighter());
    }

    @Override
    public List<Block> blocks() {

        List<Block> wideBlock = new ArrayList<Block>();
        List<Block> temp = new ArrayList<Block>();
        wideBlock = getBlocks(16, 1, Color.GRAY);
        temp.addAll(wideBlock);
        wideBlock = getBlocks(16, 2, Color.RED);
        temp.addAll(wideBlock);
        wideBlock = getBlocks(16, 3, Color.YELLOW);
        temp.addAll(wideBlock);
        wideBlock = getBlocks(16, 4, Color.GREEN);
        temp.addAll(wideBlock);
        wideBlock = getBlocks(16, 5, Color.WHITE);
        temp.addAll(wideBlock);
        wideBlock = getBlocks(16, 6, Color.PINK);
        temp.addAll(wideBlock);
        wideBlock = getBlocks(16, 7, Color.CYAN);
        temp.addAll(wideBlock);
        return temp;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
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
                    - (50 * j), 150 + (25 * i)), 50, 25), color);
            temp.add(b);
        }

        return temp;
    }
}

