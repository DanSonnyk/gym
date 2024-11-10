package fundamentals.java.lambda.dragons;


public class RunGame {
    public static void main(String[] args) {

//        SkyDragon sky = new SkyDragon();
//        System.out.printf(sky.attack("Sky Dragon : " ));

        Dragon dragon = s -> {
            return s + "Lightning Shoot!!!";
        };
        fire(dragon);
    }

    public static void fire(Dragon dragon){
        System.out.println(dragon.attack("Sky Dragon:"));
    }
}

