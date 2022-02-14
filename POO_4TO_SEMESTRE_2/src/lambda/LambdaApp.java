package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaApp {
	
	public void ordenar () {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("Redes");
		lista.add("Sistemas Operativos");
		lista.add("Programacion Orientada a Objetos");
		lista.add("Base de datos");
		lista.add("Internet de las Cosas");
		
		/*Collections.sort(lista, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});*/
		
		Collections.sort(lista, (String o1, String o2) -> o1.compareTo(o2));
		
		for (String elemento: lista) {
			System.out.println(elemento);
		}
	}

	public static void main(String[] args) {
		LambdaApp app = new LambdaApp();
		app.ordenar();

	}

}
