public class FleeMove extends Move{
    public FleeMove(Entity entity){
        this.mover = entity;
        this.name = "Flee";
    }

    public Boolean use(Entity target) {
        int chance = (int) Math.random() * 2 - 2 + (mover.agility - target.agility);
        boolean success =  chance > 0;
        if(success){
            System.out.println("You have successfully fled the battle");
            return false;
        } else{
            System.out.println("You failed to flee the battle");
            return false;
        }
    }
}
