package model;

import java.io.Serializable;

/**
 * Increases the Timer time by 10% given a TetrisTimer object.
 */
public class TetrisCommandIncrease implements TetrisCommand, Serializable {

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
