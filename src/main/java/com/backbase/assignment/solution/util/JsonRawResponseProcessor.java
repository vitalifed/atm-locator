package com.backbase.assignment.solution.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author VF85400
 */
public class JsonRawResponseProcessor extends AbstractResponseProcessor {

    private static final Logger log = LogManager.getLogger(JsonRawResponseProcessor.class);

    @SuppressWarnings({"rawtypes", "unchecked"})
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
