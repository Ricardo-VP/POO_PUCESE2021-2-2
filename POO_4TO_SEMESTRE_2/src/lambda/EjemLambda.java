package lambda;

import java.util.Scanner;

public class EjemLambda {
	
	public double calcular(double n1, double n2) {
		/*Operacion op = new Operacion() {

			public double CalcularPromedio(double n1, double n2) {
				return (n1+n2)/2;
			}
			
		};*/
		Operacion op = (x,y) -> {
			return (x+y) / 2;
		};
		return op.CalcularPromedio(n1,n2);
	}

	public static void main(String[] args) {
		EjemLambda app = new EjemLambda();
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese n1: ");
		double num1 = entrada.nextDouble();
		System.out.println("Ingrese n2: ");
		double num2 = entrada.nextDouble();
		
		System.out.println(app.calcular(num1, num2));
	}

}
