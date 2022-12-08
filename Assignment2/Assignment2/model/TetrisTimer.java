package model;

import java.io.Serializable;

/**
 * Represents a Tetris Timer for Tetris.
 */
public class TetrisTimer implements Serializable {

    private double time;
    private double percent;
    private final double timeDefault = 3;

    /**
     * Constructor for Tetris Timer
     */
    public TetrisTimer() {
        this.percent = 0.4;
        this.time = timeDefault * percent;
    }

    /**
     * Increase time by 10%.
     */
    public void increaseTime() {
        if (this.percent >= 0.9) return;
        this.percent += 0.1;
        this.time = timeDefault * this.percent;
    }

    /**
     * Decrease time by 10%.
     */
    public void decreaseTime() {
        if (this.percent <= 0.1) return;
        this.percent -= 0.1;
        this.time = timeDefault * this.percent;
    }

    /**
     * Return the current time.
     */
    public double currTime() {
        return this.time;
    }

    /**
     * Return the current percent.
     */
    public double currPercent() {
        return this.percent;
    }
}
