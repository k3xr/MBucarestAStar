package Algoritmo;

import net.datastructures.ArrayIndexList;
import Mapa.NodoMapa;
import Metro.*;


public class AEstrella_bis {

	public double distanciaLineaRectaH(Estacion a, Estacion b) {
		//	1º ~ 111.18 Km
		//	dº ~ x Km
		// entonces x = d * 111.18 Km
		double d= Math.sqrt(Math.pow(b.getLatitud()-a.getLatitud(), 2)+Math.pow(b.getLongitud()-a.getLongitud(), 2));
		return d*111.18;		
	}
	
	public ArrayIndexList<NodoMapa> AEstrella(Estacion origen, Estacion destino, Metro metro){
		ArrayIndexList<NodoMapa> listaAbierta = new ArrayIndexList<NodoMapa>();
		ArrayIndexList<NodoMapa> listaCerrada = new ArrayIndexList<NodoMapa>();
		ArrayIndexList<NodoMapa> nodosGenerados = new ArrayIndexList<NodoMapa>();
		
		NodoMapa nodoActual = new NodoMapa(origen);
		nodoActual.setG(0);
		nodoActual.setH(distanciaLineaRectaH(origen, destino));
		nodoActual.setF(nodoActual.getG() + nodoActual.getH());
		Estacion estacionActual = origen; 
		//NodoMapa nodoDestino = new NodoMapa(destino);
		
		listaAbierta.add(0, nodoActual);
	
		/*Generar una lista con las estaciones vecinas a la estacion actual*/	
		ArrayIndexList<Estacion> vecinos = new ArrayIndexList<Estacion>();
		if(estacionActual.tieneAnterior())
			vecinos.add(vecinos.size(), estacionActual.getAnterior());
		if(estacionActual.tieneSiguiente())
			vecinos.add(vecinos.size(), estacionActual.getSiguiente());
		if(estacionActual.tieneTransbordo()){
			Transbordo transbordoActual = estacionActual.getTransbordos();
			ArrayIndexList<Linea> lineasTransbordo = transbordoActual.getLineas();
			for(int i = 0; i < lineasTransbordo.size(); i++){
				if(!lineasTransbordo.get(i).pertenece(estacionActual))
					vecinos.add(vecinos.size(), lineasTransbordo.get(i).buscarEstacion(estacionActual.getNombre()));
			}
		}/*FIN*/
		
		/*Generar la lista de nodosMapa correspondientes a las estaciones vecinas
		 * controlando que no se genere un nodo nuevo de una estación si ya existe
		 * en la lista de nodos generados previamente*/
		ArrayIndexList<NodoMapa> nodosVecinos = new ArrayIndexList<NodoMapa>();
		boolean found = false;
		for(int i = 0; i < vecinos.size(); i++){
			for(int j = 0 ; j < nodosGenerados.size(); j++){
				if(nodosGenerados.get(j).getEstacion().equals(vecinos.get(i))){
					found = true;
					nodosVecinos.add(nodosVecinos.size(), nodosGenerados.get(j));
				}
			}
			if(!found){
				NodoMapa nuevoNodo = new NodoMapa(vecinos.get(i));
				nodosGenerados.add(nodosGenerados.size(), nuevoNodo);
				nodosVecinos.add(i, nuevoNodo);
			}
			found = false;
		}/*FIN*/
		
		/*Para cada nodo vecino que se haya encontrado se establece que el nodo actual es su padre*/
		for(int i = 0; i < nodosVecinos.size(); i++){
			nodosVecinos.get(i).setPadre(nodoActual);
		}/*FIN*/
		
		/*Para cada nodo vecino se evalúa su f y se añade a la lista abierta*/
		for(int i = 0; i < nodosVecinos.size(); i++){
			NodoMapa vecinoActual = nodosVecinos.get(i);
			if(estacionActual.tieneAnterior() &&
					vecinoActual.getEstacion().equals(estacionActual.getAnterior())){
				vecinoActual.setG(nodoActual.getG() + estacionActual.getDistanciaAnterior());
			}
			else if(estacionActual.tieneSiguiente() &&
					vecinoActual.getEstacion().equals(estacionActual.getSiguiente())){
				vecinoActual.setG(nodoActual.getG() + estacionActual.getDistanciaSiguiente());
			}
			else{
				vecinoActual.setG(nodoActual.getG() + estacionActual.getTransbordos().getLongitud());
			}
			vecinoActual.setH(distanciaLineaRectaH(vecinoActual.getEstacion(), destino));
			vecinoActual.setF(vecinoActual.getG() + vecinoActual.getH());
			listaAbierta.add(listaAbierta.size(), vecinoActual);
		}/*FIN*/
		
		//Se añade el nodo actual a la lista cerrada y se elimina de la lista abierta
		listaCerrada.add(listaCerrada.size(), nodoActual);
		listaAbierta.remove(0);
		
		do{
			/*Se busca el nodo con menor F dentro de la lista abierta*/
			int indiceSiguiente = 0;
			for(int n = 0; n < listaAbierta.size(); n++){
				if(listaAbierta.get(indiceSiguiente).getF() > listaAbierta.get(n).getF())
					indiceSiguiente = n;
			}
			//listaAbierta.get(indiceSiguiente).setPadre(nodoActual);
			//y se establece como nodo actual
			nodoActual = listaAbierta.get(indiceSiguiente);
			estacionActual = nodoActual.getEstacion();
			//Si la estacion actual es la estacion objetivo, se añade a la lista cerrada
			//y se termina el algoritmo
			if(estacionActual.equals(destino)){
				listaCerrada.add(listaCerrada.size(), nodoActual);
				break;
			}
			
			//System.out.println("Sale de la lista abierta: "+listaAbierta.get(indiceSiguiente).getEstacion().getNombre());
			//Se añade el nodo actual a la lista cerrada y se elimina de la lista abierta
			listaAbierta.remove(indiceSiguiente);
			listaCerrada.add(listaCerrada.size(), nodoActual);
			
			/*Generar una lista con las estaciones vecinas a la estacion actual*/
			vecinos = new ArrayIndexList<Estacion>();
			if(estacionActual.tieneAnterior())
				vecinos.add(vecinos.size(), estacionActual.getAnterior());
			if(estacionActual.tieneSiguiente())
				vecinos.add(vecinos.size(), estacionActual.getSiguiente());
			if(estacionActual.tieneTransbordo()){
				Transbordo transbordoActual = estacionActual.getTransbordos();
				ArrayIndexList<Linea> lineasTransbordo = transbordoActual.getLineas();
				for(int i = 0; i < lineasTransbordo.size(); i++){
					if(!lineasTransbordo.get(i).pertenece(estacionActual))
						vecinos.add(vecinos.size(), lineasTransbordo.get(i).buscarEstacion(estacionActual.getNombre()));
				}
			}/*FIN*/
			
			/*De la lista de estaciones vecinas se borra la estación de la que venimos*/
			for(int i = 0; i < vecinos.size(); i++){
				if(nodoActual.getPadre().getEstacion().equals(vecinos.get(i)))
					vecinos.remove(i);
			}/*FIN*/
			
			/*Generar la lista de nodosMapa correspondientes a las estaciones vecinas
			 * controlando que no se genere un nodo nuevo de una estación si ya existe
			 * en la lista de nodos generados previamente*/
			nodosVecinos = new ArrayIndexList<NodoMapa>();
			found = false;
			for(int i = 0; i < vecinos.size(); i++){
				for(int j = 0 ; j < nodosGenerados.size(); j++){
					if(nodosGenerados.get(j).getEstacion().equals(vecinos.get(i))){
						found = true;
						nodosVecinos.add(nodosVecinos.size(), nodosGenerados.get(j));
					}
				}
				if(!found){
					NodoMapa nuevoNodo = new NodoMapa(vecinos.get(i));
					nodosGenerados.add(nodosGenerados.size(), nuevoNodo);
					nodosVecinos.add(i, nuevoNodo);
				}
				found = false;
			}/*FIN*/
			
			/*A cada nodo vecino se le indica que su padre es el nodo actual
			 * salvo que ya tenga padre*/
			for(int i = 0; i < nodosVecinos.size(); i++){
				if(nodosVecinos.get(i).getPadre()==null)
					nodosVecinos.get(i).setPadre(nodoActual);
			}/*FIN*/
			
			/*Se elimina de la lista de nodos vecinos el padre del nodo actual en que caso
			 * de que se encuentre en la lista de nodos vecinos*/
			for(int i = 0; i < nodosVecinos.size(); i++){
				if(nodoActual.getPadre().getEstacion().equals(nodosVecinos.get(i).getEstacion()))
					nodosVecinos.remove(i);
			}/*FIN*/
			
			/*Para cada nodo vecino se evalúa su f y se añade a la lista abierta*/
			for(int i = 0; i < nodosVecinos.size(); i++){
				NodoMapa vecinoActual = nodosVecinos.get(i);
				if(estacionActual.tieneAnterior() &&
						vecinoActual.getEstacion().equals(estacionActual.getAnterior())){
					vecinoActual.setG(nodoActual.getG() + estacionActual.getDistanciaAnterior());
				}
				else if(estacionActual.tieneSiguiente() &&
						vecinoActual.getEstacion().equals(estacionActual.getSiguiente())){
					vecinoActual.setG(nodoActual.getG() + estacionActual.getDistanciaSiguiente());
				}
				else{
					vecinoActual.setG(nodoActual.getG() + estacionActual.getTransbordos().getLongitud());
				}
				vecinoActual.setH(distanciaLineaRectaH(vecinoActual.getEstacion(), destino));
				vecinoActual.setF(vecinoActual.getG() + vecinoActual.getH());
				
				//System.out.println("Entra en la lista abierta: "+vecinoActual.getEstacion().getNombre());
				listaAbierta.add(listaAbierta.size(), vecinoActual);
			}/*FIN*/
			
		}while(listaAbierta.size() > 0);
		
	//	listaCerrada.add(listaCerrada.size(), nodoDestino);
		
		return reconstruirTrayecto(listaCerrada);
	}

	private ArrayIndexList<NodoMapa> reconstruirTrayecto(ArrayIndexList<NodoMapa> lista) {
		ArrayIndexList<NodoMapa> aux = new ArrayIndexList<NodoMapa>();
		NodoMapa nodoAux = lista.get(lista.size()-1);
		aux.add(0, nodoAux);
		while(nodoAux.getPadre()!=null){
			aux.add(0, nodoAux.getPadre());
			nodoAux = nodoAux.getPadre();
		}
		return aux;
	}

}
