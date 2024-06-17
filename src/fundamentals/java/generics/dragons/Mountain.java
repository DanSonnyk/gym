package fundamentals.java.generics.dragons;

public class Mountain <T extends Dragon>{
    T dragons;

    public Mountain(T dragon){
        this.dragons = dragon;
    }

    public void reaction(){
        dragons.shootAttack();
    }

}
