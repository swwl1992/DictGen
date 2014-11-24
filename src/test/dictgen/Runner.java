package test.dictgen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.api.GoogleAPI;
import com.google.api.GoogleAPIException;
import com.google.api.translate.Language;

public class Runner {
	
	// extract all patterns from all files
	// combine them into one whole dictionary
	public Map<String, String> combineDict(String rootDir, Map<String, String> extensionPatternMap) {
		FileWalker fileWalker = new FileWalker();
		ReaderIter readerIter = new ReaderIter();
		Map<String, String> finalDict = new HashMap<String, String>();
		List<File> allFiles = new ArrayList<File>();
		
		Iterator<Entry<String, String>> iter = extensionPatternMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> pairs = iter.next();
			String extension = pairs.getKey();
			String pattern = pairs.getValue();
			
			allFiles.addAll(fileWalker.extractFiles(rootDir, extension));
		
			for (File file : allFiles) {
				try {
					Map<String, String> dict = readerIter.extractPattern(file.getAbsolutePath(), pattern);
					finalDict.putAll(dict);
				} catch (IOException e) {
					System.out.print("run error");
					e.printStackTrace();
				}
			}
			iter.remove();
		}
		return finalDict;
	}

	public static void main(String[] args) throws GoogleAPIException, InterruptedException {
		Translator translator = new Translator();
		Runner runner = new Runner();
		
		GoogleAPI.setHttpReferrer(Config.HTTP_REFERRER);
		GoogleAPI.setKey(Config.API_KEY);
		Map<String, String> finalDict = runner.combineDict(Config.PROJECT_DIR, Config.EXTENSION_PATTERN_MAP);
		
		Iterator<Entry<String, Language>> iter = Config.KEY_LANGUAGE_MAP.entrySet().iterator();
		SqlGen.sqlGenerator(finalDict, "1");
		while (iter.hasNext()) {
			Entry<String, Language> pairs = iter.next();
			String langKey = pairs.getKey();
			Language language = pairs.getValue();
			translator.Translate(finalDict, langKey, language);
			iter.remove();
		}
	}
}
