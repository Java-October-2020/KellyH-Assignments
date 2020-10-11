public class Ninja extends Human {
    public Ninja(String name){
        this.name = name;
        this.stealth = 10;
        numOfNinja++;
    }

    public void steal(Human target){
        target.health -= this.stealth;
        this.health += this.stealth;
        System.out.println(this.name + " stole health from " + target.name + "\n" + this.name + "'s health " + this.health + "\n" + target.name + "'s health " + target.health);
    }

    public void runAway(){
        this.health -= 10;
        System.out.println(this.name + " ran away!");

    }
    
}