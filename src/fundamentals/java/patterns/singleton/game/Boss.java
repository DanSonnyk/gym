package fundamentals.java.patterns.singleton.game;

public class Boss {
    private static Boss instance;
    public int life;

    private Boss(int life){
        this.life = life;
    }

    public static Boss getInstance(int life){
        if(instance==null){
            instance = new Boss(life);
        }

        return instance;
    }
}
