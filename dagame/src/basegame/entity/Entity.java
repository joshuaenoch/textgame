package entity;

import combat.Move;

import java.util.HashMap;
import java.util.Map;

public abstract class Entity {
    protected int lives;
    protected int agility;
    protected int strength;
    protected String name;
    Map<Integer, Move> moves = new HashMap<>();

    public void modLives(int lives, int agility, int strength){
        this.lives += lives;
        this.agility = agility;
        this.strength = strength;
    }

    public int getLives(){
        return lives;
    }

    public int getStrength(){
        return strength;
    }

    public int getAgility(){
        return lives;
    }

    public String getName(){
        return name;
    }

    public boolean isAlive(){
        return lives > 0;
    }

    public int attackChoice(){
        return 1;
    }

    public abstract void defeat();
}
