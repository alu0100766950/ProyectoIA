package prueba;

import java.awt.Image;
import javax.swing.*;

public class Casilla {
	JLabel cas_t;
	int type_t;	//1 = hierba, 2 = mina, 3 = inicio, 4 = final
	
	public Casilla(int type, int size_x, int size_y){
		cas_t = new JLabel();
		actualizar(type, size_x, size_y);

	}
	
	private void actualizar(int type, int size_x, int size_y){
		type_t = type;
		if(type == 1){
			ImageIcon img = new ImageIcon("images/Grass_develope.png");
			cas_t.setIcon(new ImageIcon(img.getImage().getScaledInstance(size_x,size_y,Image.SCALE_SMOOTH)));
		}
		//Una vez funcione bien el tablero, añadir las demas imagenes dependiendo del type
	}
	
	public void set_type(int type, int size_x, int size_y) {
		actualizar(type, size_x, size_y);
	}
	
	int get_type() {
		return type_t;
	}
	JLabel get_cas() {
		return cas_t;
	}
}
