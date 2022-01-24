package tarea_11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
	
	private Vista view;
	@SuppressWarnings("unused")
	private Modelo model;
	
	public Controlador(Vista view, Modelo model) {
		this.view = view;
		this.model = model;
		
		this.view.btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setNumeroUno(Double.parseDouble(view.txtNumero1.getText()));
				model.setNumeroDos(Double.parseDouble(view.txtNumero2.getText()));
				model.sumar();
				view.txtResultado.setText(String.valueOf(model.getSuma()));
			}
		});
		
		this.view.btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setNumeroUno(Double.parseDouble(view.txtNumero1.getText()));
				model.setNumeroDos(Double.parseDouble(view.txtNumero2.getText()));
				model.restar();
				view.txtResultado.setText(String.valueOf(model.getResta()));
			}
		});
		
		this.view.btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setNumeroUno(Double.parseDouble(view.txtNumero1.getText()));
				model.setNumeroDos(Double.parseDouble(view.txtNumero2.getText()));
				model.multiplicar();
				view.txtResultado.setText(String.valueOf(model.getMultiplicacion()));
			}
		});
		
		this.view.btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setNumeroUno(Double.parseDouble(view.txtNumero1.getText()));
				model.setNumeroDos(Double.parseDouble(view.txtNumero2.getText()));
				model.dividir();
				view.txtResultado.setText(String.valueOf(model.getDivision()));
			}
		});
	}

	public void iniciar()
	 {
		 view.setTitle("PROGRAMA OPERACIONES MATEMATICAS");
		 view.setLocationRelativeTo(null);
	 }
	
}
