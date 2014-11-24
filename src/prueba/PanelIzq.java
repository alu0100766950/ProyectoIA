package prueba;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelIzq extends JPanel{

	@SuppressWarnings("unused")
	private ImageIcon p_reset, p_start, p_mine, p_soldier, p_puddle, p_stone;
	private JButton b_random, b_reset, b_start, b_landmine, b_soldier, b_puddle, b_stone;
	Interfaz inter;
	PanelIzq(Interfaz t_inter) {
	inter = t_inter;
	setLayout(new GridLayout(7,1));
	//int height = window.getHeight();
	//int width = window.getWidth();
	ImageIcon p_reset = new ImageIcon ("images/reset.png");
	ImageIcon p_start = new ImageIcon ("images/start.png");
	ImageIcon p_mine = new ImageIcon ("images/landmine.png");
	ImageIcon p_soldier = new ImageIcon ("images/soldier.png");
	ImageIcon p_puddle = new ImageIcon ("images/puddle.png");
	ImageIcon p_stone = new ImageIcon ("images/stone.png");
	
	//INSTANCIANDO BOTONES CON TEXTO
	b_random = new JButton("Random");
	b_reset = new JButton(p_reset);
	b_start = new JButton(p_start);
	b_soldier = new JButton(p_soldier);
	b_puddle = new JButton(p_puddle);
	b_stone = new JButton(p_stone);
	b_landmine = new JButton(p_mine);
	
	//AÑADIENDO LISTENERS DEL BOTON
	b_random.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			inter.reset();
			inter.obstaculosAleatorios(10);
		}
	});
	b_reset.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			inter.reset();
		}
	});
	b_start.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			inter.set_seleccion(3);
			
		}
	});
	b_soldier.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			inter.set_seleccion(5);
		}
	});
	b_puddle.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			inter.set_seleccion(6);
		}
	});
	b_stone.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			inter.set_seleccion(7);
		}
	});
	b_landmine.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			inter.set_seleccion(2);
		}
	});

	
	//POSICIONANDO LOS OBJETOS
	/*b_random.setBounds(10, 340, 150, 50);
	b_reset.setBounds(10, 420, 150, 50);
	b_start.setBounds(10, 500, 150, 50);
	b_landmine.setBounds(10,20, 150, 50);
	b_soldier.setBounds(10,100, 150, 50);
	b_puddle.setBounds(10,180, 150, 50);
	b_stone.setBounds(10,260, 150, 50);*/
	
	//addon buttons to the window
	add(b_random);
	add(b_reset);
	add(b_start);
	add(b_landmine);
	add(b_soldier);
	add(b_puddle);
	add(b_stone);
	}
}
