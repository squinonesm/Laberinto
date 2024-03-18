package ies_comercio.laberinto;

import laberintoJuego.Juego;

/**
 * Clase principal que contiene el método main para iniciar el juego del
 * laberinto. Esta clase crea una instancia de la clase Juego y comienza el
 * juego.
 *
 * <p>
 * Autor: SergioQuiñonesMajuelo Version: 1.0 Fecha: 18-03-2024
 * </p>
 */
public class Laberinto {

    /**
     * Método principal que inicia el juego del laberinto. Crea una instancia de
     * la clase Juego y llama al método juego() para comenzar el juego.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en
     * este caso).
     */
    public static void main(String[] args) {
        // Crea una instancia de la clase Juego
        Juego j1 = new Juego();
        // Inicia el juego
        j1.juego();
    }
}
