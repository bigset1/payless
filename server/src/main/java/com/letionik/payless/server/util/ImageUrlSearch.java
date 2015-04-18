package com.letionik.payless.server.util;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

/**
 * @author Anton Nikulin
 * @since 4/19/15.
 */
public class ImageUrlSearch {

	private static final String KEY_CODE = "AIzaSyAh4eTit4TV-4NFRcC4013htBzdjgOJR2o";
	private static final String SE_ID = "012701134718858323306:oby2dr-7yee";

	public static String getImageUrl(String query) throws IOException {

		URL url = new URL("https://www.googleapis.com/customsearch/v1?key=" + KEY_CODE
				+ "&cx=" + SE_ID + "&q=" + query + "&searchType=image&fileType=jpg&imgSize=small&alt=json");
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(body);
		JsonNode itemsNode = rootNode.findValue("items");
		Iterator<JsonNode> iterator = itemsNode.iterator();

		String imageUrl = null;
		if(iterator.hasNext()) {
			JsonNode jsonNode = iterator.next();
			imageUrl = jsonNode.get("link").asText();
		}

		return imageUrl;
	}
}
