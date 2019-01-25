/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas;

/**
 *
 * @author Galina
 */
public class Aulas {
    private static final int MAX_AULAS=10;
    private int numAulas;
    
    public Aulas(){}
    
    public Aulas(Aulas aulas){
    }

    public int getNumAulas() {
        return numAulas;
    }

    public void setNumAulas(int numAulas) {
       
        this.numAulas = numAulas;
    }
    privado Aula copiaProfundaAulas(Aula[] a){
        Aula[] otrasAulas = new Aula[aulas.length];
		for (int i = 0; i < aulas.length && aulas[i] != null; i++) {
			otrasAulas[i] = new Aula(aulas[i]);
		}
		return otrasAulas;
    
    }
    public Aulas[] getAulas(){
    return Aulas[];
    }
    public void insetrar(Aula aula){
        
    }
    private int buscarIndiceAula(Aula){
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
