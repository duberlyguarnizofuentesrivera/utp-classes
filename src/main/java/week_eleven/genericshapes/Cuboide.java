package week_eleven.genericshapes;


import static java.lang.Math.round;

public class Cuboide<T extends Number> {
    private T largo;
    private T ancho;
    private T alto;

    public Cuboide(T largo, T ancho, T alto) {
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
    }

    public T volumen() {
        if (largo instanceof Integer) {
            return (T) Integer.valueOf(largo.intValue() * ancho.intValue() * alto.intValue());
        } else if (largo instanceof Double) {
            return (T) Double.valueOf(largo.doubleValue() * ancho.doubleValue() * alto.doubleValue());
        }
        return null;
    }


    public T getLargo() {
        return largo;
    }

    public T getAncho() {
        return ancho;
    }

    public T getAlto() {
        return alto;
    }

    public void setLargo(T largo) {
        this.largo = largo;
    }

    public void setAncho(T ancho) {
        this.ancho = ancho;
    }

    public void setAlto(T alto) {
        this.alto = alto;
    }

    @Override
    public String toString() {
        return "Cuboid{" +
                "largo=" + largo +
                ", ancho=" + ancho +
                ", alto=" + alto +
                '}';
    }
}
