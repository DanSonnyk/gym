package fundamentals.java.generics.dragons;


//When a Dragon arrive in a mountain fire your power
public class RunGame {

    public static void main(String[] args) {
        Mountain white = new Mountain(new WhiteDragon());

        Mountain black = new Mountain(new BlackDragon());

        Mountain metal = new Mountain(new MetalDragon());

        white.reaction();
        black.reaction();
        metal.reaction();

    }

}
