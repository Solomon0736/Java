import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class maze_main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("input.txt"));
        Maze maze = new Maze(scan);

        int numRows = maze.getNumRows();
        int numColumns = maze.getNumColumns();

        System.out.println("Antal rader: " + numRows);
        System.out.println("Antal kolumner: " + numColumns);

        scan.close();
    }
}
