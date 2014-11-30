package prueba;

import javax.swing.*;

import java.awt.*;
import java.util.Random;

public class Interfaz extends JPanel{
    private static final long serialVersionUID = 1L;
    private int WIDTH;
    private int HEIGHT;
    public int size_tablero_F;
    public int size_tablero_C;
    private Casilla [][] tablero;
    private int seleccion;
    Image imagen;
    
    public Interfaz(int size_f, int size_c) {
    	setOpaque(true);
    	ImageIcon aux = new ImageIcon("images/grass_ext1.png");
    	imagen = aux.getImage();
    	seleccion = 7;
    	size_tablero_F = size_f;
    	size_tablero_C = size_c;
    	WIDTH = (Toolkit.getDefaultToolkit().getScreenSize().width);
    	HEIGHT = (Toolkit.getDefaultToolkit().getScreenSize().height);
    	setSize(WIDTH,HEIGHT);
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
    
    @Override
    public void paint(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
        } else {
            setOpaque(true);
        }
        super.paint(g);
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
    
    public Casilla getCasilla(int[] coordenadas){
    	return tablero[coordenadas[0]][coordenadas[1]];
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
    	cambiarCasilla(tablero[x][y],type);
    }
}