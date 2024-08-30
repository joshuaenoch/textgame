public class FleeMove extends Move{
    public FleeMove(Entity entity){
        this.mover = entity;
        this.name = "Flee";
    }

    public boolean use(Entity target) {
        int chance = (int) (Math.random() * 5) - 2;
        chance += (mover.agility - target.agility);
        boolean success =  chance > 0;
        System.out.println(chance);
        if(success){
            System.out.println(mover.name + " has successfully fled the battle");
            return false;
        } else{
            System.out.println(mover.name + " failed to flee the battle");
            return true;
        }
    }
}
