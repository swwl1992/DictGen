package test.dictgen;

import java.util.HashMap;
import java.util.Map;

import com.google.api.translate.Language;

/*
 * Dictionary SQL generator
 * Last updated: 21-11-2014
 */

public class Config {
	// do not change variables below
	public static String SQL_CLOSE = "');";
	public static String JAVA_FILE = ".java";
	public static String XHTML_FILE = ".xhtml";
	
	// you may change the following variables
	public static String PROJECT_DIR = "C:\\Temp";
	public static String OUT_SQL_FILE = "dictionary.sql";
	public static String JAVA_PATTERN = "dictionary\\.get\\((.+?)\\)";
	public static String XHTML_PATTERN = "dicon.dictionary\\[(.+?)\\]";
	public static String SQL_OPEN = "INSERT INTO s_dictionary_value (dict_seq, lang_seq, key, value) VALUES ('1', ";
	public static String HTTP_REFERRER = "http://localhost";
	public static String API_KEY = "AIzaSyBSi85lxbAneavX4bdAK2axfqrAy2fKwRg";
	
	public static final Map<String, String> EXTENSION_PATTERN_MAP;
	public static final Map<String, Language> KEY_LANGUAGE_MAP;
	
	static {
		EXTENSION_PATTERN_MAP = new HashMap<String, String>();
		EXTENSION_PATTERN_MAP.put(JAVA_FILE, JAVA_PATTERN);
		EXTENSION_PATTERN_MAP.put(XHTML_FILE, XHTML_PATTERN);
	}
	static {
		KEY_LANGUAGE_MAP = new HashMap<String, Language>();
		KEY_LANGUAGE_MAP.put("2", Language.CHINESE_TRADITIONAL);
		KEY_LANGUAGE_MAP.put("3", Language.JAPANESE);
	}
}
