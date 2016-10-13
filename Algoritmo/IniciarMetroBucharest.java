package Algoritmo;

import java.util.Iterator;
import java.util.concurrent.Semaphore;

import net.datastructures.ArrayIndexList;
import net.datastructures.NodePositionList;
import GUI.Mostrar_Trayecto;
import GUI.Principal;
import Mapa.NodoMapa;
import Metro.*;

public class IniciarMetroBucharest {
	
	/*Variables para el algoritmo*/
	private Estacion origen; 
	private Estacion destino; 
	private Metro metro;
	public Semaphore hayDatos;	
	
	
	public IniciarMetroBucharest() {
		super();
		this.hayDatos = new Semaphore(0);
	}

	public Estacion getOrigen() {
		return origen;
	}



	public void setOrigen(Estacion origen) {
		this.origen = origen;
	}



	public Estacion getDestino() {
		return destino;
	}



	public void setDestino(Estacion destino) {
		this.destino = destino;
	}



	public Metro getMetro() {
		return metro;
	}
	
	/*private void setMetro(Metro metro) {
		this.metro = metro;
	}*/

	public Estacion buscarEstacion(String estacion){
		Estacion aux = null; //Estacion auxiliar
		String nombreEstacion = estacion.substring(5);	//Nombre de la estación buscada
		int numeroLinea = Character.getNumericValue(estacion.charAt(1));	
		//Número de la línea de la estación buscada
		Linea lineaBuscada = this.metro.getLineas().get(numeroLinea-1);	//Línea de la estación buscada
		Iterator<Estacion> iteradorEstaciones = lineaBuscada.getEstaciones().iterator();
		//Mientras queden estaciones por mirar, se coge la siguiente y se comprueba si el nombre
		//coincide con el nombre de la estación buscada, en caso afirmativo se devuelve
		while(iteradorEstaciones.hasNext()){
			aux = iteradorEstaciones.next();
			if(aux.getNombre().equals(nombreEstacion))
				return aux;
		}
		//System.out.println(nombreEstacion.charAt(1)); = 1
		//en caso contrario se devuelve null
		return null;
	}
	
	public ArrayIndexList<String> recorridoToString(ArrayIndexList<NodoMapa> recorrido){
		ArrayIndexList<String> listaRecorrido = new ArrayIndexList<String>();
		Estacion actual = null;
		ArrayIndexList<Linea> lineas = this.metro.getLineas();
		for(int i = 0; i < recorrido.size(); i++){
			actual = recorrido.get(i).getEstacion();
			for(int j = 0; j < lineas.size(); j++){
				if(lineas.get(j).pertenece(actual)){
					listaRecorrido.add(i, "M"+lineas.get(j).getNumero()+" - "+actual.getNombre());
				}
			}
		}
		return listaRecorrido;
	}
	
