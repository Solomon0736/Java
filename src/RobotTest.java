import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RobotTest {
    public static void main(String[] args) throws FileNotFoundException {
        Maze maze = loadMazeFromFile("src/input.txt");

        if (maze == null) {
            System.out.println("Failed to load maze from file.");
            return;
        }

        System.out.println("Maze loaded successfully:");
       // maze.printMaze();

        RandomRobot robot = new RandomRobot(maze);
        System.out.println("Start position: " + robot.getPosition());

        int moveCount = 0;
        int maxMoves = maze.getNumRows() * maze.getNumColumns(); // Max antal steg innan vi ger upp

        while (!robot.hasReachedGoal() && moveCount < maxMoves) {
            robot.move();
            moveCount++;
        }

        if (robot.hasReachedGoal()) {
            System.out.println("Goal reached at position: " + robot.getPosition());
        } else {
            System.out.println("Goal cannot be reached.");
        }
    }

    private static Maze loadMazeFromFile(String filePath) {
        try {
            Scanner fileScanner = new Scanner(new File(filePath));
            return new Maze(fileScanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
