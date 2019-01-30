/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author Galina
 */
public class Profesor {
    private static final String ER_TELEFONO = "[69][0-9]{8}";
    private static final String ER_CORREO = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,4})$";
    private String nombre;
    private String correo;
    private String telefono;
    
        //constructor con parametros, nombre y correo
        public Profesor(String nombre, String correo) {
            setNombre(nombre);
            setCorreo(correo);
            
        }
        
        //constructor con parametros nombre,correo, telefonoç
        public Profesor(String nombre, String correo, String telefono){
            setNombre(nombre);
            setCorreo(correo);
            setTelefono(telefono);
        }
        
        //constructor copia
        public Profesor(Profesor profesor){
            if(profesor == null){
                throw new IllegalArgumentException("No se puede copiar un profesor nulo.");
            }
            else {
                setNombre(profesor.nombre);
                setCorreo(profesor.correo);
                setTelefono(profesor.telefono);
            }
            
            
                
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            if(nombre==null || nombre.equals("")){
                throw new IllegalArgumentException("El nombre del profesor no puede ser nulo.");    
            }
            this.nombre = nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            if (correo != null || correo.equals("")) 
                if (Pattern.matches(ER_CORREO, correo))
                {
                this.correo = correo;
                } 
                else 
                {
                throw new IllegalArgumentException("El correo no tiene un formato válido.");
                }
            else 
            {
            throw new IllegalArgumentException("El correo no tiene un formato válido.");
            }
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            if (telefono != null || telefono.equals(""))
            if(Pattern.matches(ER_TELEFONO, telefono))
            {
                this.telefono = telefono;
            }else
            {
            throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacio.");
            }   
        else 
        {
        throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
        }
        }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.correo);
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
        final Profesor other = (Profesor) obj;
       if(nombre==null){
           if(other.nombre!=null){
               return false;
           }
       }
       else if (!nombre.equals(other.nombre)){
           return false;
       }

        return true;
    }

    @Override
    public String toString() {
       
        return "[nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + '}';
    }
        
        

        
}
