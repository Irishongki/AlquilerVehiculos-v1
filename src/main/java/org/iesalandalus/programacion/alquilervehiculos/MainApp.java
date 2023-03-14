package org.iesalandalus.programacion.alquilervehiculos;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {

	public static void main(String[] args) throws OperationNotSupportedException {
		Vista vista = new Vista();
		Modelo modelo = new Modelo() {
			
			@Override
			public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertar(Cliente cliente) throws OperationNotSupportedException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public List<Vehiculo> getListaVehiculos() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Cliente> getListaClientes() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Alquiler> getListaAlquileres(Vehiculo vehiculo) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Alquiler> getListaAlquileres(Cliente cliente) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Alquiler> getListaAlquileres() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void devolver(Vehiculo vehiculo, LocalDate fechaDevolucion) throws OperationNotSupportedException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void devolver(Cliente cliente, LocalDate fechaDevolucion) throws OperationNotSupportedException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Alquiler buscar(Alquiler alquiler) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Vehiculo buscar(Vehiculo vehiculo) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Cliente buscar(Cliente cliente) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void borrar(Cliente cliente) throws OperationNotSupportedException {
				// TODO Auto-generated method stub
				
			}
		};
		Controlador controlador = new Controlador(modelo, vista);
		controlador.comenzar();
	}

}
