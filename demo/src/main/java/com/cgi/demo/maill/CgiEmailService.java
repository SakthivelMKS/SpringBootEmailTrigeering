package com.cgi.demo.maill;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.cgi.demo.domain.Audit;

@Service
public class CgiEmailService {

	 private final TemplateEngine templateEngine;

	    private final JavaMailSender javaMailSender;
	    
	    @Value("${cgi.mail.recipient}") 
	    private String recipient;

	    public CgiEmailService(TemplateEngine templateEngine, JavaMailSender javaMailSender) {
	        this.templateEngine = templateEngine;
	        this.javaMailSender = javaMailSender;
	    }

	    public String sendMail(List<? extends Audit> audits) throws MessagingException {
	        Context context = new Context();
	        context.setVariable("audits", audits);
	        String process = templateEngine.process("welcome", context);
	        javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
	        helper.setSubject("Welcome Dear Production support ");
	        helper.setText(process, true);
	        helper.setTo(recipient);
	        javaMailSender.send(mimeMessage);
	        return "Sent";
	    }
}
