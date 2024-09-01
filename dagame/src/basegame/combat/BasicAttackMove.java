package basegame.combat;

import basegame.entity.Entity;

public class BasicAttackMove extends Move {

    public BasicAttackMove(Entity entity){
        this.mover = entity;
        this.name = "Basic Attack";

    }

    public boolean use(Entity target) {
        target.modStats(-mover.getStrength(), 0, 0);
        System.out.println(mover.toString() + " has dealt " + mover.getStrength() + " damage!");
        return true;
    }
}
