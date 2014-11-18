package wenli.dictgen;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FileWalker {
    private List<File> result;

	public void walk(String path, String extension) {
        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return;

        for (File f : list) {
            if (f.isDirectory()) {
                walk(f.getAbsolutePath(), extension);
                // System.out.println( "Dir:" + f.getAbsoluteFile() );
            }
            else {
                // System.out.println( "File:" + f.getAbsoluteFile() );
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
	public void writeFile(String filename, Map<String, String> dict) {
		sqlGenerator(dict);
	}

	private List<String> sqlGenerator(Map<String, String> dict) {
	    Iterator<Entry<String, String>> it = dict.entrySet().iterator();
	    List<String> sqls = new ArrayList<String>();
	    while (it.hasNext()) {
	        Map.Entry<String, String> pairs = it.next();
	        String sql = Config.SQL_OPEN + pairs.getKey() + "', '" +
	        		pairs.getValue() + "');";
	        System.out.println(sql);
	        sqls.add(sql);
	        it.remove(); // avoids a ConcurrentModificationException
	    }
		return sqls;
	}
}