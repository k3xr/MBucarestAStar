

package Metro;

//import net.datastructures.ArrayIndexList;

public class Estacion {
	/* Esta clase es la que simulará una estación de una línea de metro.
	 * Cosas que se pueden hacer con ella:
	 * + Crear una nueva estación
	 * + Pedir el nombre de la estación 
	 * + Pedir las coordenadas de la estación
	 * + Preguntar si la estación tiene transbordos
	 * + Pedir los transbordos de la estación */
	
	private String nombre;
	private double latitud, longitud;
	private Transbordo transbordos;
	private Estacion anterior, siguiente;
	private double distanciaAnterior, distanciaSiguiente;
	
	public Estacion(String nombre, double latitud, double longitud,
			double distanciaAnterior, double distanciaSiguiente) {
		super();
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.distanciaAnterior = distanciaAnterior;
		this.distanciaSiguiente = distanciaSiguiente;
		
	}


	public String getNombre() {
		return nombre;
	}


	public Transbordo getTransbordos() {
		return transbordos;
	}
	

	public double getLatitud() {
		return latitud;
	}


	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}


	public double getLongitud() {
		return longitud;
	}


	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public boolean tieneAnterior(){
		return anterior!=null;
	}

	public Estacion getAnterior() {
		return anterior;
	}

	public boolean tieneSiguiente(){
		return siguiente!=null;
	}
	
	public Estacion getSiguiente() {
		return siguiente;
	}


	public double getDistanciaAnterior() {
		return distanciaAnterior;
	}


	public double getDistanciaSiguiente() {
		return distanciaSiguiente;
	}


	public boolean tieneTransbordo(){
		return transbordos!=null;
	}


	public void setTransbordos(Transbordo transbordos) {
		this.transbordos = transbordos;
	}


	public void setAnterior(Estacion anterior) {
		this.anterior = anterior;
	}


	public void setSiguiente(Estacion siguiente) {
		this.siguiente = siguiente;
	}

}
