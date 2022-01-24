package tarea_11;

public class MVC {

	public static void main(String[] args) {
		Modelo model = new Modelo();
		Vista view = new Vista();
		Controlador ctrl = new Controlador(view, model);
		ctrl.iniciar();
		view.setVisible(true);
	}

}
