package laberintoJuego;

import habitaciones.HabitacionConItem;
import habitaciones.HabitacionDormir;
import habitaciones.HabitacionMerienda;
import habitaciones.HabitacionNoxus;
import habitaciones.HabitacionPollito;
import interfaces.OlorFuerte;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase principal que controla el flujo del juego del laberinto. Administra las
 * habitaciones, el inventario del jugador y la interacción con el usuario.
 *
 * <p>
 * Autor: SergioQuiñonesMajuelo Version: 1.0 Fecha: 18-03-2024
 * </p>
 */
public final class Juego {

    public static Scanner sc = new Scanner(System.in);

    private final Transformar transformar;
    private Habitacion habitacionActual;
    private Habitacion habitacionInicial;
    private Habitacion habitacionFinal;
    private final Map<String, Integer> inventario = new HashMap<>();
    private String decision;
    private int contador = 0; //Para ver si le has dado fruta o no a pollito

    /**
     * Constructor de la clase Juego. Inicializa el objeto transformar y crea
     * las habitaciones del laberinto.
     */
    public Juego() {
        transformar = new Transformar();
        crearHabitaciones();
        habitacionActual = habitacionInicial;
    }

    /**
     * Crea todas las habitaciones del laberinto y establece las conexiones
     * entre ellas.
     */
    public void crearHabitaciones() {

        habitacionInicial = new Habitacion("HABITACION INICIAL");
        Habitacion habitacionA = new HabitacionConItem("HABITACION DEL MEDICO", "IBUPROFENO");
        Habitacion habitacionB = new HabitacionConItem("HABITACION DEL VIAJERO", "VISA");
        Habitacion habitacionC = new HabitacionNoxus("HABITACION DE NOXUS EL DESTRUCTOR DE MUNDOS");
        Habitacion habitacionD = new Habitacion("HABITACION NPC");
        Habitacion habitacionE = new Habitacion("HABITACION NPC");
        Habitacion habitacionF = new HabitacionMerienda("HABITACION DE LA GULA");
        Habitacion habitacionG = new HabitacionConItem("HABITACION DEL FRUTERO DEL BARRIO", "FRUTA");
        Habitacion habitacionH = new HabitacionPollito("HABITACION DE POLLITO EL GLOTÓN");
        Habitacion habitacionJ = new HabitacionDormir("HABITACION DEL SUEÑO");
        habitacionFinal = new Habitacion("SALIDA");

        //Salidas Habitacion Inicial
        habitacionInicial.setSalida("oeste", habitacionA);
        habitacionInicial.setSalida("sur", habitacionB);

        //Salidas habitacion olfateables
        //HabitacionB
        habitacionB.setSalida("sur", habitacionC);
        habitacionB.setSalida("norte", habitacionInicial);

        //HabitacionA
        habitacionA.setSalida("sur", habitacionD);
        habitacionA.setSalida("este", habitacionInicial);
        habitacionA.setSalida("oeste", habitacionF);

        //HabitacionG
        habitacionG.setSalida("norte", habitacionD);
        habitacionG.setSalida("oeste", habitacionH);

        //Salidas habitacion normal
        //HabtacionD
        habitacionD.setSalida("oeste", habitacionE);
        habitacionD.setSalida("sur", habitacionG);
        habitacionD.setSalida("norte", habitacionA);

        //HabitacionE
        habitacionE.setSalida("norte", habitacionF);
        habitacionE.setSalida("este", habitacionD);

        //Salidas Noxus
        habitacionC.setSalida("oeste", habitacionG);
        habitacionC.setSalida("Norte", habitacionB);

        //Salidas Habitacion Merienda
        habitacionF.setSalida("este", habitacionA);
        habitacionF.setSalida("sur", habitacionE);

        //Salidas habitacion Pollito
        habitacionH.setSalida("sur", habitacionJ);
        habitacionH.setSalida("oeste", habitacionFinal);
        habitacionH.setSalida("este", habitacionG);

        //Salidas habitacion del Sueño
        habitacionJ.setSalida("norte", habitacionH);

        // Añade los elementos iniciales al inventario
        inventario.put("visa", 0);
        inventario.put("fruta", 0);
        inventario.put("ibuprofeno", 0);
    }

