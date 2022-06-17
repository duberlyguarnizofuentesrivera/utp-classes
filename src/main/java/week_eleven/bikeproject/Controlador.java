package week_eleven.bikeproject;

import java.util.ArrayList;
import java.util.Random;

public class Controlador {
    private int mountainBikeSales = 0;
    private int roadBikeSales = 0;
    Random random = new Random();

    public static void main(String[] args) {
        MountainBike mountainBike = new MountainBike();
        RoadBike roadBike = new RoadBike();
        ArrayList<Bike> bikes = new ArrayList<>();
        bikes.add(mountainBike);
        bikes.add(roadBike);
        Controlador controlador = new Controlador();
        controlador.fillArray(bikes);
        controlador.displayStock(bikes);
        controlador.displayBikeNumbers(bikes);
    }

    public void fillArray(ArrayList<Bike> bikes) {
        int aleatorio = random.nextInt(10) + 1; //enteros
        if (aleatorio >= 5) {
            bikes.add(new MountainBike());
            mountainBikeSales++;

        } else {
            bikes.add(new RoadBike());
            roadBikeSales++;
        }
    }

    public void displayStock(ArrayList<Bike> bikes) {
        for (Bike bike : bikes) {
            System.out.println(bike);
        }
    }

    public int calculateStock(ArrayList<Bike> bikes) {
        int bikesSold = 0;
        for (Bike bike : bikes) {
            if (bike instanceof MountainBike) {
                bikesSold++;
            }
        }
        return bikesSold;
    }

    public void displayBikeNumbers(ArrayList<Bike> bikes) {
        int mb = 0;
        int rb = 0;
        mb = calculateStock(bikes);
        rb = bikes.size() - mb;
        System.out.println("\n----------------------------------------------------");
        System.out.println("Niveles de stock:\n"
                + "Tenemos " + mb + " bicicletas de montaña en stock.\n"
                + "Tenemos " + rb + " bicicletas de carretera en stock.\n");
    }
}
