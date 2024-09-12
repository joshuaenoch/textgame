package basegame.travel;

import basegame.travel.sublocation.SubLocation;

import java.util.ArrayList;

public class MainLocation extends Location{

    private static ArrayList<SubLocation> sublocations = new ArrayList<>();
    ArrayList<Location> neighbors = new ArrayList<>();

    public MainLocation(String name){
        super(name);
    }

    public void addNeighbor(MainLocation location){
        this.neighbors.add(location);
        location.neighbors.add(this);
    }

    public ArrayList<Location> getNeighbors(){
        return neighbors;
    }


}
