package basegame.combat;

import basegame.entity.Entity;

public class FleeMove extends Move {
    public FleeMove(Entity entity){
        this.mover = entity;
        this.name = "Flee";
    }

    public boolean use(Entity target) {
        int chance = (int) (Math.random() * 5) - 2;
        chance += (mover.getAgility() - target.getAgility());
        boolean success =  chance > 0;
        if(success){
            System.out.println(mover.toString() + " has successfully fled the battle");
            return false;
        } else{
            System.out.println(mover.toString() + " failed to flee the battle");
            return true;
        }
    }
}
