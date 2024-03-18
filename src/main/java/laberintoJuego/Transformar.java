package laberintoJuego;

import java.util.Scanner;

/**
 * La clase Transformar se encarga de transformar la entrada del usuario en un
 * objeto Comando válido. También se encarga de gestionar la interacción con el
 * usuario para obtener los comandos.
 *
 * <p>
 * Autor: SergioQuiñonesMajuelo Version: 1.0 Fecha: 18-03-2024
 * </p>
 */
public class Transformar {

    public static Scanner sc = new Scanner(System.in);
    private final PalabrasComando palabrasComando;

    /**
     * Constructor de la clase Transformar. Inicializa el objeto
     * PalabrasComando.
     */
    public Transformar() {
        this.palabrasComando = new PalabrasComando();
    }

    /**
     * Obtiene un comando válido ingresado por el usuario. Si el comando no es
     * válido, solicita al usuario que ingrese un nuevo comando hasta que sea
     * válido.
     *
     * @return Objeto Comando creado a partir de la entrada del usuario.
     */
    public Comando getCommand() {
        System.out.print("Ingrese el comando: ");
        String comando = sc.nextLine();

        // Verificar si el comando ingresado es válido
        while (!palabrasComando.esComando(comando)) {
            System.out.println("Comando no válido. Intente de nuevo.");
            System.out.print("Ingrese el comando: ");
            comando = sc.nextLine();
        }

        // Verificar la segunda palabra (lugar)
        String lugar = "";
        if (comando.equalsIgnoreCase("ir")) {
            System.out.print("Ingrese el lugar (norte, sur, este u oeste): ");
            lugar = sc.nextLine();
        }

        return new Comando(comando, lugar);
    }
}
