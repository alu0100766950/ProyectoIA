package prueba;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Casilla extends JLabel implements MouseListener {
	private static final long serialVersionUID = 1L;
	int type_t;
	/*
	 * 1 = mina
	 * 2 = soldado,
	 * 3 = agua, 
	 * 4 = piedra
	 * 5 = inicio
	 * 6 = final
	 * 7 = hierba
	 */
	private ImageIcon hierba,mina,inicio,fin,soldier,stone,water;
	private Interfaz tablero;
	private int [] casillaMarcada = new int [2];
	
	public Casilla(int type, int size_x, int size_y, Interfaz tab){
		
		tablero = tab;
		setBorder (BorderFactory.createLineBorder(Color.black));
		actualizar(type, size_x, size_y);

		addMouseListener(this);

	}
	
	private void carga_imagenes(){
		this.hierba = new ImageIcon("images/Grass.png");
		this.mina = new ImageIcon("images/Mina_2.png"); 
		this.inicio = new ImageIcon("images/Inicio_2.png");
		this.fin = new ImageIcon("images/end.png");
		this.soldier = new ImageIcon("images/Soldado.png");
		this.stone = new ImageIcon("images/Piedra.png");
		this.water = new ImageIcon("images/Agua.png");
	}
	
	void actualizar(int type, int size_x, int size_y){
		type_t = type;
		carga_imagenes();
		switch(type){
		case 1:
			setIcon(new ImageIcon(mina.getImage().getScaledInstance(size_x,size_y,Image.SCALE_DEFAULT)));
			break;
		case 2:
			setIcon(new ImageIcon(soldier.getImage().getScaledInstance(size_x,size_y,Image.SCALE_DEFAULT)));
			break;
		case 3:
			setIcon(new ImageIcon(water.getImage().getScaledInstance(size_x,size_y,Image.SCALE_DEFAULT)));
			break;
		case 4:
			setIcon(new ImageIcon(stone.getImage().getScaledInstance(size_x,size_y,Image.SCALE_DEFAULT)));
			break;
		case 5:
			setIcon(new ImageIcon(inicio.getImage().getScaledInstance(size_x,size_y,Image.SCALE_DEFAULT)));
			break;
		case 6:
			setIcon(new ImageIcon(fin.getImage().getScaledInstance(size_x,size_y,Image.SCALE_DEFAULT)));
			break;
		case 7: 
			setIcon(new ImageIcon(hierba.getImage().getScaledInstance(size_x,size_y,Image.SCALE_DEFAULT)));
			break;
		}

	}

	public void set_type(int type, int size_x, int size_y) {
		actualizar(type, size_x, size_y);
	}
	
	int get_type() {
		return type_t;
	}

	@Override
	public void mouseClicked(MouseEvent ev) {}
	
	@Override
	public void mouseEntered(MouseEvent ev) {}
	
	@Override
	public void mouseExited(MouseEvent ev) {}
	
	@Override
	public void mousePressed(MouseEvent ev) {
		if((ev.getButton() == MouseEvent.BUTTON3) || (ev.getButton() == MouseEvent.BUTTON2)) {
			this.setCasillaMarcada(tablero.getCoordenadas((Casilla)ev.getComponent())); 
			tablero.pintar(casillaMarcada[0],casillaMarcada[1],7);
			}
		else {
			this.setCasillaMarcada(tablero.getCoordenadas((Casilla)ev.getComponent())); 
			tablero.pintar(casillaMarcada[0],casillaMarcada[1],tablero.getSeleccion());
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent ev) {}
	
	private void setCasillaMarcada(int[] PcasillaMarcada) {
		casillaMarcada = PcasillaMarcada;
	}
}