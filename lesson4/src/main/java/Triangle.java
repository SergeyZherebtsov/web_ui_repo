public class Triangle {
    public static double getArea(int a, int b, int c) throws Exception {
        // Вычислим площадь треугольника по формуле Герона
        double pp; // значение полупериметра
        double s;  // значение плащади

        if (a < 0 || b < 0 || c < 0) throw new TriangleExceptions("Стороны треугольника не могут быть отрицательными");
        if (a + b < c || a + c < b || b + c < a) throw new TriangleExceptions("Треугольник не существует");

        pp = (double) (a + b + c) / 2;  // приведём числитель к типу double, чтобы небыло округления
        s = java.lang.Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
//        System.out.println("s="+s);
        return s;
    }
}
