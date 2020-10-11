public class Tester{
    public static void main(String[] args) {
        
        Samurai Jay = new Samurai("Jay");
        Ninja Leo = new Ninja("Leo");
        Wizard Harry = new Wizard("Harry");


        Jay.meditate();

        Leo.steal(Jay);

        Harry.fireball(Leo);

        Harry.heal(Jay);

        Jay.deathBlow(Harry);

        Leo.runAway();

        Samurai.howMany();
    }
}