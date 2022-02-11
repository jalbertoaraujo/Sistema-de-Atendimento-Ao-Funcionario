package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import Controler.DadosDBCadastro;
import Uteis.EnviaEmail;
import Model.AlterarAtendimento;
import Model.ListarAtendimento;
import Model.salvarAtendimento;

import Uteis.ImpressaoJpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JSeparator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class Principal2 extends JFrame {

	private JPanel contentPane;
	public static JTextField tfhora;
	public static JTextField tfatendente;
	public static JTextField tfnomecol;
	public static JTextField tfmat;
	public static JTextField tfcpf;
	public static JTextField tfcontrato;
	public static JTextField tffone;
	private JLabel lblDataAtendimento;
	public static JTextField tfdata;
	private JLabel lblSetorResponsvelDa;
	public static JTextField tfsetor;
	private JLabel lblPendncia;
	public static JTextArea textArea;
	private ArrayList<DadosDBCadastro> RelatorioBD = new ArrayList<>();
	private JButton btnNewButton;
	public static JTextField tffone2;
	public static JTextField tfemail;
	private JButton btnNewButton_1;

	public ArrayList<DadosDBCadastro> getRelatorioBD() {
		return RelatorioBD;
	}

	public void setRelatorioBD(ArrayList<DadosDBCadastro> relatorioBD) {
		RelatorioBD = relatorioBD;
	}	
	

	// void imprimir(){
	// String imagem = "C://Teste.xls";
	// String Ruta = System.getProperty("user.dir") + "\\" + imagem;
	// File file = new File(Ruta);
	// JTable table = null;
	// ExportaExcel excel = new ExportaExcel(table,file,"Teste");
	// excel.export();
	// }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual
																									// do
																									// Windows
					Principal2 frame = new Principal2();
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
	public Principal2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal2.class.getResource("/Imagem/atendimento.png")));
		setTitle(" SISTEMA DE ATENDIMENTO AO FUNCION\u00C1RIO ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblHoraDoAtendimento = new JLabel("Hora do Atendimento");
		lblHoraDoAtendimento.setBounds(4, 61, 112, 14);
		contentPane.add(lblHoraDoAtendimento);

		tfhora = new JTextField();
		tfhora.setEditable(false);
		tfhora.setBounds(116, 58, 52, 20);
		contentPane.add(tfhora);
		tfhora.setColumns(10);
		// tfhora.setText(new SimpleDateFormat("HH:mm:ss").format(new
		// Date(System.currentTimeMillis()))); // exibe
		// hora
		// atualizada
		// do
		// sistema
		// ao
		// salvar

		JLabel lblNomeAtendente = new JLabel("Nome Atendente");
		lblNomeAtendente.setBounds(343, 61, 96, 14);
		contentPane.add(lblNomeAtendente);

		tfatendente = new JTextField();
		tfatendente.setEditable(false);
		tfatendente.setBounds(430, 58, 86, 20);
		contentPane.add(tfatendente);
		tfatendente.setColumns(10);
		tfatendente.setDocument(new UpperCaseDocument());

		JLabel lblNomeDoColaborador = new JLabel("Nome do Colaborador");
		lblNomeDoColaborador.setBounds(11, 106, 112, 14);
		contentPane.add(lblNomeDoColaborador);

		tfnomecol = new JTextField();
		tfnomecol.setEditable(false);
		tfnomecol.setBounds(130, 100, 386, 20);
		contentPane.add(tfnomecol);
		tfnomecol.setColumns(10);
		tfnomecol.setDocument(new UpperCaseDocument());

		JLabel lblMatriculaColaborador = new JLabel("Matricula Colaborador");
		lblMatriculaColaborador.setBounds(11, 134, 112, 14);
		contentPane.add(lblMatriculaColaborador);

		tfmat = new JTextField();
		tfmat.setEditable(false);
		tfmat.setBounds(130, 130, 92, 20);
		contentPane.add(tfmat);
		tfmat.setColumns(10);

		JLabel lblCpfColaborador = new JLabel("CPF Colaborador");
		lblCpfColaborador.setBounds(11, 164, 86, 14);
		contentPane.add(lblCpfColaborador);

		// try {
		// javax.swing.text.MaskFormatter mask = new
		// javax.swing.text.MaskFormatter("###.###.###-##");
		// tfcpf = new javax.swing.JFormattedTextField(mask);
		// } catch (Exception e) {
		// }
		tfcpf = new JTextField();
		tfcpf.setEditable(false);
		tfcpf.setBounds(130, 160, 92, 20);
		contentPane.add(tfcpf);
		tfcpf.setColumns(10);

		JLabel lblContrato = new JLabel("Contrato");
		lblContrato.setBounds(11, 194, 46, 14);
		contentPane.add(lblContrato);

		tfcontrato = new JTextField();
		tfcontrato.setEditable(false);
		tfcontrato.setBounds(130, 190, 92, 20);
		contentPane.add(tfcontrato);
		tfcontrato.setColumns(10);
		tfcontrato.setDocument(new UpperCaseDocument());

		JLabel lblFone = new JLabel("Fone 1");
		lblFone.setBounds(11, 225, 34, 14);
		contentPane.add(lblFone);

		// try {
		// javax.swing.text.MaskFormatter mask = new
		// javax.swing.text.MaskFormatter("(##) #####-####");
		// tffone = new javax.swing.JFormattedTextField(mask);
		// } catch (Exception e) {
		// }
		tffone = new JTextField();
		tffone.setEditable(false);
		tffone.setBounds(130, 220, 92, 20);
		contentPane.add(tffone);
		tffone.setColumns(10);

		lblDataAtendimento = new JLabel("Data Atendimento");
		lblDataAtendimento.setBounds(175, 61, 96, 14);
		contentPane.add(lblDataAtendimento);
		//
		// Date d = new Date();
		//
		// Locale local = new Locale("pt", "BR"); // Para internacionalizar a
		// data,
		// // colocar o codigo de cada país
		// // e o mesmo assume o formato.
		//
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", local);
		tfdata = new JTextField();
		tfdata.setEditable(false);
		tfdata.setBounds(269, 58, 65, 20);
		contentPane.add(tfdata);
		tfdata.setColumns(10);
		// tfdata.setText(sdf.format(d));

		lblSetorResponsvelDa = new JLabel("Setor Pend\u00EAncia");
		lblSetorResponsvelDa.setBounds(11, 284, 86, 14);
		contentPane.add(lblSetorResponsvelDa);

		tfsetor = new JTextField();
		tfsetor.setEditable(false);
		tfsetor.setBounds(130, 280, 92, 20);
		contentPane.add(tfsetor);
		tfsetor.setColumns(10);
		tfsetor.setDocument(new UpperCaseDocument());

		lblPendncia = new JLabel("Pend\u00EAncia");
		lblPendncia.setBounds(11, 313, 58, 14);
		contentPane.add(lblPendncia);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 330, 506, 159);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setDocument(new UpperCaseDocument());
		String valor = tfdata.getText();

		btnNewButton = new JButton("IMPRIMIR TELA DO ATENDIMENTO");
		btnNewButton.setToolTipText("Imprime Arquivo F\u00EDsico");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ImpressaoJpanel imp = new ImpressaoJpanel(contentPane);

				PrinterJob job = PrinterJob.getPrinterJob();
				job.setJobName(" DADOS ATENDIMENTO ");
				job.setPrintable(imp);
				boolean ok = job.printDialog();
				if (ok) {
					try {
						job.print();
					} catch (PrinterException ex) {
						/* The job did not successfully complete */
						JOptionPane.showMessageDialog(null, "Falha na impressão do documento!");
					}
				}

			}
		});
		btnNewButton.setBounds(291, 499, 225, 23);
		contentPane.add(btnNewButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(-4, 87, 530, 5);
		contentPane.add(separator);

		JLabel lblFone_1 = new JLabel("Fone 2");
		lblFone_1.setBounds(11, 256, 34, 14);
		contentPane.add(lblFone_1);

		tffone2 = new JTextField();
		tffone2.setEditable(false);
		tffone2.setColumns(10);
		tffone2.setBounds(130, 251, 92, 20);
		contentPane.add(tffone2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-4, 46, 535, 3);
		contentPane.add(separator_1);

		JLabel lblEmailDeDesdito = new JLabel("E-mail De Destino :");
		lblEmailDeDesdito.setBounds(4, 11, 96, 14);
		contentPane.add(lblEmailDeDesdito);

		tfemail = new JTextField();
		tfemail.setToolTipText("Preencher no M\u00E1ximo com 4 E-mails");
		tfemail.setBounds(113, 8, 403, 20);
		contentPane.add(tfemail);
		tfemail.setColumns(10);

		btnNewButton_1 = new JButton("ENVIAR E-MAIL");
		btnNewButton_1.setToolTipText("Favor Verificar o N\u00FAmero M\u00E1ximo De 4 E-Mails Para Enviar!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EnviaEmail env = new EnviaEmail();
				try {
					env.ConfiguraEmail();
					AlterarAtendimento alt = new AlterarAtendimento();
					alt.alteraratendimento();
					ListarAtendimento listaa = new ListarAtendimento();
					listaa.listaatendimento();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		btnNewButton_1.setBounds(8, 499, 263, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblObsPreencher = new JLabel("Obs : Preencher no M\u00E1ximo com 4 E-mails.");
		lblObsPreencher.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblObsPreencher.setBounds(116, 29, 247, 14);
		contentPane.add(lblObsPreencher);
		
		JLabel label = new JLabel("@");
		label.setForeground(Color.RED);
		label.setToolTipText("CLIQUE AQUI PARA ABRIR RELA\u00C7\u00C3O DE E-MAILS");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Relacao rel = new Relacao();
				rel.setVisible(true);
			}
		});
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(502, 25, 14, 20);
		contentPane.add(label);
		String valor2 = tfdata.getText();		
		
	}
}
