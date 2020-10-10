public class HumanTest{
    public static void main(String[] args) {
        Human Charlie = new Human();
        Human Ted = new Human(100,10,5,2); 
    
        Ted.attack(Charlie);
        System.out.println(Charlie.health);
    
    }
}