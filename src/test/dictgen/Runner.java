package test.dictgen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Runner {

	// extract all patterns from all files
	// combine them into one whole dictionary
	public Map<String, String> combineDict(String rootDir,
			Map<String, String> extensionPatternMap) throws IOException {
		FileWalker fileWalker = new FileWalker();
		ReaderIter readerIter = new ReaderIter();
		Map<String, String> finalDict = new HashMap<String, String>();
		List<File> allFiles = new ArrayList<File>();

		Iterator<Entry<String, String>> iter = extensionPatternMap.entrySet()
				.iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> pairs = iter.next();
			String extension = pairs.getKey();
			String pattern = pairs.getValue();

			allFiles.addAll(fileWalker.extractFiles(rootDir, extension));

			for (File file : allFiles) {
				Map<String, String> dict = readerIter.extractPattern(
						file.getAbsolutePath(), pattern);
				finalDict.putAll(dict);
			}
			iter.remove();
		}
		return finalDict;
	}

	public Map<String, String> processInputFile(String fileName, Map<String, String> map)
			throws IOException {
		ReaderIter readerIter = new ReaderIter();
		return readerIter.makeListToMap(readerIter.processInputFile(fileName), map);
	}

	public static void main(String[] args) throws IOException {
		Runner runner = new Runner();

		Map<String, String> finalDict = runner.combineDict(Config.PROJECT_DIR,
				Config.EXTENSION_PATTERN_MAP);

		runner.valuesPrinter(finalDict);
		SqlGen.sqlGenerator(finalDict, "1");
		SqlGen.sqlGenerator(
				runner.processInputFile(Config.INPUT_TRANSLATION_DIR, finalDict), "2");

		// print out keys

		// complete message
		System.out.println(Config.COMPLETE_MSG);
	}

	private void valuesPrinter(Map<String, String> map) {
		for (String key : map.values()) {
			System.out.println(key);
		}
	}
}
