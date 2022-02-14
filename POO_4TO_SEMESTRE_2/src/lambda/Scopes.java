package lambda;

public class Scopes {
	
	private double n3 = 3;
	
	public double probarVariableLocal() {
		Operacion op = (n1, n2) -> {
			n3 = n1+n2;
			return n1+n2+n3;
		};
		
		return op.calcular(2, 8);
	}

	public static void main(String[] args) {
		Scopes app = new Scopes();
		System.out.println(app.probarVariableLocal());

	}

}
