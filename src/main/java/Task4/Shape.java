package Task4;

public class Shape  implements Comparable<Shape> {

    protected double area;

    public void setArea( double d ) {
        this.area=d;
    }

    public double getArea() {
        return area;
    }

    @Override
    public int compareTo( Shape o) {
        return (int) (this.area - o.area);
    }
}
