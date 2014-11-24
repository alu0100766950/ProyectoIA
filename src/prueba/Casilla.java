package prueba;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Casilla extends JLabel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//JLabel cas_t;
	int type_t;	//1 = hierba, 2 = mina, 3 = inicio, 4 = final
	private ImageIcon hierba,mina,inicio,fin;
	private Interfaz tablero;
	private int [] casillaMarcada = new int [2];
	
	public Casilla(int type, int size_x, int size_y, Interfaz tab){
		//cas_t = new JLabel();
		tablero = tab;
		setBorder (BorderFactory.createLineBorder(Color.black));
		actualizar(type, size_x, size_y);
		
		//System.out.println("Casilla creada");
		addMouseListener(this);

	}
	
	private void carga_imagenes(){
		this.hierba = new ImageIcon("images/Grass.png");
		this.mina = new ImageIcon("images/Mina.png"); 
		this.inicio = new ImageIcon("images/Inicio.png");
		this.fin = new ImageIcon("images/Fin.png");
	}
	
	void actualizar(int type, int size_x, int size_y){
		type_t = type;
		carga_imagenes();
		switch(type){
		case 1: 
			setIcon(new ImageIcon(hierba.getImage().getScaledInstance(size_x,size_y,Image.SCALE_DEFAULT)));
			break;
		case 2:
			setIcon(new ImageIcon(mina.getImage().getScaledInstance(size_x,size_y,Image.SCALE_DEFAULT)));
			break;
		case 3:
			setIcon(new ImageIcon(inicio.getImage().getScaledInstance(size_x,size_y,Image.SCALE_DEFAULT)));
			break;
		case 4:
			setIcon(new ImageIcon(fin.getImage().getScaledInstance(size_x,size_y,Image.SCALE_DEFAULT)));
			break;
		}

	}

	public void set_type(int type, int size_x, int size_y) {
		actualizar(type, size_x, size_y);
	}
	
	int get_type() {
		return type_t;
	}
	/*JLabel get_cas() {
		return cas_t;
	}*/

	@Override
	public void mouseClicked(MouseEvent ev) {
		this.setCasillaMarcada(tablero.getCoordenadas((Casilla)ev.getComponent())); 
		tablero.pintar(casillaMarcada[0],casillaMarcada[1],tablero.getSeleccion());
		//tablero.escribe()
	}
	
	@Override
	public void mouseEntered(MouseEvent ev) {}
	
	@Override
	public void mouseExited(MouseEvent ev) {}
	
	@Override
	public void mousePressed(MouseEvent ev) {}
	
	@Override
	public void mouseReleased(MouseEvent ev) {}
	
	private void setCasillaMarcada(int[] PcasillaMarcada) {
		casillaMarcada = PcasillaMarcada;
	}
}