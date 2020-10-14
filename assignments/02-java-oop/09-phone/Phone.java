public abstract class Phone {
    private String versionNumber;
    private int batteryPercentage;
    private String carrier;
    private String ringTone;

    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }

    //abstract method;
    public abstract void displayInfo();

    public String getVersionNnumber(){
        return versionNumber;
    }
    public int getBatteryPercentage(){
        return batteryPercentage;
    }
    public String getCarrier(){
        return carrier;
    }
    public String getRingTone(){
        return ringTone;
    }
    public void setVersionNnumber(String versionNumber){
        this.versionNumber = versionNumber;
    }
    public void setBatteryPercentage(int percent){
        this.batteryPercentage = percent;    
    }
    public void setCarrier(String carrier){
        this.carrier = carrier;
    }
    public void setRingTone(String ringTone){
        this.ringTone = ringTone;
    }
}