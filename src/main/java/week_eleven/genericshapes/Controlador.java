package week_eleven.genericshapes;

public class Controlador {


    public static void main(String[] args) {
        Cuboide<Integer> c1 = new Cuboide<>(1, 2, 3);
        Cuboide<Double> c2 = new Cuboide<>(1.3, 2.2, 2.0);

        System.out.println("---------------------------------");
        System.out.println(c1.volumen());
        System.out.println(c2.volumen());
        System.out.println("Por Duberly Guarnizo.");
        System.out.println("---------------------------------");
    }
}
