package bombs;

import java.io.Serializable;

/**
 * Bomb1 class
 */
public class Bomb1 implements Bomb, Serializable {

    /**
     * get type of bomb
     *
     * @return String stating type of bomb
     */
    @Override
    public String getType() { return "Bomb1"; }

    /**
     * get the number of lines to be cleared by bomb
     *
     * @return int number of cleared lines
     */
    @Override
    public int numLines() { return 1; }
}
