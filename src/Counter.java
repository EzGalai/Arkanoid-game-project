/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * the Class Counter.
 * class that is used for counting things.
 */
public class Counter {
    private int counter;

    /**
     * constructor.
     *
     * @param counter1 .
     */
    public Counter(int counter1) {
        this.counter = counter1;
    }

    /**
     * constructor.
     */
    public Counter() {
        counter = 0;
    }

    /**
     * add number to current count.
     *
     * @param number given number.
     */
    public void increase(int number) {
        counter = counter + number;
    }

    /**
     * subtract number from current count.
     *
     * @param number given number to subtract.
     */
    public void decrease(int number) {
        counter = counter - number;
    }

    /**
     * get current count.
     *
     * @return the current count.
     */
    public int getValue() {
        return counter;
    }
}