package model;

/**
 * Represents a Tetris Timer for Tetris.
 */
public class TetrisTimer {

    private double time;
    private double percent;
    private final double timeDefault = 10;

    /**
     * Constructor for Tetris Timer
     */
    public TetrisTimer() {
        this.percent = 0.5;
        this.time = timeDefault * percent;
    }

    /**
     * Increase time by 10%.
     */
    public void increaseTime() {
        this.percent += 0.1;
        this.time = timeDefault * this.percent;
    }

    /**
     * Decrease time by 10%.
     */
    public void decreaseTime() {
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
