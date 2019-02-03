package org.iesalandalus.programacion.reservasaulas.modelo.vista;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package org.iesalandalus.programacion.reservasaulas;

//import javax.naming.OperationNotSupportedException;

/**
 *
 * @author Galina
 */
public class IUTextual {
    private static final String ERROR = "ERROR. Vuelve a intentarlo. ";
	
	private ModeloReservasAulas modelo;

	public IUTextual() {
		modelo = new ModeloReservasAulas();
		Opcion.setVista(this);
	}

	public void comenzar() {
		int ordinalOpcion;
		do {
			Consola.mostrarMenu();
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}
	
	public void salir() {
		System.out.println("Hasta luego!!!");
	}
	
	public void insertarCliente() {
		Consola.mostrarCabecera("Insertar aula");
		try {
			Aula aula = Consola.leerAula();
			modelo.insertarAula(aula);
			System.out.println("Aula insertado correctamente.");
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void borrarCliente() {
		Consola.mostrarCabecera("Borrar caula");
		try {
			Aula aula = Consola.leerAula();
			modelo.borrarAula(aula);
			System.out.println("Cliente borrado correctamente.");
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void buscarCliente() {
		Consola.mostrarCabecera("Buscar aula");
		Aula aula = null;
		try {
			aula = Consola.leerAula();
			aula = modelo.buscarAula(aula);
			if (aula != null) {
				System.out.println("El cliente buscado es: " + aula);
			} else {
				System.out.println("No existe ningún cliente con dicho DNI.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void listarAula() {
		Consola.mostrarCabecera("Listar aula");
		String[] aula = modelo.representarAulas();
                    if (aula.length > 0) {
			for (String aulas : aula) {
				System.out.println(aulas);
			}
		} else {
			System.out.println("No hay aulas que listar.");
		}     
	}
        
        public void insertarProfesor(){
            Consola.mostrarCabecera("Insertar Profesor");
            try{
                modelo.insertarProfesor(Consola.leerProfesor());
                System.out.println("el Profesor se ha incertado correctamente");
            }catch (IllegalArgumentException e){
                System.out.println(ERROR + e.getMessage());
                
            }
        }
        
        public void borrarProfesor(){
            Consola.mostrarCabecera("Borrar Profesor");
            try{
                Profesor profesor = new Profesor(Consola.leerNombreProfesor(), "ab@cd.e");
                modelo.borrarProfesor(profesor);
                System.out.println("El profesor se ha eliminado correctamente");
            }catch(IllegalArgumentException e){
                System.out.println(ERROR + e.getMessage());
            }
        }
        
        public void listarProfesor(){
            Consola.mostrarCabecera("Listar Profesor");
            String[] profesor = modelo.representarProfesores();
            if (profesor.length > 0) {
			for (String profesores :profesor) {
				System.out.println(profesores);
			}
		} else {
			System.out.println("No hay profesores que listar.");
		}
        }
        public void realizarReserva(){
            Consola.mostrarCabecera("Realizar reserva");
            Profesor profesor = modelo.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), "ab@c.de"));
             if(profesor == null){
                 System.out.println("El profesor que deseas reservar no existe");
                 //registrar();
             }
             try{
                 Reserva reserva = leerReserva(profesor);
                 modelo.realizarReserva(reserva);
                 System.out.println("La reserva se ha realizado correctamente");
             }catch(IllegalArgumentException e){
                 System.out.println(ERROR + e.getMessage());
             }
                 
        }
        
        private Reserva leerReserva(Profesor profesor){
            Aula aula = Consola.leerAula();
            Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
            return new Reserva(profesor, aula, permanencia);
        }   
        
       public void anularReserva(){
           Consola.mostrarCabecera("Anular Reserva");
           Reserva reserva = leerReserva(new Profesor("Jose", "ab@c.de"));
           
           try{
               modelo.anularReserva(reserva);
               System.out.println("La reserva se ha anulado correctamente");
               
           }catch(IllegalArgumentException e){
               System.out.println(ERROR + e.getMessage());
           }
       }
       
       public void listarReservas(){
           Consola.mostrarCabecera("Listar Reserva");
           String[] reserva = modelo.representarReserva();
            if (reserva.length > 0) {
			for (String reservas :reserva) {
				System.out.println(reservas);
			}
		} else {
			System.out.println("No hay reservas que listar.");
		}
       }
       
       public void listarReservasAulas(){
           Consola.mostrarCabecera("Listar reservas de aulas");
           Aula aula = Consola.leerAula();
           Reserva[] reservas = modelo.getReservasAulas(aula);
           for(int i = 0; i< reservas.length; i++){
               if(reservas[i] == null){
                   System.out.println("Las reservas para el aula: " + aula + "NO EXISTEN.");
               }
               System.out.println(reservas[i]);
           }
       }
       
       public void listarReservaProfesor(){
           Consola.mostrarCabecera("Listar Reserva Del Profesor");
           Profesor profesor = new Profesor(Consola.leerNombreProfesor(), "ab@c.de");
           Reserva[] reservas = modelo.getReservasProfesor(profesor);
           for(int i = 0; i< reservas.length; i++){
               if(reservas[i] == null){
                   System.out.println("La reserva para el Profesor: " + profesor + " NO EXISTE.");
               }
               System.out.println(reservas[i]);
           }
       }
       
       public void listarReservaPermanencia(){
           Consola.mostrarCabecera("Listar reserva Permanencia");
           Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
           Reserva[] reservas = modelo.getReservasPermanencia(permanencia);
           for(int i = 0; i<reservas.length;i++){
               if(reservas[i] == null){
                   System.out.println("La reserva para la Permanencia: " + permanencia + " NO EXISTE.");
               }
               System.out.println("reserva[i]");
           }
       }
       
       public void consultarDisponibilidad(){
           Consola.mostrarCabecera("Consulta la disponibilidad");
           Aula aula = Consola.leerAula();
           Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
           boolean disponibilidad = modelo.consultarDisponidilidad(aula,permanencia);
       
             if(disponibilidad == true){
                 System.out.println("La reserva esta disponible.");
                 
            } 
             else{
                 System.out.println("La reserva no esta disponible");
             } 
    
}
}
