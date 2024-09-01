package basegame.item;

import basegame.entity.Player;

public class HealthPotion extends Item {

    public HealthPotion(Player owner){
        this.owner = owner;
    }

    @Override
    public void use() {
    }
}
