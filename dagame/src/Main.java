import java.util.Scanner;

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
            String response =(String) scanner.nextLine();
            if(response == "y" || response == "n"){
                if(response == "n"){
                    System.out.println("Thanks for playing");
                    break;
                }
            } else{
                System.out.println("y or n dummeh");
            }
        }
    }
}