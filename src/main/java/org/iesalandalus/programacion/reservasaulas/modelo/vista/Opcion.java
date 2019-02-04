/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.vista;

import org.iesalandalus.programacion.reservasaulas.modelo.vista.IUTextual;

/**
 *
 * @author Galina
 */
public enum Opcion {
	SALIR("Salir") {
		public void ejecutar() {
			vista.salir();
		}
	},
	INSERTAR_AULA("Insertar aula") {
		public void ejecutar() {
			vista.insertarAula();
		}
	},
	BORRAR_AULA("Borrar aula") {
		public void ejecutar() {
			vista.borrarAula();
		}
	},
	BUSCAR_AULA("Buscar aula") {
		public void ejecutar() {
			vista.buscarAula();
		}
	},
	LISTAR_AULAS("Listar aula") {
		public void ejecutar() {
			vista.listarAula();
		}
	},
        LISTAR_AULAS("Listar aulas") {
		public void ejecutar() {
			vista.listarAulas();
		}
	},
	INSERTAR_PROFESOR("Insertar profesor") {
		public void ejecutar() {
			vista.insertarProfesor();
		}
	},
	BORRAR_PROFESOR("Borrar profesor") {
		public void ejecutar() {
			vista.borrarProfesor();
		}
	},
	BUSCAR_PROFESOR("Buscar profesor") {
		public void ejecutar() {
			vista.buscarProfesor();
		}
	},
	LISTAR_PROFESORES("Listar profesores") {
		public void ejecutar() {
			vista.listarProfesor();
		}
	},
	INSERTAR_RESERVA("Insertar reserva") {
		public void ejecutar() {
			vista.comenzar();
		}
	},
	BORRAR_RESERVA("Borrar reserva") {
		public void ejecutar() {
			vista.anularReserva();
		}
	},
	LISTAR_RESERVAS("Listar reservas") {
		public void ejecutar() {
			vista.listarReservas();
		}
	},
	LISTAR_RESERVAS_AULA("Listar reservas aula") {
		public void ejecutar() {
			vista.listarReservasAulas();
		}
	},
	LISTAR_RESERVAS_PROFESOR("Listar reservas profesor") {
		public void ejecutar() {
			vista.listarReservaProfesor();
		}
	},
	LISTAR_RESERVAS_PERMANENCIA("Listar reservas permanencia") {
		public void ejecutar() {
			vista.listarReservaPermanencia();
		}
	},
	CONSULTAR_DISPONIBILIDAD("Consultar disponibilidad") {
		public void ejecutar() {
			vista.consultarDisponibilidad();
		}
	};
	
	private String mensajeAMostrar;
	private static IUTextual vista;
	
	private Opcion(String mensajeAMostrar) {
		this.mensajeAMostrar = mensajeAMostrar;
	}
	
	public String getMensaje() {
		return mensajeAMostrar;
	}
	
	public abstract void ejecutar();
	
	protected static void setVista(IUTextual vista) {
		Opcion.vista = vista;
	}
	
	@Override
	public String toString() {
		return String.format("%d.- %s", ordinal(), mensajeAMostrar);
	}
	
	public static Opcion getOpcionSegunOrdinal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new IllegalArgumentException("Ordinal de la opción no válido");
	}
	
	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1);
	}
}
