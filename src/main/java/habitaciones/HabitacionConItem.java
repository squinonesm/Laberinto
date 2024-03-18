package habitaciones;

import laberintoJuego.Habitacion;

/**
 * La clase HabitacionConItem representa una habitación especial del juego del
 * laberinto que contiene un objeto/item. Extiende la clase Habitacion.
 *
 * <p>
 * Autor: SergioQuiñonesMajuelo Version: 1.0 Fecha: 18-03-2024
 * </p>
 */
public class HabitacionConItem extends Habitacion {

    private final String item;

    /**
     * Constructor de la clase HabitacionConItem.
     *
     * @param descripcion La descripción de la habitación.
     * @param item El objeto/item presente en la habitación.
     */
    public HabitacionConItem(String descripcion, String item) {
        super(descripcion);
        this.item = item;
    }

    /**
     * Obtiene el objeto/item presente en la habitación.
     *
     * @return El objeto/item presente en la habitación.
     */
    public String getItem() {
        return item;
    }
}
