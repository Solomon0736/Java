import java.util.ArrayList;
import java.util.Scanner;

public class Maze {
    private ArrayList<String> maze; // Ändrad till ArrayList<String>
    private int rows;
    private int cols;
    private Position start;
    private Position goal;

    public Maze(Scanner file) {
        maze = new ArrayList<>();
        int maxCols = 0;
        int rowIndex = 0;

        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (line.length() > maxCols) {
                maxCols = line.length();
            }
            maze.add(line); // Lägg till hela raden som en sträng i listan
            rowIndex++;
        }

        // Fyll ut korta rader med blanka tecken så att alla rader får samma längd
        for (int i = 0; i < maze.size(); i++) {
            String row = maze.get(i);
            if (row.length() < maxCols) {
                while (row.length() < maxCols) {
                    row += " "; // Lägg till blanka tecken för att fylla ut rader
                }
                maze.set(i, row);
            }
        }


        // Hitta start- och slutpositionerna baserat på 'S' och 'G' i labyrinten
        for (int i = 0; i < maze.size(); i++) {
            String row = maze.get(i);
            for (int j = 0; j < row.length(); j++) {
                char c = row.charAt(j);
                if (c == 'S') {
                    start = new Position(i, j);
                } else if (c == 'G') {
                    goal = new Position(i, j);
                }
            }
        }

        rows = rowIndex;
        cols = maxCols;
    }


    public boolean isMovable(Position pos) {
        int x = pos.getX();
        int y = pos.getY();
        if (x < 0 || y < 0 || x >= rows || y >= cols) {
            return false; // Positionen är utanför labyrintens gränser
        }

        // Hämta raden från labyrinten och kontrollera tecknet på den specifika kolumnen
        String row = maze.get(x);
        System.out.println("Row: " + row);
        System.out.println("Column: " + y);
        char cell = row.charAt(y);
        return cell != 'x' && cell != '*';
    }



    public boolean isGoal(Position position) {
        int x = position.getX();
        int y = position.getY();
        if (x < 0 || y < 0 || x >= rows || y >= cols) {
            return false;
        }
        return maze.get(x).charAt(y) == 'G'; // Kontrollera om positionen är en målposition
    }

    public Position getStart() {
        return start;
    }

    public int getNumColumns() {
        return cols;
    }

    public int getNumRows() {
        return rows;
    }
}
