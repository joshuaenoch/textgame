package item;

import entity.Player;
import item.Item;

public class StrengthPotion extends Item {
    public StrengthPotion(Player owner){
        this.owner = owner;
    }

    @Override
    public void use() {
        owner.modStrength(1);
        super.use();
    }
}
