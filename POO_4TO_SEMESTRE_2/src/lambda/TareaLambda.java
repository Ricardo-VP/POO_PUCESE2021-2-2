package lambda;

import java.util.Scanner;

public class TareaLambda {

	public void calcular(double n1, double n2) {
		OperacionesTarea op = (x,y) -> {
			System.out.println("Suma : " + (x+y));
			System.out.println("Resta : " + (x-y));
			System.out.println("Multiplicacion : " + (x*y));
			System.out.println("Division : " + (x/y));
			double mayor = x > y ? x : y;
			if( n1 == n2 )
				System.out.println("Los numeros son iguales");
			else
				System.out.println("El mayor es: " + mayor);
		};
		op.OperacionesBasicas(n1, n2);
	}

	public static void main(String[] args) {
		TareaLambda app = new TareaLambda();
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese n1 : ");
		double n1 = entrada.nextDouble();
		System.out.println("Ingrese n2 : ");
		double n2 = entrada.nextDouble();
		
		app.calcular(n1, n2);
	}

}
