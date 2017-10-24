import java.util.Scanner;
public class MazeRunner {

    public static void main(String[] args) {
        Maze myMap = new Maze();
        int moves = 0;
        intro(myMap);
        userMove(myMap, moves);
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

    public static void userMove(Maze myMap, int moves) {
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
            if (myMap.isThereAPit(direction)) {
                navigatePit(myMap,direction,moves);
            } else {
                canMove = myMap.canIMoveRight();
                if (canMove) {
                    myMap.moveRight();
                    moves++;
                    myMap.printMap();
                    System.out.println(moves);
                    movesMessage(moves);
                }
            }
        } else if (direction.equals("L")) {
            if (myMap.isThereAPit(direction)) {
                navigatePit(myMap,direction,moves);
            } else {
                canMove = myMap.canIMoveLeft();
                if (canMove) {
                    myMap.moveLeft();
                    moves++;
                    myMap.printMap();
                    movesMessage(moves);
                }
            }
        } else if (direction.equals("U")) {
            if (myMap.isThereAPit(direction)) {
                navigatePit(myMap,direction,moves);
            } else {
                canMove = myMap.canIMoveUp();
                if (canMove) {
                    myMap.moveUp();
                    moves++;
                    myMap.printMap();
                    movesMessage(moves);
                }
            }
        } else {
            if (myMap.isThereAPit(direction)) {
                navigatePit(myMap,direction,moves);
            } else {
                canMove = myMap.canIMoveDown();
                if (canMove) {
                    myMap.moveDown();
                    moves++;
                    myMap.printMap();
                    movesMessage(moves);
                }
            }
        }

        if (!canMove) {
            System.out.println("Sorry, you’ve hit a wall.");
            myMap.printMap();
            System.out.print("Pic a new direction. ");
        }

        if (myMap.didIWin()) {
            System.out.println("Congratulations, you made it out alive!");
            System.out.println("And you did it in "+ moves +" moves");
        } else if (moves == 100) {
            System.out.println("Sorry, but you didn't escape in time- you lose!");
        } else  {
            userMove(myMap, moves);
        }

    }

    public static void movesMessage(int moves) {
        if (moves == 50) {
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        } else if (moves == 75) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        } else if (moves == 90) {
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        } else if (moves == 100) {
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
        }
    }

    public static void navigatePit(Maze myMap, String direction, int moves) {
        System.out.print("Watch out! There's a pit ahead, jump it? ");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        if ((int)answer.charAt(0) == 121) {
            myMap.jumpOverPit(direction);
            moves++;
            myMap.printMap();
            movesMessage(moves);
            if (myMap.didIWin()) {
                System.out.println("Congratulations, you made it out alive!");
                System.out.println("And you did it in "+ moves +" moves");
            } else if (moves == 100) {
                System.out.println("Sorry, but you didn't escape in time- you lose!");
            } else  {
                userMove(myMap, moves);
            }

        } else {
            userMove(myMap,moves);
        }
    }
}
