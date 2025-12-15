package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class ConsultarProducto extends JDialog implements ActionListener {
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnCerrar;
	private JComboBox cmbModelo;
	private JComboBox cmbProducto;
	private JLabel lblCantidad;
	private JLabel lblPrecio;
	private JLabel lblModelo;
	private JLabel lblProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarProducto dialog = new ConsultarProducto();
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
	public ConsultarProducto() {
		setTitle("Consulta de Productos");
		setBounds(100, 100, 415, 168);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setBounds(20, 21, 69, 14);
		getContentPane().add(lblProducto);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(20, 44, 46, 14);
		getContentPane().add(lblModelo);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(20, 69, 46, 14);
		getContentPane().add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(20, 94, 46, 14);
		getContentPane().add(lblCantidad);
		
		cmbProducto = new JComboBox();
		cmbProducto.addActionListener(this);
		cmbProducto.setModel(new DefaultComboBoxModel(new String[] {"Bases", "Labiales", "Cremas", "Accesorios"}));
		cmbProducto.setBounds(99, 17, 140, 18);
		getContentPane().add(cmbProducto);
		
		cmbModelo = new JComboBox();
		cmbModelo.addActionListener(this);
		cmbModelo.setBounds(99, 40, 140, 18);
		getContentPane().add(cmbModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(99, 66, 140, 18);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(99, 91, 140, 18);
		getContentPane().add(txtCantidad);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(288, 40, 89, 23);
		getContentPane().add(btnCerrar);

	}
	
	
/* === Comenzamos a Programas ===  */
	

	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCsCerrar (e);
		}else if (e.getSource() == cmbProducto) {
			cargarModelos();
		}else if (e.getSource() == cmbModelo) {
			cargarDatosProductos();
		}else {
			actionPerformedBtnCsCerrar(e);
		}
		
	}
	
	public void actionPerformedBtnCsCerrar(ActionEvent e) {
		dispose();
		
	}
	
	
	
	public void cargarModelos() {
		
		String producto = (String) cmbProducto.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
		
		 if (producto.equals("Bases")) {
		        modelo.addElement(programa.Main.baseLiquida);
		        modelo.addElement(programa.Main.basePolvo);
		        modelo.addElement(programa.Main.baseUv);
		    

		 	}else if (producto.equals("Labiales")) {
		        modelo.addElement("Labial Mate");
		        modelo.addElement("Labial Líquido");
		        modelo.addElement("Labial Brillante");
		    

		 	}else if (producto.equals("Cremas")) {
		        modelo.addElement("Hidratante");
		        modelo.addElement("Antiarrugas");
		        modelo.addElement("Bloqueador");
		   

		 	}else  {
		        modelo.addElement("Brochas");
		        modelo.addElement("Espejo");
		        modelo.addElement("Peine");
		        modelo.addElement("Rizadora");
		 	}

		    // Asignamos los modelos al combo
		    cmbModelo.setModel(modelo);

		
		}
	
	
	public void cargarDatosProductos () {
		
		String modelo = (String) cmbModelo.getSelectedItem();
		
		if (modelo.equals(programa.Main.baseLiquida)) {
			txtPrecio.setText(String.valueOf(programa.Main.baseLiquidaPrecio));
			txtCantidad.setText(String.valueOf(programa.Main.baseLiquidaCantidad));
		} else if (modelo.equals(programa.Main.basePolvo)) {
			txtPrecio.setText(String.valueOf(programa.Main.basePolvoPrecio));
			txtCantidad.setText(String.valueOf(programa.Main.basePolvoCantidad));
		} else if (modelo.equals(programa.Main.baseUv)) {
			txtPrecio.setText(String.valueOf(programa.Main.baseUvPrecio));
			txtCantidad.setText(String.valueOf(programa.Main.baseUvCantidad));
		}
		
		
	}
}

