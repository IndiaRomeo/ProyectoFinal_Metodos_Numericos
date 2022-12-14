package mundo;

import org.nfunk.jep.JEP;

public class Evaluador 
{
	
	private String funcionfx;
	private double valorx;
	private double resultado;
	private String error;
	private JEP jep;
	
	public Evaluador (String funcionfx, double valorx)
	{
		this.funcionfx = funcionfx;
		this.valorx = valorx;
		this.resultado = 0.0;
		this.error = "";
		this.jep = new JEP();
	}

	/**
	 * @return the funcion
	 */
	public String getFuncionfx() {
		return funcionfx;
	}

	/**
	 * @param funcion the funcion to set
	 */
	public void setFuncionfx(String funcion) {
		this.funcionfx = funcion;
	}

	/**
	 * @return the valorx
	 */
	public double getValorx() {
		return valorx;
	}

	/**
	 * @param valorx the valorx to set
	 */
	public void setValorx(double valorx) {
		this.valorx = valorx;
	}

	/**
	 * @return the resultado
	 */
	public double getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the jep
	 */
	public JEP getJep() {
		return jep;
	}

	/**
	 * @param jep the jep to set
	 */
	public void setJep(JEP jep) {
		this.jep = jep;
	}
	
	
	public void evaluar	()
	{
		jep.addStandardFunctions();
		jep.addStandardConstants();
		jep.addVariable("x", valorx);
		jep.parseExpression(funcionfx);
		resultado = jep.getValue();
		error = (jep.hasError())?"Existe un error" : "No hay errores.";
	}
	
}
