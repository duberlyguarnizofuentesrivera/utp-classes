package week_twelve;

import java.util.HashSet;

public class EjercicioCinco {
    public static void main(String[] args) {
        String[] paisesArray = {"España", "Francia", "Italia", "Alemania", "Francia", "Inglaterra"};

        HashSet<String> paisesSet = new HashSet<>();
        for (String pais : paisesArray) {
            if (paisesSet.add(pais)) {
                System.out.println("Se ha añadido el país " + pais);

            } else {
                System.out.println("\nADVERTENCIA: El país " + pais + " ya existe!\n");
            }
        }

        //----------------------------------------------------
        System.out.println("Países dentro del HashSet:");
        for (String pais : paisesSet) {
            System.out.println(pais);
        }
    }
}
