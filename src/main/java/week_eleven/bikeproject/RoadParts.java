package week_eleven.bikeproject;

public interface RoadParts {
    //constant declaration
    BikeUses TERRAIN = BikeUses.TRACK;

    //required methods after implementation
    int getTyreWidth();

    void setTyreWidth(int newValue);

    int getPostHeight();

    void setPostHeight(int newValue);
}
