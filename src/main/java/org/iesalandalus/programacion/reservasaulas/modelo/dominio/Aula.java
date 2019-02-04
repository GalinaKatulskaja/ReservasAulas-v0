/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.util.Objects;

/**
 *
 * @author Galina
 */
public class Aula {
    private String nombre;
    
    public Aula(String nombre){
        setNombre(nombre);
        
    }
    public Aula(Aula aula){
        setNombre(aula.getNombre());
    }
    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        if(nombre==null){
            throw new IllegalArgumentException("El nombre del aula no puede ser nulo."); }
        if(nombre.equals("")){
            throw new IllegalArgumentException("El nombre del aula no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aula other = (Aula) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        //("[nombre=Salón de actos]", aula.toString())
        return  "[nombre=" + nombre +"]";
    }
    
    
}   
