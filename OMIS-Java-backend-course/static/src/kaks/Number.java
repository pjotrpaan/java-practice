package kaks;

public class Number {
    private int number;
    private String name;

    public Number(String name) {
        this.name = name;
        number++;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
