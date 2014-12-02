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
	 * 9 = disparo del soldado
	 */
	private ImageIcon mina,inicio,fin,soldier,stone,water,camino,caminoPiedra,caminoAgua,disparo;
	private Interfaz tablero;
	private int [] casillaMarcada = new int [2];
	
	public Casilla(int type, Interfaz tab){
		tablero = tab;
		actualizar(type);

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
		this.caminoPiedra = new ImageIcon("images/camino_piedra.png");
		this.caminoAgua = new ImageIcon("images/camino_agua.png");
		this.disparo = new ImageIcon("images/gunfire_rotated.png");
	}
	
	void actualizar(int type){
		carga_imagenes();
		switch(type){
		case 1:
			setIcon(new ImageIcon(mina.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT)));
			setBorder (BorderFactory.createLineBorder(Color.black));
			break;
		case 2:
			setIcon(new ImageIcon(soldier.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT)));
			setBorder (BorderFactory.createLineBorder(Color.black));
			break;
		case 3:
			setIcon(new ImageIcon(water.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT)));
			setBorder (BorderFactory.createLineBorder(Color.black));
			break;
		case 4:
			setIcon(new ImageIcon(stone.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT)));
			setBorder (BorderFactory.createLineBorder(Color.black));
			break;
		case 5:
			setIcon(new ImageIcon(inicio.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT)));
			setBorder (BorderFactory.createLineBorder(Color.red));
			break;
		case 6:
			setIcon(new ImageIcon(fin.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT)));
			setBorder (BorderFactory.createLineBorder(Color.red));
			break;
		case 7: 
			setIcon(null);
			setBorder (BorderFactory.createLineBorder(Color.black));
			break;
		case 8: 
			if(type_t == 4)
				setIcon(new ImageIcon(caminoPiedra.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT)));
			else if(type_t == 3)
				setIcon(new ImageIcon(caminoAgua.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT)));
			else
				setIcon(new ImageIcon(camino.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT)));
			break;
		case 9: 
			setIcon(new ImageIcon(disparo.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT)));
			setBorder (BorderFactory.createLineBorder(Color.black));
			break;	
		}
		type_t = type;
	}

	public void set_type(int type, int size_x, int size_y) {
		actualizar(type);
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
	public void mouseEntered(MouseEvent ev) {
		setBorder(BorderFactory.createLineBorder(new Color(91,236,252)));
	}
	
	@Override
	public void mouseExited(MouseEvent ev) {
		if(type_t != 5 && type_t != 6)
			setBorder(BorderFactory.createLineBorder(Color.black));
		else
			setBorder(BorderFactory.createLineBorder(Color.red));
	}
	
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