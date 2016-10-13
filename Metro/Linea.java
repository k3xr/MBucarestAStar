package Metro;

import java.util.Iterator;

import net.datastructures.NodePositionList;

public class Linea {
	/* Esta clase es la que contendrá y simulará una línea de metro.
	 * Cosas que se pueden hacer con ella:
	 * + Crear una nueva línea de metro
	 * + Pedir el nombre de la línea
	 *   (el nombre puede esta compuesto por las estaciones de cabecera)
	 * + Pedir el número de la línea
	 * + Pedir las estaciones que tiene la línea */
	
	
	private String nombre;
	private int numero;
	private NodePositionList<Estacion> estaciones;
	
	
	public Linea(String nombre, int numero) {
		super();
		this.nombre = nombre;
		this.numero = numero;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public NodePositionList<Estacion> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(NodePositionList<Estacion> estaciones) {
		this.estaciones = estaciones;
	}
	
	//Método para saber si una estación dada pertenece a la línea
	public boolean pertenece(Estacion estacion){
		boolean encontrada = false;
		Iterator<Estacion> iteradorEstaciones = this.estaciones.iterator();
		Estacion aux = null;
		while(iteradorEstaciones.hasNext()){
			aux = iteradorEstaciones.next();
			if(aux == estacion)
				encontrada = true;
		}
		return encontrada;
	}
	
	//Método que te devuelve una estación dado su nombre
	public Estacion buscarEstacion(String nombreEstacion){
		Estacion estacionBuscada = null;
		Iterator<Estacion> iteradorEstaciones = this.estaciones.iterator();
		Estacion aux = null;
		while(iteradorEstaciones.hasNext()){
			aux = iteradorEstaciones.next();
			if(aux.getNombre().equals(nombreEstacion))
				estacionBuscada = aux;
		}
		
		return estacionBuscada;
	}

}
