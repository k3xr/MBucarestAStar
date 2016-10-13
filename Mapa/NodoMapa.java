package Mapa;

import net.datastructures.ArrayIndexList;
import Metro.Estacion;

public class NodoMapa {
	
	private Estacion estacion;
	private double g, h, f;
	private NodoMapa padre;
	private ArrayIndexList<NodoMapa> hijos;
	
	
	public NodoMapa(Estacion estacion) {
		super();
		this.estacion = estacion;
		this.g = 0;
		this.h = 0;
		this.f = 0;
		this.padre = null;
		this.hijos = new ArrayIndexList<NodoMapa>();
	}


	public Estacion getEstacion() {
		return estacion;
	}


	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}


	public double getG() {
		return g;
	}


	public void setG(double g) {
		this.g = g;
	}


	public double getH() {
		return h;
	}


	public void setH(double h) {
		this.h = h;
	}


	public double getF() {
		return f;
	}


	public void setF(double f) {
		this.f = f;
	}


	public NodoMapa getPadre() {
		return padre;
	}


	public void setPadre(NodoMapa padre) {
		this.padre = padre;
	}


	public ArrayIndexList<NodoMapa> getHijos() {
		return hijos;
	}


	public void setHijos(ArrayIndexList<NodoMapa> hijos) {
		this.hijos = hijos;
	}
	
	
	
	

}
