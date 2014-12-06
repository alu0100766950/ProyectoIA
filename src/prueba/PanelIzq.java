package prueba;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;  

@SuppressWarnings("serial")
public class PanelIzq extends JPanel{

	@SuppressWarnings("unused")
	private ImageIcon p_reset, p_start, p_mine, p_soldier, p_puddle, p_stone, p_end, p_init;
	private JButton b_random, b_reset, b_start, b_landmine, b_soldier, b_puddle, b_stone, b_end, b_init;
	Interfaz inter;
	//Interfaz_true inter_t;
	
	public PanelIzq(Interfaz t_inter) {
	inter = t_inter;
	setLayout(new GridLayout(9,1));
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
	
	//AGREGANDO LISTENERS DEL BOTON
	b_random.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unused")
			BarraHorizontal app = new BarraHorizontal(inter);
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
			int [] inicio =inter.buscaType(5);
			int [] fin = inter.buscaType(6);
			
			if(inicio[0] == -1 || fin[0] == -1){
				mensageError("Para iniciar la busqueda debe haber un START y un FINISH!");
			}
			else{
				AEstrella algoritmo = new AEstrella(inter);
				LinkedList<Dimension> camino = algoritmo.encontrarCamino(inicio, fin);
				if (camino != null){
					int indice = 0;
					int[] posicion = new int[2];
					while(camino.size() > indice){
						posicion[0] = camino.get(indice).width;
						posicion[1] = camino.get(indice).height;
						if(inter.getCasilla(posicion).get_type() != 5 && inter.getCasilla(posicion).get_type() != 6)
							inter.pintar(posicion[0], posicion[1], 8);
						indice++;
					}
					mensageShow("El costo del camino actual es de :\n\n\t" +Integer.toString(inter.getCostoCaminoActual()), "Coste Camino Mínimo");
				}
				else{
					mensageError("No hay camino de START a FINISH");
				}
			}
		}
	});

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
	validate();
	}
	
	public void mensageError(String mensage){
		JOptionPane.showOptionDialog(new JOptionPane(), mensage, "Error", 
				JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{" OK "},"Cancelar");
	}
	
	public void mensageShow(String mensage1, String mensage2){
		JOptionPane.showOptionDialog(new JOptionPane(), mensage1, mensage2, 
				JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{" OK "},"OK");
	}
}