import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class Player extends Entity{

    Map<String, Integer> inventory = new HashMap<>();

    public Player(String name){
        this.name = name;
        this.lives = 50;
        this.strength = 5;
        this.agility = 3;
        this.moves.put(1, new BasicAttackMove(this));
        this.moves.put(2, new FleeMove(this));
    }

    @Override
    public int attackChoice(){
        boolean isValid = false;
        int choice = 0;
        System.out.println("YOUR MOVES");
        for (Map.Entry<Integer, Move> entry : moves.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().name);
        }
        while (!isValid) {
            try {
                System.out.print("Enter the corresponding number: ");
                choice = (int) Main.scanner.nextInt();
                if (moves.containsKey(choice)) {
                    isValid = true;
                }
            } catch (InputMismatchException e) {
                Main.scanner.next();
            }
        }
        return choice;
    }

    @Override
    public void defeat() {
        System.out.println("You have lost. Womp womp");
    }
}
