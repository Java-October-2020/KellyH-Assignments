public class Wizard extends Human {
    public Wizard(String name) {
        this.name = name;
        this.health = 50;
        this.intelligence = 8;
        numOfWizard++;
    }

    public void heal(Human target){
        target.health += this.intelligence;
        System.out.println(this.name + " healed " + target.name);
    }

    public void fireball(Human target) {
        target.health -= this.intelligence * 3;
        System.out.println(this.name + " used fireball on " + target.name + "\n" + target.name + "'s health " + target.health);
    }
}