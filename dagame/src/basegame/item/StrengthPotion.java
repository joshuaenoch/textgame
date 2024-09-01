package basegame.item;

import basegame.entity.Player;

public class StrengthPotion extends Item {
    public StrengthPotion(Player owner){
        this.owner = owner;
    }

    @Override
    public void use() {
    }
}
