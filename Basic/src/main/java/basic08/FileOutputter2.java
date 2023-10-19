package basic08;

import java.io.FileWriter;
import java.io.IOException;
/* 타입이 겹쳤을 때를 위해 2 만듬*/
public class FileOutputter2 implements Outputter {
	private String filePath;
	
	public void setFilePath(String path) { filePath = path; }
	
	@Override
	public void output(String msg) throws IOException {
		/*지금은 성능 따질 게 아니라 쉽게*/
		FileWriter writer = new FileWriter(filePath);
		writer.write(msg);
		writer.close();
	}
}
