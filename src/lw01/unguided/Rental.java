package lw01.unguided;

public abstract class Rental implements Chargeable {
    private String id;
    private int days;
    private int units;

    protected Rental (String id, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Harus lebih dari 0");
        }
        this.id = id;
        this.days = days;
    }   

    public String getId(){
        return id;
    }

    public int getDays(){
        return days;
    }

    public int getUnits(){
        return units;
    }   

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int unit) {
        if (unit <= 0) {
            throw new IllegalArgumentException("Harus bernilai positif");
        }
        return unit * calculateCharge();
    }

    public String label() {
        return "Rental";
    }

    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}
