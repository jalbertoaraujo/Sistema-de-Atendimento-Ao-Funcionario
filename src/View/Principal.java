package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



import javax.swing.table.TableRowSorter;






import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
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
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;

import Controler.DadosDBCadastro;



import Model.salvarAtendimento;





import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;

import javax.swing.JSeparator;






import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFormattedTextField;

import Uteis.ColorirTabela;
import Uteis.ExportarCsv;
import Uteis.ImpressaoJpanel;

import Model.ListarAtendimento;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Principal extends JFrame {

	private JPanel contentPane;
	public static JTextField tfhora;
	public static JTextField tfatendente;
	public static JTextField tfnomecol;
	public static JTextField tfmat;
	public static JTextField tfcpf;
	public static JTextField tfcontrato;
	public static JTextField tffone;
	public static JTextField tffone2;
	private JLabel lblDataAtendimento;
	public static JTextField tfdata;
	private JLabel lblSetorResponsvelDa;
	public static JTextField tfsetor;
	private JLabel lblPendncia;
	private JScrollPane scrollPane_1;
	public static JTable table;
	public static JTextField tfdatabusca;
	private JButton btnbuscar;
	public static JTextArea textArea;
	private ArrayList<DadosDBCadastro> RelatorioBD = new ArrayList<>();
	private JLabel label;
	public static JTextField tfsetoratendente;
	public static JTextField tfenviado;

	public ArrayList<DadosDBCadastro> getRelatorioBD() {
		return RelatorioBD;
	}

	public void setRelatorioBD(ArrayList<DadosDBCadastro> relatorioBD) {
		RelatorioBD = relatorioBD;
	}

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
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Imagem/atendimento.png")));
		setTitle(" SISTEMA DE ATENDIMENTO AO FUNCION\u00C1RIO");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1330, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblHoraDoAtendimento = new JLabel("Hora do Atendimento");
		lblHoraDoAtendimento.setBounds(10, 11, 112, 14);
		contentPane.add(lblHoraDoAtendimento);

		tfhora = new JTextField();
		tfhora.setBounds(118, 8, 52, 20);
		contentPane.add(tfhora);
		tfhora.setColumns(10);
		tfhora.setText(new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()))); // exibe
																										// hora
																										// atualizada
																										// do
																										// sistema
																										// ao
																										// salvar

		JLabel lblNomeAtendente = new JLabel("Nome Atendente");
		lblNomeAtendente.setBounds(357, 11, 96, 14);
		contentPane.add(lblNomeAtendente);

		tfatendente = new JTextField();
		tfatendente.setEditable(false);
		tfatendente.setFont(new Font("Tahoma", Font.PLAIN, 9));
		tfatendente.setBounds(444, 8, 86, 20);
		contentPane.add(tfatendente);
		tfatendente.setColumns(10);
		tfatendente.setText(Acesso.tfnomeatendenteacesso.getText());
		//tfatendente.setDocument(new UpperCaseDocument());

		JLabel lblNomeDoColaborador = new JLabel("Nome do Colaborador");
		lblNomeDoColaborador.setBounds(9, 54, 112, 14);
		contentPane.add(lblNomeDoColaborador);

		tfnomecol = new JTextField();
		tfnomecol.setBounds(123, 49, 312, 20);
		contentPane.add(tfnomecol);
		tfnomecol.setColumns(10);
		tfnomecol.setDocument(new UpperCaseDocument());

		JLabel lblMatriculaColaborador = new JLabel("Matricula Colaborador");
		lblMatriculaColaborador.setBounds(457, 51, 112, 14);
		contentPane.add(lblMatriculaColaborador);

		tfmat = new JTextField();
		tfmat.setBounds(572, 48, 86, 20);
		contentPane.add(tfmat);
		tfmat.setColumns(10);

		JLabel lblCpfColaborador = new JLabel("CPF Colaborador");
		lblCpfColaborador.setBounds(9, 109, 86, 14);
		contentPane.add(lblCpfColaborador);

		try {
			javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("###.###.###-##");
			tfcpf = new javax.swing.JFormattedTextField(mask);
		} catch (Exception e) {
		}
		tfcpf.setBounds(125, 106, 86, 20);
		contentPane.add(tfcpf);
		tfcpf.setColumns(10);

		JLabel lblContrato = new JLabel("Contrato");
		lblContrato.setBounds(9, 137, 46, 14);
		contentPane.add(lblContrato);

		tfcontrato = new JTextField();
		tfcontrato.setBounds(125, 134, 86, 20);
		contentPane.add(tfcontrato);
		tfcontrato.setColumns(10);
		tfcontrato.setDocument(new UpperCaseDocument());

		JLabel lblFone = new JLabel("Fones");
		lblFone.setBounds(9, 165, 34, 14);
		contentPane.add(lblFone);

		try {
			javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("(##) #####-####");
			tffone = new javax.swing.JFormattedTextField(mask);
		} catch (Exception e) {
		}
		tffone.setBounds(126, 162, 92, 20);
		contentPane.add(tffone);
		tffone.setColumns(10);

		lblDataAtendimento = new JLabel("Data Atendimento");
		lblDataAtendimento.setBounds(185, 11, 96, 14);
		contentPane.add(lblDataAtendimento);

		Date d = new Date();

		Locale local = new Locale("pt", "BR"); // Para internacionalizar a data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", local);
		tfdata = new JTextField();
		tfdata.setBounds(277, 8, 65, 20);
		contentPane.add(tfdata);
		tfdata.setColumns(10);
		tfdata.setText(sdf.format(d));

		lblSetorResponsvelDa = new JLabel("Setor Pend\u00EAncia");
		lblSetorResponsvelDa.setBounds(9, 83, 86, 14);
		contentPane.add(lblSetorResponsvelDa);

		tfsetor = new JTextField();
		tfsetor.setBounds(125, 78, 86, 20);
		contentPane.add(tfsetor);
		tfsetor.setColumns(10);
		tfsetor.setDocument(new UpperCaseDocument());

		lblPendncia = new JLabel("Pend\u00EAncia");
		lblPendncia.setBounds(10, 199, 58, 14);
		contentPane.add(lblPendncia);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 225, 645, 159);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		textArea.setDocument(new UpperCaseDocument());

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 412, 1304, 128);
		contentPane.add(scrollPane_1);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Principal2 frame = new Principal2();
				frame.setVisible(true);

				int indiceLinha = table.getSelectedRow();

				frame.tfhora.setText(table.getValueAt(indiceLinha, 1).toString());
				frame.tfdata.setText(table.getValueAt(indiceLinha, 2).toString());
				frame.tfatendente.setText(table.getValueAt(indiceLinha, 3).toString());
				frame.tfnomecol.setText(table.getValueAt(indiceLinha, 4).toString());
				frame.tfmat.setText(table.getValueAt(indiceLinha, 5).toString());
				frame.tfcpf.setText(table.getValueAt(indiceLinha, 6).toString());
				frame.tfcontrato.setText(table.getValueAt(indiceLinha, 7).toString());
				frame.tffone.setText(table.getValueAt(indiceLinha, 8).toString());
				frame.tffone2.setText(table.getValueAt(indiceLinha, 9).toString());
				frame.tfsetor.setText(table.getValueAt(indiceLinha, 10).toString());
				frame.textArea.setText(table.getValueAt(indiceLinha, 11).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00BA Atend.", "Hora", "Data", "Atendente", "Nome Colaborador", "Matr\u00EDcula", "CPF", "Contrato", "Fone", "Fone 2", "Setor", "Pend\u00EAncia", "Setor Atendente", "Enviado"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, true, true, true, true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(21);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(15);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(34);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(196);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(15);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(38);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(47);
		table.getColumnModel().getColumn(8).setResizable(false);
		table.getColumnModel().getColumn(8).setPreferredWidth(34);
		table.getColumnModel().getColumn(9).setResizable(false);
		table.getColumnModel().getColumn(9).setPreferredWidth(41);
		table.getColumnModel().getColumn(10).setResizable(false);
		table.getColumnModel().getColumn(10).setPreferredWidth(45);
		table.getColumnModel().getColumn(11).setResizable(false);
		table.getColumnModel().getColumn(12).setResizable(false);
		table.getColumnModel().getColumn(12).setPreferredWidth(90);
		table.getColumnModel().getColumn(13).setResizable(false);
		table.getColumnModel().getColumn(13).setPreferredWidth(15);

		// Permite que as ccolunas fiquem em ordem
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
				
		RowSorter<TableModel> sorter =
		new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		//
		
		scrollPane_1.setViewportView(table);

		table.getTableHeader().setReorderingAllowed(false);// manter menu da tabela fixo
		table.setDefaultRenderer(Object.class, new ColorirTabela());

		JButton btnsalvar = new JButton("Salvar Atendimento");
		btnsalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnsalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfhora.getText().equals("") || tfdata.getText().equals("") || tfatendente.getText().equals("")
						|| tfnomecol.getText().equals("") || tfmat.getText().equals("") || tfcpf.getText().equals("")
						|| tfcontrato.getText().equals("") || tffone.getText().equals("")
						|| tffone2.getText().equals("") || tfsetor.getText().equals("")
						|| textArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os Campos");
				} else {
					salvarAtendimento atend = new salvarAtendimento();
					atend.salvaatendimento();
					ListarAtendimento listaa = new ListarAtendimento();
					listaa.listaatendimento();
				}		
			}
		});
		btnsalvar.setBounds(510, 195, 148, 23);
		contentPane.add(btnsalvar);

		tfdatabusca = new JTextField();
		tfdatabusca.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfdatabusca.setBounds(1045, 360, 89, 20);
		contentPane.add(tfdatabusca);
		tfdatabusca.setColumns(10);
		String valor = tfdata.getText();
		tfdatabusca.setText(valor);

		btnbuscar = new JButton("Buscar Atendimento");
		btnbuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					

				ListarAtendimento list = new ListarAtendimento();
				list.listaatendimento();		
			}
		});
		btnbuscar.setBounds(1142, 357, 171, 23);
		contentPane.add(btnbuscar);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 36, 658, 3);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 395, 1324, 2);
		contentPane.add(separator_1);

		JLabel lblDataInicial = new JLabel("Buscar Data");
		lblDataInicial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataInicial.setBounds(958, 363, 79, 14);
		contentPane.add(lblDataInicial);
		String valor2 = tfdata.getText();

		try {
			javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("(##) #####-####");
			tffone2 = new javax.swing.JFormattedTextField(mask);
		} catch (Exception e) {
		}
		tffone2.setColumns(10);
		tffone2.setBounds(242, 163, 92, 20);
		contentPane.add(tffone2);

		label = new JLabel("/");
		label.setBounds(228, 164, 10, 19);
		contentPane.add(label);
		
		JButton btnBuscaPorNome = new JButton("Busca Por Nome");
		btnBuscaPorNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscaPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListarAtendimento listatend = new ListarAtendimento();
				listatend.listaatendimentopornome();
				
				
			}
		});
		btnBuscaPorNome.setBounds(315, 77, 123, 23);
		contentPane.add(btnBuscaPorNome);
		
		JButton btnExportarParaExcel = new JButton("EXPORTAR PARA EXCEL");
		btnExportarParaExcel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExportarParaExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ExportarCsv exportarCsv = new ExportarCsv();

				String caminhoCompleto = "C:/Atendimento/atendimento";
				String dt = tfdatabusca.getText();
				String data = dt.replace("/", "-");								
				
				List<DadosDBCadastro> lista = new ArrayList<DadosDBCadastro>();
				ListarAtendimento la = new ListarAtendimento();
				lista = la.listaatendimento();			
				
				
				if (!lista.isEmpty()) {
					
					boolean sucesso;

					try {
						
						sucesso = exportarCsv.exportarCsv(caminhoCompleto, lista, data);

						if (sucesso) {

							try {

								// Executa o excel
								Runtime.getRuntime().exec("cmd.exe /C start excel.exe " + caminhoCompleto+"_"+data);

							} catch (java.io.IOException e1) {

								JOptionPane.showMessageDialog(null,
										"Caminho do Arquivo esta errado, contate os Desenvolvedores " + e1,
										"Exportar tabela", JOptionPane.ERROR_MESSAGE);

							}

						}

					} catch (HeadlessException | IOException e2) {

						JOptionPane.showMessageDialog(null, "Erro, o arquivo já está aberto!\n " + e2,
								"Exportar Lançamento", JOptionPane.ERROR_MESSAGE);

					}
					
				} else {
								
					JOptionPane.showMessageDialog(null, "Lista vazia", "Erro", JOptionPane.ERROR_MESSAGE);
					
				}
		
			}
		});
		btnExportarParaExcel.setBounds(1102, 553, 214, 23);
		contentPane.add(btnExportarParaExcel);
				
						JLabel lblSac = new JLabel("S.A.F.");
						lblSac.setBounds(688, 11, 148, 73);
						contentPane.add(lblSac);
						lblSac.setForeground(new Color(0, 0, 139));
						lblSac.setFont(new Font("Tahoma", Font.BOLD, 50));
						
						JLabel lblDesenvolvidoPorJorge = new JLabel("Desenvolvido por Jorge Alberto");
						lblDesenvolvidoPorJorge.setFont(new Font("Tahoma", Font.BOLD, 9));
						lblDesenvolvidoPorJorge.setBounds(10, 542, 171, 14);
						contentPane.add(lblDesenvolvidoPorJorge);
						
						JLabel lblSetor = new JLabel("Setor");
						lblSetor.setBounds(542, 12, 34, 14);
						contentPane.add(lblSetor);
						
						tfsetoratendente = new JTextField();
						tfsetoratendente.setEditable(false);
						tfsetoratendente.setFont(new Font("Tahoma", Font.PLAIN, 9));
						tfsetoratendente.setBounds(572, 8, 86, 20);
						contentPane.add(tfsetoratendente);
						tfsetoratendente.setColumns(10);
						tfsetoratendente.setText(Acesso.cbsetoratendenteacesso.getSelectedItem().toString());
								
								JLabel lblServioDeAtendimento = new JLabel("SERVI\u00C7O DE ATENDIMENTO AO FUNCION\u00C1RIO");
								lblServioDeAtendimento.setBounds(686, 74, 529, 40);
								contentPane.add(lblServioDeAtendimento);
								lblServioDeAtendimento.setForeground(new Color(0, 51, 153));
								lblServioDeAtendimento.setFont(new Font("Times New Roman", Font.BOLD, 22));
								
								JLabel lblNewLabel_1 = new JLabel("----");
								lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/Imagem/atendimento.png")));
								lblNewLabel_1.setBounds(1084, 102, 233, 258);
								contentPane.add(lblNewLabel_1);
								
								tfenviado = new JTextField();
								tfenviado.setEditable(false);
								tfenviado.setFont(new Font("Tahoma", Font.BOLD, 11));
								tfenviado.setText("N\u00C3O");
								tfenviado.setBounds(572, 79, 86, 20);
								contentPane.add(tfenviado);
								tfenviado.setColumns(10);
								
								JLabel lblNewLabel = new JLabel("Enviado");
								lblNewLabel.setBounds(522, 83, 46, 14);
								contentPane.add(lblNewLabel);
						

	}
}
