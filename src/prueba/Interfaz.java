package prueba;

import javax.swing.*;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Interfaz extends JPanel{
    private static final long serialVersionUID = 1L;
    private int WIDTH;
    private int HEIGHT;
    private int size_tablero_F;
    private int size_tablero_C;
    private Casilla [][] tablero;
    private int seleccion;
    
    public Interfaz(int size_f, int size_c) {
    	seleccion = 7;
    	size_tablero_F = size_f;
    	size_tablero_C = size_c;
    	WIDTH = (Toolkit.getDefaultToolkit().getScreenSize().width);
    	HEIGHT = (Toolkit.getDefaultToolkit().getScreenSize().height);
    	setLayout(new GridLayout(size_tablero_F,size_tablero_C));
        int x = WIDTH/size_tablero_F;
        int y = HEIGHT/size_tablero_C;

        //Inicialización inicial del tablero lleno de hierba
        tablero = new Casilla [size_tablero_F][size_tablero_C];
		for(int i = 0; i < size_tablero_F; i++) { 
            for(int j = 0; j < size_tablero_C; j++) {
                tablero[i][j] = new Casilla(7,x,y,this);
                add(tablero[i][j]);
            }
		}
		validate();
    }
    
    public void cambiarCasilla(Casilla casilla, int type){
    	casilla.set_type(type, WIDTH/size_tablero_F,HEIGHT/size_tablero_C);
    }
    
    public void obstaculosAleatorios(int porcentaje){
		reset();
    	int numObstaculos = (porcentaje * size_tablero_F * size_tablero_C) / 100;
    	if(numObstaculos >= size_tablero_C * size_tablero_F)
    		numObstaculos = numObstaculos - 2;
    	else
    		if(numObstaculos >= size_tablero_C * size_tablero_F - 1)
    			numObstaculos = numObstaculos - 1;
    	int[] casilla = new int[2];
    	int obstaculo;
    	Random rnd = new Random();

    	//GENERAMOS EL INICIO
    	casilla[0] = rnd.nextInt(size_tablero_F);
		casilla[1] = rnd.nextInt(size_tablero_C);
		cambiarCasilla(tablero[casilla[0]][casilla[1]],5);
		
		
		//GENERAMOS EL FINAL
    	casilla[0] = rnd.nextInt(size_tablero_F);
		casilla[1] = rnd.nextInt(size_tablero_C);
		while(tablero[casilla[0]][casilla[1]].get_type() == 5){
			casilla[0] = rnd.nextInt(size_tablero_F);
			casilla[1] = rnd.nextInt(size_tablero_C);
		}
		cambiarCasilla(tablero[casilla[0]][casilla[1]],6);
		
		
    	//GENERAMOS LOS OBSTACULOS
    	for(int i=0; i<numObstaculos; i++){
    		casilla[0] = rnd.nextInt(size_tablero_F);
    		casilla[1] = rnd.nextInt(size_tablero_C);
    		while(tablero[casilla[0]][casilla[1]].get_type() != 7) {
    			casilla[0] = rnd.nextInt(size_tablero_F);
    			casilla[1] = rnd.nextInt(size_tablero_C);
    		}
    		obstaculo = rnd.nextInt(4) + 1;
    		cambiarCasilla(tablero[casilla[0]][casilla[1]],obstaculo); 
    	}
    	validate();
    }
    
    void set_seleccion(int sel) {
    	seleccion = sel;
    }
    int getSeleccion() {
    	return seleccion;
    }
    
    public int[] getCoordenadas(Casilla casilla) {
        int [] coordenadas = new int[2];
        for (int i=0; i < this.size_tablero_F; i++) {
            for (int j=0; j < this.size_tablero_C; j++) {
                if (this.tablero[i][j] == casilla) {
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                }
            }
        }
        return coordenadas;
    }
    
    public int[] buscaType(int type) {
    	int [] aux = new int [2];
    	for(int i = 0; i < size_tablero_F; i++)
    		for(int j = 0; j < size_tablero_C; j++)
    			if(tablero[i][j].get_type() == type) {
    			aux [0] = i;
    			aux [1] = j;
    			return aux;
    			}
    	aux [0] = -1;
		aux [1] = -1;
		return aux;
    }
    
    
    public void reset() {
    	for(int i = 0; i < size_tablero_F; i++)
    		for(int j = 0; j < size_tablero_C; j++)
    			cambiarCasilla(tablero[i][j], 7);
    }
    
    public void pintar(int x, int y, int type) {
    	int [] xy = new int [2];
    	if(type == 5) {
    		xy = buscaType(5);
    		if((xy[0] != -1) && (xy[0] != -1)) {
    			cambiarCasilla(tablero[xy[0]][xy[1]],7);
    		}
    	}
    	if(type == 6) {
    		xy = buscaType(6);
    		if((xy[0] != -1) && (xy[0] != -1)) {
    			cambiarCasilla(tablero[xy[0]][xy[1]],7);
    		}
    	}
    	cambiarCasilla(tablero[x][y], type);		
    }
    public void caminoMinimo() {
    	int [] direccion = new int [2];
    	direccion = buscaType(5); 
    	LinkedList<Casilla> abierta = new LinkedList<Casilla>();
    	LinkedList<Casilla> cerrada = new LinkedList<Casilla>();
    	abierta.add(tablero[direccion[0]][direccion[1]]);
    	//f'(INICIAL) := h'(INICIAL) -> Pseudocódigo que no se que significa para este problema
    	while(!abierta.isEmpty()) {
    		//Aquí va el código
    		/*extraer MEJORNODO de ABIERTOS con f' mí­nima 
    		// cola de prioridad 
    		mover MEJORNODO de ABIERTOS a CERRADOS 
    		si MEJORNODO contiene estado_objetivo entonces 
    		SOLUCION_ENCONTRADA := TRUE 
    		si no 
    		generar SUCESORES de MEJORNODO 
    		para cada SUCESOR hacer TRATAR_SUCESOR 
    		hasta SOLUCION_ENCONTRADA o FALLO*/
    	}
    }
}