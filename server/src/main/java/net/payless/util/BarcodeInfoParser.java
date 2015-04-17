package net.payless.util;

import com.letionik.payless.model.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class BarcodeInfoParser {
    private static final String DATABASE_SITE_URL = "http://www.ean13.info/";
    public static Product getProduct(long barcode) throws IOException {
        Document doc = Jsoup.connect(DATABASE_SITE_URL + String.valueOf(barcode) + ".htm").get();

        String name = doc.select(".col_rght h1 span").get(0).text();
        if(name.equals("Товар не найден в базе данных")) return null;

        Elements elements = doc.select(".information");
        List<Element> children = elements.get(0).getElementsByTag("span");
        String country = children.get(1).text();
        String producer = children.get(2).getElementsByTag("a").get(0).text();
        String description = children.get(4).getElementsByTag("a").get(0).text();
        String imageUrl = DATABASE_SITE_URL+doc.select(".img_cont a").get(0).attributes().get("href");


        Product result = new Product();
        result.setCountry(checkIsUndefined(country));
        result.setName(checkIsUndefined(name));
        result.setBarcode(barcode);
        result.setDescription(checkIsUndefined(description));
        result.setImage(checkIsUndefined(imageUrl));
        result.setProducer(checkIsUndefined(producer));
        return result;
    }

    private static String checkIsUndefined(String value){
        if(value.contains("Не определено")) return null;
        return value;
    }
}
