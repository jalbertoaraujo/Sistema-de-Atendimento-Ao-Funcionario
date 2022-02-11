package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;

import Model.ListarAtendimento;

import java.awt.Window.Type;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;

public class Relacao2 extends JFrame {

	private static final ListSelectionEvent ListSelectionEvent = null;
	private JPanel contentPane;
	public static JList listaemail;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual do Windows
					Relacao2 frame = new Relacao2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void MultiSelectionDemo() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Create the frame.
	 */
	public Relacao2() {
		setTitle(" RELA\u00C7\u00C2O DE E-MAILS");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 300, 244);
		contentPane.add(scrollPane);
		
		listaemail = new JList();		
		listaemail.setFont(new Font("Tahoma", Font.BOLD, 13));
		listaemail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String select = listaemail.getSelectedValuesList().toString();
				Principal2.tfemail.setText(select);
				
				String teste = Principal2.tfemail.getText();
				teste = teste.substring(1, teste.length() - 1);

				Principal2.tfemail.setText(teste);
				
			
			}
		});
		scrollPane.setViewportView(listaemail);
		
		JButton btnNewButton = new JButton("CADASTRAR NOVO E-MAIL \u00C0 LISTA");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Email frame = new Email();
				frame.setVisible(true);
			}
		});
		btnNewButton.setToolTipText("PARA INCLUIR NOVO E-MAIL \u00C0 LISTA");
		btnNewButton.setBounds(10, 288, 300, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 300, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		ListarAtendimento late = new ListarAtendimento();
		late.povoarlista();		
		
	}
}
