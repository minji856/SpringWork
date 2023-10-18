/*생성자를 이용한 방법*/
package basic05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static ApplicationContext ctx ; 
	
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("config/basic05_config.xml");
		
		/* ctx.getBean("messageBean", MessageBeanImpl.class) 이렇게 해도 되긴 한다*/
		MessageBean bean = ctx.getBean("messageBean", MessageBean.class); // MessageBean 인터페이스로 가져옴
		bean.sayHello();		
	}
}
