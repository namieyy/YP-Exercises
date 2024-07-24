class Shape{
    double perimeter;
    double area;

    Shape(){
        this.area = getArea();
        this.perimeter = getPerimeter();
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
}

class Circle extends Shape{
    double radius;
    double pi;

    Circle(double pi, double radius){
        this.pi = pi;
        this.radius = radius;
    }

    public double getRadius(double radius) {
        return radius;
    }

    public double getPi(double pi) {
        return pi;
    }

    @Override
    public double getPerimeter(){
        double circlePerimeter = 2 * this.pi * this.radius;
        return circlePerimeter;
    }

    @Override
    public double getArea(){
        double circleArea = (this.pi * this.radius) * (this.pi * this.radius);
        return circleArea;
    }

    public void Display(){
        super.area = getArea();
        super.perimeter = getPerimeter();
        System.out.println("Circle Area: " + area +
                "\nCircle perimeter: " + perimeter);
    }
}

public class Exercise38Q2 {
    public static void main(String[] args) {
        Circle circle = new Circle(3.142, 4);
        circle.Display();
    }
}
