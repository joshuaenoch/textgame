package basegame.combat;

import basegame.entity.Entity;
import basegame.entity.Player;

import java.util.ArrayList;

public class Battle {
    private Entity p1;
    private ArrayList<Entity> enemies = new ArrayList<>();
    private boolean ongoing = true;

    public Battle(Player p1, Entity enemy){
        this.p1 = p1;
        enemies.add(enemy);
    }

    public Battle(Player p1, ArrayList<Entity> enemies){
        this.p1 = p1;
        this.enemies = enemies;
    }

    public void sequence(){
        for(Entity p2: enemies){
            while(ongoing){
                display(p2);
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
    }

    public <T> void turn(Entity mover, Entity target){
        int move = mover.attackChoice();
        boolean result = mover.getMove(move).use(target);
        if(!result) {
            ongoing = false;
        }
    }

    private void display(Entity p2){
        System.out.println(p1.toString() + "\nLives: " + p1.getLives());
        System.out.println(p2.toString() + "\nLives: " + p2.getLives());
    }

}
