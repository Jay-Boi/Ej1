package com.liceolapaz.des.jfc;

import java.util.Random;
import java.util.Scanner;

import javax.print.attribute.standard.NumberOfInterveningJobs;

public class Blackjack {

	public static void main(String[] args) {
		while (true) {
			clear();
			// Ecribir Menú
			escribirMenu();
			// Pedir opcion
			pedirOpcion();
			// Leer y almacenar la opcion
			int opcion = leerOpcion();
			clear();
			int numeroBanca = 0;
			int numeroGenerado;
			int numeroJugador = 0;
			int contadorBanca = 0;
			int contadorJugador = 1;
			int[] puntuacion = new int[2];
			while (numeroBanca < 15) {
				numeroGenerado = generarNumero();
				numeroBanca = numeroBanca + numeroGenerado;
				contadorBanca++;
			}
			// Comprobar la opcion y realizar la consecuencia que corresponda
			if (opcion == 0) {
				System.exit(0);
			} else if (opcion == 1) {

				
				numeroGenerado = generarNumero();
				numeroJugador = numeroGenerado;
				System.out.println("JUGADOR |	Número: " + numeroJugador);
				System.out.println("BANCA   |	Número: " + numeroBanca);
				pedirCarta();
				
				int opcionJugador = leerCarta();
				if (opcionJugador == 1) {
					puntuacion = jugar(opcion, numeroGenerado, opcionJugador, numeroBanca, numeroJugador,
							contadorJugador);
				} else if (opcionJugador == 2) {
					mostrarResultado(numeroBanca, numeroJugador);
				}

			} else if (opcion == 2) {
				numeroGenerado = generarNumero();
				numeroJugador = numeroGenerado;
				System.out.println("JUGADOR |	Número: " + numeroJugador);
				pedirCarta();
				
				int opcionJugador = leerCarta();
				if (opcionJugador == 1) {
					puntuacion = jugar(opcion, numeroGenerado, opcionJugador, numeroBanca, numeroJugador,
							contadorJugador);
				} else if (opcionJugador == 2) {
					mostrarResultado2(numeroJugador);
				}
			} else {
				System.out.println("Opción no válida");
			}
			
			resultado(numeroBanca, puntuacion, contadorBanca);
			System.out.print("\r¿Jugar de nuevo?" + "\r(1.SI" + "  2.NO):  ");
			int again = leerOpcion();
			if (again == 1) {
			} else {
				System.exit(0);
			}

		}
	}

	private static void clear() {
		System.out.println(
				"\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r");
	}

	private static void mostrarResultado2(int numeroJugador) {
		System.out.println("JUGADOR |	Número: " + numeroJugador);
	}

	private static void resultado(int numeroBanca, int[] puntuacion, int contadorBanca) {
		if (numeroBanca > 21 && puntuacion[1] > 21) {
			System.out.println("\rEMPATE ambos se han pasado de 21");
		} else if (numeroBanca > puntuacion[1] && numeroBanca < 22) {
			System.out.println("\rHAS PERDIDO la banca ha ganado");
		} else if (puntuacion[1] > numeroBanca && puntuacion[1] < 22) {
			System.out.println("\r¡FELICIDADES! Ganaste a la banca");
		} else if (numeroBanca > 21 && puntuacion[1] < 22) {
			System.out.println("\r¡FELICIDADES! Ganaste a la banca");
		} else if (puntuacion[1] > 21 && numeroBanca < 22) {
			System.out.println("\rHAS PERDIDO la banca ha ganado");
		} else if (numeroBanca == puntuacion[1]) {
			if (contadorBanca > puntuacion[0]) {
				System.out.println("\r¡FELICIDADES! Has ganado porque sacaste " + puntuacion[1] + " en " + puntuacion[0] + " intentos"
						+ "\r\nMientras que la banca ha sacado " + numeroBanca + " en " + contadorBanca + " intentos.");
			} else if (contadorBanca < puntuacion[0]) {
				System.out.println("\rHAS PERDIDO porque sacaste " + puntuacion[1] + " en " + puntuacion[0]
						+ " intentos" + "\r\nMientras que la banca ha sacado " + numeroBanca + " en " + contadorBanca
						+ " intentos.");}
			else {System.out.println("\rEMPATE. Has sacado " + puntuacion[1] + " en " + puntuacion[0]
					+ " intentos" + "\r\nIgual que la banca que ha sacado " + numeroBanca + " en " + contadorBanca
					+ " intentos.");}
		} else {
			System.out.println("baia");
		}

	}

	private static int[] jugar(int opcion, int numeroGenerado, int opcionJugador, int numeroBanca, int numeroJugador,
			int contadorJugador) {
		if (opcionJugador == 1) {

			while (numeroJugador < 22 && opcionJugador == 1) {
				clear();
				numeroGenerado = generarNumero();
				numeroJugador += numeroGenerado;
				contadorJugador++;
				if (numeroJugador < 22 && opcionJugador == 1) {

					if (opcion == 1) {
						mostrarResultado(numeroBanca, numeroJugador);
					} else {
						mostrarResultado2(numeroJugador);
					}
					pedirCarta();
					opcionJugador = leerCarta();
					
				}

			}
			clear();
			mostrarResultado(numeroBanca, numeroJugador);
			
		}
		int[] puntuacion = { contadorJugador, numeroJugador };
		return puntuacion;

	}

	private static void mostrarResultado(int numeroBanca, int numeroJugador) {
		System.out.println("JUGADOR |	Número: " + numeroJugador);
		System.out.println("BANCA   |	Número: " + numeroBanca);
		
	}

	private static int leerCarta() {
		Scanner carta = new Scanner(System.in);
		return carta.nextInt();
	}

	private static void pedirCarta() {
		System.out.print("\r\n	¿Seguir jugando?\r\n" + "1. Sí\r\n" + "2. No\r\n" + "Escoja una opción: ");
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
		System.out.println("\r\n   BLACKJACK\r\n" + "1. Modo fácil\r\n" + "2. Modo normal\r\n" + "0. Salir");
	}
}
