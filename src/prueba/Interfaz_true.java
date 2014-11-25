package prueba;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interfaz_true extends JFrame{
	private static final long serialVersionUID = 1L;
	private int WIDTH;
    private int HEIGHT;
	private Interfaz inter;
	private PanelIzq s_panel;

	public Interfaz_true() {
		
		final JFrame frame = new JFrame("Juego IA");
		frame.setSize(300, 150);
		frame.setVisible(true);
		validate();

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));

		final int [] aux = new int [2];
		 
		JLabel lineLabel = new JLabel("Dimensiones",JLabel.CENTER);
		panel.add(lineLabel);

		final JTextField lineText = new JTextField(20);
		panel.add(lineText);
		
		JButton closeButton = new JButton("Cancelar");
		panel.add(closeButton);
		
		JButton acceptButton = new JButton("Aceptar");
		panel.add(acceptButton);
		frame.add(panel);
		
		aux[0] = 10;
		aux[1] = 10;
		
		acceptButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				aux[0] = Integer.parseInt(lineText.getText());
				aux[1] = Integer.parseInt(lineText.getText());
				inicio(aux);
				frame.setVisible(false);
			}
		});
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		validate();
	}
		
	void inicio (int[] a) {
		validate();
 		inter = new Interfaz(a[0],a[1]);
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