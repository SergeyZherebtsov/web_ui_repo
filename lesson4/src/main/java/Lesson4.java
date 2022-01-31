public class Lesson4 {
    public static void main(String[] args) throws Exception {

        double s = Triangle.getArea(5, 15, 18);

        if (s == 0) {
            System.out.println("Площадь равна: " + s + ", треугольник является вырожденным");
        } else {
            System.out.println("Площадь равна: " + s);
        }
    }
}
