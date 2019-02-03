/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.vista;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.*;

/**
 *
 * @author Galina
 */
public class Consola {
    private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/mm/aaaa");
    
    private Consola(){
        
    }
    
    public static void mostrarMenu(){
        mostrarCabecera("Reservas de aulas");
        for(Opcion opcion: Opcion.values()){
            System.out.println(opcion);
        }
    }
    
    public static void mostrarCabecera(String mensaje){
        System.out.printf("%n%s%n", mensaje);
		String cadena = "%0" + mensaje.length() + "d%n";
		System.out.println(String.format(cadena, 0).replace("0", "-"));
        
    }
    
    public static int elegirOpcion() {
		int opcion;
		do {
			System.out.print("\nElige una opción: ");
			opcion = Entrada.entero();
		} while (!Opcion.esOrdinalValido(opcion));
		return opcion;
	}
    public static Aula leerAula(){
        Aula aula = new Aula(leerNombreAula());
        return aula;
    }
    
    public static String leerNombreAula(){
        String nombre = null;
        do{
            System.out.println("Introduce el nombre del Aula");
            nombre = Entrada.cadena();
        }while(nombre == null || nombre == "");
        return nombre;
        
    }
    
    public static Profesor leerProfesor(){
        Profesor profesor = new Profesor(leerNombreProfesor(),null);
        return profesor;
    }
    
    public static String leerNombreProfesor(){
        String nombre = null;
        do{
            System.out.println("Introduce nombre del Profesor");
            nombre = Entrada.cadena();
        }while(nombre == null || nombre == "");
        return nombre ;
    }
    
    public static Tramo leerTramo(){
        int indice = 0;
        do{
            System.out.println("Selecciona horario de la reserva: ");
            System.out.println("1) " +Tramo.MANANA );
            System.out.println("2) " +Tramo.TARDE);
            indice = Entrada.entero();
        }while(indice<1 ||indice>2);
        return Tramo.values()[indice-1];
    }
    
 
}
