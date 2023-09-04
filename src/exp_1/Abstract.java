package exp_1;


abstract class Shape {
    abstract void draw();
}

interface Printable {
    void print();
}

class Circle extends Shape implements Printable {
    void draw() {
        System.out.println("drawing circle...");
    }

    public void print() {
        System.out.println("printing circle...");
    }
}


class Rectangle extends Shape implements Printable {
    void draw() {
        System.out.println("drawing rectangle...");
    }

    public void print() {
        System.out.println("printing rectangle...");
    }
}

public class Abstract {
    public static void main(String[] args) {
        Shape s = new Circle();
        s.draw();
        Printable p = new Rectangle();
        p.print();
    }
}
