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

public class PanelIntegral extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labN;
	private JTextField txtN;
	private JLabel labFuncion;
	private JTextField txtFuncion;
	private JLabel labA;
	private JTextField txtA;
	private JLabel labB;
	private JTextField txtB;
	private JLabel labIntegral;
	private JTextField txtIntegral;
	private JLabel labNivel;
	private JTextField txtNivel;
	private JButton butSimpson13;
	private JButton butTrapecio;
	private JButton butRomberg;
	private JButton butLimpiar;
	
	private InterfazCalculoRaiz ventana;

	public PanelIntegral(InterfazCalculoRaiz ventana){
		this.ventana = ventana;
		
		// DISEÑO
		TitledBorder borde = BorderFactory.createTitledBorder("Panel solución integrales");
		setBorder(borde);
		borde.setTitleColor(Color.BLUE);
		setLayout(new GridLayout(8, 2));
		
		
		labN = new JLabel (" Número de intervalos, N");
		txtN = new JTextField();
		
		labFuncion = new JLabel (" Función");
		txtFuncion = new JTextField();
		
		labA = new JLabel (" Valor a ");
		txtA = new JTextField();
		
		labB = new JLabel (" Valor b ");
		txtB = new JTextField();
		
		labIntegral = new JLabel (" Integral ");
		txtIntegral = new JTextField();
		
		labNivel= new JLabel (" Nivel ");
		txtNivel = new JTextField();

		
		butSimpson13 = new JButton (" Simpson 1/3 ");
		butSimpson13.addActionListener(this);
		
		butTrapecio = new JButton (" Trapecio ");
		butTrapecio.addActionListener(this);
		
		butRomberg = new JButton (" Romberg ");
		butRomberg.addActionListener(this);
		
		butLimpiar = new JButton (" Limpiar ");
		butLimpiar.addActionListener(this);
		
		add(labFuncion);
		add(txtFuncion);
		add(labA);
		add(txtA);
		add(labB);
		add(txtB);
		add(labN);
		add(txtN);
		add(labNivel);
		add(txtNivel);
		add(labIntegral);
		add(txtIntegral);
		add(butTrapecio);
		add(butSimpson13);
		add(butRomberg);
		add(butLimpiar);
			
		}
	
	public String getTxtFuncion()
	{
		return txtFuncion.getText(); 
	}
	
	public String getTxtN()
	{
		return txtN.getText(); 
		
	}
	
	public String getTxtNivel()
	{
		return txtNivel.getText(); 
		
	}
	
	
	public String getTxtA()
	{
		return txtA.getText(); 
	}
	
	public String getTxtB()
	{
		return txtB.getText(); 
	}
	
	public void setTxtintegral(double resultado)
	{
		txtIntegral.setText("" + resultado);
	}
	
	public void limpiar()
	{
		txtIntegral.setText("");
		txtA.setText("");
		txtB.setText("");
		txtN.setText("");
		txtFuncion.setText("");
		txtNivel.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == butTrapecio)
		{
			ventana.metodoTrapecio();
		}
		else if(e.getSource() == butSimpson13)
		{
			ventana.metodoSimpson();
		}
		else if(e.getSource() == butRomberg)
		{
			ventana.Romberg();
		}
		
		else if(e.getSource() == butLimpiar)
		{
			ventana.limpiarIntegracion();
		}

	}
	
	
	
	
}
