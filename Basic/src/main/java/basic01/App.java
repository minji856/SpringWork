package basic01;

public class App {
	public static void main(String[] args) {
		MessageBean bean = new MessageBean();
		bean.sayHello("홍길동");
		/* 의존성이 높은 class. spring에 부적합 */
	}
}
