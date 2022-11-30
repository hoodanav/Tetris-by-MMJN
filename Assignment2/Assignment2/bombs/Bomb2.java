package bombs;

/**
 * Bomb2 class
 */
public class Bomb2 implements Bomb {

    /**
     * get type of bomb
     *
     * @return String stating type of bomb
     */
    @Override
    public String getType() { return "Bomb2"; }

    /**
     * get the number of lines to be cleared by bomb
     *
     * @return int number of cleared lines
     */
    @Override
    public int numLines() { return 2; }
}