package basic05;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean{
	private String name;
	private int age;
	private String greeting;
	
	/* 설정파일에 만들어 놓은 것을 자동적으로 주입 받을 수 있게 변수를 추가 */
	private Outputter outputter;
	
	
	public MessageBeanImpl() {}
	public MessageBeanImpl(String name, int age, String greeting) {
		this.name = name;
		this.age = age;
		this.greeting = greeting;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	
	@Override
	public void sayHello() {
		String msg = greeting + "!~~" + name + "님~~ 이제 당신은 " + age +  "살 입니다.";
		System.out.println(msg);
		
		// 파일로 출력이 되게끔
		try {
			outputter.output(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
