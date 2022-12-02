package model;

public class TetrisLevel {
    public TetrisState state;

    public TetrisLevel(){
        this.state = new EasyState();
    }
    public void set_state(TetrisState state){
        this.state = state;
    }
    public void increase_scoring_formula(){
        this.state.increase_scoring_formula();
    }
}
