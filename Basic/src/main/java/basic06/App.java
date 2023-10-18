package basic06;
/* 어노테이션으로 bean 생성한 예제*/
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static ApplicationContext ctx;
	
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("config/basic06_config.xml"); // 이제는 설정파일 불러들이는게 필요가 없음
		// ctx = new AnnotationConfigApplicationContext("basic06");
		
		MessageBean bean = ctx.getBean("msgKr", basic06.MessageBean.class);
		bean.sayHello();
		
		bean = ctx.getBean("messageBeanEn", basic06.MessageBean.class);
		bean.sayHello();
	}
}
