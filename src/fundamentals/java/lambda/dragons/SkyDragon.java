package fundamentals.java.lambda.dragons;

public class SkyDragon implements Dragon{

    public void attack() {
        System.out.println("Lightning Shoot!!!");
    }

    @Override
    public String attack(String name) {
        return name + "Lightning Shoot!!!";
    }
}
