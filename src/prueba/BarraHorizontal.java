package prueba;


	import javax.swing.*;  

import java.awt.GridLayout;
import java.awt.event.*;

	  @SuppressWarnings("serial")
	public class BarraHorizontal extends JFrame implements AdjustmentListener { 
		  JScrollBar sbar;  
		  JLabel label;
		  Interfaz tablero;
		  int porcentaje;
		  
		  public BarraHorizontal(Interfaz tab){
			  porcentaje = 30;
			  tablero = tab;
			  setTitle("Random");
			  setSize(300, 150);
		      setLayout(new GridLayout(3,1));
		      
		      sbar = new JScrollBar(JScrollBar.HORIZONTAL, 30, 10, 0, 110);
		      sbar.addAdjustmentListener(this);
		      add(this.sbar);
		      label = new JLabel();
		      add(this.label);
		      setVisible(true);
		      
		      JButton acept = new JButton("Aceptar");
		      acept.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tablero.obstaculosAleatorios(porcentaje);
					setVisible(false);
				}
		      });
		      
		      add(acept);
		      validate();
		  }
	    
	public void adjustmentValueChanged(AdjustmentEvent e)
	  {
	   label.setText("Porcent = "+ e.getValue() + "%");
	   porcentaje = e.getValue();
	  }   

	}