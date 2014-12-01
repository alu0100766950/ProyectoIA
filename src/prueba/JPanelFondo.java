package prueba;



import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class JPanelFondo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image background;

	public void paintComponent(Graphics g) {

		/* Obtenemos el tamaño del panel para hacer que se ajuste a este
		cada vez que redimensionemos la ventana y se lo pasamos al drawImage */
		int width = (Toolkit.getDefaultToolkit().getScreenSize().width);
		int height = (Toolkit.getDefaultToolkit().getScreenSize().height);


		// Mandamos que pinte la imagen en el panel
		if (this.background != null) {
			g.drawImage(this.background, 0, 0, width, height, null);
		}

		super.paintComponent(g);
	}

	public void setFondo(String imagePath) {
		// Construimos la imagen y se la asignamos al atributo background.
		this.background = new ImageIcon(imagePath).getImage();
		repaint();
	}

}