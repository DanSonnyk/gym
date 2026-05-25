package fundamentals.java;

// When an Object its owner of another one, if the first not exists the intern second one turn off to.
public class Composition {
  puclic class Motor{
    private int potency;

    public Motor(int potency){
      this.potencia = potency;
    }

   public int getPotency(){
     return potency;
   }
  }

  //Note the Motor is created inside the Car class, if Car bean its destroyed, motor its gone to
  public class Car(){
    private Motor motor;

    public Car(int potency){
      this.motor = new Motor(potency);
    }

    public void turnOn(){
      System.out.println("Turn on the with potency:", motor.getPotency());
    }
  }
}
