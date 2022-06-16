package week_eleven.bikeproject;

public class BikeDriver {
    public static void main(String[] args) {

        RoadBike bike1 = new RoadBike();
        RoadBike bike2 = new RoadBike("drop", "tourer", "semi-grip", "comfort", 14, 25, 18);
        MountainBike bike3 = new MountainBike();

        System.out.println(bike1);
        System.out.println(bike2);
        System.out.println(bike3);

        bike1.setPostHeight(20);
        System.out.println(bike1);
    }//end method main
}
