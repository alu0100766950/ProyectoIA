package prueba;

import javax.swing.*;


public class Casilla {
	JLabel cas_t;
	int type_t;	//1 = hierba, 2 = mina, 3 = inicio, 4 = final
	
	Casilla(int type) {
		type_t = type;
		ImageIcon img = new ImageIcon("images/Grass_reduced.png");
		cas_t = new JLabel(img);
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
