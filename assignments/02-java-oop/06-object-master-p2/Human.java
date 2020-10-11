public class Human{
   protected int health = 100;
   protected int strength = 3;
   protected int stealth = 3;
   protected int intelligence = 3;
   protected String name = null;
   protected static int numOfNinja = 0;
   protected static int numOfWizard = 0;
   protected static int numOfSamurai = 0;

    public Human(){
        // this.name = name;
        //default
    }

    public Human(String name, int health, int strength, int stealth, int intelligence){
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.stealth = stealth;
        this.intelligence = intelligence;
    }

    public void attack(Human target){
        target.health -= this.strength;
    }
}