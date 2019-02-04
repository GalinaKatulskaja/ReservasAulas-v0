/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Aulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Profesores;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Reservas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

/**
 *
 * @author Galina
 */
public class ModeloReservasAulas {

	private Aulas aulas;
        private Profesores profesores;
        private Reservas reservas;
	
	public ModeloReservasAulas() {
		this.aulas = new Aulas();
                this.profesores = new Profesores();
                this.reservas = new Reservas();
	}
	
        public Aula[] getAulas(){
            return aulas.getAulas();
        }
        
        public int getNumAulas(){
            return aulas.getNumAulas();
        }
        public String[] representarAulas(){
            return aulas.representar();
        }
        
       
	public void insertarAula(Aula aula) throws OperationNotSupportedException {
		aulas.insetrar(aula);
	}
	
	public void borrarAula(Aula aula) throws OperationNotSupportedException {
		aulas.borrar(aula);
	}
	
	 public Aula buscarAula(Aula aula){
            return aulas.buscar(aula);
        }
         
         public Profesor[] getProfesor(){
             return profesores.getProfesores();
         }
         public int getNumProfesor(){
             return profesores.getNumProfesores();
         }
         
         public String[] representarProfesores(){
             return profesores.representar();
         }
         public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException{
             profesores.insertar(profesor);
         }
         public Profesor buscarProfesor(Profesor profesor){
             return profesores.buscar(profesor);
             
         }
         public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException{
             profesores.borrar(profesor);
         }
         
         public Reserva[] getReserva(){
             return reservas.getReservas();
         }
         public int getNumReservas(){
             return reservas.getNumReservas();
         }
         public String[] respresentarReservas(){
             return reservas.representar();
         }
         public void realizarReserva(Reserva reserva) throws OperationNotSupportedException{
             reservas.insertar(reserva);
         }
         public Reserva buscarReserva(Reserva reserva){
             return reservas.buscar(reserva);
         }
         public void anularReserva(Reserva reserva) throws OperationNotSupportedException{
             reservas.borrar(reserva);
           
         }
         
         public Reserva[] getReservasAulas(Aula aula){
             return reservas.getReservasAula(aula);
         }
         public Reserva[] getReservasProfesor(Profesor profesor){
             return reservas.getReservasProfesor(profesor);
         }
         public Reserva[] getReservaPermanencia(Permanencia permanencia){
             return reservas.getReservasPermanencia(permanencia);
             
         }
         public boolean consulrarDisponibilidad(Aula aula, Permanencia permanencia){
             return reservas.consultarDisponibilidad(aula, permanencia);
         }
}
	
	