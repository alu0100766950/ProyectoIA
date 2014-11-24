package prueba;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;  

@SuppressWarnings("serial")
public class PanelIzq extends JPanel{

	@SuppressWarnings("unused")
	private ImageIcon p_reset, p_start, p_mine, p_soldier, p_puddle, p_stone, p_end, p_init;
	private JButton b_random, b_reset, b_start, b_landmine, b_soldier, b_puddle, b_stone, b_end, b_init;
	Interfaz inter;
	Interfaz_true inter_t;
	PanelIzq(Interfaz t_inter) {
	inter = t_inter;
	setLayout(new GridLayout(9,1));
	//int height = window.getHeight();
	//int width = window.getWidth();
	ImageIcon p_reset = new ImageIcon ("images/reset.png");
	ImageIcon p_start = new ImageIcon ("images/start.png");
	ImageIcon p_mine = new ImageIcon ("images/landmine.png");
	ImageIcon p_soldier = new ImageIcon ("images/soldier.png");
	ImageIcon p_puddle = new ImageIcon ("images/puddle.png");
	ImageIcon p_stone = new ImageIcon ("images/stone.png");
	ImageIcon p_end = new ImageIcon ("images/boton_finish.png");
	ImageIcon p_init = new ImageIcon ("images/play.png");
	
	//INSTANCIANDO BOTONES CON TEXTO
	b_random = new JButton("Random");
	b_reset = new JButton(p_reset);
	b_start = new JButton(p_start);
	b_soldier = new JButton(p_soldier);
	b_puddle = new JButton(p_puddle);
	b_stone = new JButton(p_stone);
	b_landmine = new JButton(p_mine);
	b_end = new JButton(p_end);
	b_init = new JButton(p_init);
	
	//AÑADIENDO LISTENERS DEL BOTON
	b_random.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			BarraHorizontal app = new BarraHorizontal(inter);
			inter.reset();
			inter.obstaculosAleatorios(inter.get_porcentaje());
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
			inter.set_seleccion(5);
			
		}
	});
	b_soldier.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			inter.set_seleccion(2);
		}
	});
	b_puddle.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			inter.set_seleccion(3);
		}
	});
	b_stone.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			inter.set_seleccion(4);
		}
	});
	b_landmine.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			inter.set_seleccion(1);
		}
	});
	b_end.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			inter.set_seleccion(6);
		}
	});
	b_init.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//Añadir aquí la función de camino mínimo
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
	add(b_end);
	add(b_landmine);
	add(b_soldier);
	add(b_puddle);
	add(b_stone);
	add(b_init);
	}
}
