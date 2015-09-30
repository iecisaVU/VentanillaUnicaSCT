package mx.gob.sct.dgaf.util;

import java.io.File;
import java.io.IOException;

//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;



import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import mx.gob.sct.dgaf.controller.LoginController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EnviarCorreo {

	private static final Logger LOGVU = LoggerFactory.getLogger(EnviarCorreo.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private FilesBean filesBean;

	public EnviarCorreo() {
		LOGVU.debug("JavaMailSender inicializado por Spring !!");
	}

	public void enviarSolicitudRegistro(String from, String to,String subjetct, File archivo,
			     String contenidoHeader, String contenidoBody, String contenidoFooter) throws IOException {


		LOGVU.info("Inicia envio de e-mail !!");
		MimeMessage message = mailSender.createMimeMessage();
		String contenido = null;
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true,"UTF-8");
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subjetct);
			FileSystemResource file = new FileSystemResource(archivo);
			helper.addAttachment(file.getFilename(), file);
			contenido=contenidoHeader+contenidoBody+contenidoFooter;
			helper.setText("", contenido);
			helper.addInline("selloSCT", filesBean.getFileImgSello().getFile());	
			helper.addInline("logoSCT", filesBean.getFileImgSCT().getFile());
			mailSender.send(message);
			LOGVU.info("Envio correcto !!");
		} catch (MessagingException e) {
			throw new MailParseException(e);
		}
	}

}
