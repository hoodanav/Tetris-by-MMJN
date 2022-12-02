package model;

public class HardState extends TetrisState {
    /**
     * A subclass of TetrisState representing HardState.
     */
    @Override
    public void increase_scoring_formula() {
        this.score_formula.put(1,20); //1 line
        this.score_formula.put(2,25); //2 lines
        this.score_formula.put(3,35); //3 lines
        this.score_formula.put(4,55); //4 lines
        this.score_formula.put(0,65); //default
    }
}