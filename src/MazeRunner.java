public class MazeRunner {

    public static void main(String[] args) {
        intro();
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
}
