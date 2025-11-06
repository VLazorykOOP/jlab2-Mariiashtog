//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;

public class task2lab2 {
    private double side;
    private double height;
    private static int count = 0;

    public task2lab2() {
        ++count;
        this.side = (double)1.0F;
        this.height = (double)1.0F;
    }

    public task2lab2(double side, double height) {
        ++count;
        this.side = side;
        this.height = height;
    }

    public task2lab2(task2lab2 other) {
        ++count;
        this.side = other.side;
        this.height = other.height;
    }

    public static int getCount() {
        return count;
    }

    public double baseArea() {
        return Math.sqrt((double)3.0F) / (double)4.0F * this.side * this.side;
    }

    public double lateralArea() {
        return (double)3.0F * this.side * this.height;
    }

    public double volume() {
        return this.baseArea() * this.height;
    }

    public String toString() {
        return String.format("Призма: сторона = %.2f, висота = %.2f", this.side, this.height);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof task2lab2)) {
            return false;
        } else {
            task2lab2 other = (task2lab2)obj;
            return this.side == other.side && this.height == other.height;
        }
    }

    public static void main(String[] args) {
        task2lab2 prism1 = new task2lab2((double)4.0F, (double)10.0F);
        task2lab2 prism2 = new task2lab2((double)3.0F, (double)8.0F);
        task2lab2 prism3 = new task2lab2(prism1);
        System.out.println(prism1);
        System.out.println(prism2);
        System.out.println("Копія prism1: " + String.valueOf(prism3));
        System.out.println("\n--- Обчислення ---");
        System.out.printf("Площа основи prism1 = %.2f\n", prism1.baseArea());
        System.out.printf("Бічна площа prism1 = %.2f\n", prism1.lateralArea());
        System.out.printf("Об’єм prism1 = %.2f\n", prism1.volume());
        System.out.println("\n--- Порівняння ---");
        PrintStream var10000 = System.out;
        boolean var10001 = prism1.equals(prism3);
        var10000.println("prism1 == prism3 ? " + var10001);
        var10000 = System.out;
        var10001 = prism1.equals(prism2);
        var10000.println("prism1 == prism2 ? " + var10001);
        System.out.println("\n--- Статичне поле ---");
        System.out.println("Кількість створених об’єктів: " + getCount());
    }
}
