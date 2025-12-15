package login;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import programa.Main;
import login.Autenticacion;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Verificar extends JDialog  implements ActionListener{
	
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblClave;
	private JLabel lblUsuario;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Verificar dialog = new Verificar();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Verificar() {
		setTitle("Sistema de Seguridad");
		setBounds(100, 100, 414, 145);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 25, 103, 19);
		getContentPane().add(lblUsuario);
		
		lblClave = new JLabel("Clave");
		lblClave.setBounds(10, 55, 103, 19);
		getContentPane().add(lblClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(123, 24, 143, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(301, 23, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(301, 53, 89, 23);
		getContentPane().add(btnCancelar);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(123, 54, 143, 20);
		getContentPane().add(txtClave);

	}
	
	/*Se comienza a programar en el metodo principal*/
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		} else {
			actionPerformedBtnCancelar(e);
		}
		
	}
	
	// Generamos la variable nVeces para guardar los intentos de ingreso al sistema
	
	static int nVeces=0;
	
	
	// Programamos el boton Aceptar
	public void actionPerformedBtnAceptar(ActionEvent e) {
		//Declaramos Variables
		String usuario, clave;
		
		boolean validacion;
		//Entrada de datos
		usuario = txtUsuario.getText();
		clave = new String(txtClave.getPassword());
		 validacion = Autenticacion.verifica(usuario, clave);
		//Proceso de validacion
		
		
			if (validacion && nVeces < 3 ) {
				JOptionPane.showMessageDialog(null, "Bienvenido al sistema...", "Sistema de seguridad", JOptionPane.INFORMATION_MESSAGE);
				dispose();
				programa.Main i = new Main();
				i.setVisible(true);
			} else {
				nVeces++;
					if(nVeces == 3) {
						JOptionPane.showMessageDialog(null,"Salir del sistema", "Sistema de seguridad", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
				JOptionPane.showMessageDialog(null, "Usuario o clave no existe... tiene " + (3 - nVeces) + " oportunidades", "Sistema de seguridad", JOptionPane.INFORMATION_MESSAGE);
			}
	}
	
	public void actionPerformedBtnCancelar(ActionEvent e) {
		System.exit(0);
	}
}
