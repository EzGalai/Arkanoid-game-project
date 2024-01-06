/**
 * @author Ezra Galya.
 * @version 13.0.2
 * @since 2020-01-14
 * The class HitNotifier .
 */
public interface HitNotifier {
    /**
     * This method add hl as a listener to hit events.
     *
     * @param hl a given HitListener.
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl a given HitListener.
     */
    void removeHitListener(HitListener hl);
}