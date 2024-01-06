import java.util.Arrays;

/**
 * @author Ezra Galya 
 * @version 13.0.2
 * @since 2020-01-14
 * The class Ass6Game.
 */
public class Ass6Game {
    /**
     * Ass6Game main method Create a game object, initializes and runs it.
     *
     * @param args .
     */
    public static void main(String[] args) {
        GameFlow gameFlow = new GameFlow();
        gameFlow.runLevels(Arrays.asList(new DirectHit(), new WideEasy(), new Green3(), new FinalFour()));
    }
}
