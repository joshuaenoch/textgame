package basegame.travel.sublocation;

import basegame.Main;
import basegame.travel.Location;
import basegame.travel.LocationAction;
import basegame.travel.MainLocation;

import java.util.ArrayList;

public class SubLocation extends MainLocation {
    Location parentLocation;

    public SubLocation(String name){
        super(name);
    }

    public void onVisit(){
        Main.currLocation = this;
    }

    public void onLeave(){
        Main.currLocation = (MainLocation) parentLocation;
    }
}
