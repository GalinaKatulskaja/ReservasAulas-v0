/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;

/**
 *
 * @author Galina
 */
public class Profesores {
    
    private static final int MAX_PROFESORES = 5;
    private int numProfesores;
    private Profesor[] coleccionProfesores;
    
    //constructor por defecto 
    public Profesores(){
        this.coleccionProfesores = new Profesor[MAX_PROFESORES];
        this.numProfesores=0;
    }
    
    //constructor copia
    public Profesores(Profesores profesores){
        setProfesores(profesores);
    }
    public void setProfesores(Profesores profesores){
        if(profesores==null){
            throw new IllegalArgumentException("No se pueden copiar profesores nulos.");
        }
        this.coleccionProfesores=copiaProfundaProfesores(profesores.coleccionProfesores);
        this.numProfesores=profesores.numProfesores;
    }
    
    //constructor copia profunda
    private Profesor[] copiaProfundaProfesores(Profesor[] coleccionProfesores){
        Profesor[] coleccionProfesoresCopia = new Profesor[coleccionProfesores.length];
            for(int i=0; i<coleccionProfesores.length && coleccionProfesores[i] !=null; i++){
                coleccionProfesoresCopia[i] = new Profesor(coleccionProfesores[i]);
            }
            return coleccionProfesoresCopia;
    } 
    
    //salida
    public Profesor[] getProfesores(){
        return copiaProfundaProfesores(coleccionProfesores);
    }
    public int getNumProfesores() {
        return numProfesores;
    }

    //metodo insertar para añadir profesor en el array
    public void insertar(Profesor profesor) throws OperationNotSupportedException{
        if(profesor == null){
            throw new IllegalArgumentException("No se puede insertar un profesor nulo.");
        }
        if(indiceNoSuperaTamano(buscarIndiceProfesor(profesor))== false){
            coleccionProfesores[buscarIndiceProfesor(profesor)] =profesor;
            numProfesores++;
        }else{
            if(indiceNoSuperaCapacidad(buscarIndiceProfesor(profesor))){
                throw new OperationNotSupportedException("El profesor ya existe.");
            }else{
                throw new OperationNotSupportedException("No se aceptan más profesores.");
            }
        }
    }
    
    //metodo buscar indice libre para Profesor
    private  int buscarIndiceProfesor(Profesor profesor){
        int indice=0;
        boolean encontrado = false;
        
        if(indiceNoSuperaTamano(indice) && encontrado == false){
            if(coleccionProfesores[indice].equals(profesor)){
                encontrado=true;
            }else{
                indice++;
            }
        }
        return indice;
    }
    
    //comprobar tamaño de array
    private boolean indiceNoSuperaTamano(int indice){
        if (indice>coleccionProfesores.length){
            return true;
        }  
        else{
            return false;
        }
             
    }
    //comprobar la capacidad de numero deprofesores
    private boolean indiceNoSuperaCapacidad(int indice){
        if (indice>MAX_PROFESORES){
            return true;
        }  
        else{
            return false;
        }
    }
    
    //metodo para buscar Profesores
    public Profesor buscar(Profesor profesor){
    Profesor encontrado = null;
    if(indiceNoSuperaTamano(buscarIndiceProfesor(profesor))){
        encontrado=coleccionProfesores[buscarIndiceProfesor(profesor)];
        }
    return encontrado;
    }
    
    //metodo para borrar profesores 
    public void borrar(Profesor profesor) throws OperationNotSupportedException{
        if(profesor==null){
            throw new IllegalArgumentException("No se puede borrar un profesor nulo.");
		}
        if(indiceNoSuperaTamano(buscarIndiceProfesor(profesor))){
            desplazarUnaPosicionHaciaIzquierda(buscarIndiceProfesor(profesor));
        }
            else{
                throw new OperationNotSupportedException("El profesor a borrar no existe.");
                    }
        }
    //metodo para despalazar una posicion
    private void desplazarUnaPosicionHaciaIzquierda(int posicion){
        for(int i = posicion; i<numProfesores - 1; i++){
            coleccionProfesores[i]=coleccionProfesores[i+1];
        }

        numProfesores--;
    }
    
    public String[] representar(){
        String[] representarProfesores = new String[numProfesores];
        for(int i= 0; indiceNoSuperaTamano(i); i++){
            representarProfesores[i]= coleccionProfesores[i].toString();
        }
        return representarProfesores;
    }
}

