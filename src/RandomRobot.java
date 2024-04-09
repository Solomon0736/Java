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
            Position new_position;
            Random random = new Random();

            do {
                int direction = random.nextInt(4); // 0: North, 1: South, 2: West, 3: East

                switch (direction) {
                    case 0:
                        new_position = position.getPosToNorth();
                        break;
                    case 1:
                        new_position = position.getPosToSouth();
                        break;
                    case 2:
                        new_position = position.getPosToWest();
                        break;
                    case 3:
                        new_position = position.getPosToEast();
                        break;
                    default:
                        new_position = position; // Stanna kvar på nuvarande position om något oväntat inträffar
                }

                if (maze.isMovable(new_position) && !new_position.equals(previousPosition)) {
                    previousPosition = position;
                    position = new_position;
                    break;
                } else if (new_position.equals(previousPosition)) {
                    // Gå tillbaka till den senast besökta positionen
                    position = previousPosition;
                    break;
                }

            } while (true);
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
