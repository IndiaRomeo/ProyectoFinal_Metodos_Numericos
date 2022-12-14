
package mundo;

import javax.swing.JOptionPane;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class CalculoRaiz 

{

	private String funcionfx;
	private DJep djep;
	private Node nodoFuncion;
	private Node nodoDerivada;
	
	
	public double promedioDeLasMedidas( double[ ] medidas)throws Exception
	{
		if(medidas.length !=0)
		{
			double suma = 0.0;
			double promedio = 0.0;
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
	
	 
		public double errorAbsoluto(double valorVerdadero, double medida, double[ ] medidas)throws Exception
		{
			double ea = 0;
			if(medidas.length !=0) 
			{
				 ea = Math.abs(valorVerdadero - medida);
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

		

		// METODO PARA EL ERROR RELATIVO

		
		public double errorRelativo(double errorAbsoluto, double valorVerdadero,  double[ ] medidas)
		{
			double er = 0.0;
			try
			{
				if(medidas.length !=0) 
				{
					 er = errorAbsoluto / valorVerdadero;
				}
				 else if(medidas.length > 1)
				{
					 er = errorAbsoluto / promedioDeLasMedidas(medidas);
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, " No hay medidas ");
			}
			return er;
		}

	

		// METODOS PARA LA EXACTITUD

		
		public double porcentajeErrorExactitud(double errorRelativo,double [ ] medidas)
		{
			double pEE = errorRelativo * 100;
			return pEE;
		}

		

		public double porcentajeExactitud(double porcentajeErrorExactitud,double [ ] medidas)
		{
			double pE = 100 - porcentajeErrorExactitud;
			return pE;
		}

		public double medidaMasLejana(double[ ] medidas, double valorVerdadero)
		{
			double mML=0;
			double diferencia = 0.0;
			for(int i=0; i< medidas.length;i++)
			{
				if(Math.abs(valorVerdadero - medidas[i])> diferencia)
				{
					diferencia = Math.abs(valorVerdadero- medidas[i]);
					mML = medidas[i];
				}
			}
			return mML;
		}
		
		// METODOS PARA LA PRECISION

		
		public double porcentajeErrorPrecision(double[ ] medidas, double valorVerdadero )
		{
			double pEP =0.0;
			try
			{
				 pEP = ( Math.abs(promedioDeLasMedidas(medidas) - medidaMasLejana(medidas, valorVerdadero)) / promedioDeLasMedidas(medidas))  * 100;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, " Hay problemas con el promedio o la medida mas lejana  ");
			}
			return  pEP;
		}

		public double Presicion(double porcentajeErrorPrecision,double[ ] medidas)
		{
			double P =100-porcentajeErrorPrecision;
			return P;
		}
	
	
	public double evaluar(String funcionfx, double valorX ) throws Exception
	{   
		double resultado = 0.0;
		JEP jep = new JEP();
		jep.addStandardFunctions();
		jep.addStandardConstants();
		jep.addVariable( "x", valorX );
		jep.parseExpression( funcionfx );
		resultado = jep.getValue(); 

	
		if( jep.hasError() ){
			throw new Exception("Hay error al evaluar.");
		}
		else
		{
			return resultado;
		}      
	}

	

	// METODOS PARA LA FUNCIÓN CUADRATICA

	public double raiz1(double a, double b, double c)
	{
		return (-b + Math.sqrt((Math.pow(b, 2)-4*a*c))) / (2*a);
	}

	public double raiz2(double a, double b, double c)
	{
		return (-b - Math.sqrt((Math.pow(b, 2)-4*a*c))) / (2*a);
	}

	// METODO BISECCIÓN

	public double biseccion(double lI, double lS, String funcion) throws Exception
	{
		double lIEvaluadoEnLaF = evaluar(funcion, lI);
		double lSEvaluadoEnLaF = evaluar(funcion, lS);
		// ------------------------------
		double xRActual = (lI + lS) / 2;
		// ------------------------------
		double xRActualEvaluadoEnLaF = evaluar(funcion, xRActual);		
		double xRAnterior = 1;
		double errorAproximado = 1;
		double respuesta = 0.0;
		int contador = 0;

		if( ((lIEvaluadoEnLaF) > 0) && ((lSEvaluadoEnLaF) < 0) || 
				((lIEvaluadoEnLaF) < 0) && ((lSEvaluadoEnLaF) > 0))
		{
			while(xRActualEvaluadoEnLaF != 0 && errorAproximado > 0.000001 )
			{				
				xRActual = (lI + lS) / 2;
				contador++;
				System.out.println("Iteración: " + contador + " - Raiz: " + xRActual);
				errorAproximado = Math.abs( (xRActual - xRAnterior) / xRActual ) * 100;
				xRActualEvaluadoEnLaF = evaluar(funcion, xRActual);
				if( (lIEvaluadoEnLaF * xRActualEvaluadoEnLaF) < 0)
				{
					lS = xRActual;
				}
				else if( (lIEvaluadoEnLaF * xRActualEvaluadoEnLaF) > 0)
				{
					lI = xRActual;
				}
				else if( (lIEvaluadoEnLaF * xRActualEvaluadoEnLaF) == 0)
				{
					respuesta = xRActual;
				}
				xRAnterior = xRActual;
				lIEvaluadoEnLaF = evaluar(funcion, lI);
			}
			respuesta = xRActual;
		}
		else
		{
			throw new Exception("El rango ingresado no es valido. ");
		}		
		return respuesta;
	}

		// METODO FALSA POSICIÓN 
	
		public double falsaPosicion(double lI, double lS, String funcion) throws Exception
		{
			double lIEvaluadoEnLaF = evaluar(funcion, lI);
			double lSEvaluadoEnLaF = evaluar(funcion, lS);
			// -------------------------------------------------------------------------------------------------------
			double xRActual = ( lI * lSEvaluadoEnLaF - lS * lIEvaluadoEnLaF ) / ( lSEvaluadoEnLaF - lIEvaluadoEnLaF );
			// -------------------------------------------------------------------------------------------------------
			double xRActualEvaluadoEnLaF = evaluar(funcion, xRActual);
			double xRAnterior = 1;
			double errorAproximado = 1;
			double respuesta = 0.0;
			int contador = 0;

		if( ((lIEvaluadoEnLaF) > 0) && ((lSEvaluadoEnLaF) < 0) || 
				((lIEvaluadoEnLaF) < 0) && ((lSEvaluadoEnLaF) > 0))
		{
			while(xRActualEvaluadoEnLaF != 0 && errorAproximado > 0.000001 )
			{				
				xRActual = ( lI * lSEvaluadoEnLaF - lS * lIEvaluadoEnLaF ) / ( lSEvaluadoEnLaF - lIEvaluadoEnLaF );
				contador++;
				System.out.println("Iteración: " + contador + " - Raiz: " + xRActual);
				errorAproximado = Math.abs( (xRActual - xRAnterior) / xRActual ) * 100;
				xRActualEvaluadoEnLaF = evaluar(funcion, xRActual);
				if( (lIEvaluadoEnLaF * xRActualEvaluadoEnLaF) < 0)
				{
					lS = xRActual;
				}
				else if( (lIEvaluadoEnLaF * xRActualEvaluadoEnLaF) > 0)
				{
					lI = xRActual;
				}
				else if( (lIEvaluadoEnLaF * xRActualEvaluadoEnLaF) == 0)
				{
					respuesta = xRActual;
				}
				xRAnterior = xRActual;
				lIEvaluadoEnLaF = evaluar(funcion, lI);
				}
				respuesta = xRActual;
			}
			else
			{
				throw new Exception("El rango ingresado no es valido. ");
			}	
			return respuesta;
		}

		//METODOS ABIERTOS
		//____
		//METODO PUNTO FIJO
		public double puntoFijo(String funcionGx, double xi) throws Exception 
		{
			try 
			{
			double Fxi = evaluar(funcionGx, xi);
			double error = Math.abs((Fxi-xi)/Fxi)*100;

			while(error> 0.00001) 
			{
				double fxiAnt = Fxi;
				Fxi = evaluar(funcionGx,fxiAnt);
				error = Math.abs((Fxi - fxiAnt)/Fxi)*100;

			}
			return Fxi;
		}
			catch(Exception e) 
			{
			throw new Exception("Error en la funcion");
			}


		}

			//DERIVADA
			public void calculoRaiz (String funcion) 
			{
				System.out.println("Inicializo djep");
				this.funcionfx = funcion;
				djep = new DJep();
			}
	

			public void setFuncionADerivar(String funcion) 
			{
				this.funcionfx = funcion;
			}

			public String getFuncionDerivada() 
			{
				return funcionfx;
			}



		//DERIVAR FUNCION
	
        	public String derivar( String funcion ) 
        	{
        		System.out.println("Inicializo djep");
        		djep = new DJep();
		
        		try 
        		{
			// agrega funciones estandares cos(x), sin(x)
			djep.addStandardFunctions();

			// agrega constantes estandares, pi, e, etc
			djep.addStandardConstants();

			// por si existe algun numero complejo
			djep.addComplex();

			// permite variables no declarables
			djep.setAllowUndeclared(true);

			// permite asignaciones
			djep.setAllowAssignment(true);

			// regla de multiplicacion o para sustraccion y sumas
			djep.setImplicitMul(true);

			// regla de multiplicacion o para sustraccion y sumas
			// djep.addStandardDiffRules();

			// coloca el nodo con una funcion preestablecida
			nodoFuncion = djep.parse(funcion);

			// deriva la funcion con respecto a x
			Node diff = djep.differentiate(nodoFuncion, "x");

			// Simplificamos la funcion con respecto a x
			nodoDerivada = djep.simplify(diff);

			// Convertimos el valor simplificado en un String
			funcion = djep.toString(nodoDerivada);

		} 
		catch (ParseException e)
		{
			funcion = "NaN";
			System.out.println("Error: " + e.getErrorInfo());
		}
		return funcion;
	}

	
	public double newtonRaphson(String funcionFx, double xi )throws Exception
	{
		try 
		{
			
			
			System.out.println("1. funcion: " + funcionFx + " " + xi );
			double fxi = evaluar( funcionFx, xi );
			String derivada = derivar( funcionFx );
			System.out.println("2. derivada: " + derivada );
			double dfxi = evaluar(derivada, xi);

			double error = 100;
			while( error > 0.0000001 )
			{
				double ant = xi;
				xi = xi - (fxi/dfxi) ;
				fxi = evaluar(funcionFx, xi);
				dfxi = evaluar(derivada, xi);
				error = Math.abs((xi-ant)/xi)*100;
			}
			return xi;
		}
		catch (Exception e)
		{
			System.out.println("Error al derivar" );			
			throw new Exception ("Error al derivar ");
		}
	}
	
	
	
	public double Trapecio(String funcion, double a, double b, int n)
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
	


	public double Simpson(String funcion, double a, double b, int n)
	{
		Evaluador e1 = new Evaluador (funcion, a);
		e1.evaluar();
		double fEvalA= e1.getResultado();
		
		Evaluador e2 = new Evaluador (funcion, b);
		e2.evaluar();
		double fEvalB= e2.getResultado();
		
		
		double c=(a+b)/2;
		Evaluador e3 = new Evaluador (funcion, c);
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
		

	

			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	

