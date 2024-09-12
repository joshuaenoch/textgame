package basegame.entity;

import basegame.Main;
import basegame.Utils;
import basegame.combat.BasicAttackMove;
import basegame.combat.FleeMove;
import basegame.combat.Move;
import basegame.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class Player extends Entity {

    protected ArrayList<Item> inventory = new ArrayList<>();
    private int inventoryCap = 10;
    // money, wood, stone
    protected int[] currencies = new int[3];

    public Player(String name){
        this.name = name;
        this.lives = 50;
        this.strength = 5;
        this.agility = 3;
        this.moves.add(new BasicAttackMove(this));
        this.moves.add(new FleeMove(this));
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public void addToInventory(Item item){
        if(inventory.size() <= inventoryCap){
            inventory.add(item);
        } else{
            // TODO: make an event where the player can choose what to keep
            System.out.println("Your inventory is full and could not fit " + item.toString());
        }
    }

    public int increaseInventoryCap(){
        inventoryCap += 5;
        return inventoryCap;
    }

    @Override
    public int attackChoice(){
        boolean isValid = false;
        int choice = 0;
        System.out.println("YOUR MOVES");
        Utils.printNumList(moves);
        while (!isValid) {
            System.out.print("Enter the corresponding number: ");
            choice = (int) Main.scanner.nextInt();
            if (choice > 0 && choice <= moves.size()) {
                isValid = true;
            }
        }
        return choice - 1;
    }

    @Override
    public void defeat() {
        System.out.println("You have lost. Womp womp");
    }
}
