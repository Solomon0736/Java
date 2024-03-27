
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

    public Position getPosToSouth(){
        return new Position(this.x,this.y+1);
    }

    public Position getPosToNorth(){
        return new Position(this.x,this.y-1);
    }

    public Position getPosToWest(){
        return new Position(this.x+1,this.y);

    }

    public Position getPosToEast(){
        return new Position(this.x-1,this.y);

    }

    public boolean equal(Object o){
        if (o == this) return true;
        if (!(o instanceof Position)) return false;

        Position p = (Position)o ;
        return x == p.x && y == p.y;
    }

    public int hashCode(){

    }




}