package entity;

import combat.BasicAttackMove;
import entity.Entity;

public class HuaiRen extends Entity {

    public HuaiRen(){
        this.name = "Huai Ren";
        this.lives = 50;
        this.strength = 5;
        this.agility = 3;
        moves.put(1, new BasicAttackMove(this));
    }

    @Override
    public void defeat() {
        System.out.println("You have won. Congrats!");
    }
}