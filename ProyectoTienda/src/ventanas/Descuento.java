package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Descuento extends JDialog implements ActionListener {
	public static double valorBajo = 5;
    public static double valorMedio = 10;
    public static double valorAlto = 15;
    public static double valorMaximo = 20;
	
	private JTextField txtDescuentoBajo;
	private JTextField txtDescuentoMedio;
	private JTextField txtDescuentoAlto;
	private JButton btnCerrar;
	private JButton btnAceptar;
	private JTextField txtDescuentoMaximo;
	private JLabel lblDescuentoMaximo;
	private JLabel lblDescuentoAlto;
	private JLabel lblDescuentoMedio;
	private JLabel lblDescuentoBajo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Descuento dialog = new Descuento();
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
	public Descuento() {
		setTitle("Descuentos");
		setBounds(100, 100, 415, 174);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		lblDescuentoBajo = new JLabel("1 a 3 Unidades");
		lblDescuentoBajo.setBounds(10, 11, 104, 14);
		getContentPane().add(lblDescuentoBajo);
		
		lblDescuentoMedio = new JLabel("4 a 6 Unidades");
		lblDescuentoMedio.setBounds(10, 38, 104, 14);
		getContentPane().add(lblDescuentoMedio);
		
		lblDescuentoAlto = new JLabel("7 a 9 Unidades");
		lblDescuentoAlto.setBounds(10, 63, 104, 14);
		getContentPane().add(lblDescuentoAlto);
		
		lblDescuentoMaximo = new JLabel("10 a + Unidades");
		lblDescuentoMaximo.setBounds(10, 88, 104, 14);
		getContentPane().add(lblDescuentoMaximo);
		
		txtDescuentoBajo = new JTextField(String.valueOf(valorBajo));
		txtDescuentoBajo.setBounds(139, 8, 112, 20);
		getContentPane().add(txtDescuentoBajo);
		txtDescuentoBajo.setColumns(10);
		
		txtDescuentoMedio = new JTextField(String.valueOf(valorMedio));
		txtDescuentoMedio.setColumns(10);
		txtDescuentoMedio.setBounds(139, 35, 112, 20);
		getContentPane().add(txtDescuentoMedio);
		
		txtDescuentoAlto = new JTextField(String.valueOf(valorAlto));
		txtDescuentoAlto.setColumns(10);
		txtDescuentoAlto.setBounds(139, 60, 112, 20);
		getContentPane().add(txtDescuentoAlto);
		
		txtDescuentoMaximo = new JTextField(String.valueOf(valorMaximo));
		txtDescuentoMaximo.setColumns(10);
		txtDescuentoMaximo.setBounds(139, 85, 112, 20);
		getContentPane().add(txtDescuentoMaximo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(285, 11, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(285, 59, 89, 23);
		getContentPane().add(btnCerrar);

	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		} else {
			actionPerformedBtnCerrar(e);
		}
	}
	
	
	public void actionPerformedBtnAceptar(ActionEvent e) {
		
		
	
		
		//Entrada de Datos
		valorBajo = Double.parseDouble(txtDescuentoBajo.getText());
        valorMedio = Double.parseDouble(txtDescuentoMedio.getText());
        valorAlto = Double.parseDouble(txtDescuentoAlto.getText());
        valorMaximo = Double.parseDouble(txtDescuentoMaximo.getText());
		
		
	
	}
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}


}
