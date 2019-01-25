/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas;

import javax.naming.OperationNotSupportedException;

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
        this.coleccionAulas = this.copiaProfundaAulas(aulas.coleccionAulas);      
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
    public int getNumAulas(){
        return numAulas;
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
            return indice;
        }
    }
    private boolean indiceNoSuperaTamano(int){
    }
    private boolean indiceNoSuperaCapacidad(int){
    }
    public Aula buscar(Aula){
    }
    public void borrar (Aula){
    }
    private void desplazarUnaPosicionHaciaIzquierda(int){
    }
    public String[] representar(){} 
    
    
}
