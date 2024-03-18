package habitaciones;

import interfaces.OlorFuerte;
import laberintoJuego.Habitacion;

/**
 * La clase HabitacionNoxus representa una habitación especial del juego del
 * laberinto, donde se encuentra el personaje Noxus. Extiende la clase
 * Habitacion e implementa la interfaz OlorFuerte.
 *
 * <p>
 * Autor: SergioQuiñonesMajuelo Version: 1.0 Fecha: 18-03-2024
 * </p>
 */
public class HabitacionNoxus extends Habitacion implements OlorFuerte {

    /**
     * Constructor de la clase HabitacionNoxus.
     *
     * @param descripcion La descripción de la habitación.
     */
    public HabitacionNoxus(String descripcion) {
        super(descripcion);
    }

    /**
     * Muestra un mensaje indicando que el jugador se ha encontrado con Noxus y
     * solicita una decisión al jugador.
     */
    public void encuentrasNoxus() {
        System.out.println("¡Te has encontrado con Noxus el destructor de mundos!");
        System.out.println("El gatito risueño dice que conoce un atajo. ¿Aceptas su ayuda?");
    }

    /**
     * Verifica si el jugador acepta la ayuda de Noxus.
     *
     * @param decision La decisión tomada por el jugador.
     * @return true si el jugador acepta la ayuda, false de lo contrario.
     */
    public boolean ayudaNoxus(String decision) {
        if (decision.equalsIgnoreCase("S")) {
            System.out.println("Sigues a Noxus y este te mete en un avión.");
            System.out.println("¡Deberías haber estudiado!");
            System.out.println("Vas a ser deportado por las autoridades perrunas.");
            return true;
        } else {
            System.out.println("Noxus te mira mal, pero no ocurre nada.");
            return false;
        }
    }

    /**
     * Bloquea el rastro en la habitación debido al fuerte olor.
     *
     * @return Una cadena que indica que el rastro ha sido bloqueado debido al
     * olor fuerte.
     */
    @Override
    public String bloquearRastro() {
        return "Huele tanto a destrucción que no puedes rastrear las salidas.";
    }
}
