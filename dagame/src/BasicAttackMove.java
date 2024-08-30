public class BasicAttackMove extends Move{

    public BasicAttackMove(Entity entity){
        this.mover = entity;
        this.name = "Basic Attack";

    }

    public <T> T use(Entity target) {
        target.modLives(-mover.strength);
        System.out.println("You have dealt " + mover.strength + " damage!");
        return null;
    }
}
