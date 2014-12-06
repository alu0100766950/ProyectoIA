package prueba;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;


public class Interfaz_true extends JFrame{
	private static final long serialVersionUID = 1L;
	private int WIDTH;
    private int HEIGHT;
	private Interfaz inter;
	private PanelIzq s_panel;

	public Interfaz_true() {
		WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    	HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
		start(true);
	}
	
	private void start(boolean condicion){
		final JFrame frame = new JFrame("IAGame");
		frame.setSize(300, 150);
		frame.setVisible(true);
		validate();
		frame.setLocation((WIDTH/2)-200, (HEIGHT/2)-75);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,2));

		final int [] aux = new int [2];
		 
		JLabel lineLabel = new JLabel("NUMERO FILAS",JLabel.CENTER);
		panel.add(lineLabel);

		final JTextField lineText = new JTextField(20);
		panel.add(lineText);
		
		JLabel columnLabel = new JLabel("NUMERO COLUMNAS",JLabel.CENTER);
		panel.add(columnLabel);

		final JTextField columnText = new JTextField(20);
		panel.add(columnText);
		
		
		JButton closeButton = new JButton("Cancelar");
		panel.add(closeButton);
		
		JButton acceptButton = new JButton("Aceptar");
		panel.add(acceptButton);
		frame.add(panel);
		
		aux[0] = 10;
		aux[1] = 10;
		panel.setVisible(true);
		
		acceptButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				aux[0] = Integer.parseInt(lineText.getText());
				aux[1] = Integer.parseInt(columnText.getText());
				if(condicion)
					inicio(aux);
				else{
					setVisible(false);
					inter.newTablero(aux);
					setVisible(true);
				}
				
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
		frame.pack();
	}
		
	void inicio (int[] a) {
		validate();
 		inter = new Interfaz(a[0],a[1]);
		s_panel = new PanelIzq(inter);
        String title = "IAGame";
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(s_panel, BorderLayout.LINE_START);
        add(inter, BorderLayout.CENTER);
        
      //MenuBar
      		MenuBar barra = new MenuBar();
      		
      		//Elementos del MenuBar
      		Menu archivo = new Menu("File");
      		Menu tablero = new Menu("Board");
      		Menu algoritmo = new Menu("Algorithms");
      		Menu ayuda = new Menu("Help");
      		
      		//Elementos de archivo
      		MenuItem archivo_abrir = new MenuItem("Open");
      		MenuItem archivo_guardar = new MenuItem("Save");
      		MenuItem archivo_exit = new MenuItem("Exit");
      		archivo.add(archivo_abrir);
      		archivo.add(archivo_guardar);
      		archivo.add(archivo_exit);
      		
      		//Elementos de tablero
      		MenuItem tablero_size = new MenuItem("New size");
      		MenuItem tablero_informacion = new MenuItem("Data");
      		tablero.add(tablero_size);
      		tablero.add(tablero_informacion);
      		
      		//Elementos de algoritmo
      		MenuItem algoritmo_aEstrella = new MenuItem("A*");
      		algoritmo.add(algoritmo_aEstrella);
      		
      		//Elementos de ayuda
      		MenuItem ayuda_ayuda = new MenuItem("Help");
      		MenuItem ayuda_sobreIAGame = new MenuItem("About IAGame");
      		ayuda.add(ayuda_ayuda);
      		ayuda.add(ayuda_sobreIAGame);
      		
      		//Adicion a MenuBar
      		barra.add(archivo);
      		barra.add(tablero);
      		barra.add(algoritmo);
      		barra.add(ayuda);
      		
      		//Ponemos el MenuBar en la ventana
      		setMenuBar(barra);
      		
      		//Definimos que hara cada elemento del Menu
      		archivo_abrir.addActionListener( new ActionListener() { 
      			public void actionPerformed( ActionEvent e ) { 
      			  try
      			  {
      			   //llamamos al metodo que permite cargar el explorador
      			   JFileChooser file=new JFileChooser();
      			   file.showOpenDialog(new JFrame());
      			   //abrimos el archivo seleccionado
      			   File abre=file.getSelectedFile();
      			 
      			   //Si abrimos el fichero correctamente lo recorremos
      			   
      			   if(abre!=null)
      			   {     
      			      FileReader archivos=new FileReader(abre);
      			      BufferedReader lee=new BufferedReader(archivos);
      			         
      			    int [] size = new int [2];
       			   	size[0] = Integer.parseInt(lee.readLine());
       			   	size[1] = Integer.parseInt(lee.readLine());
       			   	
       			   	setVisible(false);
					inter.newTablero(size);
					setVisible(true);
					String cadena;
					
					for(int i=0; i<size[0]; i++){
						cadena=lee.readLine();
						for(int j=0; j<size[1]; j++){
							inter.cambiarCasilla(inter.getCasilla(i,j), Integer.parseInt(cadena.substring(j, j+1)));
						}
					}

      			         lee.close();
      			    }    
      			   }
      			   catch(IOException ex)
      			   {
      			     JOptionPane.showMessageDialog(null,ex+"" +
      			           "\nNo se ha encontrado el archivo",
      			                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
      			    }
      				} 
      			} );
      		
      		archivo_guardar.addActionListener( new ActionListener() { 
      			public void actionPerformed( ActionEvent e ) { 
      				try
      				 {
      				  JFileChooser file=new JFileChooser();
      				  file.showSaveDialog(new JFrame());
      				  File guarda =file.getSelectedFile();
      				 
      				  if(guarda !=null)
      				  {
      				   /*guardamos el archivo y le damos el formato directamente,
      				    * si queremos que se guarde en formato doc lo definimos como .doc*/
      				    FileWriter  save=new FileWriter(guarda+".txt");
      				    save.write(inter.toString());
      				    save.close();
      				    JOptionPane.showMessageDialog(null,
      				         "El archivo se a guardado Exitosamente",
      				             "Información",JOptionPane.INFORMATION_MESSAGE);
      				    }
      				 }
      				  catch(IOException ex)
      				  {
      				   JOptionPane.showMessageDialog(null,
      				        "Su archivo no se ha guardado",
      				           "Advertencia",JOptionPane.WARNING_MESSAGE);
      				  }
      				} 
      			} );
      		
      		archivo_exit.addActionListener( new ActionListener() { 
      			public void actionPerformed( ActionEvent e ) { 
      				System.exit(0); 
      				} 
      			} );
      		
      		
      		tablero_size.addActionListener( new ActionListener() { 
      			public void actionPerformed( ActionEvent e ) { 
      				start(false);
      				} 
      			} );
      		
      		tablero_informacion.addActionListener( new ActionListener() { 
      			public void actionPerformed( ActionEvent e ) { 
      				String texto = "Filas: " + Integer.toString(inter.getFil()) + "\n";
      				texto += "Columnas: " + Integer.toString(inter.getCol()) + "\n";
      				texto += "Porcentaje de obstaculos: " + Float.toString(inter.getPorcentajeObstaculos()) + "% \n";
      				int[] aux = inter.buscaType(5);
      				if (aux[0] != -1)
      					texto += "Posicion del Inicio: [" + Integer.toString(aux[0]) + ", "  + Integer.toString(aux[1]) + "] \n";
      				else
      					texto += "Posicion del Inicio: " + "[X, Y] \n";
      				
      				aux = inter.buscaType(6);
      				if (aux[0] != -1)
      					texto += "Posicion del Final: [" + Integer.toString(aux[0]) + ", "  + Integer.toString(aux[1]) + "] \n";
      				else
      					texto += "Posicion del Final: " + "[X, Y] \n";

      				s_panel.mensageShow(texto, "Data");
      				} 
      			} );
      		
      		algoritmo_aEstrella.addActionListener( new ActionListener() { 
      			public void actionPerformed( ActionEvent e ) { 
      				String texto = "El algoritmo default es el A*, cuando tengamos programados más algoritmos, podrás seleccionarlos.";
      				
      				s_panel.mensageShow(texto, "Aviso");
      				} 
      			} );
      		
      		ayuda_ayuda.addActionListener( new ActionListener() { 
      			public void actionPerformed( ActionEvent e ) { 
      				String texto = "Programa de calculo de caminos mínimos segun un algoritmo.\nVersión 2.5.6 Beta";
      				
      				s_panel.mensageShow(texto, "Help");
      				} 
      			} );
      		
      		ayuda_sobreIAGame.addActionListener( new ActionListener() { 
      			public void actionPerformed( ActionEvent e ) { 
      				String texto = "Programa  para calcular caminos mínimos. Realiado para las prácticas de Inteligencia ";
      				texto += "Artificial de la Universidad de La Laguna en el curso académico 2014/2015. \n";
      				texto += "Realizado por: \n \t- Manuel Alejandro Rodríguez Santana.\n";
      				texto += "\t - José Carlos Rodríguez Cortes.\n";
      				texto += "\t - José Saul Giffuni Becerra.";
      				
      				s_panel.mensageShow(texto, "About IAGame");
      				} 
      			} );
        validate();
	}
				
}