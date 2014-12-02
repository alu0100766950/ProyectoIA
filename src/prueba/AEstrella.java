package prueba;

import java.awt.Dimension;
import java.util.LinkedList;

public class AEstrella {
	
private LinkedList<Nodo>listaAbierta;
//Esta segunda lista no la ponemos de Nodos para poder usar el Contains despues
private LinkedList<Dimension>listaCerrada;
public Interfaz tablero;

//Constructor
public AEstrella(Interfaz tablero_){
	listaAbierta = new LinkedList<Nodo>();
	listaCerrada = new LinkedList<Dimension>();
	tablero = tablero_;
}

private void ponerNodoAListaAbierto(Nodo nodo){
	int indice = 0;
	while ((listaAbierta.size() > indice) && (nodo.costoTotal < listaAbierta.get(indice).costoTotal)){
		indice++;
	}
		listaAbierta.add(indice,nodo);
}

public LinkedList<Dimension> encontrarCamino(int[] posCasillaInicial, int[] posCasillaFinal){
	if(tablero == null)
		return null;
	
	listaAbierta.clear();
	listaCerrada.clear();
	
	Nodo nodoInicial = new Nodo(null, null,posCasillaInicial,0);
	Nodo nodoFinal = new Nodo(null, null,posCasillaFinal,0);
	
	ponerNodoAListaAbierto(nodoInicial);
	
	while(listaAbierta.size() > 0){
		Nodo nodoActual = listaAbierta.get(listaAbierta.size() - 1);
		
		//Si el nodo es el final creamos el camino minimo
		if(nodoActual.mismoNodo(nodoFinal)){
			LinkedList<Dimension>mejorCamino = new LinkedList<Dimension>();
			tablero.setCostoCaminoActual(nodoActual.costoTotal);
			while(nodoActual != null){
				mejorCamino.add(0,nodoActual.getPosicion());
				nodoActual = nodoActual.nodoPadre;
			}
			return mejorCamino;
		} //fin del if
		
		listaAbierta.remove(nodoActual);
		
		int indice = 0;
		LinkedList<Nodo> nodosAdyacentes = encontrarNodosAdyacentes(nodoActual, nodoFinal);
		
		while(nodosAdyacentes.size() > indice){
			//si el nodo no esta en la lista cerrada
			if(!listaCerrada.contains(nodosAdyacentes.get(indice).getPosicion())){
				//si ya esta en la listaAbierta
				if(listaAbierta.contains(nodosAdyacentes.get(indice))){
					if(nodosAdyacentes.get(indice).costoG >= nodoActual.costoG){
						nodosAdyacentes.remove(indice);
						//if(nodosAdyacentes.get(indice).costoG >= nodosAdyacentes.get(indice).costoG){	
						indice++;
						continue; //pasa a la siguiente interaccion del while
					}
				}
				ponerNodoAListaAbierto(nodosAdyacentes.get(indice));
			}//fin del if de contains de listaCerrada
			indice++;
		}
		listaCerrada.add(nodoActual.getPosicion());
	}//final del while (listaAbierta.size() > 0)
	return null;
}

private LinkedList<Nodo> encontrarNodosAdyacentes(Nodo nodoActual, Nodo nodoFinal){
	LinkedList<Nodo> nodosAdyacentes = new LinkedList<Nodo>();
	int x = nodoActual.getX();
	int y = nodoActual.getY();
	int[] aux = new int[2];
	int costo;
	
	//izquierda
	if(x>0){
		aux[0] = nodoActual.getX() - 1;
		aux[1] = nodoActual.getY();
		costo = tablero.getCasilla(aux).getCosto();
		if(costo < 10000){
			if (tablero.getCasilla(aux).get_type() != 5 || tablero.getCasilla(aux).get_type() != 6)
				tablero.cambiarCasilla(tablero.getCasilla(aux), 10);
			nodosAdyacentes.add(new Nodo(nodoActual, nodoFinal, aux, costo + nodoActual.costoG));
		}
	}
	
	//derecha
	if(x < tablero.size_tablero_F - 1){
		aux[0] = nodoActual.getX() + 1;
		aux[1] = nodoActual.getY();
		costo = tablero.getCasilla(aux).getCosto();
		if(costo < 10000){
			if (tablero.getCasilla(aux).get_type() != 5 || tablero.getCasilla(aux).get_type() != 6)
				tablero.cambiarCasilla(tablero.getCasilla(aux), 10);
			nodosAdyacentes.add(new Nodo(nodoActual, nodoFinal, aux, costo + nodoActual.costoG));
		}
	}
	
		//arriba
		if(y > 0){
			aux[0] = nodoActual.getX();
			aux[1] = nodoActual.getY() - 1;;
			costo = tablero.getCasilla(aux).getCosto();
			if(costo < 10000){
				if (tablero.getCasilla(aux).get_type() != 5 || tablero.getCasilla(aux).get_type() != 6)
					tablero.cambiarCasilla(tablero.getCasilla(aux), 10);
				nodosAdyacentes.add(new Nodo(nodoActual, nodoFinal, aux, costo + nodoActual.costoG));
			}
		}
		
		//abajo
		if(y < tablero.size_tablero_C - 1){
			aux[0] = nodoActual.getX();
			aux[1] = nodoActual.getY() + 1;
			costo = tablero.getCasilla(aux).getCosto();
			if(costo < 10000){
				if (tablero.getCasilla(aux).get_type() != 5 || tablero.getCasilla(aux).get_type() != 6)
					tablero.cambiarCasilla(tablero.getCasilla(aux), 10);
				nodosAdyacentes.add(new Nodo(nodoActual, nodoFinal, aux, costo + nodoActual.costoG));
			}
		}
		aux = null;
		return nodosAdyacentes;  
	}

}
