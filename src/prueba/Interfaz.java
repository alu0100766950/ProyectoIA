package prueba;

import java.awt.GridLayout;
//Interfaz
import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
@SuppressWarnings("unused")
public class Interfaz extends JFrame{
    private static final long serialVersionUID = 1L;
    private static final int HEIGHT = 600;
    private static final int WIDTH = 700;
    public int size_tablero_F = 5;
	public int size_tablero_C = 5;
    public Interfaz() {
        String title = "Tablero";
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(size_tablero_F,size_tablero_C));
        /*
        ImageIcon img = new ImageIcon("images/Grass.png");
        JLabel [][] a = new JLabel [size_tablero_F][size_tablero_C];
        for(int i = 0; i < size_tablero_F; i++)
        	for(int j = 0; j < size_tablero_C; j++) {
        		a[i][j] = new JLabel(img);
        		add(a[i][j]);
        	}
        */
    }
}
//Fin Interfaz