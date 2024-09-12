package basegame.entity;

import basegame.combat.Move;

import java.util.ArrayList;

public abstract class Entity {
    protected int lives;
    protected int agility;
    protected int strength;
    protected boolean hostile;
    protected String name;
    protected ArrayList<Move> moves = new ArrayList<>();

    public void modStats(int lives, int agility, int strength){
        this.lives += lives;
        this.agility += agility;
        this.strength += strength;
    }

    public void setHostility(boolean hostility){
        this.hostile = hostility;
    }

    public int getLives(){
        return lives;
    }

    public int getStrength(){
        return strength;
    }

    public int getAgility(){
        return agility;
    }

    public boolean isHostile(){
        return hostile;
    }

    public String toString(){
        return name;
    }

    public Move getMove(int target){
        return moves.get(target);
    }

    public boolean isAlive(){
        return lives > 0;
    }

    public int attackChoice(){
        return 0;
    }

    public abstract void defeat();
}
