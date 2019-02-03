/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

/**
 *
 * @author Galina
 */
public class Reservas {
    private static final int MAX_RESERVAS = 10;
    private int numReservas;
    private Reserva[] reservasProfesor;
    
    //constructor por defecto
    public Reservas(){
        this.numReservas = 0;
        this.reservasProfesor= new Reserva[MAX_RESERVAS];
    }
    
    //constructor copia
    public Reservas(Reservas reservas){
        setReservas(reservas);
    }

    public int getNumReservas() {
        return numReservas;
    }
    private void setReservas(Reservas reservas){
        if(reservas == null){
            throw new IllegalArgumentException("No se pueden copiar reservas nulas.");
            
        }
        this.reservasProfesor = copiaProfundaReservas(reservas.reservasProfesor);
        this.numReservas = reservas.numReservas;
    }

    //copia profunda de array de clase reserva
    private Reserva[] copiaProfundaReservas(Reserva[] reservas){
        Reserva[] reservasProfesorCopia = new Reserva[reservas.length];
        for(int i = 0; i < reservas.length && reservas[i] != null; i++){
                reservasProfesorCopia[i] = new Reserva(reservas[i]);
        }
         return reservasProfesorCopia;
    }  
    
    public Reserva[] getReserva() {
        return copiaProfundaReservas(reservasProfesor);
    }
    
    //metodo de insertar la reserva
    
    public void insertar(Reserva reserva) throws OperationNotSupportedException{
        if(reserva == null){
            throw new IllegalArgumentException("No se puede realizar una reserva nula.");
        }
        if(indiceNoSuperaTamano(buscarIndiceReserva(reserva))==false){
            reservasProfesor[numReservas] = reserva;
            numReservas++;
        }
            else{
                 if(indiceNoSuperaCapacidad(buscarIndiceReserva(reserva))){
                    throw new OperationNotSupportedException("La reserva ya existe.");
			} else {
                            throw new OperationNotSupportedException("No se permiten más reservas.");
                        }
                }
        }
    
    //metodo para buscar el primer indice libre de la resrva 
    public int buscarIndiceReserva(Reserva reserva){
        int indice = 0;
        boolean encontrado = false;
        if(indiceNoSuperaTamano(indice) && encontrado == false){
            if(reservasProfesor[indice].equals(reserva)){
                encontrado=true;
                }else{
                indice++;
                }
            }
        return indice;
    }
    
    //comprobar tamaño de array
    private boolean indiceNoSuperaTamano(int indice){
        if (indice>reservasProfesor.length){
            return true;
        }  
        else{
            return false;
        }
             
    }
    //comprobar la capacidad de numero deprofesores
    private boolean indiceNoSuperaCapacidad(int indice){
        if (indice>MAX_RESERVAS){
            return true;
        }  
        else{
            return false;
        }
    }
    
    // el metodo para buscar las reservas 
    public Reserva buscar(Reserva reserva){
    Reserva encontrado = null;
    if(indiceNoSuperaTamano(buscarIndiceReserva(reserva))){
        encontrado=reservasProfesor[buscarIndiceReserva(reserva)];
        }
    return encontrado;
    }
    
    // el metodo para borrar las reservas
    public void borrar(Reserva reserva) throws OperationNotSupportedException{
        if(reserva == null){
            throw new IllegalArgumentException("No se puede anular una reserva nula.");
        }
        if(indiceNoSuperaTamano(buscarIndiceReserva(reserva))){
            desplazarUnaPosicionHaciaIzquierda(buscarIndiceReserva(reserva));
        }
        else {
            throw new OperationNotSupportedException("La reserva a anular no existe.");
        }
    }
    
    //metodo para desplazar el array hacia izquierda
    private void desplazarUnaPosicionHaciaIzquierda(int posicion){
        for(int i = posicion; i <numReservas - 1; i++){
            reservasProfesor[i] = reservasProfesor[i+1];
        }
        numReservas--;
    }
    
    public String[] respresentar(){
        String[] representarReserva= new String[numReservas];
        for(int i = 0; indiceNoSuperaTamano(i); i++){
            representarReserva[i] = reservasProfesor[i].toString();
        }
        return representarReserva;
        
    }
     //comprobamos si la permanencia que quiere reservar, esta disponible
    //en el caso de que esta disponible se le añade una
    public Reserva[] getReservasPermanencia(Permanencia permanencia){
        
        int indice = 0;
        Reserva[] permanenciaReservada = new Reserva[MAX_RESERVAS];
        
        if(permanencia == null){
            throw new IllegalArgumentException("");
        }
        for(int i = 0;i< numReservas; i++){
           
            if(reservasProfesor[i].getPermanencia().equals(permanencia)){
               permanenciaReservada[indice] = new Reserva(reservasProfesor[i]);
               indice++;
            }
        }
        return permanenciaReservada;
    }
    
    public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia){
        boolean consultaDisponible = true;
        
        if(aula == null){
            throw new IllegalArgumentException("No se puede consultar la disponibilidad de un aula nula.");
        }
        if(permanencia == null){
            throw new IllegalArgumentException("No se puede consultar la disponibilidad de una permanencia nula");
        }
        
        for(int i = 0; i<numReservas; i++){
            if(reservasProfesor[i].getAula().equals(aula) && reservasProfesor[i].getPermanencia().equals(permanencia)){
                consultaDisponible = false;
            }
            
            
        }
        return consultaDisponible;
    }

}