    /**
     * Método principal que inicia el juego. Muestra el mensaje de bienvenida y
     * ejecuta el bucle principal del juego hasta que se alcanza la salida o se
     * ingresa el comando "FIN".
     */
    public void juego() {
        bienvenido();
        Comando c;
        do {
            c = transformar.getCommand();
            procesarComando(c);
        } while (!c.getComando().equalsIgnoreCase("FIN") && !habitacionFinal.getDescripcion().equals(habitacionActual.getDescripcion()));

        if (habitacionFinal.getDescripcion().equals(habitacionActual.getDescripcion())) {
            System.out.println("FELICIDADES HAS TERMINADO TU AVENTURA EN CHUPIVILLA.");
            verInventario();
        } else {
            System.out.println("Tenías tanto miedo, que decidiste salir huyendo.");
        }
    }

    /**
     * Muestra el mensaje de bienvenida al jugador.
     */
    public void bienvenido() {
        System.out.println("¡BIENVENIDO A CHUPILLIVA!");
        System.out.println("Te encuentras en un laberinto misterioso y tu objetivo es encontrar la salida.");
        System.out.println("Puedes utilizar los siguientes comandos:");
        System.out.println("- IR: Para moverte a otras habitaciones.");
        System.out.println("- AYUDA: Para ver los comandos disponibles.");
        System.out.println("- OLFATEAR: Para ver si encuentras objetos escondidos.");
        System.out.println("- RASTREAR: Para ver las salidas de la habitación.");
        System.out.println("- INVENTARIO: Para ver los objetos que has encontrado durante tu aventura.");
        System.out.println("- POSICION: Para ver en que habitación te encuentras");
        System.out.println("- FIN: Para salir del juego.");
        System.out.println("¡Explora Chupivilla y disfruta de esta aventura!");
    }

