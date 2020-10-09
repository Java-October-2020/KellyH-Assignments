
public class Gorilla extends mammal {
    public Gorilla() {

    }

    public void throwSomthing(){
        this.energyLevel -= 5;
        this.displayEnergy();
        System.out.println("Thew something");
    }

    public void eatBananas(){
        this.energyLevel += 10;
        this.displayEnergy();
        System.out.println("Gorilla energy level +10");
    }

    public void climbTree(){
        this.energyLevel -= 10;
        this.displayEnergy();
        System.out.println("Gorilla climbed a tree, energy -10");
    }
}
