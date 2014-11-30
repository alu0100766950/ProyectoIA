package prueba;

public class Nodo {
public Nodo nodoPadre;  //Nodo del que viene
public Nodo nodoFinal;  //Nodo destino
private int[] posicion = new int[2]; //Posicion en el tablero
public int costoTotal;  //costo total del camino hasta ahi
public int costoG; 
public boolean cerrado = false;

//Constructor de la clase Nodo
public Nodo (Nodo nodoPadre_, Nodo nodoFinal_, int[] posicionTablero, int costo){
	nodoPadre = nodoPadre_;
	nodoFinal = nodoFinal_;
	posicion[0] = posicionTablero[0];
	posicion[1] = posicionTablero[1];
	costoG = costo;
	
	//calculamos el costo total
	if(nodoFinal != null){
		costoTotal = costoG + CalcularCosto();
	}
}

//Calculamos el costo desde la posicion actual hasta la casilla final (HEURISTICA --> distancia manhattan)
public int CalcularCosto(){
	return Math.abs(this.posicion[0] - nodoFinal.getX()) + Math.abs(this.posicion[1] - nodoFinal.getY());
}

//ges de la posicion en X
public int getX(){
	return this.posicion[0];
}

//get de la posicion en Y
public int getY(){
	return this.posicion[1];
}

public int[] getPosicion(){
	return this.posicion;
}

//Comprueba si un nodo es igual a este
public boolean mismoNodo(Nodo nodo){
	return (this.posicion[0] == nodo.getX() && this.posicion[1] == nodo.getY());
}

}
