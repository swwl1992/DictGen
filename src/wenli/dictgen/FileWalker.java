package wenli.dictgen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.api.GoogleAPIException;

public class FileWalker {
    private List<File> result;

	public void walk(String path, String extension) {
        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return;

        for (File f : list) {
            if (f.isDirectory()) {
                walk(f.getAbsolutePath(), extension);
            }
            else {
            	if(f.getName().contains(extension)) {
            		result.add(f.getAbsoluteFile());
            	}
            }
        }
    }

	public List<File> extractFiles(String path, String extension) {
		result = new ArrayList<File>();
		walk(path, extension);
		return result;
	}

	// so far it only prints to console
	// you may modify it such that it writes to files
	public void writeFile(String filename, Map<String, String> dict, String langKey) throws GoogleAPIException {
	}
}