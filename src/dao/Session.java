package dao;

import java.util.HashMap;

public class Session {
	private final static HashMap<String, Object> datas = new HashMap<String, Object>();
	
	public static HashMap<String, Object> getDatas() {
		return datas;
	}
	
	public static void setData(String key, Object value) {
		datas.put(key, value);
	}
	public static Object getData(String key) {
		return datas.get(key);
	}
}
