package basegame.entity;

import basegame.combat.BasicAttackMove;

public class HuaiRen extends Entity {

    public HuaiRen(){
        this.name = "Huai Ren";
        this.lives = 50;
        this.strength = 5;
        this.agility = 3;
        moves.add(new BasicAttackMove(this));
    }

    @Override
    public void defeat() {
        System.out.println("You have defeated HuaiRen");
    }
}