public class Bat extends mammal {


   public Bat() {
       this.energyLevel = 300;
   }

    public void fly(){
        System.out.println("woosh woosh woosh");
        energyLevel -= 50;
    }

    public void eatHumans(){
        System.out.println("Bat is eating a human!");
        energyLevel += 25;
    }

    public void attackTown(String town){
        System.out.println("crackles and screams from " + town);
        energyLevel -= 100;
    }
}