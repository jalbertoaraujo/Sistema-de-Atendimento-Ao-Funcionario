package Uteis;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import View.Principal;
import Controler.DadosDBCadastro;

public class ExportarCsv {

	public boolean exportarCsv(String caminhoCompleto,
			List<DadosDBCadastro> lista, String data) throws HeadlessException, IOException {

		File file = new File(caminhoCompleto.toString() + "_"+data+".csv");

		OutputStreamWriter bufferOut = null;

		boolean sucesso = false;

		try {

			bufferOut = new OutputStreamWriter(new FileOutputStream(file),
					StandardCharsets.ISO_8859_1);

			int contador = 1;

			bufferOut.write("iD" + ";" + "ID_ATENDIMENTO" + ";" + "HORA" + ";" + "DATA"
					+ ";" + "ATENDENTE" + ";" + "NOME COLABORADOR" + ";"
					+ "MATRICULA" + ";" + "CPF" + ";" + "CONTRATO" + ";"
					+ "FONE" + ";" + "FONE 2" + ";" + "SETOR" + ";"
					+ "PENDENCIA " + ";"
					+ "SETOR ATENDENTE\n");

			NumberFormat tresDigitos = new DecimalFormat("000");

			try {

				DateFormat formatBR = new SimpleDateFormat("dd/MM/YYYY");
				String dataBr = "";

				for (DadosDBCadastro ls : lista) {

					//dataBr = formatBR.format(ls//);

					String linha = tresDigitos.format(contador)
							+ ";" + ls.getId_atendimento() + ";" + ls.getHora()
							+ ";" + ls.getData() + ";" + ls.getAtendente()
							+ ";" + ls.getNomecol() + ";" + ls.getMatricula()
							+ ";" + ls.getCpf() + ";" + ls.getContrato() + ";"
							+ ls.getFone() + ";" + ls.getFone2() + ";"
							+ ls.getSetor() + ";"
							+ ls.getPendencia()  + ";" + ls.getSetoratendente().toUpperCase();

					bufferOut.write(linha + "\n");

					contador++;

				}

				sucesso = true;
				bufferOut.close();

			} catch (Exception e) {

				bufferOut.close();
				file.delete();
				return sucesso;

			}

			bufferOut.close();
			return sucesso;

		} catch (Exception f) {

			JOptionPane.showMessageDialog(null,
					"O arquivo está já está aberto!", "Exportar Lançamento",
					JOptionPane.ERROR_MESSAGE);

		}

		return sucesso;

	}

	/*
	 * public void exportarLog() throws HeadlessException, IOException {
	 * 
	 * String endereco = "C:/temp/log";
	 * 
	 * File arquivo = new File(endereco.toString() + ".csv");
	 * 
	 * OutputStreamWriter bufferOut = null;
	 * 
	 * try {
	 * 
	 * bufferOut = new OutputStreamWriter(new FileOutputStream(arquivo),
	 * StandardCharsets.ISO_8859_1);
	 * 
	 * int contador = 1;
	 * 
	 * bufferOut.write("iD" + ";" + "LOGADO" + ";" + "DESCRIÇÃO" + ";" +
	 * "DATA LOG" + ";" + "HORA LOG\n");
	 * 
	 * NumberFormat tresDigitos = new DecimalFormat("000");
	 * 
	 * try {
	 * 
	 * DateFormat formatBR = new SimpleDateFormat("dd/MM/YYYY"); String dataBr =
	 * "";
	 * 
	 * LogSegurancaController logSegurancaController = new
	 * LogSegurancaController(); List<LogSeguranca> listaLog = new
	 * ArrayList<LogSeguranca>(); listaLog = logSegurancaController.listaLog();
	 * 
	 * for (LogSeguranca log : listaLog) {
	 * 
	 * dataBr = formatBR.format(log.getDataLog());
	 * 
	 * String linha = tresDigitos.format(contador) + ";" + log.getLogado() + ";"
	 * + log.getDescricao() + ";" + dataBr + ";" + log.getHoraLog();
	 * 
	 * bufferOut.write(linha + "\n");
	 * 
	 * contador++;
	 * 
	 * }
	 * 
	 * Runtime.getRuntime().exec("cmd.exe /C start excel.exe " + arquivo);
	 * 
	 * bufferOut.close();
	 * 
	 * } catch (Exception e) {
	 * 
	 * bufferOut.close(); arquivo.delete();
	 * 
	 * }
	 * 
	 * bufferOut.close();
	 * 
	 * } catch (Exception f) {
	 * 
	 * JOptionPane.showMessageDialog(null, "O arquivo está já está aberto!",
	 * "Exportar Log", JOptionPane.ERROR_MESSAGE);
	 * 
	 * }
	 * 
	 * }
	 */

}
