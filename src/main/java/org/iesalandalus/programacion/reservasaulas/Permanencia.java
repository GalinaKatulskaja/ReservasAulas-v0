/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author Galina
 */
public class Permanencia {
    private LocalDate dia;
    private static final DateTimeFormatter FORMATO_DIA=DateTimeFormatter.ofPattern("dd/mm/yyyy");
    private Tramo tramo;
    
    public Permanencia(LocalDate dia, Tramo tramo){
        setDia(dia);
        setTramo(tramo);
    }
    public Permanencia(Permanencia p)
    {
        if(p==null){
            throw new IllegalArgumentException("No se puede copiar una permanencia nula.");
        }
        setDia(dia);
        setTramo(tramo);
    }

    public LocalDate getDia() {
        return dia;
    }

    private void setDia(LocalDate dia) {
        if(dia==null){
            throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
        }
        this.dia = dia;
    }

    public Tramo getTramo() {
        return tramo;
    }

    public void setTramo(Tramo tramo) {
        if(tramo==null){
        throw new IllegalArgumentException("El tramo de una permanencia no puede ser nulo.");}
        this.tramo = tramo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.dia);
        hash = 89 * hash + Objects.hashCode(this.tramo);
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
        final Permanencia other = (Permanencia) obj;
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        if (this.tramo != other.tramo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[dia= "+getDia().format(FORMATO_DIA)+ ", tramo="+getTramo()+"]";
        
    }
    
}
