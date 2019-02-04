/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;

/**
 *
 * @author Galina
 */
public class Aulas {
    private static final int MAX_AULAS=10;
    private int numAulas;
    private Aula[] coleccionAulas;
    
    public Aulas(){
        this.numAulas = 0;
        this.coleccionAulas = new Aula[MAX_AULAS];
    }
    
    public Aulas(Aulas aulas){
        setAulas(aulas);
    }

    public int getNumAulas() {
        return numAulas;
    }

    public void setAulas(Aulas aulas) {
        if(aulas == null){
            throw new IllegalArgumentException("No se pueden copiar aulas nulas.");
        }
        this.coleccionAulas = copiaProfundaAulas(aulas.coleccionAulas);      
        this.numAulas = aulas.numAulas;
    }
    private Aula[] copiaProfundaAulas(Aula[] coleccionAulas){
        Aula[] otrasAulas = new Aula[coleccionAulas.length];
		for (int i = 0; i < coleccionAulas.length && coleccionAulas[i] != null; i++) {
			otrasAulas[i] = new Aula(coleccionAulas[i]);
		}
		return otrasAulas;
    
    }
    public Aula[] getAulas(){
        return  copiaProfundaAulas(coleccionAulas);
    }
    public void insetrar(Aula aula) throws OperationNotSupportedException{
        if( aula == null){
            throw new IllegalArgumentException("No se puede insertar un aula nula.");
        }
        int indice = buscarIndiceAula(aula);
        if(indiceNoSuperaTamano(indice)== false) {
            coleccionAulas[indice] = aula;
            numAulas=+1;
        }
        else {
            if(indiceNoSuperaCapacidad(indice)){
                throw new OperationNotSupportedException("El aula ya existe.");
            }
            else {
                throw new OperationNotSupportedException("");
            }
        }
    }
    private int buscarIndiceAula(Aula aula){
        int indice = 0;
        boolean encontrado = false;
        if(indiceNoSuperaTamano(indice) && encontrado == false){
            if(coleccionAulas[indice].equals(aula)){
                encontrado= true;
            }
            else {
                indice=+1;
            }
            
        }
        return indice;
    } 
    private boolean indiceNoSuperaTamano(int indice){
        if (indice<coleccionAulas.length){
            return true;
        }
        else{
            return false;
        }    
    }
    private boolean indiceNoSuperaCapacidad(int indice){
        if (indice<MAX_AULAS){
            return true;
        }
        else{
            return false;
        }    
    }
    
    public void insertar(Aula aula) throws OperationNotSupportedException {
		if(aula == null) {
			throw new IllegalArgumentException("No se puede insertar un aula nula.");
		}
		int indice = buscarIndiceAula(aula);
		if(indiceNoSuperaTamano(indice) == false) {
			coleccionAulas[indice] = aula;
			numAulas++;
		} else {
			if(indiceNoSuperaCapacidad(indice)) {
				throw new OperationNotSupportedException("El aula ya existe.");
			} else {
				throw new OperationNotSupportedException("");
			}
		}
	}


    public Aula buscar(Aula aula){
        Aula encontrada= null;
        int indice = buscarIndiceAula(aula);
        if(indiceNoSuperaTamano(indice)){
            encontrada = coleccionAulas[indice];
        }
        return encontrada;
    }
    public void borrar(Aula aula) throws OperationNotSupportedException{
        int indice = buscarIndiceAula(aula);
        if(aula ==null){
            throw new IllegalArgumentException("No se puede borrar un aula nula.");
        }
        if(indiceNoSuperaTamano(indice)){
            desplazarUnaPosicionHaciaIzquierda(indice);
        }
        else {
            throw new OperationNotSupportedException("El aula a borrar no existe.");
        }
    }
    private void desplazarUnaPosicionHaciaIzquierda(int indice){
        for(int i = indice; i<numAulas-1;i++){
            coleccionAulas[i] = coleccionAulas[i+1];
        }
        coleccionAulas[numAulas]=null;
        numAulas=-1;
    }
    public String[] representar(){
        String[] representacion = new String[numAulas];
            for (int i = 0; indiceNoSuperaTamano(i); i++) {
		representacion[i] = coleccionAulas[i].toString();
		}
		return representacion;
    } 
    
    
}
