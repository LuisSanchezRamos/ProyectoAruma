package ventanas;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Ayuda extends JDialog implements ActionListener {
	private JButton btnAceptar;
	private JLabel lblNombre3;
	private JLabel lblNombre2;
	private JLabel lblNombre1;
	private JLabel lblIntegrantes;
	private JLabel lblMarca;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayuda dialog = new Ayuda();
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
	public Ayuda() {
		setTitle("Acerca Deasdfkl");
		setBounds(100, 100, 492, 455);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		lblMarca = new JLabel("Aruma 1.0");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("Verdana", Font.BOLD, 30));
		lblMarca.setBounds(10, 11, 456, 76);
		getContentPane().add(lblMarca);
		
		lblIntegrantes = new JLabel("Integrantes:");
		lblIntegrantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntegrantes.setFont(new Font("Verdana", Font.BOLD, 19));
		lblIntegrantes.setBounds(10, 92, 456, 45);
		getContentPane().add(lblIntegrantes);
		
		lblNombre1 = new JLabel("Diana Diaz");
		lblNombre1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNombre1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre1.setBounds(10, 159, 456, 45);
		getContentPane().add(lblNombre1);
		
		lblNombre2 = new JLabel("Fabiola Pati\u00F1o");
		lblNombre2.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNombre2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre2.setBounds(10, 229, 456, 45);
		getContentPane().add(lblNombre2);
		
		lblNombre3 = new JLabel("Luis Sanchez");
		lblNombre3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre3.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNombre3.setBounds(10, 300, 456, 45);
		getContentPane().add(lblNombre3);
		
		btnAceptar = new JButton("Ok");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(198, 382, 89, 23);
		getContentPane().add(btnAceptar);

	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAceptar) {
			dispose();
		}
		
	}

}
