package mundo;

import javax.swing.JOptionPane;

public class Error 
{
	private double [] medidas;
	private double valorverdadero;
	private String funcion;
	private double a;
	private double b;
	private int n;
	public Error(String funcion, double a, double b, int n)
	{
		this.funcion=funcion;
		this.a=a;
		this.b=b;
		this.n=n;
	}
	public Error (double valorVerdadero, double[] medidasP)
	{
		valorverdadero = valorVerdadero;
		medidas= medidasP;
	}
	
	public Error(double[]medidasP)
	{
		 valorverdadero=0.0;
		 medidas = medidasP;
	}
	
	public double promedioDeLasMedidas( double[ ] medidas)throws Exception
	{
		if(medidas.length !=0)
		{
			double promedio = 0.0;
			double suma = 0.0;
	
			for(int i= 0; i < medidas.length; i++)
			{
				suma = suma + medidas[i];
			}
			promedio = suma / medidas.length;
			return promedio;
			
		}
		else  
		{
			throw new Exception("No hay medidas");
		}
		
	}
	
	 
		public double errorAbsoluto()throws Exception
		{
			double ea = 0;
			if(medidas.length !=0) 
			{
				 ea = Math.abs(valorverdadero - medidas[0]);
			}
			else if(medidas.length > 1)
			{
				double suma = 0.0;
				double promedio = 0.0;
				for(int i= 0; i < medidas.length; i++)
				{
					suma = suma + medidas[i];
				}
				promedio = suma / medidas.length;

				// Ya con el promedio podemos calcular el error absoluto para varias medidas. 
				double suma2 = 0.0;
				for(int i= 0; i < medidas.length; i++)
				{
					suma2 = suma2 + Math.abs(medidas[i] - promedio);
				}
				 ea = suma2/medidas.length;
			
			}
			else
			{
				throw new Exception("No hay medidas");
			}
			
			return ea;
			
		}

			
		public double errorRelativo()
		{
			double er = 0.0;
			try
			{
				if(medidas.length !=0) 
				{
					 er = errorAbsoluto() / valorverdadero;
				}
				 else if(medidas.length > 1)
				{
					 er = errorAbsoluto() / promedioDeLasMedidas(medidas);
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, " No hay medidas ");
			}
			return er;
		}

	
		public double Trapecio()
		{
			Evaluador e1 = new Evaluador (funcion, a);
			e1.evaluar();
			double fEvalA= e1.getResultado();
			
			Evaluador e2 = new Evaluador (funcion, b);
			e2.evaluar();
			double fEvalB= e2.getResultado();
			
			double integral = 0.0;
			double delta = (b-a)/n;
			
			if(n==1)
			{
				integral = (b-a)*((fEvalA+fEvalB)/2);
			}
			else if (n>1)
			{
				double [] trapecios = new double [n + 1];
				double suma1 = 0.0;
				double suma2 = 0.0;
				double inicio = a;
				
				for(int i=0; i< trapecios.length; i++)
				{
					Evaluador e = new Evaluador (funcion, inicio);
					e.evaluar();
					trapecios[i] = e.getResultado();
					inicio += delta;
				}
				for(int i=0; i< trapecios.length; i++)
				{
					if(i == 0 || i == (trapecios.length -1))
					{
						suma1 = suma1 + trapecios[i];
					}
					
					else
					{
						suma2=suma2 + trapecios[i];
					}
				}
				integral = (delta/2)*((suma1)+2*(suma2));
			}
			else
			{
				System.out.println("error");
			}
			return integral;
		}
		


		public double Simpson(String funcionfx, double a, double b, int n)
		{
			Evaluador e1 = new Evaluador (funcionfx, a);
			e1.evaluar();
			double fEvalA= e1.getResultado();
			
			Evaluador e2 = new Evaluador (funcionfx, b);
			e2.evaluar();
			double fEvalB= e2.getResultado();
			
			
			double c=(a+b)/2;
			Evaluador e3 = new Evaluador (funcionfx, c);
			e3.evaluar();
			double fEvalC= e3.getResultado();
			
			double integral = 0.0;
			double delta = (b-a)/n;
			
			if(n==2)
			{
				integral = ((b-a)/6)*((fEvalA+ fEvalC+fEvalB));
			}
			else if (n>2 && (n%2 ==0))
			{
				double [] trapecios = new double [n + 1];
				double suma1 = 0.0;
				double suma2 = 0.0;
				double suma3 = 0.0;
				double inicio = a;
				
				for(int i=0; i< trapecios.length; i++)
				{
					Evaluador e = new Evaluador (funcionfx, inicio);
					e.evaluar();
					trapecios[i] = e.getResultado();
					inicio += delta;
				}
				for(int i=0; i< trapecios.length; i++)
				{
					if(i == 0 || i == (trapecios.length -1))
					{
						suma1 = suma1 + trapecios[i];
					}
					
					else if (i % 2 ==0)
					{
						suma2=suma2 + trapecios[i];
					}
					else 
					{
						suma3 = suma3 + trapecios[i];
					}
				}
				integral = (delta/3)*((suma1+4*(suma3)+2*(suma2)));
			}
			else
			{
				System.out.println("error");
			}
			return integral;
		}
			
		
		public double porcentajeErrorExactitud()
		{
			double pEE = errorRelativo() * 100;
			return pEE;
		}

		

		public double porcentajeExactitud()
		{
			double pE = 100 - porcentajeErrorExactitud();
			return pE;
		}

		public double medidaMasLejana()
		{
			double mML=0;
			double diferencia = 0.0;
			for(int i=0; i< medidas.length;i++)
			{
				if(Math.abs(valorverdadero - medidas[i])> diferencia)
				{
					diferencia = Math.abs(valorverdadero- medidas[i]);
					mML = medidas[i];
				}
			}
			return mML;
		}
		
		

		
		public double porcentajeErrorPrecision( )
		{
			double pEP =0.0;
			try
			{
				 pEP = ( Math.abs(promedioDeLasMedidas(medidas) - medidaMasLejana()) / promedioDeLasMedidas(medidas))  * 100;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, " Hay problemas con el promedio o la medida mas lejana  ");
			}
			return  pEP;
		}

		public double Presicion()
		{
			double P =100-porcentajeErrorPrecision();
			return P;
		}
}
