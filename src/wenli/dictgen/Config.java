package wenli.dictgen;

/*
 * Dictionary SQL generator
 * Author: Wan Wenli Simon
 * Last updated: 14-11-2014
 */

public class Config {
	public static String PROJECT_DIR = "C:\\eclipse\\Eclipse4Starter\\workspace\\RD4";
	public static String OUT_SQL_FILE = "dictionary.sql";
	public static String JAVA_PATTERN = "dictionary\\.get\\((.+?)\\)";
	public static String XHTML_PATTERN = "dicon.dictionary\\[(.+?)\\]";
	public static String SQL_OPEN = "INSERT INTO s_dictionary_value (dict_seq, lang_seq, key, value) VALUES ('1', 1, '";

	// do not change variables below
	public static String JAVA_FILE = ".java";
	public static String XHTML_FILE = ".xhtml";
}
