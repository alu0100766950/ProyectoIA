package prueba;

	import javax.swing.*;  
	
import java.awt.GridLayout;
import java.awt.event.*;

	  public class BarraHorizontal extends JFrame implements AdjustmentListener {
		  // application object fields   
		  JScrollBar sbar;  
		  JLabel label;
		  Interfaz tablero;
		  
		  public BarraHorizontal(Interfaz tab){
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
		      //Button cancel = new JButton("Cancelar");
		      
		      acept.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
		      });
		      
		      add(acept);
		      
		      /*cancel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						tablero.set_porcentaje(0);
						setVisible(false);
						
					}
				});*/
    
		  }
	    
	  private void setPreferredSize(int[] aux2) {
			// TODO Auto-generated method stub
			
		}

	public void adjustmentValueChanged(AdjustmentEvent e)
	  {
	   label.setText("Porcent = "+ e.getValue() + "%");
	   tablero.set_porcentaje(e.getValue());
	  }   

	}
