package wenli.dictgen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderIter {
	private Map<String, String> dict;

	public Map<String, String> extractPattern(String filename, String pattern)
			throws IOException {
		dict = new HashMap<String, String>();
		// The RE pattern
		Pattern patt = Pattern.compile(pattern);
		// A FileReader (see the I/O chapter)
		BufferedReader r = new BufferedReader(new FileReader(filename));

		// For each line of input, try matching in it.
		String line;
		while ((line = r.readLine()) != null) {
			// For each match in the line, extract and print it.
			Matcher m = patt.matcher(line);
			while (m.find()) {
				// Simplest method:
				// System.out.println(m.group(0));
				String innerStr = m.group(1);
				String key = innerStr.substring(1, innerStr.length() - 1);
				String val = capitalizeFirstChar(splitCamelCase(key));
				dict.put(key, val);
			}
		}
		return dict;
	}

	private String splitCamelCase(String s) {
		return s.replaceAll(
				String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])",
						"(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[^A-Za-z])"),
				" ").trim();
	}

	private String capitalizeFirstChar(String line) {
		return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}
}