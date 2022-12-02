package bombs;

/**
 * Bomb3 class
 */
public class Bomb3 implements Bomb {

    /**
     * get type of bomb
     *
     * @return String stating type of bomb
     */
    @Override
    public String getType() { return "Bomb3"; }

    /**
     * get the number of lines to be cleared by bomb
     *
     * @return int number of cleared lines
     */
    @Override
    public int numLines() { return 3; }
}
