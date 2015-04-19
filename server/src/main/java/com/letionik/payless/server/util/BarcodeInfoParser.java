package com.letionik.payless.server.util;

import com.letionik.payless.server.persistance.model.ProductBO;
import org.apache.commons.io.IOUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class BarcodeInfoParser {
	private static final String DATABASE_SITE_URL = "http://www.ean13.info/";
	//    public static ProductBO getProduct(String barcode) throws IOException {
	//        Document doc = Jsoup.connect(DATABASE_SITE_URL + String.valueOf(barcode) + ".htm").get();
	//
	//        String name = doc.select(".col_rght h1 span").get(0).text();
	//        if(name.equals("Товар не найден в базе данных")) return null;
	//
	//        Elements elements = doc.select(".information");
	//        List<Element> children = elements.get(0).getElementsByTag("span");
	//        String country = children.get(1).text();
	//        String producer = children.get(2).getElementsByTag("a").get(0).text();
	//        String description = children.get(4).getElementsByTag("a").get(0).text();
	//        Elements imageElement = doc.select(".img_cont a");
	//        ProductBO result = new ProductBO();
	//        if(imageElement.size() > 0) {
	//            String imageUrl = DATABASE_SITE_URL + imageElement.get(0).attributes().get("href");
	//            result.setImageUrl(checkIsUndefined(imageUrl));
	//        }
	//
	//        result.setCountry(checkIsUndefined(country));
	//        result.setName(checkIsUndefined(name));
	//        result.setBarcode(barcode);
	//        result.setDescription(checkIsUndefined(description));
	//        result.setProducer(checkIsUndefined(producer));
	//        return result;
	//    }

	public static ProductBO getProduct(String barcode) throws IOException, ParserConfigurationException, SAXException {

		URL url = new URL(DATABASE_SITE_URL + "/api.php?code=" + barcode + "&key=dfjreksalkjxvc3411");
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);

		ProductBO productBO = new ProductBO();
		productBO.setBarcode(barcode);

		if (body != null && !body.isEmpty() && !body.contains("no info")) {
			int nameStart = body.indexOf("<name>");
			int nameEnd = body.indexOf("</name>");
			String name = validateString(body.substring(nameStart + 6, nameEnd));
			productBO.setName(name);
            String imageUrl = null;
            try {
                imageUrl = ImageUrlSearch.getImageUrl(name);
            } catch (Exception e) {
                // Ignore
            }
			productBO.setImageUrl(imageUrl);

			int manStart = body.indexOf("<man>");
			int manEnd = body.indexOf("</man>");
			String man = validateString(body.substring(manStart + 5, manEnd));
			productBO.setProducer(man);

			int descStart = body.indexOf("<desc>");
			int descEnd = body.indexOf("</desc>");
			String desc = validateString(body.substring(descStart + 6, descEnd));
			productBO.setDescription(desc);
		}

		return productBO;
	}

	private static String validateString(String value) {
		if (value.contains("Не определено"))
			return null;
		return value.replace("&quot;", "\"").replace("&#34;", "'");
	}
}
