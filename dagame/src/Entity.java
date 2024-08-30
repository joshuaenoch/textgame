import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public abstract class Entity {
    protected int lives;
    protected int agility;
    protected int strength;
    protected String name;
    Map<Integer, Move> moves = new HashMap<>();

    public void modLives(int amount){
        this.lives += amount;
    }

    public void modAgility(int amount){
        this.agility += amount;
    }

    public void modStrength(int amount){
        this.strength += amount;
    }

    public boolean flee(Entity pursuer){
        int chance = (int) Math.random() * 2 - 2 + (this.agility - pursuer.agility);
        return chance > 0;
    }

    public boolean isAlive(){
        return lives > 0;
    }

    public int attackChoice(){
        return 1;
    }

    public abstract void defeat();
}
