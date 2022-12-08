package bombs;

/**
 * Bomb interface
 */
public interface Bomb {

    /**
     * get type of bomb
     *
     * @return String stating type of bomb
     */
    public String getType();

    /**
     * get the number of lines to be cleared by bomb
     *
     * @return int number of cleared lines
     */
    public int numLines();

}
