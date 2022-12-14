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

public class PanelCuadratica extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labA;
	private JTextField txtA;
	private JLabel labB;
	private JTextField txtB;
	private JLabel labC;
	private JTextField txtC;
	private JLabel labRaiz1;
	private JTextField txtRaiz1;
	private JLabel labRaiz2;
	private JTextField txtRaiz2;
	private JButton butCalcular;
	private JButton butLimpiar;
	private InterfazCalculoRaiz ventana;
	
	
	public PanelCuadratica(InterfazCalculoRaiz ventana)
	{
		this.ventana = ventana;
		TitledBorder borde = BorderFactory.createTitledBorder("Función cuadrática");
		setBorder(borde);
		borde.setTitleColor(Color.BLUE);
		setLayout(new GridLayout(6, 2));
		
		// CREAMOS LOS OBJETOS
		labA = new JLabel("Valor (a)");
		txtA = new JTextField();
		
		labB = new JLabel("Valor (b)");
		txtB = new JTextField();
		labC = new JLabel("Valor (c)");
		txtC = new JTextField();
		
		labRaiz1 = new JLabel("Raiz 1");
		txtRaiz1 = new JTextField();
		
		labRaiz2 = new JLabel("Raiz 2");
		txtRaiz2 = new JTextField();
		butCalcular = new JButton("Calcular");
		butCalcular.addActionListener(this);
		
		butLimpiar = new JButton("Limpiar");
		butLimpiar.addActionListener(this);
		
		add(labA);
		add(txtA);
		add(labB);
		add(txtB);
		add(labC);
		add(txtC);
		add(labRaiz1);
		add(txtRaiz1);
		add(labRaiz2);
		add(txtRaiz2);
		add(butCalcular);
		add(butLimpiar);
	}
	
	
	public String getTxtA()
	{
		return txtA.getText();
	}
	
	public String getTxtB()
	{
		return txtB.getText();
	}
	
	public String getTxtC()
	{
		return txtC.getText();
	}
	
	public void setTxtRaiz1(double raiz1)
	{
		txtRaiz1.setText("" + raiz1);
	}
	
	public void setTxtRaiz2(double raiz2)
	{
		txtRaiz2.setText("" + raiz2);
	}
	
	public void limpiar()
	{
		
		txtA.setText("");
		txtB.setText("");
		txtC.setText("");
		txtRaiz1.setText("");
		txtRaiz2.setText("");
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == butCalcular)
		{
			ventana.raiz1();
			ventana.raiz2();
		}
		else if(e.getSource() == butLimpiar)
		{
			ventana.limpiarCuadratica();
		}
		
		
	}

}
