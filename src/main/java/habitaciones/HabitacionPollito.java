package habitaciones;

import interfaces.OlorFuerte;
import laberintoJuego.Habitacion;

/**
 * La clase HabitacionPollito representa una habitación especial del juego del
 * laberinto, donde se encuentra el personaje Pollito. Extiende la clase
 * Habitacion e implementa la interfaz OlorFuerte.
 *
 * <p>
 * Autor: SergioQuiñonesMajuelo Version: 1.0 Fecha: 18-03-2024
 * </p>
 */
public class HabitacionPollito extends Habitacion implements OlorFuerte {

    /**
     * Constructor de la clase HabitacionPollito.
     *
     * @param descripcion La descripción de la habitación.
     */
    public HabitacionPollito(String descripcion) {
        super(descripcion);
    }

    /**
     * Muestra un mensaje indicando la presencia de Pollito en la habitación y
     * solicita una decisión al jugador.
     */
    public void pollitoAlAcecho() {
        System.out.println("Te estas acercando a un puente y a lo lejos ves una figura imponente.");
        System.out.println("Es Pollito, el gran murciélago de la fruta.");
        System.out.println("¿Qué quieres hacer? ¿Atacar? ó ¿Hacer una reverencia al gran Pollito?");
    }

    /**
     * Verifica la decisión del jugador con respecto a Pollito.
     *
     * @param decision La decisión tomada por el jugador.
     * @return true si la decisión es atacar, false si es hacer una reverencia.
     */
    public boolean accionPollito(String decision) {
        return decision.equalsIgnoreCase("A");
    }

    /**
     * Bloquea el rastro en la habitación debido al fuerte olor.
     *
     * @return Una cadena que indica que el rastro ha sido bloqueado debido al
     * olor fuerte.
     */
    @Override
    public String bloquearRastro() {
        return "Huelo tanto a fruta que no puedes rastrear las salidas.";
    }

}
