package factura;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField codigo;
	private JTextField descripcion;
	private JTextField precio;
	private JTextField impuesto;
	private JTextField cantidad;
	private JTable table;

	Datos datos = new Datos();
	DefaultTableModel model = new DefaultTableModel();
	private JTextField textSubtotal;
	private JTextField textIVA;
	private JTextField textTotal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(10, 11, 83, 14);
		contentPane.add(lblNewLabel);

		codigo = new JTextField();
		codigo.setBounds(123, 8, 86, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setBounds(10, 38, 83, 14);
		contentPane.add(lblNewLabel_1);

		descripcion = new JTextField();
		descripcion.setBounds(123, 35, 86, 20);
		contentPane.add(descripcion);
		descripcion.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Precio Venta");
		lblNewLabel_2.setBounds(10, 69, 83, 14);
		contentPane.add(lblNewLabel_2);

		precio = new JTextField();
		precio.setBounds(123, 66, 86, 20);
		contentPane.add(precio);
		precio.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Impuesto");
		lblNewLabel_3.setBounds(10, 94, 46, 14);
		contentPane.add(lblNewLabel_3);

		impuesto = new JTextField();
		impuesto.setBounds(123, 91, 86, 20);
		contentPane.add(impuesto);
		impuesto.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setBounds(10, 119, 46, 14);
		contentPane.add(lblNewLabel_4);

		cantidad = new JTextField();
		cantidad.setBounds(123, 122, 86, 20);
		contentPane.add(cantidad);
		cantidad.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 550, 150);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Cod");
		model.addColumn("Articulo");
		model.addColumn("Precio Venta");
		model.addColumn("Imp");
		model.addColumn("Cant");
		model.addColumn("Subtotal");
		model.addColumn("Iva");
		model.addColumn("Total");
		table.setModel(model);

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cod = codigo.getText();
				String desc = descripcion.getText();
				int cant = Integer.parseInt(cantidad.getText());
				int prec = Integer.parseInt(precio.getText());
				double imp = Double.parseDouble(impuesto.getText());

				Producto p = new Producto(cod, desc, cant, prec, imp);
				datos.adicionarRegistro(p);
				
				double granTotal = 0;
				double granIVA = 0;
				double aPagar=0;
				
				
				codigo.setText("");
				descripcion.setText("");
				cantidad.setText("");
				precio.setText("");
				impuesto.setText("");

				model.setRowCount(0);
				for (int i = 0; i < datos.tamano(); i++) {
					Object[] fila = { datos.obtenerPosicion(i).getCodigo(), datos.obtenerPosicion(i).getDescripcion(),
							datos.obtenerPosicion(i).getPrecioVenta(), datos.obtenerPosicion(i).getImpuesto(),
							datos.obtenerPosicion(i).getCantidad(), datos.obtenerPosicion(i).getSubtotal(),
							datos.obtenerPosicion(i).getIva(), datos.obtenerPosicion(i).getTotal() };
					model.addRow(fila);
					
					granTotal += p.getSubtotal();
					granIVA += p.getIva();
					aPagar += p.getTotal();
				}
				
				
				textSubtotal.setText(String.valueOf(Math.round(granTotal)));
				textIVA.setText(String.valueOf(Math.round(granIVA))); 
				textTotal.setText(String.valueOf(Math.round(aPagar)));
			}
		});

		btnNewButton.setBounds(274, 34, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Subtotal");
		lblNewLabel_5.setBounds(40, 315, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textSubtotal = new JTextField();
		textSubtotal.setBounds(106, 312, 103, 20);
		contentPane.add(textSubtotal);
		textSubtotal.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("IVA");
		lblNewLabel_6.setBounds(240, 315, 25, 14);
		contentPane.add(lblNewLabel_6);
		
		textIVA = new JTextField();
		textIVA.setBounds(274, 312, 86, 20);
		contentPane.add(textIVA);
		textIVA.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("A Pagar");
		lblNewLabel_7.setBounds(383, 315, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textTotal = new JTextField();
		textTotal.setBounds(439, 312, 86, 20);
		contentPane.add(textTotal);
		textTotal.setColumns(10);
	}
}
