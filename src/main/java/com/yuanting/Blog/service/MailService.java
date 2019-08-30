package com.yuanting.Blog.service;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.yuanting.Blog.pojo.Role;

@Service
public class MailService {
	  
	@Autowired
	public JavaMailSender javaMailSender;
	
	public void sendEmail(String address) { 		 
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(address); 
		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");
		javaMailSender.send(msg);
	}
	
	/*
	public void sendEmailWithAttachment(String address) {
		 MimeMessage message = javaMailSender.createMimeMessage();
		 SimpleMailMessage msg = new SimpleMailMessage();
		   try{
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
				
			helper.setFrom(msg.getFrom());
			helper.setTo(msg.getTo());
			helper.setSubject(msg.getSubject());
			helper.setText(String.format(
					msg.getText(), dear, content));
				
			FileSystemResource file = new FileSystemResource("C:\\log.txt");
			helper.addAttachment(file.getFilename(), file);

		     }catch (MessagingException e) {
			throw new MailParseException(e);
		     }
		     mailSender.send(message);
	         }
	}
	*/

}
