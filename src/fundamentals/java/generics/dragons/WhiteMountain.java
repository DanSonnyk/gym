package fundamentals.java.generics.dragons;

public class WhiteMountain {
    WhiteDragon dragons;


    WhiteMountain(WhiteDragon dragon){
        this.dragons = dragon;
    }

    public void reaction(){
        dragons.shootAttack();
    }

}
