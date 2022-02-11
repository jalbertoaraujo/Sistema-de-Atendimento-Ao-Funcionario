package Uteis;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import org.apache.commons.mail.Email;

import View.Principal2;

public class EnviaEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// configurando nossa mensagem
		try {
			ConfiguraEmail();
			System.out.print("Email-> Enviado com sucesso");
		} catch (MessagingException ex) {
			Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
			System.out.print("Erro ao enviar, verifique, senha, sua conexão e tente novamente");
		}
	}

	public static void ConfiguraEmail() throws MessagingException {
		
		String email = Principal2.tfemail.getText();
		String t1 = "\n----------------------------------------";		
		String t2 = "\nSERVIÇO DE ATENDIMENTO AO FUNCIONÁRIO";
		String t3 = "\n----------------------------------------";
		String t4 = "\n\n----------------------------------------";
		String hora = "  \n\nHORA DO ATENDIMENTO : "+Principal2.tfhora.getText();
		String data = "  \n\nDATA DO ATENDIMENTO : "+Principal2.tfdata.getText();
		String atendente = "  \n\nNOME DO ATENDENTE : "+Principal2.tfatendente.getText();
		String nome = "  \n\nNOME COLABORADOR : "+Principal2.tfnomecol.getText();
		String matricula = "  \n\nMATRÍCULA : "+Principal2.tfmat.getText();
		String cpf = "  \n\nCPF : "+Principal2.tfcpf.getText();
		String contrato = "  \n\nCONTRATO : "+Principal2.tfcontrato.getText();
		String fone = "  \n\nFONE : "+Principal2.tffone.getText();
		String fone2 = "  \n\nFONE 2 : "+Principal2.tffone2.getText();
		String setor = "  \n\nSETOR : "+Principal2.tfsetor.getText();
		String texto = "  \n\nPENDÊNCIA : "+Principal2.textArea.getText();
		
		
		// seta o servidor de email
		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.soll.eng.br");
		props.put("mail.smtp.auth", "false");
		// cria uma sessao com o servidor de email
		Session mailSession = Session.getDefaultInstance(props, null);
		// Mostra detalhes do envio da mensagem, quando (true)
		mailSession.setDebug(false);
		Message msg = new MimeMessage(mailSession);			
		// Subject = ASSUNTO
		msg.setSubject("NOVO SAF - "+nome);
		// FROM = de esta enviando //
		InternetAddress from = new InternetAddress("saf@soll.eng.br");
		msg.setFrom(from);
		// PARA QUEM recebe //
		Address[] address = InternetAddress.parse(email.trim().toLowerCase());	
		msg.setRecipients(Message.RecipientType.CC, address);		
		// conteudo
		msg.setContent(("SOLL - Serviços Obras e Locações  "+t1 + t2 +t3 + hora + data + atendente +t4 + nome + matricula + cpf + contrato + fone + fone2 + setor + texto ), "text/plain");		
		// Executa finalmente o envio!
		Transport.send(msg);			
		
		JOptionPane.showMessageDialog(null, "E-mail Enviado Com Sucesso !");
	}

	private static Level InternetAddress(String texto) {
		// TODO Auto-generated method stub
		return null;
	}

}
