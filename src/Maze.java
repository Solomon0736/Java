import java.io.File;
import java.util.Scanner;

public class Maze {

    private int rows;
    private int cols;
    private int[][] arr;
    private Position start;

    public Maze(Scanner scan) {
        rows = 0;

    }


    public boolean ismovable(Position pos){
        return true;
    }
    public boolean isGoal(Position position) {
        if (position == position) {
            return true;
        }
        return false;
    }
    public Position getstarted(){
    return start;
    }
    public int getNumColumns(){
        return cols;
    }
    public int getNumRows(){
        return rows;
    }
}