package fundamentals.java.patterns.singleton.game;

public class RunGame {
    public static void main(String[] args) {

        Boss boss = Boss.getInstance(8000);
        Boss boss2 = Boss.getInstance(1000);

        System.out.println("Boss Life points: "+boss.life);
        System.out.println("Boss Life points: "+boss2.life);

    }
}
