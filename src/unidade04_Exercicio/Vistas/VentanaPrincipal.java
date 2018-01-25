package unidade04_Exercicio.Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Point;
import java.awt.ComponentOrientation;
import javax.swing.border.EmptyBorder;

import unidade04_Exercicio.controlador.Controlador;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	Controlador controlador;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNeodatis = new JLabel("Neodatis");
		lblNeodatis.setHorizontalAlignment(SwingConstants.CENTER);
		lblNeodatis.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNeodatis, BorderLayout.NORTH);

		JTextPane txtpnAsdfasdf = new JTextPane();
		txtpnAsdfasdf.setBorder(new EmptyBorder(10, 10, 10, 10));
		txtpnAsdfasdf.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnAsdfasdf.setLocation(new Point(1, 1));
		txtpnAsdfasdf.setMargin(new Insets(10, 10, 10, 10));
		txtpnAsdfasdf.setFont(new Font("Tahoma", Font.ITALIC, 12));
		txtpnAsdfasdf.setBounds(new Rectangle(50, 50, 150, 150));
		txtpnAsdfasdf.setText(
				"Esta \u00E9 unha aplicaci\u00F3n que xestiona clientes, produtos e ventas usando a base de datos orientada a obxectos Neodatis.\r\n");
		frame.getContentPane().add(txtpnAsdfasdf, BorderLayout.CENTER);

		JPanel menuButtons = new JPanel();
		frame.getContentPane().add(menuButtons, BorderLayout.SOUTH);

		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Evento");
				controlador.mostrarVentanaClientes();
			}
		});
		menuButtons.add(btnClientes);

		JButton btnProductos = new JButton("Productos");
		menuButtons.add(btnProductos);

		JButton btnVentas = new JButton("Ventas");
		menuButtons.add(btnVentas);
	}

}
