package model;

import java.util.HashMap;

public abstract class TetrisState {
    /**
     * An abstract class representing a TetrisState.
     */
    public HashMap<Integer,Integer> score_formula; //scoring formula based on clearing how many lines.
    public TetrisCommandIncrease commandIncrease; //command object to increase block falling speed.
    public static TetrisTimer timer = new TetrisTimer(); // timer object.
    public TetrisSpeedModifier speedModifier; // speed modifier.

    public TetrisState(){
        this.score_formula = new HashMap<Integer,Integer>();
        this.score_formula.put(1,0); //1 line
        this.score_formula.put(2,0); //2 lines
        this.score_formula.put(3,0); //3 lines
        this.score_formula.put(4,0); //4 lines
        this.score_formula.put(0,0); //default
        this.commandIncrease = new TetrisCommandIncrease(timer);
        this.speedModifier = new TetrisSpeedModifier(commandIncrease);
    }

    /**
     * increases the scoring formula based on how many lines are cleared.
     * for example, clearing two lines will be worth more points in the NormalState than in the EasyState.
     */
    public abstract void increase_scoring_formula();
    /**
     * automatically increases the block falling speed by 10% in each state.
     */
    public abstract void increase_block_falling_speed();
}
