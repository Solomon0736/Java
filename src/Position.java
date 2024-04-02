import java.util.Objects;

public class Position {
    private  int x;
    private  int y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Position getPosToSouth() {
        return new Position(x, y + 1);
    }

    public Position getPosToNorth() {
        return new Position(x, y - 1);
    }

    public Position getPosToWest() {
        return new Position(x - 1, y);
    }

    public Position getPosToEast() {
        return new Position(x + 1, y);
    }
    public boolean equals(Object o) {
        // Kontrollera om objektet är samma som den aktuella instansen
        if (this == o) return true;
        // Kontrollera om objektet är en instans av Position-klassen
        if (!(o instanceof Position)) {
            return false;
        }
        // Om objektet är av Position-typ, kasta om det till en Position-referens
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
    public int hashCode(){
        return Objects.hash(x, y);
    }

}