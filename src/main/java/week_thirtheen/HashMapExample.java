package week_thirtheen;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    HashMap<String, String> tazonFruta = new HashMap<>();

    public static void main(String[] args) {
        HashMapExample hashMapExample = new HashMapExample();
        hashMapExample.fillHashMap();
        hashMapExample.displayHashMap();
        hashMapExample.findElement("Melocoton");
    }

    private void displayHashMap() {
        int totalLen = 12;
        System.out.println("\nLISTADO DE FRUTAS EN EL HASHMAP");
        System.out.println("----------------------------------------------------");
        System.out.println("--FRUTA-- | --COLOR---");
        for (Map.Entry<String, String> fruta : tazonFruta.entrySet()) {
            int keyLen = fruta.getKey().length();
            String spaces = new String(new char[totalLen - keyLen]).replace("\0", " ");
            System.out.print(" " + fruta.getKey() + spaces + fruta.getValue() + "\n");
        }
    }

    private void fillHashMap() {
        tazonFruta.put("Manzana", "Naranja");
        tazonFruta.put("Pera", "Roja");
        tazonFruta.put("Mandarina", "Naranja");
        tazonFruta.put("Sandia", "Amarillo");
        tazonFruta.put("Melon", "Verde");
        tazonFruta.put("Ciruela", "Roja");
        tazonFruta.put("Mango", "Amarillo");
        tazonFruta.put("Papaya", "Verde");
        tazonFruta.put("Uva", "Negra");
    }

    private void findElement(String value) {
        System.out.println("\nBÚSQUEDA DE ELEMENTO EN EL HASHMAP");
        System.out.println("----------------------------------------------------");
        boolean found = false;
        for (Map.Entry<String, String> fruta : tazonFruta.entrySet()) {

            if (fruta.getKey().equalsIgnoreCase(value)) {
                System.out.println("La fruta " + fruta.getKey() + " es de color " + fruta.getValue());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No se encontró la fruta " + value);
        }
    }
}
