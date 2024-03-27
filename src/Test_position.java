public class Test_position {

    private int x;
    private int y;

    public Test_position(int x, int y) {
        this.x=x;
        this.y=y;

    }

    public Test_position(Test_position p) {
        if (p == null){
            throw new NullPointerException();
        }
        this.x=p.x;
        this.y=p.y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x=x;
    }

    public void setY(int y) {
        this.y=y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}