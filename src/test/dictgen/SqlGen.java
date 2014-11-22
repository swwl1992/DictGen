package test.dictgen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SqlGen {
	public static List<String> sqlGenerator(Map<String, String> finalDict, String langKey) {
	    Iterator<Entry<String, String>> it = finalDict.entrySet().iterator();
	    List<String> sqls = new ArrayList<String>();
	    while (it.hasNext()) {
	        Map.Entry<String, String> pairs = it.next();
	        String sql = sqlWrapper(langKey, pairs.getKey(), pairs.getValue());
	        System.out.println(sql);
	        sqls.add(sql);
	    }
		return sqls;
	}
	
	public static String sqlWrapper(String langKey, String key, String value) {
		 return Config.SQL_OPEN + langKey + ", '" + key + "', '" + value + Config.SQL_CLOSE;
	}
}
