package model;

public class NormalState extends TetrisState {
    /**
     * A subclass of TetrisState representing NormalState.
     */
    @Override
    public void increase_scoring_formula() {
        this.score_formula.put(1,10); //1 line
        this.score_formula.put(2,15); //2 lines
        this.score_formula.put(3,25); //3 lines
        this.score_formula.put(4,45); //4 lines
        this.score_formula.put(0,55); //default
    }
    public void increase_block_falling_speed() {
        this.commandIncrease.execute();
    }
}