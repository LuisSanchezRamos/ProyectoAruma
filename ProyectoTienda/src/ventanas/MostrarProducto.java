package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class MostrarProducto extends JDialog implements ActionListener {
	private JButton btnCerrar;
	private JButton btnMostrar;
	private JTextArea txtAreaResultado;
	private JScrollPane sclArea;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarProducto dialog = new MostrarProducto();
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
	public MostrarProducto() {
		setTitle("Inventario General");
		setBounds(100, 100, 593, 421);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		sclArea = new JScrollPane();
		sclArea.setBounds(10, 11, 557, 326);
		getContentPane().add(sclArea);
		
		txtAreaResultado = new JTextArea();
		sclArea.setViewportView(txtAreaResultado);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(this);
		btnMostrar.setBounds(302, 348, 89, 23);
		getContentPane().add(btnMostrar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(169, 348, 89, 23);
		getContentPane().add(btnCerrar);

	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnMostrar) {
			actionPerformedBtnMostrar(e);
		} else {
			actionPerformedBtnCerrar(e);
		}	
		
	}
	
	
	public void actionPerformedBtnMostrar(ActionEvent e) {
		
		txtAreaResultado.setText("LISTADO DE BASES\n\n");
		txtAreaResultado.append("Producto    : " + programa.Main.baseLiquida + "\n");
		txtAreaResultado.append("Precio         : " + programa.Main.baseLiquidaPrecio + "\n");
		txtAreaResultado.append("Stock            : " + programa.Main.baseLiquidaCantidad  + "\n\n");
		
		txtAreaResultado.append("Producto     : " + programa.Main.basePolvo + "\n");
		txtAreaResultado.append("Precio         : " + programa.Main.basePolvoPrecio + "\n");
		txtAreaResultado.append("Stock            : " + programa.Main.basePolvoCantidad  + "\n\n");
		
		txtAreaResultado.append("Producto     : " + programa.Main.baseUv + "\n");
		txtAreaResultado.append("Precio         : " + programa.Main.baseUvPrecio + "\n");
		txtAreaResultado.append("Stock            : " + programa.Main.baseUvCantidad  + "\n\n");
		
		txtAreaResultado.append("LISTADO DE LABIALES\n\n");
		txtAreaResultado.append("Producto    : " + programa.Main.labialMate+ "\n");
		txtAreaResultado.append("Precio         : " + programa.Main.labialMatePrecio + "\n");
		txtAreaResultado.append("Stock            : " + programa.Main.labialMateCantidad  + "\n\n");
		
		txtAreaResultado.append("Producto     : " + programa.Main.labialLiquido + "\n");
		txtAreaResultado.append("Precio         : " + programa.Main.labialLiquidoPrecio + "\n");
		txtAreaResultado.append("Stock            : " + programa.Main.labialLiquidoCantidad  + "\n\n");
		
		txtAreaResultado.append("Producto     : " + programa.Main.labialBrillante + "\n");
		txtAreaResultado.append("Precio         : " + programa.Main.labialBrillantePrecio + "\n");
		txtAreaResultado.append("Stock            : " + programa.Main.labialBrillanteCantidad  + "\n\n");
		
		txtAreaResultado.append("LISTADO DE CREMAS\n\n");
		txtAreaResultado.append("Producto    : " + programa.Main.cremaHidratante+ "\n");
		txtAreaResultado.append("Precio         : " + programa.Main.cremaHidrantePrecio + "\n");
		txtAreaResultado.append("Stock            : " + programa.Main.cremaHidratanteCantidad  + "\n\n");
		
		txtAreaResultado.append("Producto     : " + programa.Main.cremaAntiarrugas + "\n");
		txtAreaResultado.append("Precio         : " + programa.Main.cremaAntiarrugasPrecio + "\n");
		txtAreaResultado.append("Stock            : " + programa.Main.cremaAntiarrugasCantidad  + "\n\n");
		
		txtAreaResultado.append("Producto     : " + programa.Main.cremaBloqueador + "\n");
		txtAreaResultado.append("Precio         : " + programa.Main.cremaBloqueadorPrecio + "\n");
		txtAreaResultado.append("Stock            : " + programa.Main.cremaBloqueadoCantidad  + "\n\n");
	}
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

}
