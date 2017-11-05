package ud02.mvc.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ud02.mvc.controlador.Coordinador;
import ud02.mvc.vo.PersoaVo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaNuevo extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textProfesion;
	private JTextField textIdade;
	private JTextField textTelefono;

	private Coordinador miCoordinador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevo frame = new VentanaNuevo();
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
	public VentanaNuevo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRexistroDePersoas = new JLabel("REXISTRO DE PERSOAS");
		lblRexistroDePersoas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRexistroDePersoas.setBounds(137, 32, 182, 33);
		contentPane.add(lblRexistroDePersoas);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(25, 97, 46, 14);
		contentPane.add(lblCdigo);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(25, 122, 46, 14);
		contentPane.add(lblNome);

		JLabel lblProfesion = new JLabel("Profesion");
		lblProfesion.setBounds(25, 147, 46, 14);
		contentPane.add(lblProfesion);

		textCodigo = new JTextField();
		textCodigo.setBounds(81, 94, 86, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);

		textNome = new JTextField();
		textNome.setBounds(81, 119, 173, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textProfesion = new JTextField();
		textProfesion.setBounds(81, 144, 173, 20);
		contentPane.add(textProfesion);
		textProfesion.setColumns(10);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(289, 122, 46, 14);
		contentPane.add(lblIdade);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(289, 147, 46, 14);
		contentPane.add(lblTelfono);

		textIdade = new JTextField();
		textIdade.setBounds(338, 119, 86, 20);
		contentPane.add(textIdade);
		textIdade.setColumns(10);

		textTelefono = new JTextField();
		textTelefono.setBounds(338, 144, 86, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);

		JButton btnGardar = new JButton("Gardar");
		btnGardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// A secuencia orde vai ser
				// coordinador registrarPersona(PersoaVo miPersona)
				// Loxica validarRegistro(miPersona);
				// PersonaDAO inserirPersoa(PersoaVo miPersona)

				// ISTO TEN QUE SER INCORRECTO
				PersoaVo miPersona = new PersoaVo();
				miPersona.setIdPersoa(Integer.parseInt(textCodigo.getText()));
				miPersona.setNome(textNome.getText());
				miPersona.setProfesion(textProfesion.getText());
				miPersona.setIdade(Integer.parseInt(textIdade.getText()));
				miPersona.setTelefono(Integer.parseInt(textTelefono.getText()));

				miCoordinador.registrarPersona(miPersona);

			}
		});
		btnGardar.setBounds(111, 194, 89, 23);
		contentPane.add(btnGardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(257, 194, 89, 23);
		contentPane.add(btnCancelar);
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub

	}
}
