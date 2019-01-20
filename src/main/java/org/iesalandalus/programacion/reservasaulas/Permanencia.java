/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public void setDia(LocalDate dia) {
        if(dia==null){
            throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
        }
        this.dia = LocalDate.of(dia.getDayOfMonth(), dia.getMonth(), dia.getYear());
    }

    public Tramo getTramo() {
        return tramo;
    }

    public void setTramo(Tramo tramo) {
        if(tramo==null){
        throw new IllegalArgumentException("El tramo de una permanencia no puede ser nulo.");}
        this.tramo = tramo;
    }
    
}