    /**
     * Procesa el comando ingresado por el jugador.
     *
     * @param c El comando ingresado por el jugador.
     * @return true si se procesa el comando correctamente, false si el comando
     * no es válido.
     */
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
                case "olfatear" -> {
                    olfatear();
                    return true;
                }
                case "rastrear" -> {
                    rastrear();
                    return true;
                }
                case "inventario" -> {
                    verInventario();
                    return true;
                }
                case "posicion" -> {
                    verPosicion();
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

    /**
     * Muestra los comandos disponibles para el jugador.
     */
    public void ayuda() {
        PalabrasComando palabrasComando = new PalabrasComando();
        System.out.println("Ayuda del juego: ");
        System.out.println(" - " + palabrasComando);
    }

    /**
     * Permite al jugador moverse a otra habitación según la dirección
     * especificada en el comando.
     *
     * @param c El comando que contiene la dirección a la que el jugador desea
     * moverse.
     */
    public void irA(Comando c) {
        String direccion = c.getSegundaPalabra().toLowerCase();
        Habitacion nuevaHabitacion = habitacionActual.getSalida(direccion);

        if (nuevaHabitacion != null) {
            habitacionActual = nuevaHabitacion;
            System.out.println("HAS CAMBIADO DE SALA");

            // Llama al método específico de la habitación actual
            accionHabitacionActual();

        } else {
            System.out.println("No puedes ir en esa dirección desde aquí.");
        }
    }

    /**
     * Permite al jugador buscar objetos escondidos en la habitación actual.
     */
    public void olfatear() {
        if (habitacionActual instanceof HabitacionConItem) {
            String itemEncontrado = ((HabitacionConItem) habitacionActual).getItem();
            System.out.println("HAS ENCONTRADO UN " + itemEncontrado.toUpperCase());
            agregarElemento(itemEncontrado.toLowerCase(), 1);
        } else {
            System.out.println("En esta habitación no hay nada interesante.");
        }
    }

    /**
     * Muestra el inventario del jugador.
     */
    public void verInventario() {
        System.out.println("REVISAS TU MOCHILITA Y TIENES:");
        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }

    // Métodos para la gestión del inventario
    /**
     * Agrega un elemento al inventario con la cantidad especificada.
     *
     * @param elemento El elemento a agregar.
     * @param cantidad La cantidad del elemento a agregar.
     */
    private void agregarElemento(String elemento, int cantidad) {
        inventario.put(elemento, inventario.getOrDefault(elemento, 0) + cantidad);
    }

    /**
     * Verifica si un elemento está en el inventario.
     *
     * @param elemento El elemento a verificar.
     * @return true si el elemento está en el inventario, false de lo contrario.
     */
    private boolean elementoEnInventario(String elemento) {
        return inventario.containsKey(elemento) && inventario.get(elemento) > 0;
    }

    /**
     * Consume un elemento del inventario.
     *
     * @param elemento El elemento a consumir.
     */
    private void consumirElemento(String elemento) {
        if (elementoEnInventario(elemento)) {
            inventario.put(elemento, inventario.get(elemento) - 1);
        }
    }
    //

    /**
     * Muestra la posición actual del jugador.
     */
    public void verPosicion() {
        System.out.println("Te encuentras en la: " + habitacionActual.getDescripcion());
    }

    /**
     * Muestra las salidas disponibles en la habitación actual o bloquea el
     * rastro si la habitación emite un olor fuerte.
     */
    public void rastrear() {
        if (habitacionActual instanceof OlorFuerte) {
            System.out.println(((OlorFuerte) habitacionActual).bloquearRastro());
        } else {
            System.out.println("Salidas disponibles:");
            System.out.println(habitacionActual.getStringSalidas());
        }
    }

    /**
     * Finaliza el juego.
     *
     * @param c El comando que indica el fin del juego.
     */
    public void fin(Comando c) {

        System.out.println("FIN DEL JUEGO.");
    }

    /**
     * Acción específica realizada en la habitación de Noxus.
     */
    private void habitacionNoxus() {
        ((HabitacionNoxus) habitacionActual).encuentrasNoxus();
        do {
            System.out.println("S/N");
            decision = sc.nextLine();
        } while (!decision.equalsIgnoreCase("S") && !decision.equalsIgnoreCase("N"));

        if (((HabitacionNoxus) habitacionActual).ayudaNoxus(decision)) {
            // Verificar si el jugador tiene la visa en el inventario
            if (elementoEnInventario("visa")) {
                System.out.println("SIN EMBARGO MUESTRAS LA VISA QUE ENCONTRASTE, EVITANDO SER DEPORTADO,"
                        + " Y ERES ESCOLTADO AL INICIO.");
                consumirElemento("visa");
                habitacionActual = habitacionInicial;
            } else {
                System.out.println("NO POSEES UNA VISA, POR LO QUE LAS AUTORIDADES PERRUNAS TE HAN DEPORTADO.");
                System.exit(0);
            }
        }
    }

    /**
     * Acción específica realizada en la habitación de Merienda.
     */
    private void habitacionMerienda() {
        ((HabitacionMerienda) habitacionActual).ahiDiceGratis();
        do {
            System.out.println("Tarta/Mate");
            decision = sc.nextLine();
        } while (!decision.equalsIgnoreCase("tarta") && !decision.equalsIgnoreCase("mate"));
        if (decision.equalsIgnoreCase("tarta")) {
            System.out.println(" Te comes la tarta, ¡Oh no! Eres intolerante a la "
                    + "lactosa, te enfermas y decides ir al veterinario, para ello debes regresar al inicio. ");
            if (elementoEnInventario("ibuprofeno")) {
                System.out.println("TENIAS UN IBUPROFENO, LO USAS Y CURAS TUS PROBLEMAS DE SALUD.");
                System.out.println("Puedes seguir avanzando.");
                consumirElemento("ibuprofeno");
            } else {
                habitacionActual = habitacionInicial;
            }
        } else if (decision.equalsIgnoreCase("mate")) {
            System.out.println("Te tomas el mate pero estaba frío, debes correr al baño, "
                    + "para ello debes regresar al inicio.");
            if (elementoEnInventario("ibuprofeno")) {
                System.out.println("TENIAS UN IBUPROFENO, LO USAS Y CURAS TUS PROBLEMAS DE SALUD.");
                System.out.println("Puedes seguir avanzando.");
                consumirElemento("ibuprofeno");
            } else {
                System.out.println("Sin embargo, volviendo al inicio te resbalas y mueres.");
                System.out.println("FIN DEL JUEGO.");
                System.exit(0);
            }
        }
    }

    /**
     * Acción específica realizada en la habitación de Pollito.
     */
    private void habitacionPollito() {
        ((HabitacionPollito) habitacionActual).pollitoAlAcecho();
        do {
            System.out.println("Escribe 'A' para atacar o 'R' para hacer una reverencia.");
            decision = sc.nextLine();
        } while (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("R"));

        if (((HabitacionPollito) habitacionActual).accionPollito(decision)) {
            System.out.println("ATACAS A POLLITO");
            System.out.println("PERO NO ERES RIVAL PARA SUS GARRAS.");
            System.out.println("Mueres entre terribles sufrimientos");
            System.exit(0);
        } else {
            System.out.println("POLLITO ACEPTA TU REVERENCIA Y TE DEJA CONTINUAR TU CAMINO");
        }

        // Verificar si el jugador tiene fruta en el inventario
        if (elementoEnInventario("fruta")) {
            System.out.println("TIENES UNA FRUTA, ¿QUIERES DÁRSELA A POLLITO?");
            do {
                System.out.println("S/N");
                decision = sc.nextLine();
            } while (!decision.equalsIgnoreCase("S") && !decision.equalsIgnoreCase("N"));
            if (decision.equalsIgnoreCase("S")) {
                System.out.println("Pollito se come tan feliz su fruta");
                System.out.println("Y con una de sus alas te indica donde se encuentra la salida del LABERINTO");
                System.out.println("AL OESTE!!");
                contador++;
                consumirElemento("fruta");
            } else {
                System.out.println("Es probable que lamentes no haberle dado la fruta a Pollito.");
            }
        }
    }

    /**
     * Acción específica realizada en la habitación de Dormir.
     */
    private void habitacionDormir() {
        System.out.println("Estás tan cansado de caminar que te echas a dormir un ratito...");
        System.out.println("Durmiendo...");

        try {
            Thread.sleep(15000); // Espera 15 segundos para simular dormir
        } catch (InterruptedException e) {
        }

        System.out.println("¡Has despertado!");

        if (contador == 1) {
            System.out.println("¡Ves a Pollito acercarse hacia ti muy enfadado!");
            System.out.println("Pollito no tolera a la gente que no escucha y, "
                    + "al ver que no has ido hacia la salida...");
            System.out.println("Decide tirarte al agua y mueres ahogado.");
            System.exit(0);
        } else {
            System.out.println("Te encuentras en el inicio.");
            System.out.println("A lo lejos ves a Pollito alejarse.");
            System.out.println("Debe haber sido por no haberle traído una ofrenda...");
            habitacionActual = habitacionInicial;
        }
    }

    /**
     * Realiza la acción específica de la habitación actual.
     */
    private void accionHabitacionActual() {
        if (habitacionActual instanceof HabitacionNoxus) {
            habitacionNoxus();
        } else if (habitacionActual instanceof HabitacionMerienda) {
            habitacionMerienda();
        } else if (habitacionActual instanceof HabitacionPollito) {
            habitacionPollito();
        } else if (habitacionActual instanceof HabitacionDormir) {
            habitacionDormir();
        }
    }
}
