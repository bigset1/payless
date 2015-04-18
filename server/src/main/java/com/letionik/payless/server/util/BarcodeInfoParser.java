package com.letionik.payless.server.util;

import com.letionik.payless.model.Product;
import com.letionik.payless.server.persistance.model.ProductBO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class BarcodeInfoParser {
    private static final String DATABASE_SITE_URL = "http://www.ean13.info/";
    public static ProductBO getProduct(String barcode) throws IOException {
        Document doc = Jsoup.connect(DATABASE_SITE_URL + String.valueOf(barcode) + ".htm").get();

        String name = doc.select(".col_rght h1 span").get(0).text();
        if(name.equals("Товар не найден в базе данных")) return null;

        Elements elements = doc.select(".information");
        List<Element> children = elements.get(0).getElementsByTag("span");
        String country = children.get(1).text();
        String producer = children.get(2).getElementsByTag("a").get(0).text();
        String description = children.get(4).getElementsByTag("a").get(0).text();
        Elements imageElement = doc.select(".img_cont a");
        ProductBO result = new ProductBO();
        if(imageElement.size() > 0) {
            String imageUrl = DATABASE_SITE_URL + imageElement.get(0).attributes().get("href");
            result.setImageUrl(checkIsUndefined(imageUrl));
        }

        result.setCountry(checkIsUndefined(country));
        result.setName(checkIsUndefined(name));
        result.setBarcode(barcode);
        result.setDescription(checkIsUndefined(description));
        result.setProducer(checkIsUndefined(producer));
        return result;
    }

    private static String checkIsUndefined(String value){
        if(value.contains("Не определено")) return null;
        return value;
    }
}
