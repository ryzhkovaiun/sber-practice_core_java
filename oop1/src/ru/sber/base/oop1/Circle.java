package ru.sber.base.oop1;

public class Circle {
    private final double radius;
    private final Color color;

    public Circle(double radius, Color color){
        this.radius = radius;
        this.color =color;

        this.color.setAlpha(Color.MAX_VALUE);
    }
    public double area(){
        return Math.PI * Math.pow(radius,2);
    }

    public double perimeter(){
        return 2 * Math.PI * radius;
    }
    public String toString(){
        return String.format("{ Радиус: %.3f; Цвет: + number +; Площадь: %.3f;Периметр:%.3f}",radius, color, area(),
                perimeter());
    }
    public static void main(String[] args) {

        Circle circle = new Circle(Math.random() * 69, new Color(150, 50, 100));

        System.out.format("Площадь круга: %f\n", circle.area());
        System.out.format("Периметр круга: %f\n", circle.perimeter());

        System.out.println(circle);
    }
}
