//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class task3lab2 {
    private int year;
    private int dayOfYear;
    private static int count = 0;

    public task3lab2() {
        ++count;
        this.year = 2000;
        this.dayOfYear = 1;
    }

    public task3lab2(int dayOfYear, int year) {
        ++count;
        this.dayOfYear = dayOfYear;
        this.year = year;
    }

    public task3lab2(task3lab2 other) {
        ++count;
        this.year = other.year;
        this.dayOfYear = other.dayOfYear;
    }

    public static int getCount() {
        return count;
    }

    public String getDateAndWeekday() {
        try {
            LocalDate date = LocalDate.ofYearDay(this.year, this.dayOfYear);
            String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("uk", "UA"));
            String month = date.getMonth().getDisplayName(TextStyle.FULL, new Locale("uk", "UA"));
            int dayOfMonth = date.getDayOfMonth();
            return String.format("%d %s, %s", dayOfMonth, month, dayOfWeek);
        } catch (Exception var5) {
            return "Невірний день року!";
        }
    }

    public String toString() {
        return String.format("Календар: рік = %d, день року = %d", this.year, this.dayOfYear);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof task3lab2)) {
            return false;
        } else {
            task3lab2 other = (task3lab2)obj;
            return this.year == other.year && this.dayOfYear == other.dayOfYear;
        }
    }

    public static void main(String[] args) {
        task3lab2 cal1 = new task3lab2(32, 2002);
        task3lab2 cal2 = new task3lab2(365, 2023);
        task3lab2 cal3 = new task3lab2(cal1);
        System.out.println(cal1);
        System.out.println("Дата та день тижня: " + cal1.getDateAndWeekday());
        System.out.println(cal2);
        System.out.println("Дата та день тижня: " + cal2.getDateAndWeekday());
        System.out.println("\nКопія cal1: " + cal3.getDateAndWeekday());
        System.out.println("\nПорівняння:");
        PrintStream var10000 = System.out;
        boolean var10001 = cal1.equals(cal3);
        var10000.println("cal1 == cal3 ? " + var10001);
        var10000 = System.out;
        var10001 = cal1.equals(cal2);
        var10000.println("cal1 == cal2 ? " + var10001);
        System.out.println("\nКількість створених об’єктів: " + getCount());
    }
}
