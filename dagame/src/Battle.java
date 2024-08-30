import java.util.InputMismatchException;

public class Battle {
    private Entity p1;
    private Entity p2;
    private boolean ongoing = true;

    public Battle(Player p1, Entity p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public void sequence(){
        while(ongoing){
            display();
            if(p1.isAlive()){
                turn(p1, p2);
            } else{
                p1.defeat();
                ongoing = false;
            }
            if(ongoing && p2.isAlive()){
                turn(p2, p1);
            } else{
                if(!p2.isAlive()) {
                    p2.defeat();
                }
                ongoing = false;
            }
        }
    }

    public <T> void turn(Entity mover, Entity target){
        int move = mover.attackChoice();
        boolean result = mover.moves.get(move).use(target);
        if(!result) {
            ongoing = false;
        }
    }

    public void display(){
        System.out.println(p1.name + "\nLives: " + p1.lives);
        System.out.println(p2.name + "\nLives: " + p2.lives);
    }

}
