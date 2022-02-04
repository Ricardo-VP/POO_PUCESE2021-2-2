package conexionbd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class universidad extends JFrame {

	private JPanel contentPane;
	
	private static final String URL = "jdbc:mysql://localhost:3306/universidad";
	private static final String Usuario = "root";
	private static final String Clave = "";
	
	private JTextField txtCedula;
	private JTextField txtApellidos;
	private JTextField txtNombres;
	private JTextField txtLugarNacimiento;
	private JTextField txtFechaNacimiento;
	private JTextField txtNotaGrado;
	
	private JButton btnModificar = new JButton("Modificar");
	private JButton btnBuscar = new JButton("Buscar");
	private JButton btnEliminar = new JButton("Eliminar");
	
	PreparedStatement ps; // Preparar la base de datos para la consulta (instruccion SQL)
	ResultSet rs; // Variable que contiene los resultados de la consulta
	private JTable tblDatos;
	private JTextField txtBuscarCedula;
	
 	public static Connection getConnection() {
		Connection con = null; // Almacenar la conexion a la base de datos
		try {
 			Class.forName("com.mysql.cj.jdbc.Driver"); // Llamar al driver de la conexion
 			con = DriverManager.getConnection(URL, Usuario, Clave);
 			// JOptionPane.showMessageDialog(null, "Se ha conectado con exito!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error en la conexion");
		}
		return con;
	};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					universidad frame = new universidad();
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
	public universidad() {
		setTitle("CONEXION A LA DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProbar = new JButton("Probar conexion");
		btnProbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con;
					con = getConnection();
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Hubo un error en la conexion");
				}
			}
		});
		btnProbar.setBounds(10, 438, 145, 23);
		contentPane.add(btnProbar);
		
		JLabel lblNewLabel = new JLabel("Cedula");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(20, 36, 86, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidos.setBounds(10, 67, 66, 14);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(20, 92, 86, 20);
		contentPane.add(txtApellidos);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombres.setBounds(10, 123, 66, 14);
		contentPane.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(20, 148, 86, 20);
		contentPane.add(txtNombres);
		
		JLabel lblLugarDeNacimiento = new JLabel("Lugar de nacimiento");
		lblLugarDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLugarDeNacimiento.setBounds(159, 12, 145, 14);
		contentPane.add(lblLugarDeNacimiento);
		
		txtLugarNacimiento = new JTextField();
		txtLugarNacimiento.setColumns(10);
		txtLugarNacimiento.setBounds(169, 36, 86, 20);
		contentPane.add(txtLugarNacimiento);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaDeNacimiento.setBounds(159, 68, 145, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(169, 92, 86, 20);
		contentPane.add(txtFechaNacimiento);
		
		JLabel lblNotaDeGrado = new JLabel("Nota de grado");
		lblNotaDeGrado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNotaDeGrado.setBounds(159, 124, 145, 14);
		contentPane.add(lblNotaDeGrado);
		
		txtNotaGrado = new JTextField();
		txtNotaGrado.setText("0");
		txtNotaGrado.setColumns(10);
		txtNotaGrado.setBounds(169, 148, 86, 20);
		contentPane.add(txtNotaGrado);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				try {
					con = getConnection();
					ps = con.prepareStatement("INSERT INTO estudiantes (cedula, apellidos, nombres, lugar_nacimiento, fecha_nacimiento, nota_grado)"
							+ " VALUES (?, ?, ?, ?, ?, ?)");
					ps.setString(1, txtCedula.getText());
					ps.setString(2, txtApellidos.getText());
					ps.setString(3, txtNombres.getText());
					ps.setString(4, txtLugarNacimiento.getText());
					ps.setDate(5, Date.valueOf(txtFechaNacimiento.getText()));
					ps.setDouble(6, Double.valueOf(txtNotaGrado.getText()));
					
					ps.execute(); // Actualizar la tabla estudiantes
					JOptionPane.showMessageDialog(null, "Estudiante guardado con exito!");
					recargarTabla(0);
					borrarTextos();
					con.close();
				} catch (Exception ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, "Hubo un error, no se guardó");
				}
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(17, 193, 113, 23);
		contentPane.add(btnGuardar);

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnModificar.setEnabled(true);
					btnEliminar.setEnabled(true);
					recargarTabla(1);
				} catch (Exception ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, "No hubo registros con esa cedula");
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(159, 193, 110, 23);
		contentPane.add(btnBuscar);
		
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				try {
					con = getConnection();
					ps = con.prepareStatement("UPDATE estudiantes SET cedula = ?, apellidos = ?"
							+ ", nombres = ?, lugar_nacimiento = ?, fecha_nacimiento = ?, nota_grado = ?"
							+ " WHERE cedula = ?");
					ps.setString(1, txtCedula.getText());
					ps.setString(2, txtApellidos.getText());
					ps.setString(3, txtNombres.getText());
					ps.setString(4, txtLugarNacimiento.getText());
					ps.setDate(5, Date.valueOf(txtFechaNacimiento.getText()));
					ps.setDouble(6, Double.valueOf(txtNotaGrado.getText()));
					ps.setString(7, txtCedula.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Se modificó con éxito!");
					recargarTabla(0);
					con.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Hubo un error en la conexion");
				}
			}
		});
		btnModificar.setEnabled(false);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificar.setBounds(20, 239, 110, 23);
		contentPane.add(btnModificar);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				try {
					con = getConnection();
					int input = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el registro?");
					System.out.println(input);
					if(input == 0) {
						ps = con.prepareStatement("DELETE FROM estudiantes where cedula = ?");
						ps.setString(1, txtCedula.getText());
						ps.execute();
						borrarTextos();
						btnModificar.setEnabled(false);
						btnEliminar.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Se eliminó con éxito!");
						recargarTabla(0);
						con.close();
					}
				} catch (Exception ex) {
					
				}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(159, 239, 110, 23);
		contentPane.add(btnEliminar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarTextos();
				btnModificar.setEnabled(false);
				btnEliminar.setEnabled(false);
			}
		});
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNuevo.setBounds(159, 283, 110, 23);
		contentPane.add(btnNuevo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(336, 59, 689, 402);
		contentPane.add(scrollPane);
		
		tblDatos = new JTable();
		tblDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection con;
				int fila = tblDatos.getSelectedRow();
				String ced = tblDatos.getValueAt(fila, 0).toString();
				try {
					con = getConnection();
					ps = con.prepareStatement("SELECT * FROM estudiantes where cedula = '" + ced + "'" );
					// ps.setString(1, ced);
					rs = ps.executeQuery();
					while(rs.next()) {
						txtCedula.setText(rs.getString("cedula"));
						txtApellidos.setText(rs.getString("apellidos"));
						txtNombres.setText(rs.getString("nombres"));
						txtLugarNacimiento.setText(rs.getString("lugar_nacimiento"));
						txtFechaNacimiento.setText(rs.getDate("fecha_nacimiento").toString());
						txtNotaGrado.setText(String.valueOf(rs.getDouble("nota_grado")));
					}
					con.close();
					btnModificar.setEnabled(true);
					btnEliminar.setEnabled(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Hubo un error en la conexion");
				}
			}
		});
		scrollPane.setRowHeaderView(tblDatos);
		scrollPane.setViewportView(tblDatos);
		
		JLabel lblIngreseLaCedula = new JLabel("Ingrese la cedula a buscar:");
		lblIngreseLaCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseLaCedula.setBounds(410, 23, 172, 14);
		contentPane.add(lblIngreseLaCedula);
		
		txtBuscarCedula = new JTextField();
		txtBuscarCedula.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(txtBuscarCedula.getText().matches("")) {
					recargarTabla(0);
				}else {
					recargarTabla(2);
				}
			}
		});
		txtBuscarCedula.setColumns(10);
		txtBuscarCedula.setBounds(592, 21, 137, 20);
		contentPane.add(txtBuscarCedula);
		
		recargarTabla(0);
	}
	
	public void borrarTextos() {
		txtCedula.setText("");
		txtApellidos.setText("");
		txtNombres.setText("");
		txtLugarNacimiento.setText("");
		txtFechaNacimiento.setText("");
		txtNotaGrado.setText("0");
	}
	
	public void recargarTabla(int metodo) {
		Connection con;
		try {
			DefaultTableModel modelo = new DefaultTableModel() {
				// Bloquear columnas para no editar
				public boolean isCellEditable(int filas, int columnas) {
					return (!(columnas >= 0 && columnas <= 5 ));
				}
			};
			modelo.addColumn("Cedula");
			modelo.addColumn("Apellidos");
			modelo.addColumn("Nombres");
			modelo.addColumn("Lugar nacimiento");
			modelo.addColumn("Fecha nacimiento");
			modelo.addColumn("Nota grado");
			tblDatos.setModel(modelo);
			con = getConnection();
			ps = metodo == 0 ? con.prepareStatement("SELECT * FROM estudiantes") 
							 : (
						 		metodo == 1 ? con.prepareStatement("SELECT * FROM estudiantes where cedula = '" + txtCedula.getText() + "'") 
									 		: con.prepareStatement("SELECT * FROM estudiantes where cedula = '" + txtBuscarCedula.getText() + "'")
					 		   );
			rs = ps.executeQuery();
			ResultSetMetaData rstabla = (ResultSetMetaData) rs.getMetaData();
			int numCampos = rstabla.getColumnCount(); // Obtener cuantas columnas tiene la tabla
			System.out.println(numCampos);
			// Recorrer tabla estudiantes
			while(rs.next()) {
				if(metodo == 1) {
					txtApellidos.setText(rs.getString("apellidos"));
					txtNombres.setText(rs.getString("nombres"));
					txtLugarNacimiento.setText(rs.getString("lugar_nacimiento"));
					txtFechaNacimiento.setText(String.valueOf(rs.getString("fecha_nacimiento")));
					txtNotaGrado.setText(String.valueOf(rs.getDouble("nota_grado")));
					
				}
				Object [] filas = new Object[numCampos];
				for(int i = 0; i<numCampos; i++) {
					filas[i] = rs.getObject(i+1);
				}
				modelo.addRow(filas);
			}
			con.close();
		} catch (Exception ex) {
			
		}
	}
}
