package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ModificarProducto extends JDialog implements ActionListener{
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnCerrar;
	private JComboBox cmbModelo;
	private JComboBox cmbProducto;
	private JLabel lblCantidad;
	private JLabel lblPrecio;
	private JLabel lblModelo;
	private JLabel lblProducto;
	private JButton btnGuardar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarProducto dialog = new ModificarProducto();
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
	public ModificarProducto() {
		setBounds(100, 100, 450, 300);
		setTitle("Modificar Productos");
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
		txtPrecio.setBounds(99, 66, 140, 18);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(99, 91, 140, 18);
		getContentPane().add(txtCantidad);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(288, 44, 89, 23);
		getContentPane().add(btnCerrar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(288, 17, 89, 23);
		getContentPane().add(btnGuardar);

	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmbProducto) {
			actionPerformedCmbProducto(e);
		} else if (e.getSource() == cmbModelo) {
			cargarDatosProductos();
			
		} else if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		} else {
			actionPerformedBtnCerrar(e);
		}
		
	}
		/* Se crea el metodo combo producto que al seleccionar una producto,
		 * automaticamente jala los modelos en el combo modelo */
	public void actionPerformedCmbProducto(ActionEvent e) {
		String producto = (String) cmbProducto.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
		/* equals iguala el texto String para que sea Bases*/
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

	public void actionPerformedBtnGuardar(ActionEvent e) {
		
		String modelo = (String) cmbModelo.getSelectedItem();
	    double precio = Double.parseDouble(txtPrecio.getText());
	    int cantidad = Integer.parseInt(txtCantidad.getText());
	    
	    
	    
	    if (modelo.equals(programa.Main.baseLiquida)) {
	    	programa.Main.baseLiquidaPrecio = precio;
	        programa.Main.baseLiquidaCantidad = cantidad;
	    }
		
	}
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
		
	}

}


