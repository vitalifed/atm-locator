package com.backbase.assignment.solution.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author VF85400
 *
 */
public class JsonRawResponseProcessor extends AbstractResponseProcessor {

	private static final Logger log = Logger.getLogger(JsonRawResponseProcessor.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String filterByCity(String inputJSON, String city) {
		try {
			List<Map> locations = readValue(inputJSON);
			Iterator<Map> it = locations.iterator();

			while (it.hasNext()) {
				Map<String, Map> address = it.next();
				if (city != null && city.length() > 0
						&& !city.trim().equalsIgnoreCase((String) address.get("address").get("city"))) {
					it.remove();
					continue;
				}
			}

			return writeValueAsString(locations);
		} catch (IOException e) {
			// Just ignore
			log.error(e.getMessage(), e);
		}

		return "";
	}

}
