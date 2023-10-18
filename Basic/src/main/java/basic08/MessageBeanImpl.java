package basic08;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean{
	private String name;
	private int age;
	
	/* byType이 여기를 탐색한다 */
	private Outputter outputter;
	
	public MessageBeanImpl() {}
	public MessageBeanImpl(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	
	@Override
	public void sayHello() {
		String msg = name + "님~~ 이제 당신은 " + age +  "살 입니다.2";
		System.out.println(msg);
		
		// 파일로 출력이 되게끔
		try {
			outputter.output(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
