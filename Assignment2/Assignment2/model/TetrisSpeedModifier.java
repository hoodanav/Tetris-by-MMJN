package model;

/**
 * Executes the given command and modifies the TetrisTimer speed
 * as required.
 */
public class TetrisSpeedModifier {

    private final TetrisCommand command;

    /**
     * Constructor for TetrisSpeedModifier
     */
    public TetrisSpeedModifier(TetrisCommand command) {
        this.command = command;
    }

    /**
     * Executes the given command.
     */
    public void changeTime(){
        this.command.execute();
    }
}
