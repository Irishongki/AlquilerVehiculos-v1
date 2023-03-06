package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public class Vehiculos {

	private List<Vehiculo> coleccionVehiculos;

	public Vehiculos() {
		coleccionVehiculos = new ArrayList<>();
	}

	public List<Vehiculo> get() {
		return new ArrayList<>(coleccionVehiculos);
	}

	public int getCantidad() {
		return coleccionVehiculos.size();
	}

	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un vehiculo nulo.");
		}
		if (coleccionVehiculos.contains(vehiculo)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un vehiculo con esa matrícula.");
		}
		coleccionVehiculos.add(vehiculo);
	}

	public Vehiculo buscar(Vehiculo vehiculo) {
		Vehiculo vehiculoEncontrado;
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un vehiculo nulo.");
		}
		int indice = coleccionVehiculos.indexOf(vehiculo);
		if (coleccionVehiculos.contains(vehiculo)) {
			vehiculoEncontrado = coleccionVehiculos.get(indice);
		} else {
			vehiculoEncontrado = null;
		}
		return vehiculoEncontrado;
	}

	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un vehiculo nulo.");
		}
		if (!coleccionVehiculos.contains(vehiculo)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún vehiculo con esa matrícula.");
		}
		coleccionVehiculos.remove(vehiculo);
	}
}
