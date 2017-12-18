package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import entidade.Funcionario;
import entidade.Usuario;
import implement.FuncionarioDAOImp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JPasswordField;

public class TelaDoSistema extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtCargo;
	private JTextField txtEmail;
	private JTextField txtUsu;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDoSistema frame = new TelaDoSistema();
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
	public TelaDoSistema() {
		setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 431);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 444, 382);
		contentPane.add(tabbedPane);
						
								JPanel logar = new JPanel();
								tabbedPane.addTab("Login", null, logar, null);
								logar.setLayout(null);
								
								JLabel login = new JLabel("Login:");
								login.setBounds(88, 129, 46, 14);
								logar.add(login);
								
								txtUsu = new JTextField();
								txtUsu.setBounds(162, 126, 86, 20);
								logar.add(txtUsu);
								txtUsu.setColumns(10);
								
								JLabel password = new JLabel("Password: ");
								password.setBounds(88, 176, 60, 14);
								logar.add(password);
								
								txtPassword = new JPasswordField();
								txtPassword.setBounds(162, 173, 86, 20);
								logar.add(txtPassword);
								
								JButton btnLogar = new JButton("Logar");
								btnLogar.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
									Usuario usu = new Usuario();
									usu.setUsuario(txtUsu.getText());
									usu.setSenha(txtPassword.getPassword().toString());
									if(new FuncionarioDAOImp().Check(usu)) {
								/*		cadastro.setVisible(true); */
									}
									}
								});
								btnLogar.setBounds(170, 258, 89, 23);
								logar.add(btnLogar);
				
						JPanel cadastro = new JPanel();
						tabbedPane.addTab("Cadastro", null, cadastro, null);
						cadastro.setLayout(null);
						
								JLabel nome = new JLabel("Nome:");
								nome.setBounds(10, 79, 72, 14);
								cadastro.add(nome);
								
										txtNome = new JTextField();
										txtNome.setBounds(131, 76, 86, 20);
										cadastro.add(txtNome);
										txtNome.setColumns(10);
										
												JLabel cpf = new JLabel("CPF :");
												cpf.setBounds(10, 104, 72, 14);
												cadastro.add(cpf);
												
														JLabel telefone = new JLabel("Telefone:");
														telefone.setBounds(10, 129, 72, 14);
														cadastro.add(telefone);
														
																JLabel endereco = new JLabel("Endere\u00E7o:");
																endereco.setBounds(10, 154, 72, 14);
																cadastro.add(endereco);
																
																		JLabel cargo = new JLabel("Cargo:");
																		cargo.setBounds(10, 179, 33, 14);
																		cadastro.add(cargo);
																		
																				txtCpf = new JTextField();
																				txtCpf.setBounds(131, 101, 86, 20);
																				cadastro.add(txtCpf);
																				txtCpf.setColumns(10);
																				
																						txtTelefone = new JTextField();
																						txtTelefone.setBounds(131, 126, 86, 20);
																						cadastro.add(txtTelefone);
																						txtTelefone.setColumns(10);
																						
																								txtEndereco = new JTextField();
																								txtEndereco.setBounds(131, 151, 86, 20);
																								cadastro.add(txtEndereco);
																								txtEndereco.setColumns(10);
																								
																										txtCargo = new JTextField();
																										txtCargo.setBounds(131, 176, 86, 20);
																										cadastro.add(txtCargo);
																										txtCargo.setColumns(10);
																										
																												JLabel lblCadastroDeFuncionrios = new JLabel("Cadastro de funcion\u00E1rios");
																												lblCadastroDeFuncionrios.setBounds(97, 24, 257, 20);
																												cadastro.add(lblCadastroDeFuncionrios);
																												lblCadastroDeFuncionrios.setFont(new Font("Calibri", Font.BOLD, 20));
																												lblCadastroDeFuncionrios.setForeground(Color.BLUE);
																												
																														JButton btnCadastrar = new JButton("Cadastrar");
																														btnCadastrar.setBounds(170, 255, 95, 23);
																														cadastro.add(btnCadastrar);
																														
																																txtEmail = new JTextField();
																																txtEmail.setBounds(131, 201, 86, 20);
																																cadastro.add(txtEmail);
																																txtEmail.setColumns(10);
																																
																																		JLabel email = new JLabel("Email:");
																																		email.setBounds(10, 204, 46, 14);
																																		cadastro.add(email);
																																										btnCadastrar.addActionListener(new ActionListener() {
																																											public void actionPerformed(ActionEvent arg0) {
																																												Funcionario func = new Funcionario();
																																												func.setNome(txtNome.getText());
																																												func.setCpf(txtCpf.getText());
																																												func.setTelefone(txtTelefone.getText());
																																												func.setEndereco(txtEndereco.getText());
																																												func.setCargo(txtCargo.getText());
																																												func.setEmail(txtEmail.getText());
																						

																																												if (new FuncionarioDAOImp().salvar(func)) {

																																													JOptionPane.showMessageDialog(null, "Dados gravados com sucesso");
																																												} else {
																																													JOptionPane.showMessageDialog(null, "Falha na gravação");
																																												}
																																											}
																																										});
	}
}
