package laberintoJuego;

import java.util.ArrayList;

/**
 * La clase Habitacion representa una habitación dentro del laberinto del juego.
 * Cada habitación tiene una descripción y puede tener salidas en las cuatro
 * direcciones cardinales.
 *
 * <p>
 * Autor: SergioQuiñonesMajuelo Version: 1.0 Fecha: 18-03-2024
 * </p>
 */
public class Habitacion {

    private final String descripcion;
    private Habitacion sNorte;
    private Habitacion sSur;
    private Habitacion sEste;
    private Habitacion sOeste;

    /**
     * Constructor de la clase Habitacion.
     *
     * @param descripcion La descripción de la habitación.
     */
    public Habitacion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece una salida en una dirección dada.
     *
     * @param direccion La dirección de la salida (norte, sur, este u oeste).
     * @param h La habitación a la que se dirige la salida.
     */
    public void setSalida(String direccion, Habitacion h) {
        switch (direccion.toLowerCase()) {
            case "norte":
                this.sNorte = h;
                break;
            case "sur":
                this.sSur = h;
                break;
            case "este":
                this.sEste = h;
                break;
            case "oeste":
                this.sOeste = h;
                break;
            default:
                System.out.println("Dirección no válida");
        }
    }

    /**
     * Obtiene la descripción de la habitación.
     *
     * @return La descripción de la habitación.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene una representación en forma de cadena de las salidas disponibles
     * en la habitación.
     *
     * @return Una cadena que contiene las direcciones de las salidas
     * disponibles.
     */
    public String getStringSalidas() {
        ArrayList<String> salidas = new ArrayList<>();

        if (sNorte != null) {
            salidas.add("Norte");
        }
        if (sSur != null) {
            salidas.add("Sur");
        }
        if (sEste != null) {
            salidas.add("Este");
        }
        if (sOeste != null) {
            salidas.add("Oeste");
        }

        return salidas.toString();
    }

    /**
     * Imprime una descripción larga de la habitación, incluyendo su descripción
     * y las salidas disponibles.
     */
    public void getDescripcionLarga() {

        System.out.println("Estas en " + getDescripcion() + " y las salidas posibles son " + getStringSalidas());
    }

    /**
     * Obtiene la habitación a la que se dirige la salida en una dirección dada.
     *
     * @param direccion La dirección de la salida.
     * @return La habitación a la que se dirige la salida, o null si no hay una
     * salida en esa dirección.
     */
    public Habitacion getSalida(String direccion) {

        switch (direccion.toLowerCase()) {
            case "norte" -> {
                return sNorte;
            }
            case "sur" -> {
                return sSur;
            }
            case "este" -> {
                return sEste;
            }
            case "oeste" -> {
                return sOeste;
            }
            default -> {
                System.out.println("Dirección no válida");
                return null;
            }
        }
    }

}
