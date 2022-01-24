package tarea_11;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Vista extends JFrame {

	private JPanel contentPane;
	public JTextField txtNumero1;
	public JTextField txtNumero2;
	public JTextField txtResultado;
	
	public JButton btnSumar;
	public JButton btnRestar;
	public JButton btnMultiplicar;
	public JButton btnDividir;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 285);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OPERACIONES MATEMATICAS PRINCIPALES - RICARDO VACA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 25, 453, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumero = new JLabel("Numero 1");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumero.setBounds(29, 63, 95, 14);
		contentPane.add(lblNumero);
		
		txtNumero1 = new JTextField();
		txtNumero1.setBounds(47, 88, 86, 20);
		contentPane.add(txtNumero1);
		txtNumero1.setColumns(10);
		
		JLabel lblNumero_2 = new JLabel("Numero 2");
		lblNumero_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumero_2.setBounds(29, 125, 95, 14);
		contentPane.add(lblNumero_2);
		
		txtNumero2 = new JTextField();
		txtNumero2.setColumns(10);
		txtNumero2.setBounds(47, 150, 86, 20);
		contentPane.add(txtNumero2);
		
		JLabel lblNumero_2_1 = new JLabel("Resultado");
		lblNumero_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumero_2_1.setBounds(29, 181, 95, 14);
		contentPane.add(lblNumero_2_1);
		
		txtResultado = new JTextField();
		txtResultado.setEditable(false);
		txtResultado.setColumns(10);
		txtResultado.setBounds(47, 206, 86, 20);
		contentPane.add(txtResultado);
		
		JLabel lblSumar = new JLabel("Operaciones");
		lblSumar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSumar.setBounds(284, 65, 95, 14);
		contentPane.add(lblSumar);
		
		btnSumar = new JButton("Sumar");
		btnSumar.setBackground(Color.CYAN);
		btnSumar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSumar.setBounds(290, 87, 89, 23);
		contentPane.add(btnSumar);
		
		btnRestar = new JButton("Restar");
		btnRestar.setBackground(Color.GREEN);
		btnRestar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRestar.setBounds(290, 122, 89, 23);
		contentPane.add(btnRestar);
		
		btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.setBackground(Color.BLUE);
		btnMultiplicar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMultiplicar.setBounds(279, 160, 115, 23);
		contentPane.add(btnMultiplicar);
		
		btnDividir = new JButton("Dividir");
		btnDividir.setBackground(Color.YELLOW);
		btnDividir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDividir.setBounds(279, 194, 115, 23);
		contentPane.add(btnDividir);
	}
}
