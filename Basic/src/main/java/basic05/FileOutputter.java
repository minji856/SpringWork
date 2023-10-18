package basic05;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
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
