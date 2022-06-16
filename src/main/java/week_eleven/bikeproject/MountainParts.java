package week_eleven.bikeproject;

public interface MountainParts {
    //constant declaration
    BikeUses TERRAIN = BikeUses.OFF_ROAD;

    //required methods after implementation
    String getSuspension();

    void setSuspension(String newValue);

    String getType();

    void setType(String newValue);
}
