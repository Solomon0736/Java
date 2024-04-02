import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class RandomRobot {
    private Position position;
    private Position previousPosition;
    private Maze maze;

    public RandomRobot(Maze maze) {

        this.maze = maze;
        position = maze.getstarted();
        previousPosition= new Position(position.getX() - 1, position.getY());
    }

    public void move() {

        Position new_position = null;
        do {
            Random rand = new Random();
            int number = rand.nextInt(4) + 1;

            try {
                if (number == 1) {
                    new_position = position.getPosToSouth();
                } else if (number == 2) {
                    new_position = position.getPosToEast();
                } else if (number == 3) {
                    new_position = position.getPosToNorth();
                } else {
                    new_position = previousPosition;
                }

                if (maze.ismovable(new_position)) {
                    position = new_position;
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("error out of bound" + e.getMessage());
            }

        } while (((new_position.getX() < 0 || new_position.getX() >= maze.getNumRows() ||
                new_position.getY() < 0 || new_position.getY() >= maze.getNumColumns())));
    }

    public Position getPosition() {
        return position;
    }

    private void setPosition(Position position) {
        this.position = position;
    }

    public boolean hasReachedGoal() {
        return maze.isGoal(position);
    }
}