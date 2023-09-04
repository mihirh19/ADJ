package exp_3.decoratordesign;


interface Shape {
    void draw();
}

class Circle implements Shape {

    @Override
    public void draw()
    {
        System.out.println("Shape: Circle");
    }
}

class Rectangle implements Shape {

    // Overriding the method
    @Override public void draw()
    {
        // /Print statement to execute when
        // draw() method of this class is called
        // later on in the main() method
        System.out.println("Shape: Rectangle");
    }
}


abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape)
    {
        this.decoratedShape = decoratedShape;
    }

    public void draw() { decoratedShape.draw(); }
}


// Class 3
// Concrete class extending the abstract class
// RedShapeDecorator.java
class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape)
    {
        super(decoratedShape);
    }

    @Override public void draw()
    {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape)
    {
        // Display message whenever function is called
        System.out.println("Border Color: Red");
    }
}
public class Main {
    public static void main(String[] args) {
        Shape circle = new Rectangle();

        Shape redCircle
                = new RedShapeDecorator(new Circle());

        Shape redRectangle
                = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();
        System.out.println("\nCircle of red border");
        redCircle.draw();
        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
