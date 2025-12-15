package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import programa.Main;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class Ventas extends JDialog implements ActionListener {
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTextArea txtAreaResultado;
	private JScrollPane sclArea;
	private JButton btnCerrar;
	private JButton btnProcesar;
	private JComboBox cmbModelo;
	private JComboBox cmbProducto;
	private JLabel lblStock;
	private JLabel lblPrecio;
	private JLabel lblModelo;
	private JLabel lblProducto;
	private JLabel lblCantidad;
	private JTextField txtCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas dialog = new Ventas();
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
	public Ventas() {
		setTitle("Ventas");
		setBounds(100, 100, 585, 378);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setBounds(28, 28, 46, 14);
		getContentPane().add(lblProducto);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(28, 53, 46, 14);
		getContentPane().add(lblModelo);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(28, 78, 46, 14);
		getContentPane().add(lblPrecio);
		
		lblStock = new JLabel("Stock");
		lblStock.setBounds(28, 103, 76, 14);
		getContentPane().add(lblStock);
		
		cmbProducto = new JComboBox();
		cmbProducto.addActionListener(this);
		cmbProducto.setModel(new DefaultComboBoxModel(new String[] {"Bases", "Labiales", "Cremas", "Accesorios"}));
		cmbProducto.setBounds(142, 26, 163, 18);
		getContentPane().add(cmbProducto);
		
		cmbModelo = new JComboBox();
		cmbModelo.addActionListener(this);
		cmbModelo.setBounds(142, 51, 163, 18);
		getContentPane().add(cmbModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(142, 76, 163, 18);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(142, 101, 163, 18);
		getContentPane().add(txtStock);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(358, 28, 106, 28);
		getContentPane().add(btnProcesar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(358, 74, 106, 28);
		getContentPane().add(btnCerrar);
		
		sclArea = new JScrollPane();
		sclArea.setBounds(10, 158, 549, 170);
		getContentPane().add(sclArea);
		
		txtAreaResultado = new JTextArea();
		sclArea.setViewportView(txtAreaResultado);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(28, 128, 76, 14);
		getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(142, 125, 163, 18);
		getContentPane().add(txtCantidad);

	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		} else if (e.getSource() == cmbProducto) {
			cargarModelos();
		} else if (e.getSource() == cmbModelo) {
			cargarDatosProductos();
		} else {
			actionPerformedBtnProcesar(e);
		}
	}
	public void cargarModelos() {
		
		
		String producto = (String) cmbProducto.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
		cmbModelo.setModel(modelo);
		
		if(producto.equals("Bases")) {
			 modelo.addElement(Main.baseLiquida);
		     modelo.addElement(Main.basePolvo);
		     modelo.addElement(Main.baseUv);
		
		} else if (producto.equals("Labiales")) {
	        modelo.addElement("Labial Mate");
	        modelo.addElement("Labial Líquido");
	        modelo.addElement("Labial Brillante");
	    

	 	} else if (producto.equals("Cremas")) {
	        modelo.addElement("Hidratante");
	        modelo.addElement("Antiarrugas");
	        modelo.addElement("Bloqueador");
	   

	 	} else  {
	        modelo.addElement("Brochas");
	        modelo.addElement("Espejo");
	        modelo.addElement("Peine");
	        modelo.addElement("Rizadora");
	 	}
		
		
	}
	
	public void cargarDatosProductos() {
		
		String modelo = (String) cmbModelo.getSelectedItem();
		
		if (modelo.equals(Main.baseLiquida)) {
			txtPrecio.setText(String.valueOf(Main.baseLiquidaPrecio));
			txtStock.setText(String.valueOf(Main.baseLiquidaCantidad));
		} else if (modelo.equals(Main.basePolvo)) {
			txtPrecio.setText(String.valueOf(Main.basePolvoPrecio));
			txtStock.setText(String.valueOf(Main.basePolvoCantidad));
		} else if (modelo.equals(Main.baseUv)) {
			txtPrecio.setText(String.valueOf(Main.baseUvPrecio));
			txtStock.setText(String.valueOf(Main.baseUvCantidad));
		}
		
		
	}
	public void actionPerformedBtnProcesar(ActionEvent e) {
		//Declaramos Variables
		int cantidad, stock;
		double importeCompra, importeDescuento = 0, importePagar, importePrecio;
		String obsequio, modelo;
		
		//Entrada de datos
		modelo =(String) cmbModelo.getSelectedItem();
		cantidad = Integer.parseInt(txtCantidad.getText());
		importePrecio = Double.parseDouble(txtPrecio.getText());
		stock = Integer.parseInt(txtStock.getText());
		//Proceso de calculo
		if (stock >= cantidad && cantidad >0) {
				importeCompra = importePrecio *cantidad;
				// Calculamos el Descuento
				if(cantidad >= 1 && cantidad < 4) {
					 importeDescuento = ventanas.Descuento.valorBajo;
				} else if ( cantidad >= 4 && cantidad < 7) {
					importeDescuento = ventanas.Descuento.valorMedio;
				} else if (cantidad >= 7 && cantidad < 10) {
					importeDescuento = ventanas.Descuento.valorAlto;
				} else {
					importeDescuento = ventanas.Descuento.valorMaximo;
				}
				
				programa.Main.numeroVentas++;
				// Calculamos el importe a pagar
				
				importePagar = importeCompra - importeDescuento;
				
				programa.Main.ventasTotales = programa.Main.ventasTotales + importePagar;
				
				// Calculamos los obsequios que reciben segun la cantidad de venta
				
				if(cantidad == 1) {
					obsequio = ventanas.Obsequio.obsequioBajo;
				} else if(cantidad >= 2 && cantidad < 6) {
					obsequio = ventanas.Obsequio.obsequioMedio;
				} else {
					obsequio = ventanas.Obsequio.obsequioAlto;
				}
				
				//Actualizamos el stock general
					if (modelo.equals(programa.Main.baseLiquida)) {
						programa.Main.baseLiquidaCantidad = stock - cantidad;
					}else if (modelo.equals(programa.Main.basePolvo)) {
						programa.Main.basePolvoCantidad= stock - cantidad;
					}
				
					
					// Almacenamos los Las ventas totales
					if (programa.Main.numeroVentas >= 5) {
						JOptionPane.showMessageDialog(
							    this,
							    "Venta Nro. " + Main.numeroVentas + "\n\n"
							  + "Importe total general acumulado : S/. "
							  + String.format("%.2f", Main.ventasTotales),
							    "Avance de ventas",
							    JOptionPane.INFORMATION_MESSAGE
							);
					}
				
				//Salida de Datos
				txtAreaResultado.setText("==== ARUMA BOLETA DE VENTA ====" + "\n");
				txtAreaResultado.append("El importe de Compra es : " + importeCompra + "\n");
				txtAreaResultado.append("El importe Descuento es : " + importeDescuento + "\n");
				txtAreaResultado.append("El importe a pagar es : " + importePagar + "\n");
				txtAreaResultado.append("Los obsequios son : " + obsequio );
		
		
				//Limpieza de datos
				cmbProducto.setSelectedItem("Bases");
				cmbModelo.setSelectedItem(e);
				txtPrecio.setText("");
				txtStock.setText("");
				txtCantidad.setText("");
		
		} else {
			if(cantidad < 1) {
				JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida", "Alerta cantidad incorrecta ", JOptionPane.INFORMATION_MESSAGE);
		
				} else {
					JOptionPane.showMessageDialog(null, "La cantidad es mayor a nuestro stock", "Alerta de Stock ", JOptionPane.INFORMATION_MESSAGE);
				}
		}
}
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
		
	}
	
	
}
