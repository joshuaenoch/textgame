package basegame.travel;

import basegame.Utils;

import java.util.ArrayList;

public class Location {
    protected String name;
    protected static ArrayList<LocationAction> actions = new ArrayList<>();
    protected static ArrayList<Encounter> encounters = new ArrayList<>();
    public boolean unlocked;

    public Location(String name){
        this.name = name;
        unlocked = true;
    }

    public void addAction(LocationAction action){
        actions.add(action);
    }

    public void removeAction(LocationAction action){
        actions.remove(action);
    }

    public String toString(){
        if(unlocked){
            return name;
        } else {
            return "???";
        }
    }

    public void onVisit(){
        for(Encounter encounter: encounters){
            encounter.occur();
        }
        // check for updates - people, places, etc
        // display actions
        System.out.println("ACTIONS");
        Utils.printNumList(actions);
    }
}
