package basic03;

public class MessageBeanFactory {
	// 생성자 막아주기
	private MessageBeanFactory(){}
	private static MessageBeanFactory factory =
								new MessageBeanFactory();
	public static MessageBeanFactory newInstance() {
		return factory;
	}
	
	public MessageBean createMessage(String nation) {
		if(nation.equals("kr")) {
			return new MessageBeanKr();
		}
		else {
			return new MessageBeanEn();
		}
	}
}
