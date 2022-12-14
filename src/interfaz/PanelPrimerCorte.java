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

public class PanelPrimerCorte extends JPanel implements ActionListener{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JLabel labVv;
	private JTextField txtVv;
	private JLabel labMp;
	private JTextField txtMp;
	private JLabel labM;
	private JTextField txtM;
	private JLabel labMl;
	private JTextField txtMl;
	private JLabel labEa;
	private JTextField txtEa;
	private JLabel labEr;
	private JTextField txtEr;
	private JLabel labEe;
	private JTextField txtEe;
	private JLabel labE;
	private JTextField txtE;
	private JLabel labEp;
	private JTextField txtEp;
	private JLabel labP;
	private JTextField txtP;
	private JButton butMP;
	private JButton butMl;
	private JButton butEa;
	private JButton butEr;
	private JButton butEe;
	private JButton butE;
	private JButton butEp;
	private JButton butP;
	private JButton butLimpiar;
	private InterfazCalculoRaiz ventana;
	
	public PanelPrimerCorte(InterfazCalculoRaiz ventana)
	{
		this.ventana = ventana;
		TitledBorder borde = BorderFactory.createTitledBorder(" Teoría del error ");
		setBorder(borde);
		borde.setTitleColor(Color.BLUE);
		setLayout(new GridLayout(8, 4));
	
		labVv= new JLabel ("Vv");
		txtVv = new JTextField();
		
		labMp= new JLabel ("Mp");
		txtMp = new JTextField();
		
		labM= new JLabel ("M");
		txtM = new JTextField();
		labMl= new JLabel ("Ml");
		txtMl = new JTextField();
		labEa= new JLabel ("Ea");
		txtEa = new JTextField();
		
		labEr= new JLabel ("Er");
		txtEr = new JTextField();
		
		labEe= new JLabel ("%Ee");
		txtEe = new JTextField();
		
		labE= new JLabel ("%E");
		txtE = new JTextField();
		labEp= new JLabel ("%Ep");
		txtEp = new JTextField();
		
		labP= new JLabel ("%P");
		txtP= new JTextField();
		
		butMP = new JButton (" MP ");
		butMP.addActionListener(this);
		
		butMl = new JButton (" Ml ");
		butMl.addActionListener(this);
		
		butEa = new JButton (" Ea ");
		butEa.addActionListener(this);
		
		butEr = new JButton (" Er ");
		butEr.addActionListener(this);
		
		butEe = new JButton (" %Ee ");
		butEe.addActionListener(this);
		
		butE = new JButton (" %E ");
		butE.addActionListener(this);
		
		butEp = new JButton (" %Ep ");
		butEp.addActionListener(this);
		
		butP = new JButton (" %P ");
		butP.addActionListener(this);
		
		butLimpiar = new JButton ("Limpiar");
		butLimpiar.addActionListener(this);
		
		add(labVv);
		add(txtVv);
		add(labMp);
		add(txtMp);
		add(labEa);
		add(txtEa);
		add(labEr);
		add(txtEr);
		add(labM);
		add(txtM);
		add(labMl);
		add(txtMl);
		add(labEe);
		add(txtEe);
		add(labE);
		add(txtE);
		add(labEp);
		add(txtEp);
		add(labP);
		add(txtP);
		add(butMP);
		add(butMl);
		add(butEa);
		add(butEr);
		add(butEe);
		add(butE);
		add(butEp);
		add(butP);
		add(butLimpiar);
		
		}
	
		public String getTxtVv()
		{
			return txtVv.getText(); 
		}
		
		public String getTxtM()
		{
			return txtM.getText(); 
		}
		
		public String getTxtMp()
		{
			return txtMp.getText(); 
		}
		
		public void setTxtMp(double Mp)
		{
			txtMp.setText("" + Mp);
		}
		
		public String getTxtMl()
		{
			return txtMl.getText(); 
		}
		
		public void setTxtMl(double Ml)
		{
			txtMl.setText("" + Ml);
		}
		
		public String getTxtEa()
		{
			return txtEa.getText(); 
		}
		
		public void setTxtEa(double Ea)
		{
			txtEa.setText("" + Ea);
		}
		
		public String getTxtEr()
		{
			return txtEr.getText(); 
		}
		
		public void setTxtEr(double Er)
		{
			txtEr.setText("" + Er);
		}
		
		public String getTxtEe()
		{
			return txtEe.getText(); 
		}
		
		public void setTxtEe(double Ee)
		{
			txtEe.setText("" + Ee);
		}
		
		public String getTxtE()
		{
			return txtE.getText(); 
		}
		
		public void setTxtE(double E)
		{
			txtE.setText("" + E);
		}
		
		public String getTxtEp()
		{
			return txtEp.getText(); 
		}
		
		public void setTxtEp(double Ep)
		{
			txtEp.setText("" + Ep);
			
		}
		
		public String getTxtP()
		{
			return txtP.getText(); 
		}
		
		public void setTxtP(double P)
		{
			txtP.setText("" + P);
		}
		
		public void limpiar()
		{
			txtVv.setText("");
			txtM.setText("");
			txtMp.setText("");
			txtMl.setText("");
			txtEa.setText("");
			txtEr.setText("");
			txtEe.setText("");
			txtE.setText("");
			txtEp.setText("");
			txtP.setText("");
		}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == butEa)
		{
			ventana.errorAbsoluto();
		}
		else if(e.getSource() == butE)
		{
			ventana.Exactitud();
			
		}
		else if(e.getSource() == butEe)
		{
			ventana.errorExactitud();
			
		}
		else if(e.getSource() == butEr)
		{
			ventana.errorRelativo();
			
		}
		else if(e.getSource() == butEp)
		{
			ventana.errorPresicion();
			
		}
		else if(e.getSource() == butMl)
		{
			ventana.MedidaMasLejana();
			
		}
		else if(e.getSource() == butMP)
		{
			ventana.MedidaPromedio();
			
		}
		else if(e.getSource() == butP)
		{
			ventana.Presicion();
			
		}
		else if(e.getSource() == butLimpiar)
		{
			ventana.limpiarError();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
