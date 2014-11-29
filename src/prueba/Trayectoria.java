package prueba;

import java.util.LinkedList;

public class Trayectoria extends LinkedList<Casilla> {
	private static final long serialVersionUID = 1L;
	int coste;	//Coste real de la trayectoria
	//int coste_estimado	//Coste estimado de la trayectoria
	int INFINITE = 10000;
	int WATER = 10;
	int STONE = 20;
	int GRASS = 1;
	int NONE = 0;
	public Trayectoria() {
		coste = 0;
		Trayectoria aux = new Trayectoria();
		aux = this;
		while(!aux.isEmpty()) {
			switch(aux.getFirst().get_type()) {
			case 1:
				coste += INFINITE;
				break;
			case 2:
				coste += INFINITE;
				break;
			case 3:
				coste += WATER;
				break;
			case 4:
				coste += STONE;
				break;
			case 5:
				coste += NONE;
				break;
			case 6:
				coste += NONE;
				break;
			case 7:
				coste += GRASS;
				break;	
			}
			aux.removeFirst();
		}
	}
	int getCoste() {
		return coste;
	}
}
