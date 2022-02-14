package lambda;

public class LambdaEjercicio {
	
	public double calcularPromedioTresNotas() {
		OperacionEjercicio op = (double n1, double n2, double n3) -> (n1+n2+n3) /3;
		return op.CalcularPromedioTres(1, 2, 5);
	}

	public static void main(String[] args) {
		LambdaEjercicio ejercicio = new LambdaEjercicio();
		System.out.println(ejercicio.calcularPromedioTresNotas());
	}

}
