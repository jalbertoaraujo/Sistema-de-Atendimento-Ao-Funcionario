package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Acesso extends JFrame {

	private JPanel contentPane;
	public static JTextField tfnomeatendenteacesso;
	public static JComboBox cbsetoratendenteacesso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual do Windows
					Acesso frame = new Acesso();
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
	public Acesso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Acesso.class.getResource("/Imagem/atendimento.png")));
		setTitle(" ACESSO ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 280, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null); // tela sempre no centro
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{56, 206, 0};
		gbl_contentPane.rowHeights = new int[]{45, 20, 20, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnAcessar = new JButton("ACESSAR");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tfnomeatendenteacesso.getText().equals("") || cbsetoratendenteacesso.getSelectedItem().equals("Informe Setor do Atendente")){
					JOptionPane.showMessageDialog(null, "Informe Todos os Campos");
				}else{
					Principal pri = new Principal();
					pri.setVisible(true);
					dispose();
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 153));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(null);
		
		JLabel lblAtendimento = new JLabel("ATENDIMENTO");
		lblAtendimento.setForeground(Color.WHITE);
		lblAtendimento.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAtendimento.setBounds(37, 11, 189, 23);
		panel.add(lblAtendimento);
		
		JLabel lblNome = new JLabel("NOME : ");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		contentPane.add(lblNome, gbc_lblNome);
		
		tfnomeatendenteacesso = new JTextField();
		tfnomeatendenteacesso.setToolTipText("Informe Nome do Atendente ");
		GridBagConstraints gbc_tfnomeatendenteacesso = new GridBagConstraints();
		gbc_tfnomeatendenteacesso.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfnomeatendenteacesso.anchor = GridBagConstraints.NORTH;
		gbc_tfnomeatendenteacesso.insets = new Insets(0, 0, 5, 0);
		gbc_tfnomeatendenteacesso.gridx = 1;
		gbc_tfnomeatendenteacesso.gridy = 1;
		contentPane.add(tfnomeatendenteacesso, gbc_tfnomeatendenteacesso);
		tfnomeatendenteacesso.setColumns(10);
		tfnomeatendenteacesso.setDocument(new UpperCaseDocument());
		
		JLabel lblSetor = new JLabel("SETOR :");
		GridBagConstraints gbc_lblSetor = new GridBagConstraints();
		gbc_lblSetor.anchor = GridBagConstraints.EAST;
		gbc_lblSetor.insets = new Insets(0, 0, 5, 5);
		gbc_lblSetor.gridx = 0;
		gbc_lblSetor.gridy = 2;
		contentPane.add(lblSetor, gbc_lblSetor);
		
		cbsetoratendenteacesso = new JComboBox();
		cbsetoratendenteacesso.setModel(new DefaultComboBoxModel(new String[] {"Informe Setor do Atendente", "DP", "OPERACIONAL"}));
		cbsetoratendenteacesso.setToolTipText("Informe Setor do Atendente");
		GridBagConstraints gbc_cbsetoratendenteacesso = new GridBagConstraints();
		gbc_cbsetoratendenteacesso.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbsetoratendenteacesso.anchor = GridBagConstraints.NORTH;
		gbc_cbsetoratendenteacesso.insets = new Insets(0, 0, 5, 0);
		gbc_cbsetoratendenteacesso.gridx = 1;
		gbc_cbsetoratendenteacesso.gridy = 2;
		contentPane.add(cbsetoratendenteacesso, gbc_cbsetoratendenteacesso);
		btnAcessar.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnAcessar = new GridBagConstraints();
		gbc_btnAcessar.gridwidth = 2;
		gbc_btnAcessar.anchor = GridBagConstraints.NORTH;
		gbc_btnAcessar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAcessar.gridx = 0;
		gbc_btnAcessar.gridy = 3;
		contentPane.add(btnAcessar, gbc_btnAcessar);
	}
}
