public class Samurai extends Human {
    public Samurai(String name){
        this.name = name;
        this.health = 200;
        numOfSamurai++;
    }

    public void deathBlow(Human target){
        target.health = 0; 
        this.health /=2;
        System.out.println(this.name + " just killed " + target.name + "!");
    }

    public void meditate(){
        this.health += this.health / 2;
        System.out.println(this.name + "'s Health: "+ this.health);
    }

    public static int howMany(){
        System.out.printf("There are %d samruais", numOfSamurai);
        return numOfSamurai;
    }
}
