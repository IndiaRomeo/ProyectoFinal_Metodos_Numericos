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

public class PanelAbierto extends JPanel implements ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labFuncionFx;
	private JTextField txtFuncionFx;	
	private JLabel labXi;
	private JTextField txtXi;
	private JLabel labResultado;
	private JTextField txtResultado;
	private JButton butPF;
	private JButton butNR;
	private JLabel labVacio;
	private JButton butLimpiar;
	private InterfazCalculoRaiz ventana;
	
	public PanelAbierto(InterfazCalculoRaiz ventana)
	{
		this.ventana = ventana;
		TitledBorder borde = BorderFactory.createTitledBorder("Métodos Abiertos");
		setBorder(borde);
		borde.setTitleColor(Color.BLUE);
		setLayout(new GridLayout(6, 2));


	
		labFuncionFx = new JLabel ("Función ");
		
		txtFuncionFx = new JTextField();
		
		labXi = new JLabel (" X0 ");
		txtXi = new JTextField();
		
		labResultado = new JLabel("Raíz");
		txtResultado = new JTextField();
		
		butPF = new JButton (" Punto Fijo ");
		
		
		
		butNR = new JButton (" NewtonRaphson ");
		butNR.addActionListener(this);
		butPF.addActionListener(this);
		
		labVacio = new JLabel();
		
		butLimpiar = new JButton ("Limpiar");
		butLimpiar.addActionListener(this);
		
		
		add(labFuncionFx);
		add(txtFuncionFx);
		add(labXi);
		add(txtXi);
		add(labResultado);
		add(txtResultado);
		add(butPF);
		add(butNR);
		add(labVacio);
		add(butLimpiar);
	}
	
			
			public String getTxtFuncionFx()
			{
				return txtFuncionFx.getText(); 
			}
			
			public String getTxtXi()
			{
				return txtXi.getText(); 
			}
			
			public void setTxtResultado(double resultado)
			{
				txtResultado.setText("" + resultado);
			}
			
			public void limpiar()
			{
				txtFuncionFx.setText("");
				txtXi.setText("");
				txtResultado.setText("");
				
			}
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				if(e.getSource() == butPF)
				{
					ventana.PuntoFijo();
				}
				else if(e.getSource() == butNR)
				{
					ventana.NewtonRaphsoon();
					
				}
				else if(e.getSource() == butLimpiar)
				{
					ventana.limpiarAbiertos();
				}
			}
		
		
		
			
		}
		
