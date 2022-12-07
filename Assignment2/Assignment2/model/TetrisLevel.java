package model;

import java.io.Serializable;

public class TetrisLevel implements Serializable {
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
    public void increase_block_falling_speed(){
        this.state.increase_block_falling_speed();
    }
}
