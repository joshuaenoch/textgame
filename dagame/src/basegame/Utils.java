package basegame;

import java.util.ArrayList;

public class Utils {
    public static <T> void printNumList(ArrayList<T> list){
        int index = 1;
        for(T item: list){
            System.out.println(index + ". " + item.toString());
            index++;
        }
    }
}
