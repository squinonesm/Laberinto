/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberintoJuego;

import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public class Transformar {

    public static Scanner sc = new Scanner(System.in);
    private final PalabrasComando palabrasComando;

    public Transformar() {
        this.palabrasComando = new PalabrasComando();
    }

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
