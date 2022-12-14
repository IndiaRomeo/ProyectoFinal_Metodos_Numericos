package mundo;

import java.util.ArrayList;

public class Romberg 
{	
	private String funcion;
	private double a;
	private double b;
	private int nivel;
	
	public Romberg (String funcion, double a, double b, int nivel)
	{
		this.a=a;
		this.b=b;
		this.funcion=funcion;
		this.nivel=nivel;
	}
	
	public double metodoRomberg()  

	{
		double t0_2=0.0;
		double t0_4=0.0;
		double t0_8=0.0;
		double t0_16=0.0;
		double t1_2=0.0;
		double t1_4=0.0;
		double t1_8=0.0;
		double t2_2=0.0;
		double t2_4=0.0;
		double t3_2=0.0;
		double respuesta=0.0;
		
		int n=(int)Math.pow(2,(nivel+1));
		ArrayList<Double> valoresNivelCero=new ArrayList<Double>();
		while(n!=1)
		{
			

			Error tp = new Error(funcion, a, b, n);
			double valorIntegral = tp.Trapecio();
			valoresNivelCero.add(valorIntegral);
			n = n/2;

		}
		if(nivel==3)
		{
			t0_16 = valoresNivelCero.get(0);
			t0_8 = valoresNivelCero.get(1);
			t0_4 = valoresNivelCero.get(2);
			t0_2 = valoresNivelCero.get(3);
			t1_2 = ((4*t0_4)/3)- (t0_2/3);
			t1_4 = ((4*t0_8)/3)- ( t0_4/3);
			t1_8 = ((4*t0_16)/3)- ( t0_8/3);
			t2_2=((16*t1_4)/15)- ( t1_2/15);
			t2_4=((16*t1_8)/15)-(t1_4/15);
			t3_2=((64*t2_4)/63)-(t2_2/63);
			respuesta =t3_2;
		}
		else if(nivel==2)
		{
			
			t0_8 = valoresNivelCero.get(0);
			t0_4 = valoresNivelCero.get(1);
			t0_2 = valoresNivelCero.get(2);
			t1_2 = ((4*t0_4)/3)- (t0_2/3);
			t1_4 = ((4*t0_8)/3)- ( t0_4/3);
			t2_2=((16*t1_4)/15)- ( t1_2/15);
			
			respuesta =t2_2;
			
			
		}
		else if(nivel==1) 
		{
			
			
			t0_4 = valoresNivelCero.get(0);
			t0_2 = valoresNivelCero.get(1);
			t1_2 = ((4*t0_4)/3)- (t0_2/3);
			respuesta =t1_2;
		
			
		}
		else
		{
			System.out.println("El numero de niveles debe estar entre 1 y 3");
		}
		return respuesta;
	}
}
