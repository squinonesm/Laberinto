package laberintoJuego;

/**
 * La clase Comando representa un comando ingresado por el jugador en el juego
 * del laberinto.
 * <p>
 * Autor: SergioQuiñonesMajuelo Version: 1.0 Fecha: 18-03-2024
 * </p>
 */
public class Comando {

    private final String comando;
    private final String segundaPalabra;

    /**
     * Constructor de la clase Comando.
     *
     * @param comando El primer término del comando.
     * @param segundaPalabra El segundo término del comando, si existe.
     */
    public Comando(String comando, String segundaPalabra) {
        this.comando = comando;
        this.segundaPalabra = segundaPalabra;
    }

    public String getComando() {
        return comando;
    }

    public String getSegundaPalabra() {
        return segundaPalabra;
    }

    /**
     * Verifica si el comando tiene un primer término.
     *
     * @param comando El comando que se va a verificar.
     * @return true si el comando tiene un primer término, false de lo
     * contrario.
     */
    public boolean hayComando(String comando) {
        return comando != null;
    }

    /**
     * Verifica si el comando tiene un segundo término.
     *
     * @param comando El comando que se va a verificar.
     * @return true si el comando tiene un segundo término, false de lo
     * contrario.
     */
    public boolean haySegundaPalabra(String comando) {
        return comando != null;
    }
}
