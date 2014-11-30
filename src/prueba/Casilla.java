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
	 * 8 = paso el robot
	 */
	private ImageIcon mina,inicio,fin,soldier,stone,water,camino;
	private Interfaz tablero;
	private int [] casillaMarcada = new int [2];
	
	public Casilla(int type, int size_x, int size_y, Interfaz tab){
		
		tablero = tab;
		setBorder (BorderFactory.createLineBorder(Color.black));
		actualizar(type, size_x, size_y);

		addMouseListener(this);

	}
	
	private void carga_imagenes(){
		this.mina = new ImageIcon("images/Mina.png"); 
		this.inicio = new ImageIcon("images/start_image.png");
		this.fin = new ImageIcon("images/finish.png");
		this.soldier = new ImageIcon("images/soldier_image.png");
		this.stone = new ImageIcon("images/stone_image.png");
		this.water = new ImageIcon("images/ice_frames.png");
		this.camino = new ImageIcon("images/camino.png");
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
			setIcon(null);
			break;
		case 8: 
			setIcon(new ImageIcon(camino.getImage().getScaledInstance(size_x,size_y,Image.SCALE_DEFAULT)));
			break;
		}

	}

	public void set_type(int type, int size_x, int size_y) {
		actualizar(type, size_x, size_y);
	}
	
	int get_type() {
		return type_t;
	}
	
	public int getCosto(){
		switch(type_t){
		case 1:
			return 10000; //Como infinito
		case 2:
			return 10000; //como infinito
		case 3:
			return 10;
		case 4:
			return 20;
		case 5:
			return 1; //En la casilla inicial hay hierba
		case 6:
			return 1; //En la casilla final hay hierba
		case 7: 
			return 1;
		}
		return 10000; //esto es solo para que no me de error la funcion por el return
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