package lw01.unguided;

public class ProjectorRental extends Rental{
    public ProjectorRental(String id, int days){
        super(id, days);
    }
    
    @Override 
    public int calculateCharge(){
        int days = getDays();
        int unit = getUnits();
        int hargaTotal = 0;

        if (days <= 3){
            hargaTotal += days * 60000; 
        }else{
            hargaTotal += (3*60000) + ((days - 3) * 45000 + (getUnits() * 20000));
        }
        return hargaTotal;
    }

    @Override 
    public String label(){
        return "Projector";
    }
}
