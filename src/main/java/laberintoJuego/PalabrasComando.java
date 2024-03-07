package laberintoJuego;

/**
 *
 * @author Diurno
 */
public class PalabrasComando {

    private final String IR = "ir";
    private final String FIN = "fin";
    private final String AYUDA = "ayuda";

    public boolean esComando(String comando) {

        return comando.equalsIgnoreCase(IR) || comando.equalsIgnoreCase(FIN) || comando.equalsIgnoreCase(AYUDA);

    }

    @Override
    public String toString() {
        return String.format("PalabrasComando{ IR='%s', FIN='%s', AYUDA='%s' }", IR, FIN, AYUDA);
    }

}
