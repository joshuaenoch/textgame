public class BasicAttackMove extends Move{

    public BasicAttackMove(Entity entity){
        this.mover = entity;
        this.name = "Basic Attack";

    }

    public boolean use(Entity target) {
        target.modLives(-mover.strength);
        System.out.println(mover.name + " has dealt " + mover.strength + " damage!");
        return true;
    }
}
