package interfaz;

import java.awt.GridLayout;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mundo.CalculoRaiz;
import mundo.Error;

public class InterfazCalculoRaiz extends JFrame
{

	private static final long serialVersionUID = 1L;
		
	// ATRIBUTOS 
		
	private PanelCuadratica panelCuadratica;
		
	private PanelCerrado panelCerrado;
	private PanelPrimerCorte panelPrimerCorte;
	private PanelAbierto panelAbierto;
	
	private PanelIntegral panelIntegral;
		
		// METODO CONSTRUCTOR
		public InterfazCalculoRaiz()
		{
			// DISEÑO
			setTitle("Calculadora final");
			setSize(600, 750);
			setResizable(true);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(new GridLayout(5, 1));
			
			// CREAN LOS OBJETOS
			panelCuadratica = new PanelCuadratica(this);
			panelCerrado = new PanelCerrado(this);
			panelAbierto = new PanelAbierto(this);
			panelIntegral = new PanelIntegral(this);
			panelPrimerCorte = new PanelPrimerCorte(this);
				
			// ADICIONAR  OBJETOS 
			add(panelCuadratica);
			add(panelPrimerCorte);
			add(panelAbierto);
			add(panelCerrado);
			add(panelIntegral);
			
		}
		//PARA QUE FUNCIONE CADA METODO, RAIZ, FALSA POSICION, BISECCION, PUNTO FIJO, NEWTON RAPHSON
		public void Presicion()
		{
			if(!panelPrimerCorte.getTxtVv().isEmpty() && !panelPrimerCorte.getTxtM().isEmpty())
			{
				if(!panelPrimerCorte.getTxtVv().isEmpty() && !panelPrimerCorte.getTxtM().isEmpty())
				{
					double Vv = Double.parseDouble(panelPrimerCorte.getTxtVv());
					String medidas = panelPrimerCorte.getTxtM();
					String[] medidas2 = medidas.split(";");
					double [] medidas3 = new double [medidas2.length];
					for(int i= 0; i< medidas2.length; i++)
					{
						medidas3[i]= Double.parseDouble(medidas2[i]);
					}
					Error error = new Error(Vv, medidas3);
					try
					{
						double P = error.Presicion();
						panelPrimerCorte.setTxtP(P);
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this, e.getMessage());
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Error");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Errorr");
			}
		}
		public void MedidaPromedio()
		{
			if(panelPrimerCorte.getTxtM().isEmpty())
			{
				String medidas = panelPrimerCorte.getTxtM();
				String[] medidas2 = medidas.split(";");
				double [] medidas3 = new double [medidas2.length];
				
				for(int i= 0; i< medidas2.length; i++)
				{
					medidas3[i]= Double.parseDouble(medidas2[i]);
				}
				Error error = new Error(medidas3);
				try
				{
					double PR = error.promedioDeLasMedidas(medidas3);
					panelPrimerCorte.setTxtMp(PR);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this, e.getMessage());
				}
			}
		}
		public void errorAbsoluto()
		{
			if(!panelPrimerCorte.getTxtVv().isEmpty() && !panelPrimerCorte.getTxtM().isEmpty())
			{
				double Vv = Double.parseDouble(panelPrimerCorte.getTxtVv());
				String medidas = panelPrimerCorte.getTxtM();
				String[] medidas2 = medidas.split(";");
				double [] medidas3 = new double [medidas2.length];
				
				for(int i= 0; i< medidas2.length; i++)
				{
					medidas3[i]= Double.parseDouble(medidas2[i]);
				}
				Error error= new Error(Vv, medidas3);
				try
				{
					double eA = error.errorAbsoluto();
					panelPrimerCorte.setTxtEa(eA);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this, e.getMessage());
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Error");
			}
				
			}
		public void MedidaMasLejana()
		{
			if(!panelPrimerCorte.getTxtVv().isEmpty() && !panelPrimerCorte.getTxtM().isEmpty())
			{
				double Vv = Double.parseDouble(panelPrimerCorte.getTxtVv());
				String medidas = panelPrimerCorte.getTxtM();
				String[] medidas2 = medidas.split(";");
				double [] medidas3 = new double [medidas2.length];
				
				for(int i= 0; i< medidas2.length; i++)
				{
					medidas3[i]= Double.parseDouble(medidas2[i]);
				}
				Error error = new Error(Vv, medidas3);
				try
				{
					double mML = error.medidaMasLejana();
					panelPrimerCorte.setTxtMl(mML);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this, e.getMessage());
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Error");
			}
		}
		
		
		
		
		public void errorRelativo()
		{
			if(!panelPrimerCorte.getTxtVv().isEmpty() && !panelPrimerCorte.getTxtM().isEmpty()&& !panelPrimerCorte.getTxtEa().isEmpty())
			{
				double Vv = Double.parseDouble(panelPrimerCorte.getTxtVv());
				String medidas = panelPrimerCorte.getTxtM();
				String[] medidas2 = medidas.split(";");
				double [] medidas3 = new double [medidas2.length];
				
				for(int i= 0; i< medidas2.length; i++)
				{
					medidas3[i]= Double.parseDouble(medidas2[i]);
				}
				Error error = new Error(Vv, medidas3);
				try
				{
					double eR = error.errorRelativo();
					panelPrimerCorte.setTxtEr(eR);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this, e.getMessage());
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Error");
			}
				
			}
		
		public void errorExactitud()
		{
			if(!panelPrimerCorte.getTxtVv().isEmpty() && !panelPrimerCorte.getTxtM().isEmpty())
			{
				double Vv = Double.parseDouble(panelPrimerCorte.getTxtVv());
				String medidas = panelPrimerCorte.getTxtM();
				String[] medidas2 = medidas.split(";");
				double [] medidas3 = new double [medidas2.length];
				
				for(int i= 0; i< medidas2.length; i++)
				{
					medidas3[i]= Double.parseDouble(medidas2[i]);
				}
				Error error = new Error(Vv, medidas3);
				try
				{
					double Ee = error.porcentajeErrorExactitud();
					panelPrimerCorte.setTxtEe(Ee);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this, e.getMessage());
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Error");
			}
				
			}
		
		
		public void errorPresicion()
		{
			if(!panelPrimerCorte.getTxtVv().isEmpty() && !panelPrimerCorte.getTxtM().isEmpty())
			{
				if(!panelPrimerCorte.getTxtVv().isEmpty() && !panelPrimerCorte.getTxtM().isEmpty())
				{
					double Vv = Double.parseDouble(panelPrimerCorte.getTxtVv());
					String medidas = panelPrimerCorte.getTxtM();
					String[] medidas2 = medidas.split(";");
					double [] medidas3 = new double [medidas2.length];
					for(int i= 0; i< medidas2.length; i++)
					{
						medidas3[i]= Double.parseDouble(medidas2[i]);
					}
					Error error = new Error(Vv, medidas3);
					try
					{
						double pEP = error.porcentajeErrorPrecision();
						panelPrimerCorte.setTxtEp(pEP);
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this, e.getMessage());
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Error");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Errorr");
			}
		}
		public void Exactitud()
		{
			if(!panelPrimerCorte.getTxtVv().isEmpty() && !panelPrimerCorte.getTxtM().isEmpty())
			{
				double Vv = Double.parseDouble(panelPrimerCorte.getTxtVv());
				String medidas = panelPrimerCorte.getTxtM();
				String[] medidas2 = medidas.split(";");
				double [] medidas3 = new double [medidas2.length];
				
				for(int i= 0; i< medidas2.length; i++)
				{
					medidas3[i]= Double.parseDouble(medidas2[i]);
				}
				Error error = new Error(Vv, medidas3);
				try
				{
					double E = error.porcentajeExactitud();
					panelPrimerCorte.setTxtE(E);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this, e.getMessage());
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Error");
			}
				
			}
		
		public void raiz1()
		{
			double valorA = Double.parseDouble(panelCuadratica.getTxtA());
			double valorB = Double.parseDouble(panelCuadratica.getTxtB());
			double valorC = Double.parseDouble(panelCuadratica.getTxtC());
			CalculoRaiz calculoRaiz = new CalculoRaiz();
			double raiz1 = calculoRaiz.raiz1(valorA, valorB, valorC);
			panelCuadratica.setTxtRaiz1(raiz1);

		}
		
		public void raiz2()
		{
			double valorA = Double.parseDouble(panelCuadratica.getTxtA());
			double valorB = Double.parseDouble(panelCuadratica.getTxtB());
			double valorC = Double.parseDouble(panelCuadratica.getTxtC());
			CalculoRaiz calculoRaiz = new CalculoRaiz();
			double raiz2 = calculoRaiz.raiz2(valorA, valorB, valorC);
			panelCuadratica.setTxtRaiz2(raiz2);
		}
		
		public void biseccion()
		{
			String funcion = panelCerrado.getTxtFuncion();
			double limiteInferior = Double.parseDouble(panelCerrado.getTxtLimiteInferior());
			double limiteSuperior = Double.parseDouble(panelCerrado.getTxtLimiteSuperior());
			CalculoRaiz calculoRaiz = new CalculoRaiz();
			try 
			{
				double raiz = calculoRaiz.biseccion(limiteInferior, limiteSuperior, funcion);
				panelCerrado.setTxtRaiz(raiz);
			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
		
		public void falsaPosicion()
		{
			String funcion = panelCerrado.getTxtFuncion();
			double limiteInferior = Double.parseDouble(panelCerrado.getTxtLimiteInferior());
			double limiteSuperior = Double.parseDouble(panelCerrado.getTxtLimiteSuperior());
			CalculoRaiz calculoRaiz = new CalculoRaiz();
			try 
			{
				double raiz = calculoRaiz.falsaPosicion(limiteInferior, limiteSuperior, funcion);
				panelCerrado.setTxtRaiz(raiz);
			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
		public void PuntoFijo()
		{
			String funcion = panelAbierto.getTxtFuncionFx();
			double Xi = Double.parseDouble(panelAbierto.getTxtXi());
			CalculoRaiz calculoRaiz = new CalculoRaiz();
			try 
			{
				double resultado = calculoRaiz.puntoFijo(funcion, Xi);
				panelAbierto.setTxtResultado(resultado);
			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
			
		}
		
		public void NewtonRaphsoon()
		{
			String funcionFx = panelAbierto.getTxtFuncionFx();
			double Xi = Double.parseDouble(panelAbierto.getTxtXi());
			CalculoRaiz calculoRaiz = new CalculoRaiz();
			try 
			{
				double resultado = calculoRaiz.newtonRaphson(funcionFx, Xi);
				panelAbierto.setTxtResultado(resultado);
			
			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		
		}
		
		public void metodoTrapecio()
		{
			String funcion = panelIntegral.getTxtFuncion();
			double a = Double.parseDouble(panelIntegral.getTxtA());
			double b = Double.parseDouble(panelIntegral.getTxtB());
			int n = Integer.parseInt(panelIntegral.getTxtN());
			CalculoRaiz calculoRaiz = new CalculoRaiz();
			double resultado = calculoRaiz.Trapecio(funcion, a, b, n);
			panelIntegral.setTxtintegral(resultado);
		}
		
		public void metodoSimpson()
		{
			String funcion = panelIntegral.getTxtFuncion();
			double a = Double.parseDouble(panelIntegral.getTxtA());
			double b = Double.parseDouble(panelIntegral.getTxtB());
			int n = Integer.parseInt(panelIntegral.getTxtN());
			CalculoRaiz calculoRaiz = new CalculoRaiz();
			double resultado = calculoRaiz.Simpson(funcion, a, b, n);
			panelIntegral.setTxtintegral(resultado);
		}
		
		public void Romberg()
		{String funcion = panelIntegral.getTxtFuncion();
		double a = Double.parseDouble(panelIntegral.getTxtA());
		double b = Double.parseDouble(panelIntegral.getTxtB());
		int nivel = Integer.parseInt(panelIntegral.getTxtNivel());
		mundo.Romberg Rom = new mundo.Romberg(funcion, a, b, nivel);
		double resultado = Rom .metodoRomberg();
		panelIntegral.setTxtintegral(resultado);
			
		}
		
		
		
		
		public void limpiarCuadratica()
		{
			panelCuadratica.limpiar();
		}
		public void limpiarCerrados()
		{
			panelCerrado.limpiar();
		}
		public void limpiarAbiertos() 
		{
			panelAbierto.limpiar();
		}
		public void limpiarIntegracion() 
		{
			panelIntegral.limpiar();
		}
		public void limpiarError() 
		{
			panelPrimerCorte.limpiar();
		}
	public static void main(String[] args) 
	{
		InterfazCalculoRaiz ventanaPrincipal = new InterfazCalculoRaiz();
		ventanaPrincipal.setVisible(true);

	}

}
