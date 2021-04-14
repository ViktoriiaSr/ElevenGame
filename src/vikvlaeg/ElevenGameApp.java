package vikvlaeg;

import elevengame.DataStore;
import elevengame.GameInterface;
import java.util.List;
import java.util.Scanner;

public class ElevenGameApp {

    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GameInterface game = new GameImplementation();
        System.out.println(game.getName());
        System.out.println(game.getDeckSize());
        for (int i = 0; i < DataStore.getNCards(); i++) {
            System.out.println(game.getCardDescriptionAt(i));
        }
        System.out.println(game.anotherPlayIsPossible());
//        List<Integer> i =
//        while (game.anotherPlayIsPossible()) {
//            game.playAndReplace();
//        }
    }
}
