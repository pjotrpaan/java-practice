package Static;

public class Dog {

    private int teeth;
    public static int jalgadeArv = 4;

    public static void bark() {
        System.out.println("Haugun");

    }

    public void sit() {
        System.out.println("Istun");
        System.out.println(jalgadeArv);
    }

    public void setName(String name) {
        this.name = name;
    }
}
