public class Task1Lab2 {
    private long wholePart;       // Ціла частина числа
    private short decimalPart;    // Дробова частина (до 4 знаків)
    private static int count = 0; // Лічильник створених об’єктів

    // ---------- ГЕТЕР для кількості створених об’єктів ----------
    public static int getCount() {
        return count;
    }

    // ---------- КОНСТРУКТОРИ ----------
    public Task1Lab2() {
        count++;
        this.wholePart = 0;
        this.decimalPart = 0;
    }

    public Task1Lab2(long wholePart) {
        count++;
        this.wholePart = wholePart;
        this.decimalPart = 0;
    }

    public Task1Lab2(long wholePart, short decimalPart) {
        count++;
        this.wholePart = wholePart;
        this.decimalPart = (short) Math.abs(decimalPart);
    }

    public Task1Lab2(Task1Lab2 other) {
        count++;
        this.wholePart = other.wholePart;
        this.decimalPart = other.decimalPart;
    }

    // ---------- ДОПОМІЖНИЙ МЕТОД ----------
    private double toDecimal() {
        return this.wholePart + this.decimalPart / 10000.0;
    }

    // ---------- АРИФМЕТИЧНІ ОПЕРАЦІЇ ----------
    public Task1Lab2 add(Task1Lab2 other) {
        double result = this.toDecimal() + other.toDecimal();
        return fromDouble(result);
    }

    public Task1Lab2 subtract(Task1Lab2 other) {
        double result = this.toDecimal() - other.toDecimal();
        return fromDouble(result);
    }

    public Task1Lab2 multiply(Task1Lab2 other) {
        double result = this.toDecimal() * other.toDecimal();
        return fromDouble(result);
    }

    // ---------- ПОРІВНЯННЯ ----------
    public int compareTo(Task1Lab2 other) {
        return Double.compare(this.toDecimal(), other.toDecimal());
    }

    // ---------- СТВОРЕННЯ ОБ’ЄКТА З double ----------
    public static Task1Lab2 fromDouble(double value) {
        long whole = (long) value;
        short decimal = (short) Math.round((value - whole) * 10000);
        return new Task1Lab2(whole, decimal);
    }

    // ---------- ПЕРЕТВОРЕННЯ У РЯДОК ----------
    @Override
    public String toString() {
        return wholePart + "," + String.format("%04d", decimalPart);
    }

    // ---------- ПЕРЕВИЗНАЧЕННЯ equals ----------
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Task1Lab2)) return false;
        Task1Lab2 other = (Task1Lab2) obj;
        return this.wholePart == other.wholePart &&
                this.decimalPart == other.decimalPart;
    }

    // ---------- ГОЛОВНИЙ МЕТОД ----------
    public static void main(String[] args) {
        Task1Lab2 f1 = new Task1Lab2(3L, (short) 5000);
        Task1Lab2 f2 = new Task1Lab2(2L, (short) 7500);
        Task1Lab2 f3 = new Task1Lab2(f1);

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 (копія f1) = " + f3);

        System.out.println("\n--- Арифметичні операції ---");
        System.out.println("f1 + f2 = " + f1.add(f2));
        System.out.println("f1 - f2 = " + f1.subtract(f2));
        System.out.println("f1 * f2 = " + f1.multiply(f2));

        System.out.println("\n--- Порівняння ---");
        System.out.println("f1 == f3 ? " + f1.equals(f3));
        System.out.println("f1 > f2 ? " + (f1.compareTo(f2) > 0));
        System.out.println("f1 < f2 ? " + (f1.compareTo(f2) < 0));

        System.out.println("\n--- Статичне поле ---");
        System.out.println("Кількість створених об'єктів: " + getCount());
    }
}
