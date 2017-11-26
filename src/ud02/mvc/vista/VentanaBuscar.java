package ud02.mvc.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ud02.mvc.controlador.Coordinador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
// import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaBuscar extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscar frame = new VentanaBuscar();
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
	public VentanaBuscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdministracinDePersoas = new JLabel("ADMINISTRACI\u00D3N DE PERSOAS");
		lblAdministracinDePersoas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdministracinDePersoas.setBounds(92, 21, 238, 28);
		contentPane.add(lblAdministracinDePersoas);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 68, 46, 14);
		contentPane.add(lblCdigo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 93, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblProfesin = new JLabel("Profesi\u00F3n:");
		lblProfesin.setBounds(10, 118, 66, 14);
		contentPane.add(lblProfesin);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(72, 65, 86, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		textNome = new JTextField();
		textNome.setEnabled(false);
		textNome.setBounds(72, 90, 161, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(72, 115, 161, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade: ");
		lblIdade.setBounds(244, 93, 46, 14);
		contentPane.add(lblIdade);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(300, 90, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(244, 118, 46, 14);
		contentPane.add(lblTelfono);
		
		textField_2 = new JTextField();
		textField_2.setBounds(300, 115, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnGardar = new JButton("Gardar");
		btnGardar.setEnabled(false);
		btnGardar.setBounds(10, 166, 89, 23);
		contentPane.add(btnGardar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(109, 166, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(208, 166, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(311, 166, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(172, 64, 58, 23);
		contentPane.add(btnOk);
		// setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, btnOk, lblNome, lblProfesin, textCodigo, textNome, lblAdministracinDePersoas, textField, lblIdade, textField_1, lblTelfono, textField_2, btnCancelar, btnGardar, lblCdigo, btnModificar, btnEliminar}));
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		
	}

}
