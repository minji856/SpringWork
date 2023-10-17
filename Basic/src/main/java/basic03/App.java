package basic03;

public class App {
	public static void main(String[] args) {
		// Factory 버전
		MessageBeanFactory factory = MessageBeanFactory.newInstance(); // 공장의 위치를 알아냄
		MessageBean bean = factory.createMessage("kr");
		bean.sayHello("홍길동");
		
		bean = factory.createMessage("en");
		bean.sayHello("Tom");
	}
}
