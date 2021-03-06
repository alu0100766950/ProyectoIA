/*package prueba;

import java.util.LinkedList;

public @interface Funciones {
    //Algoritmo de busqueda
    public Casilla getInicio() {	//Devuelve la casilla de inicio
    	int [] direccion = new int [2];
    	direccion = buscaType(5); 
    	return tablero[direccion[0]][direccion[1]];
    }
    public Casilla getFin() {	//Devuelve la casilla de fin
    	int [] direccion = new int [2];
    	direccion = buscaType(6);
    	return tablero[direccion[0]][direccion[1]];
    }
  
  // Función hayOtra
    // Calcula si hay otro trayecto que termine en el mismo sitio en una lista y devuelve una lista de todas las trayectorias
    //iguales por si se da el caso de que haya más de una.
  
    public LinkedList<Trayectoria> hayOtra(LinkedList<Trayectoria> LT, Trayectoria T) {	
    	LinkedList<Trayectoria> aux = LT;
    	LinkedList<Trayectoria> aux2 = new LinkedList<Trayectoria>();
    	while (!aux.isEmpty()) {
    		if(aux.getFirst().getLast() == T.getLast())
    			aux2.add(aux.getFirst());
    		else
    			aux.removeFirst();
    	}
    	if(aux2.isEmpty())
    		return null;
    	else
    		return aux2;
    }
    Trayectoria getMayorCoste(LinkedList<Trayectoria> LT) {	//Captura la trayectoria con mayor coste dentro de una lista
    	Trayectoria aux = new Trayectoria();
    	aux = LT.getFirst();
    	LT.removeFirst();
    	while(!LT.isEmpty()) {
    		if(LT.getFirst().getCoste() > aux.getCoste())
    			aux = LT.getFirst();
    		LT.removeFirst();
    	}
    	return aux;
    }
    void removeMayor(LinkedList<Trayectoria> LT, LinkedList<Trayectoria> auxList) {	//Elimina la trayectoria con mayor coste
    	Trayectoria aux = new Trayectoria();
    	aux = getMayorCoste(auxList);
    	for(int i = 0; i < LT.size(); i++) {
    		if(LT.get(i) == aux) {
    			LT.remove(i);
    		}
    	}
    }
    //Funcion que calcula los hijos de una trayectoria de la lista cerrada y los añade a la lista abierta
    void nuevasTrayectorias(LinkedList<Trayectoria> abierta, Trayectoria cerrada) {
    	int [] aux = new int[2];
    	aux = getCoordenadas(cerrada.getLast());
    	cerrada.removeFirst();
    	Trayectoria [] aux_t = new Trayectoria[4];
    	//¡¡Tengo duda con estos if en cuanto a si poner igual o mayor igual!!
    	//Condiciones para evitar llamar a una casilla que no este dentro del tablero
    	if(aux[0]-1 >= 0)
    		aux_t[0].add(tablero[aux[0]-1][aux[1]]);
    	else if(aux[0] + 1 <= size_tablero_F)
    		aux_t[1].add(tablero[aux[0]+1][aux[1]]);
    	else if(aux[1] - 1 >= 0)
    		aux_t[2].add(tablero[aux[0]][aux[1]-1]);
    	else if(aux[1] + 1 <= size_tablero_C)
    		aux_t[3].add(tablero[aux[0]][aux[1]+1]);
    	for(int i = 0; i < 3; i++)
    		abierta.add(aux_t[i]);
    }    
    public Trayectoria caminoMinimo() {
    	//Inicialización -> Punto 1 algoritmo PDF
    	LinkedList<Trayectoria> abierta = new LinkedList<Trayectoria>();	// Lista de trayectorias abierta
    	LinkedList<Trayectoria> cerrada = new LinkedList<Trayectoria>();	//Lista de trayectorias cerrada
    	LinkedList<Trayectoria> aux_list = new LinkedList<Trayectoria>();	//Lista auxiliar para la eliminacion de trayectorias de mayor coste
    	//Inserción del nodo inicio en la lista de trayectorias abierta
    	Trayectoria aux = new Trayectoria();
    	aux.add(getInicio());
    	abierta.add(aux);
    	//Bucle de búsqueda -> Punto 2
    	while(!abierta.isEmpty()) {
    		if(abierta.getFirst().getLast() == getFin()) {	//Punto 2A 
    			return abierta.getFirst();
    		}
    		else {	//Punto 2B
    			//Comienzo Punto 2B1
    			cerrada.add(abierta.getFirst());
    			abierta.removeFirst();
    				aux_list = hayOtra(cerrada, cerrada.getLast());
    				if(hayOtra(cerrada, cerrada.getLast()) != null) {
    				removeMayor(cerrada,aux_list);
    			}
   				//Fin Punto 2B1
    			//Comienzo Punto 2B2 y 2B3
    			while(!cerrada.isEmpty()) {	//Este bucle es para extraer los hijos de todas las trayectorias de cerrada
    				nuevasTrayectorias(abierta, cerrada.getFirst());
    				cerrada.removeFirst();
    			}
    			//Fin Punto 2B2 y 2B3
    		}
    	}
    	return abierta.getFirst();	//Lo he puesto para que no me molesten los warning pero no se si va aquí
    }
    //Fin algoritmo busqueda
}*/