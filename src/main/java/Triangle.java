public class Triangle {

    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return (base * height) / 2;
    }

}
