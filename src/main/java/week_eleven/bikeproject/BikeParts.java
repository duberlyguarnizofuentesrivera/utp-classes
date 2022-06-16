package week_eleven.bikeproject;

public interface BikeParts {
    //constant declaration
    String MAKE = "Oracle Bikes";

    //required methods after implementation
    String getHandleBars();

    void setHandleBars(String newValue);

    String getTyres();

    void setTyres(String newValue);

    String getSeatType();

    void setSeatType(String newValue);
}
