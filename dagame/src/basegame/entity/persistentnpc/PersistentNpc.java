package basegame.entity.persistentnpc;

import basegame.combat.BasicAttackMove;
import basegame.combat.Move;
import basegame.entity.Entity;
import basegame.travel.Location;

import java.util.ArrayList;

public class PersistentNpc extends Entity {
    protected static final int MAX_RELATIONSHIP = 100;
    protected static final int MIN_RELATIONSHIP = -100;
    protected int playerRelationship = -1000;
    // hostile, enemy, dislike, acquaintance, likes, close
    protected int[] relationshipLevels = new int[6];
    // dawn, morning, noon, afternoon, evening, night, late night
    protected Location[] currArea = new Location[7];
    // veryfriendly, friendly1, friendly2, enemy1, enemy2/hostile, hostile2, description1 through 7 (time)
    protected String[] additionalText = new String[13];

    public PersistentNpc(String name, int lives, int strength, int agility, Move[] moves, int[] levels,
                         Location[] areas, String[] texts){
        this.name = name;
        this.modStats(lives, strength, agility);
        this.moves.add(new BasicAttackMove(this));
        for(Move move: moves){
            this.moves.add(move);
        }
        relationshipLevels = levels;
        currArea = areas;
        additionalText = texts;
    }

    public int adjustRelationship(int amount){
        int newRelationship = playerRelationship + amount;
        if(newRelationship >= MIN_RELATIONSHIP && newRelationship <= MAX_RELATIONSHIP){
            playerRelationship = newRelationship;
        }
        if(playerRelationship == -1000){
            playerRelationship = 0;
        }
        return playerRelationship;
    }

    public int opinion(){
        if(playerRelationship == -1000){
            return -1;
            //return "does not know you";
        }
        /*String[] opinions = new String[]
                {"wants to kill you", "hates you", "dislikes you", "has no opinion of you",
                        "is friendly with you", "likes you", "really likes you"};*/
        int opinion = 0;
        for(int i = 0; i < 6; i++){
            if(opinion > relationshipLevels[i]){
                opinion = i;
            } else{
                break;
            }
        }
        return opinion;
    }

    public String speak(){
        System.out.println();
        return null; //FIX
    }

    @Override
    public void defeat() {
        System.out.println(name + " has died.");
    }
}
