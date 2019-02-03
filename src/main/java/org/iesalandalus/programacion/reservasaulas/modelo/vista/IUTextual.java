package org.iesalandalus.programacion.reservasaulas.modelo.vista;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;

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
			System.out.println("No hay clientes que listar.");
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
			System.out.println("No hay clientes que listar.");
		}
        }
        
}
