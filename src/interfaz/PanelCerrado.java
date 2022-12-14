package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelCerrado extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ATRIBUTOS
		private JLabel labFuncion;
		private JTextField txtFuncion;	
		private JLabel labLimiteInferior;
		private JTextField txtLimiteInferior;	
		private JLabel labLimiteSuperior;
		private JTextField txtLimiteSuperior;	
		private JLabel labRaiz;
		private JTextField txtRaiz;	
		private JButton butBi;
		private JButton butFP;
		private JLabel labVacio;
		private JButton butLimpiar;
		private InterfazCalculoRaiz ventana;

		public PanelCerrado(InterfazCalculoRaiz ventana)
		{
			this.ventana = ventana;	
			TitledBorder borde = BorderFactory.createTitledBorder("Métodos Cerrados");
			setBorder(borde);
			borde.setTitleColor(Color.BLUE);
			setLayout(new GridLayout(6, 2));
		
			labFuncion = new JLabel("Función");
			txtFuncion = new JTextField();	
			labLimiteInferior = new JLabel("Límite inferior");
			txtLimiteInferior = new JTextField();	
			labRaiz = new JLabel("Raíz");
			txtRaiz = new JTextField();	
			labLimiteSuperior = new JLabel("Límite superior");
			txtLimiteSuperior = new JTextField();	
			butBi = new JButton("Bisección");
			butFP = new JButton("Falsa Posición");
			labVacio = new JLabel("");
			butLimpiar = new JButton("Limpiar");
			butLimpiar.addActionListener(this);
			butBi.addActionListener(this);
			butFP.addActionListener(this);
			
			add(labFuncion);
			add(txtFuncion);
			add(labLimiteInferior);
			add(txtLimiteInferior);
			add(labLimiteSuperior);
			add(txtLimiteSuperior);
			add(labRaiz);
			add(txtRaiz);
			add(butBi);
			add(butFP);
			add(labVacio);
			add(butLimpiar);
		}

		
		
		public String getTxtFuncion()
		{
			return txtFuncion.getText(); 
		}
		
		public String getTxtLimiteInferior()
		{
			return txtLimiteInferior.getText(); 
		}
		
		public String getTxtLimiteSuperior()
		{
			return txtLimiteSuperior.getText(); 
		}
		
		public void setTxtRaiz(double raiz)
		{
			txtRaiz.setText("" + raiz);
		}
		
		public void limpiar()
		{
			txtFuncion.setText("");
			txtLimiteInferior.setText("");
			txtLimiteSuperior.setText("");
			txtRaiz.setText("");
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == butBi)
		{
			ventana.biseccion();
		}
		else if(e.getSource() == butFP)
		{
			ventana.falsaPosicion();
		}
		else if(e.getSource() == butLimpiar)
		{
			ventana.limpiarCerrados();
		}
		
	}
	
}
