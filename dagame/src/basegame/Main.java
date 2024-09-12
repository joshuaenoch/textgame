package basegame;

import basegame.combat.Battle;
import basegame.entity.HuaiRen;
import basegame.entity.Player;
import basegame.travel.Location;
import basegame.travel.MainLocation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Player player;
    public static MainLocation currLocation;

    public static void main(String[] args) {
        Main mainInstance = new Main();
        mainInstance.characterCreation();
        mainInstance.mapInit();
        while(true){
            System.out.println("Current location: " + currLocation.toString());
            mainInstance.travel();
        }
        //mainInstance.battle();
    }

    public int travel(){
        boolean isValid = false;
        int choice = 0;
        int index = 1;
        System.out.println("LOCATIONS");
        Utils.printNumList(currLocation.getNeighbors());
        System.out.print("Where do you wish to go? ");
        while (!isValid) {
            try {
                System.out.print("Enter the corresponding number: ");
                choice = ((int) Main.scanner.nextInt()) - 1;
                if (currLocation.getNeighbors().get(choice) != null) {
                    if(!currLocation.getNeighbors().get(choice).unlocked){
                        System.out.println("You have not unlocked this area yet");
                    }
                    currLocation = (MainLocation) currLocation.getNeighbors().get(choice);
                    currLocation.onVisit();
                    isValid = true;
                }
            } catch (InputMismatchException e) {
                Main.scanner.next();
            }
        }
        return choice;
    }

    public void characterCreation(){
        System.out.print("Hello. Enter your name: ");
        String name = scanner.nextLine();
        player = new Player(name);
    }

    public void battle(){
        while(true){
            System.out.println("Good luck " + player.toString());
            HuaiRen enemy = new HuaiRen();
            Battle battle = new Battle(player, enemy);
            battle.sequence();
            System.out.print("Play again (y or n)? ");
            scanner.nextLine(); // make it so this isn't needed in the future
            String response = (String) scanner.nextLine().trim();
            if(response.equals("y") || response.equals("n")){
                if(response.equals("n")){
                    System.out.println("Thanks for playing");
                    break;
                }
            } else{
                System.out.println("I guess not");
                break;
            }
        }
    }

    public void mapInit(){
        MainLocation valley = new MainLocation("Valley");
        MainLocation town = new MainLocation("Town");
        valley.addNeighbor(town);
        MainLocation forest = new MainLocation("Forest");
        town.addNeighbor(forest);
        MainLocation mountain = new MainLocation("Mountain");
        town.addNeighbor(mountain);
        MainLocation beach = new MainLocation("Beach");
        mountain.addNeighbor(beach);
        currLocation = valley;
    }

    public void npcInit(){
        
    }
}