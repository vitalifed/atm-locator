package com.backbase.assignment.solution.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

public class JsonResponseProcessor extends AbstractResponseProcessor {

	private static final Logger log = Logger.getLogger(JsonResponseProcessor.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String filterByCity(String inputJSON, String city) {
		try {
			List<Map> locations = readValue(inputJSON);
			Iterator<Map> it = locations.iterator();

			List resultList = new ArrayList<>();

			while (it.hasNext()) {
				Map<String, Map> address = it.next();
				if (city != null && city.length() > 0
						&& !city.trim().equalsIgnoreCase((String) address.get("address").get("city"))) {
					it.remove();
					continue;
				}
				// Remove useless data
				resultList.add(address.get("address").values().stream().filter(obj -> String.class.isInstance(obj))
						.collect(Collectors.toList()));
			}
			Map<String, List> results = new HashMap<>();
			results.put("data", resultList);

			return writeValueAsString(results);

		} catch (IOException e) {
			// Just ignore
			log.error(e.getMessage(), e);
		}

		return "";
	}

}
