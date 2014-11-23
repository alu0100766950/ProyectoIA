package prueba;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

//Aqui elimine unos cuantos import que te sobraban porque ya tenias esos dos.


@SuppressWarnings("unused")
public class Interfaz extends JFrame{
    private static final long serialVersionUID = 1L;
    private int WIDTH;
    private int HEIGHT;
    private int size_tablero_F;
    private int size_tablero_C;
    private Casilla [][] tablero;
    
    public Interfaz(int size_f, int size_c) {
    	size_tablero_F = size_f;
    	size_tablero_C = size_c;
    	WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    	HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
        String title = "Tablero2";
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(size_tablero_F,size_tablero_C));
        int x = WIDTH/size_tablero_F;
        int y = HEIGHT/size_tablero_C;

        //Inicialización inicial del tablero lleno de hierba
        tablero = new Casilla [size_tablero_F][size_tablero_C];
		for(int i = 0; i < size_tablero_F; i++) { 
            for(int j = 0; j < size_tablero_C; j++) {
                tablero[i][j] = new Casilla(1,x,y);
                // Las tres lineas siguientes las uso para intentar que la imagen se redimensione si mueves la ventana
                
               /*
               x = tablero[i][j].getWidth();    - intente eso (que hace falta ponerle a la clase casilla que herede de jframe) 
                                                  y tablero[i][j].get_cas().getWidth() (que no haria falta que casilla herede de nadie, como esta ahora)
                                                  en ambos caso devuelve 0 el get. Tambien lo probe con .getX() y .getHorizontalNOSEQUE
               
               y = tablero[i][j].getHeight();   - lo mismo que arriba, pero con la componentes Y, Height y Vertical.
               
               tablero[i][j].set_type(1, x, y); - esto seria para redimensionar la imagen si conseguimos algo con las linea de arriba
               */
                add(tablero[i][j].get_cas());
            }
            
		}
        
    }
    
    public void cambiarCasilla(Casilla casilla, int type){
    	casilla.set_type(type, WIDTH/size_tablero_F,HEIGHT/size_tablero_C);
    }
    
    public void obstaculosAleatorios(int porcentaje){
    	int numObstaculos = (porcentaje * size_tablero_F * size_tablero_C) / 100;
    	int[] casilla = new int[2];
    	Random rnd = new Random();
    	
    	//GENERAMOS EL INICIO
    	casilla[0] = rnd.nextInt(size_tablero_F);
		casilla[1] = rnd.nextInt(size_tablero_C);
		cambiarCasilla(tablero[casilla[0]][casilla[1]],3);
		
		
		//GENERAMOS EL FINAL
    	casilla[0] = rnd.nextInt(size_tablero_F);
		casilla[1] = rnd.nextInt(size_tablero_C);
		while(tablero[casilla[0]][casilla[1]].get_type() == 3){
			casilla[0] = rnd.nextInt(size_tablero_F);
			casilla[1] = rnd.nextInt(size_tablero_C);
		}
		cambiarCasilla(tablero[casilla[0]][casilla[1]],4);
		
		
    	//GENERAMOS LOS OBSTACULOS
    	for(int i=0; i<numObstaculos; i++){
    		casilla[0] = rnd.nextInt(size_tablero_F);
    		casilla[1] = rnd.nextInt(size_tablero_C);
    		while(tablero[casilla[0]][casilla[1]].get_type() == 3  || tablero[casilla[0]][casilla[1]].get_type() == 4) {
    			casilla[0] = rnd.nextInt(size_tablero_F);
    			casilla[1] = rnd.nextInt(size_tablero_C);
    		}
    		cambiarCasilla(tablero[casilla[0]][casilla[1]],2); //De momento solo hay 1 tipo de obstaculo
    	}
    }

}
//Fin Interfaz