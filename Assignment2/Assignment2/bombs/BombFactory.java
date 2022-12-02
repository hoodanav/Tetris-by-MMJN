package bombs;

/**
 * Bomb Factory class
 */
public class BombFactory {

    /**
     * Create a bomb
     *
     * @param type type of bomb to create
     * @return bomb of specified type
     */
    public Bomb createBomb(String type){
        if (type.equals("Bomb1")){
            return new Bomb1();
        }
        if (type.equals("Bomb2")){
            return new Bomb2();
        }
        if (type.equals("Bomb3")){
            return new Bomb3();
        }
        return new Bomb4();
    }

}
