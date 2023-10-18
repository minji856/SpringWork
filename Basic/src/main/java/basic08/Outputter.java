package basic08;

import java.io.IOException;

// 어떤 장치로 출력한 것인가를 상속받아서 쓸 수 있는 인터페이스
public interface Outputter {
	void output(String msg) throws IOException;
}
