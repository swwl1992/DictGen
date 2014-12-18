package test.dictgen;

import java.util.HashMap;
import java.util.Map;

/*
 * Dictionary SQL generator
 * Last updated: 27-11-2014
 */

public class Config {
	// do not change variables below
	public static String SQL_CLOSE = "');";
	public static String JAVA_FILE = ".java";
	public static String XHTML_FILE = ".xhtml";
	public static String COMPLETE_MSG = "Complete";

	// you may change the following variables
	public static String PROJECT_DIR = "C:\\eclipse\\Eclipse4Starter\\workspace\\EasyCarRental";
	public static String INPUT_TRANSLATION_DIR = "C:\\Users\\wan_w\\Documents\\assignments\\R&D3&4\\input.txt";
	public static String OUT_SQL_FILE = "dictionary.sql";
	public static String JAVA_PATTERN = "dictionary\\.get\\((.+?)\\)";
	public static String XHTML_PATTERN = "dicon.dictionary\\[(.+?)\\]";
	public static String SQL_OPEN = "INSERT INTO s_dictionary_value (dict_seq, lang_seq, key, value) VALUES ('1', ";

	public static final Map<String, String> EXTENSION_PATTERN_MAP;

	static {
		EXTENSION_PATTERN_MAP = new HashMap<String, String>();
		EXTENSION_PATTERN_MAP.put(JAVA_FILE, JAVA_PATTERN);
		EXTENSION_PATTERN_MAP.put(XHTML_FILE, XHTML_PATTERN);
	}
}
