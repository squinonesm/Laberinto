package habitaciones;

import interfaces.OlorFuerte;
import laberintoJuego.Habitacion;

/**
 * La clase HabitacionMerienda representa una habitación especial del juego del
 * laberinto, donde se encuentra una merienda. Extiende la clase Habitacion e
 * implementa la interfaz OlorFuerte.
 * 
 * <p>
 * Autor: SergioQuiñonesMajuelo Version: 1.0 Fecha: 18-03-2024
 * </p>
 */
public class HabitacionMerienda extends Habitacion implements OlorFuerte {

    /**
     * Constructor de la clase HabitacionMerienda.
     *
     * @param descripcion La descripción de la habitación.
     */
    public HabitacionMerienda(String descripcion) {
        super(descripcion);
    }

    /**
     * Muestra un mensaje indicando la presencia de una merienda en la
     * habitación y solicita una decisión al jugador.
     */
    public void ahiDiceGratis() {
        System.out.println("¡Encuentras una casita con mate y tarta! ¿Qué coges?");
    }

    /**
     * Bloquea el rastro en la habitación debido al fuerte olor de la merienda.
     *
     * @return Una cadena que indica que el rastro ha sido bloqueado debido al
     * olor fuerte de la merienda.
     */
    @Override
    public String bloquearRastro() {
        return "Hay un olor tan FUERTEMENTE rico que te nubla los sentidos y no puedes rastrear las salidas.";
    }

}
