public class BatTest {
    public static void main(String[] args) {
        Bat drac = new Bat();
        drac.displayEnergy();

        
        drac.attackTown("Houston");
        drac.eatHumans();
        drac.fly();
        drac.attackTown("Odessa");
        drac.eatHumans();
        drac.fly();
        drac.attackTown("Midland");
        drac.displayEnergy(); 
    }
}