import java.util.Scanner;
public class MazeRunner {

    public static void main(String[] args) {
        intro();
        userMove();
    }

    public static void intro() {
        Maze myMap = new Maze();
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
        for (int i = 0; i < 40; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void userMove() {
        System.out.print("Where would you like to move? (R, L, U, D) ");
        Scanner directionInput = new Scanner(System.in);
        String direction = directionInput.next();
        direction = direction.toUpperCase();
        while ((!direction.equals("R")) && (!direction.equals("L")) && (!direction.equals("U")) && (!direction.equals("D"))) {
            System.out.println(direction);
            System.out.print("Where would you like to move? (R, L, U, D) ");
            direction = directionInput.next();
            direction = direction.toUpperCase();
        }
        System.out.println("Outside!");

    }
}
