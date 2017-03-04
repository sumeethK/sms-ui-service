package com.sumeeth.webapp.util;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonUtil {

	private static final Logger log = Logger
			.getLogger(JsonUtil.class);

	public static Map<String, Object> getMapFormJson(
			String json) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		try {
			// convert JSON string to Map
			map = mapper
					.readValue(
							json,
							new TypeReference<Map<String, Object>>() {
							});

			log.debug("JSON to MAP Result : " + map);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;

	}
}