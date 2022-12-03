package model;

public class EasyState extends TetrisState {

    @Override
    public void increase_scoring_formula() {
        this.score_formula.put(1,5); //1 line
        this.score_formula.put(2,10); //2 lines
        this.score_formula.put(3,20); //3 lines
        this.score_formula.put(4,40); //4 lines
        this.score_formula.put(0,50); //default
    }

    @Override
    public void increase_block_falling_speed() {
        this.speedModifier.changeTime();
    }
}
