package io.acorn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
	// 핵심클래스
	private final JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String fromAddress;
	
	@Override
	public void sendMail(MailDto mail) {
		try {
			MailHandler mailHandler = new MailHandler(mailSender);

			// 보내는 사람
			mailHandler.setFrom(fromAddress);
			// 받는 사람
			mailHandler.setTo(mail.getToAddress());
			mailHandler.setSubject(mail.getTitle());
			mailHandler.setText(mail.getContent());
			
			mailHandler.send();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
