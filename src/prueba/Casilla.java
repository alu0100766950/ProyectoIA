package prueba;

import javax.swing.*;


public class Casilla {
	
	
	JLabel cas_t;
	int type_t;	//1 = hierba, 2 = mina, 3 = inicio, 4 = final
	Interfaz pantalla; 
	
	Casilla(int type) {
		type_t = type;
		//Inicialización inicial del tablero lleno de hierba
		cas_t = new JLabel(new ImageIcon("/home/carlos/workspace/pruebaimages/Grass.png"));
		Casilla [][] tablero = new Casilla [pantalla.size_tablero_F][pantalla.size_tablero_C];
		for(int i = 0; i < pantalla.size_tablero_F; i++) { 
            for(int j = 0; j < pantalla.size_tablero_C; j++) {
                tablero[i][j] = new Casilla(1);
                pantalla.add(tablero[i][j].get_cas());
            }
		}
	}
	void set_type(int type) {
		type_t = type;
	}
	void set_icon(ImageIcon img) {
		cas_t.setIcon(img);
	}
	int get_type() {
		return type_t;
	}
	JLabel get_cas() {
		return cas_t;
	}
}
