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

public class Reserva {
    private Profesor profesor;
    private Aula aula;
    private Permanencia permanencia;
    


    //constructor con parametrosprofesor, aula, permanencia
    public Reserva(Profesor profesor, Aula aula, Permanencia permanencia){
       setProfesor(profesor);
       setAula(aula);
       setPermanencia(permanencia);
    }
    
    //constructor copia
    public Reserva(Reserva reserva){
        if(reserva == null){
            throw new IllegalArgumentException("No se puede copiar una reserva nula.");
        }
        setProfesor(reserva.profesor);
        setAula(reserva.aula);
        setPermanencia(reserva.permanencia);
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        if(profesor==null){
            throw new IllegalArgumentException("La reserva debe estar a nombre de un profesor.");
        }
        this.profesor = profesor;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        if(aula==null){
            throw new IllegalArgumentException("La reserva debe ser para un aula concreta.");
        }
        this.aula = aula;
    }

    public Permanencia getPermanencia() {
       
        return permanencia;
    }

    public void setPermanencia(Permanencia permanencia) {
        if(permanencia==null){
            throw new IllegalArgumentException("La reserva se debe hacer para una permanencia concreta.");
            
        }
        this.permanencia = permanencia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.aula);
        hash = 11 * hash + Objects.hashCode(this.permanencia);
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
        Reserva other = (Reserva) obj;
        if(aula==null){
            if(other.aula!=null){
                return false;
            }else if(!aula.equals(other.aula))
                return false;
        }
        
        if (permanencia==null) {
            if(other.permanencia!=null){
                return false;
            }else if(!permanencia.equals(other.permanencia))
            return false;
        }
        if (!Objects.equals(this.permanencia, other.permanencia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[profesor=" + profesor + ", aula=" + aula + ", permanencia=" + permanencia + "]";
    }
    
    
    
}