	private void iniciarBucarest(){
		
		/* Creación de las estaciones de cada línea */
		/* Línea 1*/
		Estacion Republica = new Estacion("Republica", 44.434331, 26.185695, 0, 1.4);
		Estacion CostinGeorgian = new Estacion("Costin Georgian", 44.435435,26.169323, 1.4, 1.5);
		Estacion Titan = new Estacion("Titan", 44.425505,26.162542,1.5, 1.6);
		Estacion NicolaeGrigorescu = new Estacion("Nicolae Grigorescu", 44.413704,26.159903,1.6, 1.7);
		Estacion Dristor2 = new Estacion("Dristor2", 44.418977,26.141857,1.7, 1.7);
		Estacion MihaiBravu = new Estacion("Mihai Bravu", 44.411375,26.126043, 1.7, 1.5);
		Estacion TimpuriNoi = new Estacion("Timpuri Noi", 44.416862,26.113597 ,1.5, 1.6);
		Estacion PiataUnirii = new Estacion("Piata Unirii", 44.42618,26.103512, 1.6, 1.5);
		Estacion Izvor = new Estacion("Izvor", 44.43283,26.089479, 1.5, 1.2);
		Estacion Eroilor = new Estacion("Eroilor", 44.435052,26.075939, 1.2, 1.4);
		Estacion Grozavesti = new Estacion("Grozavesti", 44.445485,26.045834, 1.4, 1.4);
		Estacion Semanatoarea = new Estacion("Semanatoarea", 44.445531,26.046199, 1.4, 1.4);
		Estacion Crangasi = new Estacion("Crangasi", 44.452393,26.046607,1.4, 2.2);
		Estacion Basarab = new Estacion("Basarab", 44.45103,26.067506, 2.2, 0.7);
		Estacion GaradeNord = new Estacion("Gara de Nord", 44.447476,26.075424, 0.7, 1.2);
		Estacion PiataVictoriei = new Estacion("Piata Victoriei", 44.452378,26.086944, 1.2, 1.4);
		Estacion StefancelMare = new Estacion("Stefan cel Mare", 44.452899,26.1048, 1.4, 1.8);
		Estacion Obor = new Estacion("Obor", 44.449023,26.124906, 1.8, 1);
		Estacion Iancului  = new Estacion("Iancului", 44.441471,26.132287, 1, 1.2);
		Estacion PiataMuncii = new Estacion("Piata Muncii", 44.43188,26.138531, 1.2, 1.3);
		Estacion Dristor1 = new Estacion("Dristor1", 44.421444,26.139518, 1.3, 0);
		
		Republica.setSiguiente(CostinGeorgian);
		CostinGeorgian.setAnterior(Republica);		CostinGeorgian.setSiguiente(Titan);
		Titan.setAnterior(CostinGeorgian);			Titan.setSiguiente(NicolaeGrigorescu);
		NicolaeGrigorescu.setAnterior(Titan);		NicolaeGrigorescu.setSiguiente(Dristor2);
		Dristor2.setAnterior(NicolaeGrigorescu);	Dristor2.setSiguiente(MihaiBravu);
		MihaiBravu.setAnterior(Dristor2);			MihaiBravu.setSiguiente(TimpuriNoi);
		TimpuriNoi.setAnterior(MihaiBravu);			TimpuriNoi.setSiguiente(PiataUnirii);
		PiataUnirii.setAnterior(TimpuriNoi);		PiataUnirii.setSiguiente(Izvor);
		Izvor.setAnterior(PiataUnirii);				Izvor.setSiguiente(Eroilor);
		Eroilor.setAnterior(Izvor);					Eroilor.setSiguiente(Grozavesti);
		Grozavesti.setAnterior(Eroilor);			Grozavesti.setSiguiente(Semanatoarea);
		Semanatoarea.setAnterior(Grozavesti);		Semanatoarea.setSiguiente(Crangasi);
		Crangasi.setAnterior(Semanatoarea);			Crangasi.setSiguiente(Basarab);
		Basarab.setAnterior(Crangasi);				Basarab.setSiguiente(GaradeNord);
		GaradeNord.setAnterior(Basarab);			GaradeNord.setSiguiente(PiataVictoriei);
		PiataVictoriei.setAnterior(GaradeNord);		PiataVictoriei.setSiguiente(StefancelMare);
		StefancelMare.setAnterior(PiataVictoriei);	StefancelMare.setSiguiente(Obor);
		Obor.setAnterior(StefancelMare);			Obor.setSiguiente(Iancului);
		Iancului.setAnterior(Obor);					Iancului.setSiguiente(PiataMuncii);
		PiataMuncii.setAnterior(Iancului);			PiataMuncii.setSiguiente(Dristor1);
		Dristor1.setAnterior(PiataMuncii);
		
		/* Introducir las estaciones en una lista */
		NodePositionList<Estacion> estacionesL1 = new NodePositionList<Estacion>();
		estacionesL1.addLast(Republica);
		estacionesL1.addLast(CostinGeorgian);
		estacionesL1.addLast(Titan);
		estacionesL1.addLast(NicolaeGrigorescu);
		estacionesL1.addLast(Dristor2);
		estacionesL1.addLast(MihaiBravu);
		estacionesL1.addLast(TimpuriNoi);
		estacionesL1.addLast(PiataUnirii);
		estacionesL1.addLast(Izvor);
		estacionesL1.addLast(Eroilor);
		estacionesL1.addLast(Grozavesti);
		estacionesL1.addLast(Semanatoarea);
		estacionesL1.addLast(Crangasi);
		estacionesL1.addLast(Basarab);
		estacionesL1.addLast(GaradeNord);
		estacionesL1.addLast(PiataVictoriei);
		estacionesL1.addLast(StefancelMare);
		estacionesL1.addLast(Obor);
		estacionesL1.addLast(Iancului);
		estacionesL1.addLast(PiataMuncii);
		estacionesL1.addLast(Dristor1);
		
		
		/* Línea 2*/
		Estacion Pipera = new Estacion("Pipera", 44.480861,26.117714, 0, 1.3);
		Estacion AurelVlaicu = new Estacion("Aurel Vlaicu", 44.479269,26.100204, 1.3, 1.9);
		Estacion Aviatorilor = new Estacion("Aviatorilor", 44.467264,26.086429, 1.9, 1.9);
		Estacion PiataVictoriei2 = new Estacion("Piata Victoriei", 44.452378,26.086944, 1.9, 1.2);
		Estacion PiataRomana = new Estacion("Piata Romana", 44.445454,26.097715, 1.2, 1.1);
		Estacion Universitatii = new Estacion("Universitatii", 44.436078,26.10235, 1.1, 2.1);
		Estacion PiataUnirii2 = new Estacion("Piata Unirii", 44.42618,26.103512, 2.1, 1.5);
		Estacion Tineretului = new Estacion("Tineretului", 44.414747,26.104582, 1.5, 1.4);
		Estacion EroiiRevolutiei = new Estacion("Eroii Revolutiei", 44.404538,26.096385, 1.4, 1.2);
		Estacion ConstantinBrancoveanu = new Estacion("Constantin Brancoveanu", 44.398866,26.108702, 1.2, 1.2);
		Estacion PiataSudului = new Estacion("Piata Sudului", 44.392917,26.122091, 1.2, 1.8);
		Estacion AparatoriiPatriei = new Estacion("Aparatorii Patriei", 44.379668,26.135395, 1.8, 1.4);
		Estacion IMGB = new Estacion("IMGB", 44.368901,26.143592, 1.4, 1);
		Estacion DepuIMGB = new Estacion("Depou IMGB", 44.361169,26.149085, 1, 0);
		
		Pipera.setSiguiente(AurelVlaicu);
		AurelVlaicu.setAnterior(Pipera);					AurelVlaicu.setSiguiente(Aviatorilor);
		Aviatorilor.setAnterior(AurelVlaicu);				Aviatorilor.setSiguiente(PiataVictoriei2);
		PiataVictoriei2.setAnterior(Aviatorilor);			PiataVictoriei2.setSiguiente(PiataRomana);
		PiataRomana.setAnterior(PiataVictoriei2);			PiataRomana.setSiguiente(Universitatii);
		Universitatii.setAnterior(PiataRomana);				Universitatii.setSiguiente(PiataUnirii2);
		PiataUnirii2.setAnterior(Universitatii);			PiataUnirii2.setSiguiente(Tineretului);
		Tineretului.setAnterior(PiataUnirii2);				Tineretului.setSiguiente(EroiiRevolutiei);
		EroiiRevolutiei.setAnterior(Tineretului);			EroiiRevolutiei.setSiguiente(ConstantinBrancoveanu);
		ConstantinBrancoveanu.setAnterior(EroiiRevolutiei);	ConstantinBrancoveanu.setSiguiente(PiataSudului);
		PiataSudului.setAnterior(ConstantinBrancoveanu);	PiataSudului.setSiguiente(AparatoriiPatriei);
		AparatoriiPatriei.setAnterior(PiataSudului);		AparatoriiPatriei.setSiguiente(IMGB);
		IMGB.setAnterior(AparatoriiPatriei);				IMGB.setSiguiente(DepuIMGB);
		DepuIMGB.setAnterior(IMGB);
		
		/* Introducir las estaciones en una lista */
		NodePositionList<Estacion> estacionesL2 = new NodePositionList<Estacion>();
		estacionesL2.addLast(Pipera);
		estacionesL2.addLast(AurelVlaicu);
		estacionesL2.addLast(Aviatorilor);
		estacionesL2.addLast(PiataVictoriei2);
		estacionesL2.addLast(PiataRomana);
		estacionesL2.addLast(Universitatii);
		estacionesL2.addLast(PiataUnirii2);
		estacionesL2.addLast(Tineretului);
		estacionesL2.addLast(EroiiRevolutiei);
		estacionesL2.addLast(ConstantinBrancoveanu);
		estacionesL2.addLast(PiataSudului);
		estacionesL2.addLast(AparatoriiPatriei);
		estacionesL2.addLast(IMGB);
		estacionesL2.addLast(DepuIMGB);
		
		
		/* Línea 3*/
		Estacion Industriilor = new Estacion("Industriilor", 44.430562,25.98906, 0, 1.2);
		Estacion Pacii = new Estacion("Pacii", 44.433964,26.004167, 1.2, 1.3);
		Estacion Gorjului = new Estacion("Gorjului", 44.434178,26.020904, 1.3, 1);
		Estacion ArmataPoporulu = new Estacion("Armata Poporului", 44.434669,26.033306, 1, 2);
		Estacion Politehnia = new Estacion("Politehnia", 44.435588,26.05545, 2, 2.3);
		Estacion Eroilor2 = new Estacion("Eroilor", 44.435052,26.075939, 2.3, 0);
		
		Industriilor.setSiguiente(Pacii);
		Pacii.setAnterior(Industriilor);		Pacii.setSiguiente(Gorjului);
		Gorjului.setAnterior(Pacii);			Gorjului.setSiguiente(ArmataPoporulu);
		ArmataPoporulu.setAnterior(Gorjului);	ArmataPoporulu.setSiguiente(Politehnia);
		Politehnia.setAnterior(ArmataPoporulu);	Politehnia.setSiguiente(Eroilor2);
		Eroilor2.setAnterior(Politehnia);
		
		/* Introducir las estaciones en una lista */
		NodePositionList<Estacion> estacionesL3 = new NodePositionList<Estacion>();
		estacionesL3.addLast(Industriilor);
		estacionesL3.addLast(Pacii);
		estacionesL3.addLast(Gorjului);
		estacionesL3.addLast(ArmataPoporulu);
		estacionesL3.addLast(Politehnia);
		estacionesL3.addLast(Eroilor2);
		
		
		/* Línea 4*/
		Estacion Mai = new Estacion("1 Mai", 44.470419,26.050644, 0, 1.1);
		Estacion Gravita  = new Estacion("Gravita", 44.461598,26.057382, 1.1, 1.3);
		Estacion Basarab2 = new Estacion("Basarab", 44.451459,26.067939, 1.3, 0.7);
		Estacion GaradeNord2 = new Estacion("Gara de Nord", 44.446588,26.074591, 0.7, 0);
		
		Mai.setSiguiente(Gravita);
		Gravita.setAnterior(Mai);		Gravita.setSiguiente(Basarab2);
		Basarab2.setAnterior(Gravita);	Basarab2.setSiguiente(GaradeNord2);
		GaradeNord2.setAnterior(Basarab2);
		
		/* Introducir las estaciones en una lista */
		NodePositionList<Estacion> estacionesL4 = new NodePositionList<Estacion>();
		estacionesL4.addLast(Mai);
		estacionesL4.addLast(Gravita);
		estacionesL4.addLast(Basarab2);
		estacionesL4.addLast(GaradeNord2);
		/*+++*/
		
		
		/* Creación de las líneas */
		Linea l1 = new Linea("Republica - Dristor", 1);
		Linea l2 = new Linea("Pipera - Depou IMGB", 2);
		Linea l3 = new Linea("Industriilor - Eroilor", 3);
		Linea l4 = new Linea("1 Mai - Gara de Nord", 4);
		
		/* Añadir las estaciones a las líneas e introducir los transbordos */
		/* Línea 1 */
		ArrayIndexList<Linea> transbordoL1L2 = new ArrayIndexList<Linea>();
		//crea una lista para hacer el transbordo entre las líneas 1 y 2
		transbordoL1L2.add(0, l1);	//se añade la línea 1 a la lista en la posición 0
		transbordoL1L2.add(1, l2);	//se añade la línea 1 a la lista en la posición 1
		Transbordo transbordoPiataUnirii = new Transbordo(transbordoL1L2, 0.2);
		//se crea el objeto transbordo usando la lista anterior, con lo que queda
		//un transbordo entre las líneas 1 y 2 con una longitud de 0 metros
		PiataUnirii.setTransbordos(transbordoPiataUnirii);
		//se le indica a la estación PiataUnirii que tiene un trasnbordo entre las líneas 1 y 2
		//utilizando el transbordo que se creó previamente
		
		ArrayIndexList<Linea> transbordoL1L3 = new ArrayIndexList<Linea>();
		transbordoL1L3.add(0, l1);
		transbordoL1L3.add(1, l3);
		Transbordo transbordoEroilor = new Transbordo(transbordoL1L3, 0.0167);
		Eroilor.setTransbordos(transbordoEroilor);
		
		ArrayIndexList<Linea> transbordoL1L4 = new ArrayIndexList<Linea>();
		transbordoL1L4.add(0, l1);
		transbordoL1L4.add(1, l4);
		Transbordo transbordoBasarab = new Transbordo(transbordoL1L4, 0.0167);
		Basarab.setTransbordos(transbordoBasarab);
		
		Transbordo transbordoGaradeNord = new Transbordo(transbordoL1L4, 0.01);
		GaradeNord.setTransbordos(transbordoGaradeNord);
		
		Transbordo transbordoPiataVictoriei = new Transbordo(transbordoL1L2, 0.04);
		PiataVictoriei.setTransbordos(transbordoPiataVictoriei);
		
		l1.setEstaciones(estacionesL1);
		
		
		/* Línea 2 */
		PiataVictoriei2.setTransbordos(transbordoPiataVictoriei);
		PiataUnirii2.setTransbordos(transbordoPiataUnirii);
		l2.setEstaciones(estacionesL2);
		
		/* Línea 3 */
		Eroilor2.setTransbordos(transbordoEroilor);
		l3.setEstaciones(estacionesL3);
		
		/* Línea 4 */
		Basarab2.setTransbordos(transbordoBasarab);
		GaradeNord2.setTransbordos(transbordoGaradeNord);
		l4.setEstaciones(estacionesL4);
		/*+++*/
		
		
		
		/* Añadir las líneas a una lista */
		ArrayIndexList<Linea> lineas = new ArrayIndexList<Linea>();
		lineas.add(0, l1);
		lineas.add(1, l2);
		lineas.add(2, l3);
		lineas.add(3, l4);
		
		/* Creación de la red de metro */
		this.metro = new Metro("Metro Bucharest", lineas);	
	}

	public static void main (String[] Args){
		
		IniciarMetroBucharest MetroPrincipal = new IniciarMetroBucharest();
		MetroPrincipal.iniciarBucarest();
		Principal pantallaPrincipal = new Principal();
		pantallaPrincipal.setLlamante(MetroPrincipal);
		pantallaPrincipal.setVisible(true);
		try {
			MetroPrincipal.hayDatos.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println(MetroPrincipal.getOrigen().getNombre());
		//System.out.println(MetroPrincipal.getDestino().getNombre());
		//pantallaPrincipal.main(null);
		AEstrella_bis algoritmo = new AEstrella_bis();
		
		ArrayIndexList<NodoMapa> recorrido = algoritmo.AEstrella(
					MetroPrincipal.getOrigen(), MetroPrincipal.getDestino(), MetroPrincipal.getMetro());
		
		Mostrar_Trayecto pantallaResultado = new Mostrar_Trayecto(MetroPrincipal.recorridoToString(recorrido));
		pantallaResultado.setVisible(true);
	}
	
}
