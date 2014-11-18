package wenli.dictgen;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
	private static void run(String fileExt, String pattern) {
		FileWalker fw = new FileWalker();
		ReaderIter ri = new ReaderIter();
		List<File> files = fw.extractFiles(Config.PROJECT_DIR, fileExt);
		for (File file : files) {
			try {
				fw.writeFile(Config.OUT_SQL_FILE,
						ri.extractPattern(file.getAbsolutePath(), pattern));
			} catch (IOException e) {
				System.out.print("run error");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		run(Config.JAVA_FILE, Config.JAVA_PATTERN);
		run(Config.XHTML_FILE, Config.XHTML_PATTERN);
	}
}
