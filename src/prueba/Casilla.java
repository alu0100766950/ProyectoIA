package prueba;

import java.awt.*;
import java.awt.image.BufferedImage;

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
		int scale = 1; 
		switch(type){
		case 1: 
			ImageIcon image = new ImageIcon("images/Grass.png");   
		      
		    int width = image.getIconWidth();  
		    int height = image.getIconHeight();  
		    BufferedImage buffer = new BufferedImage(scale * width, scale * height, BufferedImage.TYPE_INT_ARGB);  
		    Graphics2D graphics = buffer.createGraphics();  
		    graphics.scale(scale,scale);  
		    image.paintIcon(null, graphics, 0, 0);  
		    graphics.dispose();  
		      
		    cas_t.setIcon(new ImageIcon(buffer));  
			break;
		case 2:
			ImageIcon image1 = new ImageIcon("images/Mina.png");    
		      
		    int width1 = image1.getIconWidth();  
		    int height1 = image1.getIconHeight();  
		    BufferedImage buffer1 = new BufferedImage(scale * width1, scale * height1, BufferedImage.TYPE_INT_ARGB);  
		    Graphics2D graphics1 = buffer1.createGraphics();  
		    graphics1.scale(scale,scale);  
		    image1.paintIcon(null, graphics1, 0, 0);  
		    graphics1.dispose();  
		      
		    cas_t.setIcon(new ImageIcon(buffer1));  
			break;
		case 3:
			ImageIcon image2 = new ImageIcon("images/Inicio.png");  
		      
		    int width2 = image2.getIconWidth();  
		    int height2 = image2.getIconHeight();  
		    BufferedImage buffer2 = new BufferedImage(scale * width2, scale * height2, BufferedImage.TYPE_INT_ARGB);  
		    Graphics2D graphics2 = buffer2.createGraphics();  
		    graphics2.scale(scale,scale);  
		    image2.paintIcon(null, graphics2, 0, 0);  
		    graphics2.dispose();  
		      
		    cas_t.setIcon(new ImageIcon(buffer2));
			break;
		case 4:
			ImageIcon image3 = new ImageIcon("images/Fin.png");  
		      
		    int width3 = image3.getIconWidth();  
		    int height3 = image3.getIconHeight();  
		    BufferedImage buffer3 = new BufferedImage(scale * width3, scale * height3, BufferedImage.TYPE_INT_ARGB);  
		    Graphics2D graphics3 = buffer3.createGraphics();  
		    graphics3.scale(scale,scale);  
		    image3.paintIcon(null, graphics3, 0, 0);  
		    graphics3.dispose();  
		      
		    cas_t.setIcon(new ImageIcon(buffer3));
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
