package com.letionik.payless.server.util;

import com.letionik.payless.server.persistance.model.StoreBO;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
public class StoreParser {

	public static List<StoreBO> parseStores() throws IOException {
		List<StoreBO> storeList = new ArrayList<StoreBO>();

		String fileName = StoreParser.class.getClassLoader().getResource("store/stores.json").getFile();
		BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(fileReader);
		JsonNode resultsNode = rootNode.findValue("results");

        for (JsonNode storeNode : resultsNode) {
            double latitude = storeNode.findValue("lat").asDouble();
            double longitude = storeNode.findValue("lng").asDouble();
            String name = storeNode.findValue("name").asText();
            String address = storeNode.findValue("vicinity").asText();

            StoreBO store = new StoreBO();
            store.setName(name);
            store.setLocation(new double[]{longitude, latitude});
            store.setAddress(address);
            storeList.add(store);
        }
		return storeList;
	}

}
