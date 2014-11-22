package prueba;

import javax.swing.*;

import java.awt.*;

//Aqui elimine unos cuantos import que te sobraban porque ya tenias esos dos.


@SuppressWarnings("unused")
public class Interfaz extends JFrame{
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private int size_tablero_F;
    private int size_tablero_C;
    private Casilla [][] tablero;
    
    public Interfaz(int size_f, int size_c) {
    	size_tablero_F = size_f;
    	size_tablero_C = size_c;
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
    

}
//Fin Interfaz