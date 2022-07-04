package Task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int side = 3;
        int radius = 1;
        int base = 5;
        int height = 2;
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Square(side));
        shapes.add(new Circle(radius));
        shapes.add(new Triangle(base, height));

        System.out.println(shapes);//Before

        Collections.sort(shapes);

        System.out.println(shapes);//After

        for (Shape s:shapes) {
            System.out.println(s.getArea());
        }
    }
}
