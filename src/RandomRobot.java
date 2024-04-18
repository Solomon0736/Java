import java.util.Objects;
import java.util.Random;

public class RandomRobot {
    private  Maze maze;
    private Position position;
    private Position previousPosition; // Tredje attribut

    public RandomRobot(Maze maze) {
        this.maze = maze;
        this.position = maze.getStart();
    }

        public void move() {
        Position newposition;
        Random rand = new Random();

        do {
            int number = rand.nextInt(4);

            switch(number){
                case 0:
                    newposition = position.getPosToEast();
                    break;
                case 1:
                    newposition= position.getPosToNorth();
                    break;
                case 2:
                    newposition= position.getPosToSouth();
                    break;
                case 3:
                    newposition = position.getPosToWest();
                    break;
                default:
                    newposition= position;
            }

            if (!newposition.equals(previousPosition)&& maze.isMovable(newposition)){
                previousPosition = position;
                position=newposition;
                break;
            }else if (newposition.equals(previousPosition)){
                position=previousPosition;  break;
            }


        }while (true);

        }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean hasReachedGoal() {
        return maze.isGoal(position);
    }
}
