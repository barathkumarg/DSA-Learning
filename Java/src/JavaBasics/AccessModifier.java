package JavaBasics;

/**
 * ============================================================
 *            Java Access Modifiers
 * ============================================================
 *
 * This program demonstrates:
 * 1. private access modifier
 * 2. default (package-private) access modifier
 * 3. protected access modifier
 * 4. public access modifier
 *
 * Visibility Scope:
 * ------------------------------------------------------------
 * Modifier     | Same Class | Same Package | Subclass | Anywhere
 * ------------------------------------------------------------
 * private      |    ✔       |      ✘       |    ✘     |    ✘
 * default      |    ✔       |      ✔       |    ✘     |    ✘
 * protected    |    ✔       |      ✔       |    ✔     |    ✘
 * public       |    ✔       |      ✔       |    ✔     |    ✔
 * ============================================================
 */

/* ============================
 * PRIVATE ACCESS MODIFIER
 * ============================
 */
class Person {

    private String name; // accessible ONLY inside this class

    // public setter
    public void setName(String name) {
        this.name = name;
    }

    // public getter
    public String getName() {
        return name;
    }
}

/* ============================
 * DEFAULT ACCESS MODIFIER
 * ============================
 * No keyword used
 */
class Car {
    String model; // default (package-private)
}

/* ============================
 * PROTECTED ACCESS MODIFIER
 * ============================
 */
class Vehicle {
    protected int speed;
}

class Bike extends Vehicle {

    void setSpeed(int s) {
        speed = s; // accessible due to inheritance
    }

    int getSpeed() {
        return speed;
    }
}

/* ============================
 * PUBLIC ACCESS MODIFIER
 * ============================
 */
class MathUtils {

    public static int add(int a, int b) {
        return a + b;
    }
}

/* ============================
 * MAIN CLASS
 * ============================
 */
public class AccessModifier {

    public static void main(String[] args) {

        System.out.println("----- PRIVATE MODIFIER -----");
        Person p = new Person();
        p.setName("Alice");
        System.out.println(p.getName());
        // p.name ❌ Not accessible (private)

        System.out.println("\n----- DEFAULT MODIFIER -----");
        Car c = new Car();
        c.model = "Tesla";
        System.out.println(c.model);

        System.out.println("\n----- PROTECTED MODIFIER -----");
        Bike b = new Bike();
        b.setSpeed(100);
        System.out.println("Bike Speed: " + b.getSpeed());

        Vehicle v = new Vehicle();
        System.out.println("Vehicle Speed (same package): " + v.speed);

        System.out.println("\n----- PUBLIC MODIFIER -----");
        System.out.println("Addition: " + MathUtils.add(5, 10));
    }
}

