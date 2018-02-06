package io.ayoue.common.tools;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static Map<String, String> jsonStringToMap(String json) {
		Map<String, String> map = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			map = mapper.readValue(json, new TypeReference<HashMap<String, String>>(){});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
