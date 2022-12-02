package model;

import java.util.HashMap;

public abstract class TetrisState {
    /**
     * An abstract class representing a TetrisState.
     */
    public HashMap<Integer,Integer> score_formula; //scoring formula based on clearing how many lines.

    public TetrisState(){
        this.score_formula = new HashMap<Integer,Integer>();
        this.score_formula.put(1,0); //1 line
        this.score_formula.put(2,0); //2 lines
        this.score_formula.put(3,0); //3 lines
        this.score_formula.put(4,0); //4 lines
        this.score_formula.put(0,0); //default
    }
    public abstract void increase_scoring_formula();
}
