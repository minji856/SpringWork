package basic08;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageBeanImpl implements MessageBean{
	private String name;
	private int age;
	
	private Outputter outputter;
	
	public MessageBeanImpl() {}
	public MessageBeanImpl(String name, int age) {
		this.name = name;
		this.age = age;
	}
//	가급적이면 생성자를 이용하기
//	@Autowired
//	public MessageBeanImpl(Outputter outputter) {
//		this.outputter = outputter;
//	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Autowired
	@Qualifier("out1")
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	
	@Override
	public void sayHello() {
		String msg = name + "님~~ 이제 당신은 " + age +  "살 입니다.3";
		System.out.println(msg);
		
		// 파일로 출력이 되게끔
		try {
			outputter.output(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
