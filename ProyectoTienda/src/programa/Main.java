package programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ventanas.Ayuda;
import ventanas.ConsultarProducto;
import ventanas.Descuento;
import ventanas.ModificarProducto;
import ventanas.MostrarProducto;
import ventanas.Obsequio;
import ventanas.Ventas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem mntmSalir;
	private JMenu mnSalir;
	private JMenuItem mntmAcercade;
	private JMenu mnAyuda;
	private JMenuItem mntmDescuento;
	private JMenuItem mntmObsequio;
	private JMenu mnConfiguracion;
	private JMenuItem mntmMostrarProductos;
	private JMenuItem mntmModificarProducto;
	private JMenuItem mntmConsultarProducto;
	private JMenu mnInventario;
	private JMenuItem mntmVenta;
	private JMenu mnVentas;
	private JMenuBar menuBar;
	
/*Declaramos todas la variables globales
 * para poder llamarlos desde las otras ventanas*/
	
	
	public static String baseLiquida = "Base Liquida"; 
	public static double baseLiquidaPrecio = 98.0;
	public static int baseLiquidaCantidad = 58;

	// Datos de la segunda Base
	public static String basePolvo = "Base en Polvo"; 
	public static double basePolvoPrecio = 85.5;
	public static int basePolvoCantidad = 45;
	// Datos de la tercera Base
	public static String baseUv = "Base con Protector UV"; 
	public static double baseUvPrecio = 102.4;
	public static int baseUvCantidad = 33;
	
	// Datos del primer labial
	public static String labialMate = "Labial Mate"; 
	public static double labialMatePrecio = 44.0;
	public static int labialMateCantidad = 104;

	// Datos del segundo labial
	public static String labialLiquido = "Labial Liquido"; 
	public static double labialLiquidoPrecio = 40.5;
	public static int labialLiquidoCantidad = 74;
	// Datos del tercer labial
	public static String labialBrillante = "Labial Brillante"; 
	public static double labialBrillantePrecio = 41.4;
	public static int labialBrillanteCantidad = 25;
	
	// Datos de la primera crema
	public static String cremaHidratante = "Crema Hidratante"; 
	public static double cremaHidrantePrecio = 124.45;
	public static int cremaHidratanteCantidad = 88;

	// Datos de la segunda Crema
	public static String cremaAntiarrugas = "Labial Liquido"; 
	public static double cremaAntiarrugasPrecio = 120.5;
	public static int cremaAntiarrugasCantidad = 74;
	// Datos de la tercera Crema
	public static String cremaBloqueador = "Labial Brillante"; 
	public static double cremaBloqueadorPrecio = 112.45;
	public static int cremaBloqueadoCantidad = 68;
	
	public static double ventasTotales = 0;
	public static int numeroVentas = 0;
	
	
	
	
	
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("ARUMA");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 371);
		setLocationRelativeTo(null);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVenta = new JMenuItem("Generar Venta");
		mntmVenta.addActionListener(this);
		mnVentas.add(mntmVenta);
		
		mnInventario = new JMenu("Inventario");
		menuBar.add(mnInventario);
		
		mntmConsultarProducto = new JMenuItem("Consultar Producto");
		mntmConsultarProducto.addActionListener(this);
		mnInventario.add(mntmConsultarProducto);
		
		mntmModificarProducto = new JMenuItem("Modificar Producto");
		mntmModificarProducto.addActionListener(this);
		mnInventario.add(mntmModificarProducto);
		
		mntmMostrarProductos = new JMenuItem("Mostrar Productos");
		mntmMostrarProductos.addActionListener(this);
		mnInventario.add(mntmMostrarProductos);
		
		mnConfiguracion = new JMenu("Configuracion");
		menuBar.add(mnConfiguracion);
		
		mntmObsequio = new JMenuItem("Obsequio");
		mntmObsequio.addActionListener(this);
		mnConfiguracion.add(mntmObsequio);
		
		mntmDescuento = new JMenuItem("Descuento");
		mntmDescuento.addActionListener(this);
		mnConfiguracion.add(mntmDescuento);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercade = new JMenuItem("Acerca de");
		mntmAcercade.addActionListener(this);
		mnAyuda.add(mntmAcercade);
		
		mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnSalir.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	
	
	/*Comenzamos a programar en el metodo principal la accion del usuario,
	 * al hacer click en cada menu item*/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mntmVenta) {
			actionPerformedMntmventa(e);
		} else if (e.getSource() == mntmConsultarProducto) {
			actionPerformedMntmConsultarProducto(e);
		} else if (e.getSource() == mntmModificarProducto) {
			actionPerformedMntmModificarProducto(e);
		} else if (e.getSource() == mntmMostrarProductos) {
			actionPerformedMntmMostraProductos(e);
		} else if (e.getSource() == mntmObsequio) {
			actionPerformedMntmObsequio(e);
		} else if (e.getSource() == mntmDescuento) {
			actionPerformedMntmDescuento(e);
		} else if (e.getSource() == mntmAcercade) {
			actionPerformedMntmAcerdade(e);
		} else {
			actionPerformedMntmSalir(e);
		}
	}
	
	/*Aqui se crean los metodos para llamar a las ventanas y con la opcion set visible true,
	 * para que se puedan visualizar*/
	
	public void actionPerformedMntmventa(ActionEvent e) {
		ventanas.Ventas a = new Ventas();
		a.setVisible(true);
	}
	
	public void actionPerformedMntmConsultarProducto(ActionEvent e) {
		ventanas.ConsultarProducto a = new ConsultarProducto();
		a.setVisible(true);
	}
	
	public void actionPerformedMntmModificarProducto(ActionEvent e) {
		ventanas.ModificarProducto a = new ModificarProducto();
		a.setVisible(true);
	}
	
	public void actionPerformedMntmMostraProductos(ActionEvent e) {
		ventanas.MostrarProducto a = new MostrarProducto();
		a.setVisible(true);
	}
	
	public void actionPerformedMntmObsequio(ActionEvent e) {
		ventanas.Obsequio a = new Obsequio();
		a.setVisible(true);
	}
	
	public void actionPerformedMntmDescuento(ActionEvent e) {
		ventanas.Descuento a = new Descuento();
		a.setVisible(true);
	}
	
	public void actionPerformedMntmAcerdade(ActionEvent e) {
		ventanas.Ayuda a = new Ayuda();
		a.setVisible(true);
	}
	
	public void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	
}
