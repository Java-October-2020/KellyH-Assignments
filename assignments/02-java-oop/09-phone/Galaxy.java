public class Galaxy extends Phone implements Ringable{
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring(){
        return this.getClass().getName() + " says " + this.getRingTone(); //change
    }
    @Override
    public String unlock(){
        return "unlocking via fingerprint";
    }
    @Override
    public void displayInfo(){
        System.out.println(this.getClass().getName() + " " + this.getVersionNnumber() + " fromm " + this.getCarrier());
    }

}
