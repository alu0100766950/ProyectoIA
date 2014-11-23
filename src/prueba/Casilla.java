package prueba;

import java.awt.*;
import javax.swing.*;

public class Casilla {
	JLabel cas_t;
	int type_t;	//1 = hierba, 2 = mina, 3 = inicio, 4 = final
	
	public Casilla(int type, int size_x, int size_y){
		cas_t = new JLabel();
		cas_t.setBorder (BorderFactory.createLineBorder(Color.black));
		actualizar(type, size_x, size_y);

	}
	
	private void actualizar(int type, int size_x, int size_y){
		type_t = type;
		ImageIcon img;
		switch(type){
		case 1: 
			img = new ImageIcon("images/Grass.png");
			cas_t.setIcon(new ImageIcon(img.getImage().getScaledInstance(size_x,size_y,Image.SCALE_SMOOTH)));
			break;
		case 2:
			img = new ImageIcon("images/Mina.png");
			cas_t.setIcon(new ImageIcon(img.getImage().getScaledInstance(size_x,size_y,Image.SCALE_SMOOTH)));
			break;
		case 3:
			img = new ImageIcon("images/Inicio.png");
			cas_t.setIcon(new ImageIcon(img.getImage().getScaledInstance(size_x,size_y,Image.SCALE_SMOOTH)));
			break;
		case 4:
			img = new ImageIcon("images/Fin.png");
			cas_t.setIcon(new ImageIcon(img.getImage().getScaledInstance(size_x,size_y,Image.SCALE_SMOOTH)));
			break;
		}

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
