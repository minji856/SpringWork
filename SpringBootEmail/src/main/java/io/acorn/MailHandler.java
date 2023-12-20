package io.acorn;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public class MailHandler {
	private JavaMailSender mailSender;
	private MimeMessage mimeMessage;
	private MimeMessageHelper mimeMessageHelper;
	
	public MailHandler(JavaMailSender mailSender) throws MessagingException {
		this.mailSender = mailSender;
		// MIME 타입으로 묶어주기 위한 포장지
		mimeMessage = mailSender.createMimeMessage();
		
		/**
		 * 포장을 도와주는 Helper
		 * @param true 첨부파일도 같이 보낼때. 문자는 false
		 */
		mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
	}
	
	// 생성자 안에 다 묶어도 되는데 필요한 메서드만 골라 쓸 때는 빼내기
	public void setFrom(String fromAddress) throws MessagingException {
		mimeMessageHelper.setFrom(fromAddress);
	}
	
	public void setTo(String toAddress) throws MessagingException {
		mimeMessageHelper.setTo(toAddress);	
	}
	
	public void setSubject(String subject) throws MessagingException {
		mimeMessageHelper.setSubject(subject);
	}
	
	public void setText(String text) throws MessagingException {
		mimeMessageHelper.setText(text);
	}
	
	// 최종적으로 메일 서버에 보낼 수 있는 메서드 send
	public void send() {
		mailSender.send(mimeMessage);
	}
}
