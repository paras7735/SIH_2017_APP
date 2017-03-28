package app.alchemist.sih2017.alchemist;
public class MeterData {
    public String quantity;
    public String quality;
    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public MeterData() {
    }

    public MeterData(String quantity, String quality ) {
        this.quantity = quantity;
        this.quality = quality;
    }
}
