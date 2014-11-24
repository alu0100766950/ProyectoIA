package prueba;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

//@SuppressWarnings({ "serial", "unused" })
public class Interfaz_true extends JFrame{
	private static final long serialVersionUID = 1L;
	private int WIDTH;
    private int HEIGHT;
	private Interfaz inter;
	private PanelIzq s_panel;

	public Interfaz_true(int f, int c) {
		inter = new Interfaz(f,c);
		s_panel = new PanelIzq(inter);
		WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    	HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
        String title = "Tablero 2.5.6 Beta";
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(s_panel, BorderLayout.LINE_START);
        add(inter, BorderLayout.CENTER);
        validate();
	}
}
