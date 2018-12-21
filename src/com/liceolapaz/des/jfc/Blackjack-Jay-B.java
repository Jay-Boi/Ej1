package com.liceolapaz.des.jfc;

import java.util.Random;
import java.util.Scanner;

import javax.print.attribute.standard.NumberOfInterveningJobs;

public class Blackjack {

	public static void main(String[] args) {

		// Ecribir Menú
		escribirMenu();
		// Pedir opcion
		pedirOpcion();
		// Leer y almacenar la opcion
		int opcion = leerOpcion();
		int numeroBanca = 0;
		int numeroGenerado;
		int numeroJugador = 0;
		int contadorBanca = 0;
		int contadorJugador = 1;
		while (numeroBanca < 15) {
			numeroGenerado = generarNumero();
			numeroBanca = numeroBanca + numeroGenerado;
			contadorBanca++;
		}
		// Comprobar la opcion y realizar la consecuencia que corresponda
		if (opcion == 0) {
			System.exit(0);
		} else if (opcion == 1) {

			System.out.println("numero de la banca: " + numeroBanca);
			numeroGenerado = generarNumero();
			System.out.println("tu número: " + numeroGenerado);
			pedirCarta();
			numeroJugador = numeroGenerado;
			int opcionJugador = leerCarta();
			if (opcionJugador == 1) {
				numeroJugador = jugar(numeroGenerado, opcionJugador, numeroBanca, numeroJugador, contadorJugador);
			} else if (opcionJugador == 2) {
				mostrarResultado(numeroBanca, numeroJugador);
			}

		} else if (opcion == 2) {
			// modo dificil
		} else {
			System.out.println("Opción no válida");
		}
		resultado(numeroBanca, numeroJugador, contadorBanca, contadorJugador);
	}

	private static void resultado(int numeroBanca, int numeroJugador, int contadorBanca, int contadorJugador) {
		if (numeroBanca > 21 && numeroJugador > 21) {
			System.out.println("Ambos se han pasado de 21 asi que nadie gana.");
		} else if (numeroBanca > numeroJugador && numeroBanca < 22) {
			System.out.println("Gana la banca");
		} else if (numeroJugador > numeroBanca && numeroJugador < 22) {
			System.out.println("Ganaste a la banca");
		}
	}

	private static int jugar(int numeroGenerado, int opcionJugador, int numeroBanca, int numeroJugador, int contadorJugador) {
		if (opcionJugador == 1) {

			while (numeroJugador < 22 && opcionJugador == 1) {
				numeroGenerado = generarNumero();
				numeroJugador = numeroJugador + numeroGenerado;
				
				if (numeroJugador < 22 && opcionJugador == 1) {
					mostrarResultado(numeroBanca, numeroJugador);
					pedirCarta();
					opcionJugador = leerCarta();
				}

			}
			mostrarResultado(numeroBanca, numeroJugador);
		}
		return numeroJugador;
	}

	private static void carta(int numeroGenerado) {
		System.out.println("Te tocó la carta de valor: " + numeroGenerado);
	}

	private static void mostrarResultado(int numeroBanca, int numeroJugador) {
		System.out.println("El número de la banca es : " + numeroBanca + "\nTu número es: " + numeroJugador);
	}

	private static int leerCarta() {
		Scanner carta = new Scanner(System.in);
		return carta.nextInt();
	}

	private static void pedirCarta() {
		System.out.println("¿Seguir jugando?\r\n" + "1. Sí\r\n" + "2. No\r\n" + "Escoja una opción: ");
	}

	private static int generarNumero() {
		Random numeroGenerado = new Random();
		return numeroGenerado.nextInt((11 - 1) + 1) + 1;

	}

	private static int leerOpcion() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	private static void pedirOpcion() {
		System.out.print("Escoge la dificultad: ");

	}

	private static void escribirMenu() {
		System.out.println("\r\nBLACKJACK\r\n" + "1. Modo fácil\r\n" + "2. Modo normal\r\n" + "0. Salir");
	}
}
