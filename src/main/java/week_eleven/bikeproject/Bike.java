package week_eleven.bikeproject;

public class Bike implements BikeParts{

    private String handleBars;
    private String frame;
    private String tyres;
    private String seatType;
    private int numGears;
    private final String make;

    public Bike(){
        this.make = "Oracle Cycles";
    }//end constructor

    public Bike(String handleBars, String frame, String tyres, String seatType, int numGears) {
        this.handleBars = handleBars;
        this.frame = frame;
        this.tyres = tyres;
        this.seatType = seatType;
        this.numGears = numGears;
        this.make = "Oracle Cycles";
    }//end constructor

    public String toString()
    {
        return ("\n" + this.make + "\n"
                + "This bike has " + this.handleBars + " handlebars on a "
                + this.frame + " frame with " + this.numGears + " gears."
                + "\nIt has a " + this.seatType + " seat with " + this.tyres + " tyres.");
    }//end method toString


    @Override
    public String getHandleBars() {
        return this.handleBars;
    }//end method getHandleBars

    @Override
    public void setHandleBars(String newValue) {
        this.handleBars = newValue;
    }//end method setHandleBars

    @Override
    public String getTyres() {
        return this.tyres;
    }//end method getTyres

    @Override
    public void setTyres(String newValue) {
        this.tyres = newValue;
    }//end method setTyres

    @Override
    public String getSeatType() {
        return this.seatType;
    }//end method getSeatType

    @Override
    public void setSeatType(String newValue) {
        this.seatType = newValue;
    }//end method

}
