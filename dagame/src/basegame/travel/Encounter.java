package basegame.travel;

import basegame.Main;
import basegame.combat.Battle;
import basegame.entity.Entity;
import basegame.item.Item;

import java.util.ArrayList;

public class Encounter {
    private static ArrayList<Entity> entities = new ArrayList<>();
    String text = "";
    String text2 = "";
    private static ArrayList<Item> gifts = new ArrayList<>();
    private static ArrayList<Item> rewards = new ArrayList<>();
    int chance;

    public Encounter(ArrayList<Entity> entities, String text, String text2,
                     ArrayList<Item> gifts, ArrayList<Item> rewards, int chance){
        this.entities = entities;
        this.text = text;
        this.text2 = text2;
        this.gifts = gifts;
        this.rewards = rewards;
        this.chance = chance;
    }

    public boolean occur(){
        int num = (int) (Math.random() * 100) + 1;
        if(chance >= num){
            this.execute();
            return true;
        }
        return false;
    }

    private void execute(){
        System.out.println(text);
        for(Item gift: gifts){
            Main.player.addToInventory(gift);
        }

        ArrayList<Entity> enemies = new ArrayList<>();
        for(Entity entity: entities){
            if(entity.isHostile()){
                enemies.add(entity);
                entities.remove(entity);
            }
        }
        if(!enemies.isEmpty()){
            Battle battle = new Battle(Main.player, enemies);
            battle.sequence();
        }

        System.out.println(text2);
        for(Item reward: rewards){
            Main.player.addToInventory(reward);
        }
    }
}
