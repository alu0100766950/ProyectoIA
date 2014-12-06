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
    private int costoCaminoActual;
    private float porcentajeObstaculos;
    Image imagen;
    
    public Interfaz(int size_f, int size_c) {
    	setOpaque(true);
    	ImageIcon aux = new ImageIcon("images/grass_final.jpg");
    	imagen = aux.getImage();
    	costoCaminoActual = 0;
    	porcentajeObstaculos = (float) 0.0;
    	seleccion = 7;
    	size_tablero_F = size_f;
    	size_tablero_C = size_c;
    	WIDTH = (Toolkit.getDefaultToolkit().getScreenSize().width);
    	HEIGHT = (Toolkit.getDefaultToolkit().getScreenSize().height);
    	setSize(WIDTH,HEIGHT);
    	setLayout(new GridLayout(size_tablero_F,size_tablero_C));

        //Inicialización inicial del tablero lleno de hierba
        tablero = new Casilla [size_tablero_F][size_tablero_C];
		for(int i = 0; i < size_tablero_F; i++) { 
            for(int j = 0; j < size_tablero_C; j++) {
                tablero[i][j] = new Casilla(7,this);
                add(tablero[i][j]);
            }
		}
		validate();
    }
    public int getCol() {
    	return size_tablero_C;
    }
    
    public int getFil() {
    	return size_tablero_F;
    }
    
    public void setPorcentajeObstaculos(float porcentaje) {
    	porcentajeObstaculos = porcentaje;
    }
    
    public float getPorcentajeObstaculos() {
    	int cont = 0;
    	for(int i = 0; i < size_tablero_F; i++)
    		for(int j = 0; j < size_tablero_C; j++)
    			if (tablero[i][j].get_type() == 8)
    				cont++;
    	
    	if(cont == 0)
    		return porcentajeObstaculos;
    	
    	return (float) (porcentajeObstaculos - (100.0 / ((float) size_tablero_F * (float) size_tablero_C)));
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
    	if(type != 7 && type != 5 && type != 6)
    		porcentajeObstaculos = (float) (porcentajeObstaculos + (100.0 / ((float) size_tablero_F * (float) size_tablero_C)));
    	
    	if( (type == 7  || type == 5 || type == 6) && casilla.get_type() != 7 && casilla.get_type() != 5 && casilla.get_type() != 6)
    		porcentajeObstaculos = (float) (porcentajeObstaculos - (100.0 / ((float) size_tablero_F * (float) size_tablero_C)));
    	
    	casilla.set_type(type, WIDTH/size_tablero_F,HEIGHT/size_tablero_C);
    }
    
    public void obstaculosAleatorios(int porcentaje){
		reset();
		//setPorcentajeObstaculos(porcentaje);
    	int numObstaculos = (porcentaje * size_tablero_F * size_tablero_C) / 100;
    	if(numObstaculos >= size_tablero_C * size_tablero_F)
    		numObstaculos = numObstaculos - 2;
    	else
    		if(numObstaculos >= size_tablero_C * size_tablero_F - 1)
    			numObstaculos = numObstaculos - 1;
    	int[] casilla = new int[2];
    	int obstaculo;
    	Random rnd = new Random();
		
    	//GENERAMOS LOS OBSTACULOS
    	for(int i=0; i<numObstaculos; i++){
    		casilla[0] = rnd.nextInt(size_tablero_F);
    		casilla[1] = rnd.nextInt(size_tablero_C);
    		while(tablero[casilla[0]][casilla[1]].get_type() != 7) {
    			casilla[0] = rnd.nextInt(size_tablero_F);
    			casilla[1] = rnd.nextInt(size_tablero_C);
    		}
    		obstaculo = rnd.nextInt(4) + 1;
    		if((obstaculo == 2) && casilla[1]+1 < size_tablero_C && tablero[casilla[0]][casilla[1]+1].get_type() == 7) {
    			cambiarCasilla(tablero[casilla[0]][casilla[1]],obstaculo);
    			if(casilla[1]+1 < size_tablero_C){
    				cambiarCasilla(tablero[casilla[0]][casilla[1]+1],9);
    				i++;
    			}
    		}
    		else
    			cambiarCasilla(tablero[casilla[0]][casilla[1]],obstaculo); 
    	}
    	
    	
    	//GENERAMOS EL INICIO
    	casilla[0] = rnd.nextInt(size_tablero_F);
		casilla[1] = rnd.nextInt(size_tablero_C);
		while(tablero[casilla[0]][casilla[1]].get_type() != 7) {
			casilla[0] = rnd.nextInt(size_tablero_F);
			casilla[1] = rnd.nextInt(size_tablero_C);
		}
		cambiarCasilla(tablero[casilla[0]][casilla[1]],5);
		
		
		//GENERAMOS EL FINAL
    	casilla[0] = rnd.nextInt(size_tablero_F);
		casilla[1] = rnd.nextInt(size_tablero_C);
		while(tablero[casilla[0]][casilla[1]].get_type() != 7) {
			casilla[0] = rnd.nextInt(size_tablero_F);
			casilla[1] = rnd.nextInt(size_tablero_C);
		}
		cambiarCasilla(tablero[casilla[0]][casilla[1]],6);
    	
    	
    	
    	validate();
    }
    
    void set_seleccion(int sel) {
    	seleccion = sel;
    }
    int getSeleccion() {
    	return seleccion;
    }
    
    void setCostoCaminoActual(int costo) {
    	costoCaminoActual = costo;
    }
    int getCostoCaminoActual() {
    	return costoCaminoActual;
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
    
    public Casilla getCasilla(int x, int y){
    	return tablero[x][y];
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
    		for(int j = 0; j < size_tablero_C; j++){
    			cambiarCasilla(tablero[i][j], 7);
    			tablero[i][j].setVisitada(false);
    		}
    	setPorcentajeObstaculos(0);
    }
    
    public void resetVisitada() {
    	for(int i = 0; i < size_tablero_F; i++)
    		for(int j = 0; j < size_tablero_C; j++){
    			tablero[i][j].setVisitada(false);
    		}
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
    	if(type == 2){
    		cambiarCasilla(tablero[x][y], 2);
    		if(y+1 < size_tablero_C)
    			cambiarCasilla(tablero[x][y+1], 9);
    	}
    	cambiarCasilla(tablero[x][y],type);
    }
    
    public void newTablero(int [] size){
    	removeAll();
    	setOpaque(true);
    	ImageIcon aux = new ImageIcon("images/grass_final.jpg");
    	imagen = aux.getImage();
    	costoCaminoActual = 0;
    	porcentajeObstaculos = 0;
    	seleccion = 7;
    	size_tablero_F = size[0];
    	size_tablero_C = size[1];
    	WIDTH = (Toolkit.getDefaultToolkit().getScreenSize().width);
    	HEIGHT = (Toolkit.getDefaultToolkit().getScreenSize().height);
    	setSize(WIDTH,HEIGHT);
    	setLayout(new GridLayout(size_tablero_F,size_tablero_C));

        //Inicialización inicial del tablero lleno de hierba
        tablero = new Casilla [size_tablero_F][size_tablero_C];
		for(int i = 0; i < size_tablero_F; i++) { 
            for(int j = 0; j < size_tablero_C; j++) {
                tablero[i][j] = new Casilla(7,this);
                add(tablero[i][j]);
            }
		}
		validate();
    }
    
    public String toString(){
    	String aux=Integer.toString(getFil()) + "\n";
    	aux+=Integer.toString(getCol()) + "\n";
    	
    	for(int i=0; i<getFil();i++){
    		for(int j=0;j<getCol();j++){
    			aux+=Integer.toString(tablero[i][j].get_type());
    		}
    		aux +="\n";
    	}
    	return aux;
    }
}