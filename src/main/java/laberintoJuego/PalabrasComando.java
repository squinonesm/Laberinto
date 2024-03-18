package laberintoJuego;

/**
 * La clase PalabrasComando proporciona métodos para verificar si una cadena
 * representa un comando válido en el juego del laberinto.
 *
 * <p>
 * Autor: SergioQuiñonesMajuelo Version: 1.0 Fecha: 18-03-2024
 * </p>
 */
public class PalabrasComando {

    private final String IR = "ir";
    private final String FIN = "fin";
    private final String AYUDA = "ayuda";
    private final String OLFATEAR = "olfatear";
    private final String RASTREAR = "rastrear";
    private final String INVENTARIO = "inventario";
    private final String POSICION = "posicion";

    /**
     * Verifica si la cadena dada representa un comando válido en el juego del
     * laberinto.
     *
     * @param comando La cadena que se va a verificar.
     * @return true si la cadena representa un comando válido, false de lo
     * contrario.
     */
    public boolean esComando(String comando) {

        return comando.equalsIgnoreCase(IR)
                || comando.equalsIgnoreCase(FIN)
                || comando.equalsIgnoreCase(AYUDA)
                || comando.equalsIgnoreCase(OLFATEAR)
                || comando.equalsIgnoreCase(RASTREAR)
                || comando.equalsIgnoreCase(INVENTARIO)
                || comando.equalsIgnoreCase(POSICION);
    }

    @Override
    public String toString() {
        return String.format("""
                             PalabrasComando{
                                IR='%s',
                                FIN='%s',
                                AYUDA='%s',
                                OLFATEAR='%s',
                                RASTREAR='%s',
                                INVENTARIO='%s'
                                POSICION='%s'
                             }""", IR, FIN, AYUDA, OLFATEAR, RASTREAR, INVENTARIO, POSICION);
    }

}
