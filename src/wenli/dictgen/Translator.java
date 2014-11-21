package wenli.dictgen;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.api.GoogleAPIException;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;

public class Translator {
	
	public void Translate(Map<String, String> dict, String langKey, Language language) throws GoogleAPIException, InterruptedException {
		Map<String, String> result = new HashMap<String, String>();
		result.putAll(dict);
		Iterator<Entry<String, String>> it = result.entrySet().iterator();
		
	    while (it.hasNext()) {
	        Map.Entry<String, String> pairs = it.next();
	        String translatedText = Translate.DEFAULT.execute(pairs.getValue(), Language.ENGLISH, language);
	        Thread.sleep(5);
	        System.out.println(SqlGen.sqlWrapper(langKey, pairs.getKey(), translatedText));
	    }
	}
}
