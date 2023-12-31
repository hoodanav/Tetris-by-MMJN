package model;

import java.io.Serializable;

/**
 * Decreases the Timer time by 10% given a TetrisTimer object.
 */
public class TetrisCommandDecrease implements TetrisCommand, Serializable {
    private final TetrisTimer timer;

    /**
     * Constructor for TetrisCommandIncrease
     */
    public TetrisCommandDecrease(TetrisTimer timer) {
        this.timer = timer;
    }

    @Override
    public void execute() {
        this.timer.decreaseTime();
    }
}
