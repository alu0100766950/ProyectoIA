package prueba;

import java.awt.Image;

import javax.swing.*;


public class Casilla {
	JLabel cas_t;
	int type_t;	//1 = hierba, 2 = mina, 3 = inicio, 4 = final
	
	Casilla(int type) {
		cas_t = new JLabel();
		type_t = type;
		ImageIcon img = new ImageIcon("images/Grass_develope.png");
		cas_t.setIcon(new ImageIcon(img.getImage().getScaledInstance(125,125,Image.SCALE_SMOOTH)));
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
