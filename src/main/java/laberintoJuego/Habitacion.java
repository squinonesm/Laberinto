package laberintoJuego;

import java.util.ArrayList;

/**
 *
 * @author Diurno
 */
public class Habitacion {

    private final String descripcion;
    private Habitacion sNorte;
    private Habitacion sSur;    
    private Habitacion sEste;
    private Habitacion sOeste;

    public Habitacion(String descripcion) {
        this.descripcion = descripcion;
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public String getStringSalidas() {
        ArrayList<String> salidas = new ArrayList<>();
        
        if(sNorte != null){
            salidas.add("Norte");
        }
        if(sSur != null){
            salidas.add("Sur");
        }
        if(sEste != null){
            salidas.add("Este");
        }
        if(sOeste != null){
            salidas.add("Oeste");
        }
        
        return salidas.toString();
    }

    public void getDescripcionLarga() {

        System.out.println("Estas en " + getDescripcion() + " y las salidas posibles son " + getStringSalidas());
    }

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
