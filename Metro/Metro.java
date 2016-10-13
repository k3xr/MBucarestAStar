package Metro;

import net.datastructures.ArrayIndexList;

public class Metro {
	/* Esta clase es la que contendrá y simulará la red de metro.
	 * Cosas que se pueden hacer con ella:
	 * + Crear una nueva red de metro
	 * + Pedir el nombre de la red de metro
	 * + Pedir las líneas que tiene la red de metro */
	
	private String nombre;
	private ArrayIndexList<Linea> lineas;
	
	
	public Metro(String nombre, ArrayIndexList<Linea> lineas) {
		super();
		this.nombre = nombre;
		this.lineas = lineas;
	}


	public String getNombre() {
		return nombre;
	}


	public ArrayIndexList<Linea> getLineas() {
		return lineas;
	}
	
	

}
