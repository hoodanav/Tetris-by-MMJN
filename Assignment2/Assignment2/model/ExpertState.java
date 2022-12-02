package model;

public class ExpertState extends TetrisState {
    /**
     * A subclass of TetrisState representing ExpertState.
     */
    @Override
    public void increase_scoring_formula() {
        this.score_formula.put(1,40); //1 line
        this.score_formula.put(2,45); //2 lines
        this.score_formula.put(3,55); //3 lines
        this.score_formula.put(4,75); //4 lines
        this.score_formula.put(0,85); //default
    }
}