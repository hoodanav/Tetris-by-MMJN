package model;

/**
 * Increases the Timer time by 10% given a TetrisTimer object.
 */
public class TetrisCommandIncrease implements TetrisCommand {

    private final TetrisTimer timer;

    /**
     * Constructor for TetrisCommandIncrease
     */
    public TetrisCommandIncrease(TetrisTimer timer) {
        this.timer = timer;
    }

    @Override
    public void execute() {
        this.timer.increaseTime();
    }
}
