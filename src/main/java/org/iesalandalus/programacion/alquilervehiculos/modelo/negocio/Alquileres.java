package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public class Alquileres {

	private List<Alquiler> coleccionAlquileres;

	public Alquileres() {
		coleccionAlquileres = new ArrayList<>();
	}

	public List<Alquiler> get() {
		return new ArrayList<>(coleccionAlquileres);
	}

	// Devolvemos una lista de los Alquileres para el cliente indicado
	public List<Alquiler> get(Cliente cliente) {
		List<Alquiler> listaAlquileres = new ArrayList<>();
		for (Alquiler elemento : coleccionAlquileres) {
			if (elemento.getCliente().equals(cliente)) {
				listaAlquileres.add(elemento);
			}
		}
		return listaAlquileres;
	}

	// Devolvemos una lista de los Alquileres para el turismo indicado
	public List<Alquiler> get(Vehiculo turismo) {
		List<Alquiler> listaAlquileres = new ArrayList<>();
		for (Alquiler elemento : coleccionAlquileres) {
			if (elemento.getVehiculo().equals(turismo)) {
				listaAlquileres.add(elemento);
			}
		}
		return listaAlquileres;
	}

	public int getCantidad() {
		return coleccionAlquileres.size();
	}

	private void comprobarAlquiler(Cliente cliente, Vehiculo turismo, LocalDate fechaAlquiler)
			throws OperationNotSupportedException {
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getFechaDevolucion() == null) {
				if (alquiler.getCliente().equals(cliente)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
				} else if (alquiler.getVehiculo().equals(turismo)) {
					throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
				}
			} else {
				if (alquiler.getCliente().equals(cliente) && (alquiler.getFechaDevolucion().isAfter(fechaAlquiler)
						|| alquiler.getFechaDevolucion().isEqual(fechaAlquiler))) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
				} else if (alquiler.getVehiculo().equals(turismo)
						&& (alquiler.getFechaDevolucion().isAfter(fechaAlquiler)
								|| alquiler.getFechaDevolucion().isEqual(fechaAlquiler))) {
					throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
				}
			}
		}
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}
		comprobarAlquiler(alquiler.getCliente(), alquiler.getVehiculo(), alquiler.getFechaAlquiler());
		coleccionAlquileres.add(alquiler);
	}

	public void devolver(Cliente cliente, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler de un cliente nulo.");
		}
		if (getAlquilerAbierto(cliente) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler abierto para ese cliente.");
		}
		getAlquilerAbierto(cliente);
	}

	private Alquiler getAlquilerAbierto(Cliente cliente) throws OperationNotSupportedException {
		Alquiler alquilerAbierto = null;
		for (Iterator<Alquiler> iterator = coleccionAlquileres.iterator(); alquilerAbierto == null
				&& iterator.hasNext();) {
			Alquiler alquiler = (Alquiler) iterator.next();
			if (alquiler.getCliente().equals(cliente) && alquiler.getFechaDevolucion() == null) {
				alquilerAbierto = alquiler;
			}
		}
		return alquilerAbierto;
	}

	public void devolver(Vehiculo vehiculo, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler de un vehículo nulo.");
		}
		if (getAlquilerAbierto(vehiculo) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler abierto para ese vehículo.");
		}
		getAlquilerAbierto(vehiculo);
	}

	private Alquiler getAlquilerAbierto(Vehiculo vehiculo) {
		Alquiler alquilerAbierto = null;
		for (Iterator<Alquiler> iterator = coleccionAlquileres.iterator(); alquilerAbierto == null
				&& iterator.hasNext();) {
			Alquiler alquiler = (Alquiler) iterator.next();
			if (alquiler.getVehiculo().equals(vehiculo) && alquiler.getFechaDevolucion() == null) {
				alquilerAbierto = alquiler;
			}
		}
		return alquilerAbierto;
	}

	public Alquiler buscar(Alquiler alquiler) {
		Alquiler alquilerEncontrado;
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}
		int indice = coleccionAlquileres.indexOf(alquiler);
		if (coleccionAlquileres.contains(alquiler)) {
			alquilerEncontrado = coleccionAlquileres.get(indice);
		} else {
			alquilerEncontrado = null;
		}
		return alquilerEncontrado;
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}
		if (!coleccionAlquileres.contains(alquiler)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
		coleccionAlquileres.remove(alquiler);
	}

}
