package travel;

import java.util.ArrayList;

public class Location {
    String name;
    private static ArrayList<LocationAction> actions = new ArrayList<>();
    ArrayList<Location> neighbors = new ArrayList<>();
    boolean unlocked;

    public Location(String name){
        this.name = name;
        unlocked = false;
    }

    public void addNeighbor(Location location){
        this.neighbors.add(location);
        location.neighbors.add(this);
    }

    public void addAction(LocationAction action){
        actions.add(action);
    }

    public void removeAction(LocationAction action){
        actions.remove(action);
    }

    public void print(){
        if(unlocked){
            System.out.println(name);
        } else {
            System.out.println("???");
        }
    }
}
