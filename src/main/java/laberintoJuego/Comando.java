package laberintoJuego;

/**
 *
 * @author Diurno
 */
public class Comando {
    
    private final String comando;
    private final String segundaPalabra;

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
    
    public boolean hayComando(String comando){
        return comando != null;
    }
    
    public boolean haySegundaPalabra(String comando){
        return comando != null;
    }
}
