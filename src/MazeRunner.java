import java.util.Scanner;
public class MazeRunner {

    public static void main(String[] args) {
        Maze myMap = new Maze();
        intro(myMap);
        userMove(myMap);
    }

    public static void intro(Maze myMap) {
        //Maze myMap = new Maze();
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
        for (int i = 0; i < 40; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void userMove(Maze myMap) {
        //Maze myMap = new Maze();
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

        boolean canMove = false;
        if (direction.equals("R")) {
            canMove =  myMap.canIMoveRight();
            System.out.println("canMove --> " + canMove);
            if (canMove) {
                System.out.println("Inside ---> " + canMove);
                myMap.moveRight();
                myMap.printMap();
            }
        } else if (direction.equals("L")) {
            canMove = myMap.canIMoveLeft();
            if (canMove) {
                myMap.moveLeft();
                myMap.printMap();
            }
        } else if (direction.equals("U")) {
            canMove = myMap.canIMoveUp();
            if (canMove) {
                myMap.moveUp();
                myMap.printMap();
            }
        } else {
            canMove = myMap.canIMoveDown();
            if (canMove) {
                myMap.moveDown();
                myMap.printMap();
            }
        }

        if (!canMove) {
            System.out.println("Sorry, you’ve hit a wall.");
            myMap.printMap();
            System.out.print("Pic a new direction. ");
        }

        if (myMap.didIWin()) {
            System.out.println("Congratulations, you made it out alive!");
        } else {
            userMove(myMap);
        }

    }
}
