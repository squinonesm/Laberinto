package laberintoJuego;

import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public final class Juego {

    public static Scanner sc = new Scanner(System.in);

    private Transformar transformar;
    private Habitacion habitacionActual;
    private Habitacion habitacionInicial;

    public Juego() {
        transformar = new Transformar();
        crearHabitaciones();
        habitacionActual = habitacionInicial;
    }

    public void crearHabitaciones() {

        habitacionInicial = new Habitacion("Habitación Inicial");
        Habitacion habitacionA = new Habitacion("Habitación A");
        Habitacion habitacionB = new Habitacion("Habitación B");
        Habitacion habitacionC = new Habitacion("Habitación C");
        Habitacion habitacionD = new Habitacion("Habitación D");

        habitacionInicial.setSalida("oeste", habitacionA);

        habitacionA.setSalida("norte", habitacionB);
        habitacionA.setSalida("sur", habitacionD);
        habitacionA.setSalida("este", habitacionInicial);

        habitacionB.setSalida("sur", habitacionA);
        habitacionB.setSalida("este", habitacionC);

        habitacionC.setSalida("oeste", habitacionB);

        habitacionD.setSalida("norte", habitacionA);

    }

    public void juego() {
        bienvenido();
        Comando c;
        do {
            c = transformar.getCommand();
            procesarComando(c);
        } while (!c.getComando().equalsIgnoreCase("FIN"));
    }

    public void bienvenido() {
        System.out.println("¡Bienvenido al Laberinto!");
        System.out.println("Te encuentras en un laberinto misterioso y tu objetivo es encontrar la salida.");
        System.out.println("Puedes utilizar los siguientes comandos:");
        System.out.println("- IR: Para moverte a otras habitaciones.");
        System.out.println("- AYUDA: Para ver los comandos disponibles.");
        System.out.println("- FIN: Para salir del juego.");
        System.out.println("¡Explora el laberinto y disfruta de la aventura!");
    }

    public boolean procesarComando(Comando c) {
        if (c.hayComando(c.getComando())) {
            String comando = c.getComando().toLowerCase();

            switch (comando) {
                case "ayuda" -> {
                    ayuda();
                    return true;
                }
                case "fin" -> {
                    fin(c);
                    return true;
                }
                case "ir" -> {
                    irA(c);
                    return true;
                }
                default -> {
                    System.out.println("Comando no válido. Introduce 'ayuda' para ver los comandos disponibles.");
                    return false;
                }
            }
        }
        return false;
    }

    public void ayuda() {
        PalabrasComando palabrasComando = new PalabrasComando();
        System.out.println("Ayuda del juego: ");
        System.out.println(" - " + palabrasComando);
        System.out.println("Estas en la habitacion: " + habitacionActual.getDescripcion());
        System.out.println("Las salidas son: "+habitacionActual.getStringSalidas());
    }

    public void irA(Comando c) {
        String lugar = c.getSegundaPalabra().toLowerCase();

        Habitacion nuevaHabitacion = habitacionActual.getSalida(lugar);

        if (nuevaHabitacion != null) {
            habitacionActual = nuevaHabitacion;
            System.out.println("Te has movido a " + habitacionActual.getDescripcion());
        } else {
            System.out.println("No puedes ir en esa dirección desde aquí.");
        }
    }

    public void fin(Comando c) {

        System.out.println("FIN DEL JUEGO");
    }
}

