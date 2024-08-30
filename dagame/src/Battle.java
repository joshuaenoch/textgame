import java.util.InputMismatchException;

public class Battle {
    private Entity p1;
    private Entity p2;
    private boolean ongoing = true;

    public Battle(Entity p1, Entity p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public void sequence(){
        if(ongoing){
            display();
            if(p1.isAlive()){
                turn(p1);
            } else{
                p1.defeat();
                ongoing = false;
            }
            if(p2.isAlive()){
                turn(p2);
            } else{
                p2.defeat();
                ongoing = false;
            }
        }
    }

    public <T> void turn(Entity p){
        int move = p.attackChoice();
        T result = p.moves.get(move).use(p);
        try {
            if(!(boolean) result){
                ongoing = false;
            }
        } catch (NullPointerException e) {}
    }

    public void display(){
        System.out.println(p1.name + "\nLives: " + p1.lives);
        System.out.println(p2.name + "\nLives: " + p2.lives);
    }

}
