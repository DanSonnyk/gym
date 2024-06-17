package fundamentals.java.generics.dragons;

public class BlackMountain {
    BlackDragon dragons;

    BlackMountain(BlackDragon dragon){
        this.dragons = dragon;
    }

    public void reaction(){
        dragons.shootAttack();
    }

}
