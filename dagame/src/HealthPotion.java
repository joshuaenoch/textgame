public class HealthPotion extends Item{

    public HealthPotion(Player owner){
        this.owner = owner;
    }

    @Override
    public void use() {
        owner.modLives(10);
        super.use();
    }
}
