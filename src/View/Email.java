package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.ListarAtendimento;
import Model.salvarAtendimento;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Email extends JFrame {

	private JPanel contentPane;
	public static JTextField tfnumeroemail;
	public static JTextField tfemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual do Windows
					Email frame = new Email();
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
	public Email() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Email.class.getResource("/Imagem/atendimento.png")));
		setResizable(false);
		setTitle(" INSERIR NOVO E-MAIL ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 428, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNmero = new JLabel("N\u00FAmero : ");
		lblNmero.setBounds(10, 15, 58, 14);
		contentPane.add(lblNmero);
		
		tfnumeroemail = new JTextField();
		tfnumeroemail.setForeground(Color.RED);
		tfnumeroemail.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfnumeroemail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfnumeroemail.setEditable(false);
		tfnumeroemail.setBounds(78, 12, 86, 20);
		contentPane.add(tfnumeroemail);
		tfnumeroemail.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setBounds(10, 51, 46, 14);
		contentPane.add(lblEmail);
		
		tfemail = new JTextField();
		tfemail.setBounds(78, 48, 332, 20);
		contentPane.add(tfemail);
		tfemail.setColumns(10);
		
		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				salvarAtendimento sa = new salvarAtendimento();
				sa.salvaemail();
				ListarAtendimento la = new ListarAtendimento();
				la.retornanumero();
				
			}
		});
		btnNewButton.setBounds(78, 88, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCELAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tfemail.setText("");
			}
		});
		btnNewButton_1.setBounds(177, 88, 89, 23);
		contentPane.add(btnNewButton_1);
		
		ListarAtendimento la = new ListarAtendimento();
		la.retornanumero();
	}
}
