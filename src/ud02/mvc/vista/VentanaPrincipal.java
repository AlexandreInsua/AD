package ud02.mvc.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ud02.mvc.controlador.Coordinador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private Coordinador miCoordinador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatrnModeloVista = new JLabel("PATR\u00D3N MODELO VISTA CONTROLADOR");
		lblPatrnModeloVista.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPatrnModeloVista.setBounds(62, 23, 302, 31);
		contentPane.add(lblPatrnModeloVista);
		
		JTextPane txtpnEstaAplicacinPresenta = new JTextPane();
		txtpnEstaAplicacinPresenta.setText("Esta aplicaci\u00F3n presenta un exemplo pr\u00E1ctico do patr\u00F3n de dese\u00F3n MVC.\r\nA aplicaci\u00F3n permite rexistrar, actualizar, buscar e eliminar rexistros dunha t\u00E1boa Persoa. Tam\u00E9n son vinculados alg\u00FAn conceptos dos Patr\u00F3ns Value Object e Data Access Object.");
		txtpnEstaAplicacinPresenta.setBounds(72, 65, 283, 139);
		contentPane.add(txtpnEstaAplicacinPresenta);
		
		JLabel lblEscollaAOperacin = new JLabel("Escolla a operaci\u00F3n que desexa realizar");
		lblEscollaAOperacin.setBounds(62, 215, 246, 14);
		contentPane.add(lblEscollaAOperacin);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador = new Coordinador();
				miCoordinador.mostrarVentanaRegistro();
			}
		});
		btnNovo.setBounds(102, 240, 89, 23);
		contentPane.add(btnNovo);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador = new Coordinador();
				miCoordinador.mostrarVentanaConsulta();
			}
		});
		btnBuscar.setBounds(241, 240, 89, 23);
		contentPane.add(btnBuscar);
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		
	}
}
