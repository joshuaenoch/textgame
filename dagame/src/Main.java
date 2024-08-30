import java.util.Scanner;
import java.util.jar.JarEntry;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Hello. Enter your name: ");
        String name = scanner.nextLine();
        Player player = new Player(name);
        while(true){
            System.out.println("Good luck " + name);
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
}