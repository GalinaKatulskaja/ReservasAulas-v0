package org.iesalandalus.programacion.reservasaulas;

import org.iesalandalus.programacion.reservasaulas.modelo.vista.IUTextual;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("Programa para la gestión de reservas de espacios del IES Al-Ándalus");
	
                IUTextual iuTextual = new IUTextual();
		iuTextual.comenzar();
        }

}
