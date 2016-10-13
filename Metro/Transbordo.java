package Metro;

import net.datastructures.ArrayIndexList;

public class Transbordo {
	/* Esta clase es la que simulará un transbordo entre dos estaciones de una línea de metro.
	 * Cosas que se pueden hacer con ella:
	 * + Crear un nueva transbordo
	 * + Pedir las línes del transbordo 
	 * + Pedir la longitud del transbordo */
	
	private ArrayIndexList<Linea> lineas;
	private double longitud;
	
	public Transbordo(ArrayIndexList<Linea> lineas, double longitud) {
		super();
		this.lineas = lineas;
		this.longitud = longitud;
	}

	public ArrayIndexList<Linea> getLineas() {
		return lineas;
	}

	public double getLongitud() {
		return longitud;
	}
	
	

}
