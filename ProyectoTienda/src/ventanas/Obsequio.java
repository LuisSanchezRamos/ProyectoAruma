package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Obsequio extends JDialog implements ActionListener {
	public static String obsequioBajo = "3 Lapiceros";
	public static String obsequioMedio = "6 Lapiceros";
	public static String obsequioAlto = "10 Lapiceros";
	
	private JTextField txtRegaloBajo;
	private JTextField txtRegaloMedio;
	private JTextField txtRegaloAlto;
	private JButton btnCerrar;
	private JButton btnAceptar;
	private JLabel lblRegaloAlto;
	private JLabel lblRegaloMedio;
	private JLabel lblRegaloBajo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Obsequio dialog = new Obsequio();
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
	public Obsequio() {
		setTitle("Obsequios");
		setBounds(100, 100, 397, 148);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		lblRegaloBajo = new JLabel("1 Unidad");
		lblRegaloBajo.setBounds(10, 11, 86, 14);
		getContentPane().add(lblRegaloBajo);
		
		lblRegaloMedio = new JLabel("2 - 5 Unidades");
		lblRegaloMedio.setBounds(10, 43, 86, 14);
		getContentPane().add(lblRegaloMedio);
		
		lblRegaloAlto = new JLabel("6 a + Unidades");
		lblRegaloAlto.setBounds(10, 78, 86, 14);
		getContentPane().add(lblRegaloAlto);
		
		txtRegaloBajo = new JTextField(obsequioBajo);
		txtRegaloBajo.setBounds(106, 8, 128, 17);
		getContentPane().add(txtRegaloBajo);
		txtRegaloBajo.setColumns(10);
		
		txtRegaloMedio = new JTextField(obsequioMedio);
		txtRegaloMedio.setColumns(10);
		txtRegaloMedio.setBounds(106, 40, 128, 17);
		getContentPane().add(txtRegaloMedio);
		
		txtRegaloAlto = new JTextField(obsequioAlto);
		txtRegaloAlto.setColumns(10);
		txtRegaloAlto.setBounds(106, 76, 128, 17);
		getContentPane().add(txtRegaloAlto);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(277, 22, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(277, 56, 89, 23);
		getContentPane().add(btnCerrar);

	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}else {
			actionPerformedBtnCerrar(e);
		}
	}

	public void actionPerformedBtnAceptar(ActionEvent e) {
		
		//Entrada de Datos
		
		obsequioBajo = txtRegaloBajo.getText();
		obsequioMedio = txtRegaloMedio.getText();
		obsequioAlto = txtRegaloAlto.getText();
	}

	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

}
