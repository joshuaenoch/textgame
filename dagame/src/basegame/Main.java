import combat.Battle;
import entity.HuaiRen;
import entity.Player;
import travel.Location;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    private static Player player;
    private static Location currLocation;

    public static void main(String[] args) {
        Main mainInstance = new Main();
        mainInstance.characterCreation();
        mainInstance.mapInit();
        while(true){
            System.out.println("Current location: " + currLocation.name);
            mainInstance.travel();
        }
    }

    public int travel(){
        boolean isValid = false;
        int choice = 0;
        int index = 1;
        System.out.println("LOCATIONS");
        for (Location neighbor: currLocation.neighbors){
            System.out.println(index + ". " + neighbor.name);
            index++;
        }
        System.out.print("Where do you wish to go? ");
        while (!isValid) {
            try {
                System.out.print("Enter the corresponding number: ");
                choice = ((int) Main.scanner.nextInt()) - 1;
                if (currLocation.neighbors.get(choice) != null) {
                    currLocation = currLocation.neighbors.get(choice);
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
            System.out.println("Good luck " + player.name);
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
        Location valley = new Location("Valley");
        Location town = new Location("Town");
        valley.addNeighbor(town);
        Location forest = new Location("Forest");
        town.addNeighbor(forest);
        Location mountain = new Location("Mountain");
        town.addNeighbor(mountain);
        Location beach = new Location("Beach");
        mountain.addNeighbor(beach);
        currLocation = valley;
    }
}