package br.com.lopes.util;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public final class EmailUtils {

	/**
	 * Validar o e-mail no formato com @ e .(ponto)	
	 * @param email
	 * @return
	 */
	public static boolean emailValido(String email) {
		
		Logger.getLogger(EmailUtils.class.getName()).info("Validar email: [" + email+']');
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher m = p.matcher(email);
		
		if (m.find()) {
			Logger.getLogger(EmailUtils.class.getName()).info("E-mail ["+email+"] válido");	
			return true;
		} else {
			System.out.println("O E-mail [" + email + "] é inválido");
			return false;
		}
	}
	
	
	/**
	 * Enviar e-mail com a conta do GMAIL
	 * @param destinatario
	 * @throws MessagingException
	 */
	public static void enviarEmail(String destinatario) throws MessagingException {
    	
    	final String username = "luis.augusto.lopes@gmail.com";
		final String password = "senha";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

        /** Ativa Debug para sessão */
        session.setDebug(true);

        try {

              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress("luis.augusto.lopes@gmail.com")); //Remetente

              //Destinatário(s) separado por vírgula
              Address[] toUser = InternetAddress.parse(destinatario);  

              message.setRecipients(Message.RecipientType.TO, toUser);
              message.setSubject("Enviando email com JavaMail");//Assunto
              message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
              /**Método para enviar a mensagem criada*/
              Transport.send(message);

        } catch (MessagingException e){
              throw e;
        }
  }
    	
}
