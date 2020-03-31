package v1ch06.interfaces.defaultmethod;

public class CarDealWithDefaultMethodByInstruct implements Vehicle, FourWheeler {
   @Override
   public void print(){
      Vehicle.super.print();
   }
}