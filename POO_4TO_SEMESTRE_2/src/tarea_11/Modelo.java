package tarea_11;

public class Modelo {
	
	private double numeroUno;
	private double numeroDos;
	private double suma;
	private double resta;
	private double multiplicacion;
	private double division;
	
	// Getters y setters
	
	public double getNumeroUno() {
		return numeroUno;
	}
	public void setNumeroUno(double numeroUno) {
		this.numeroUno = numeroUno;
	}
	public double getNumeroDos() {
		return numeroDos;
	}
	public void setNumeroDos(double numeroDos) {
		this.numeroDos = numeroDos;
	}
	public double getSuma() {
		return suma;
	}
	public void setSuma(double suma) {
		this.suma = suma;
	}
	public double getResta() {
		return resta;
	}
	public void setResta(double resta) {
		this.resta = resta;
	}
	public double getMultiplicacion() {
		return multiplicacion;
	}
	public void setMultiplicacion(double multiplicacion) {
		this.multiplicacion = multiplicacion;
	}
	public double getDivision() {
		return division;
	}
	public void setDivision(double division) {
		this.division = division;
	}
	
	// Operaciones matematicas
	
	public void sumar() {
		double suma = this.numeroUno + this.numeroDos;
		suma = Math.round(suma * 100.00) / 100.00;
		this.suma = suma;
	}
	
	public void restar() {
		double resta = this.numeroUno - this.numeroDos;
		resta = Math.round(resta * 100.00) / 100.00;
		this.resta = resta;
	}
	
	public void multiplicar() {
		double multiplicacion = this.numeroUno * this.numeroDos;
		multiplicacion = Math.round(multiplicacion * 100.00) / 100.00;
		this.multiplicacion = multiplicacion;
	}
	
	public void dividir() {
		double division = this.numeroUno / this.numeroDos;
		division = Math.round(division * 100.00) / 100.00;
		this.division = division;
	}
}
