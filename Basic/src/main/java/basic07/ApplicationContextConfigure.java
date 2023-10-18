package basic07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* 설정파일을 대신할 class. 어노테이션이 XML과 같은 역할은 한다
 * 가장 마지막에 저장된 내용만 파일에 입력됨 (En만 출력) */
@Configuration
public class ApplicationContextConfigure {
	/* 메서드이름은 id 랑 똑같은 역할 */
	@Bean
	public MessageBean getMessageKr() {
		MessageBeanKr kr = new MessageBeanKr();
		kr.setAge(20);
		kr.setName("신돌석");
		kr.setOutputter(output());
		return kr;
	}
	
	@Bean
	public MessageBean getMessageEn() {
		MessageBeanEn en = new MessageBeanEn();
		en.setAge(30);
		en.setName("Tom");
		en.setOutputter(output());
		return en;
	}
	
	@Bean
	public Outputter output() {
		FileOutputter f = new FileOutputter();
		f.setFilePath("c:\\temp\\out.txt");
		return f;
	}
}
