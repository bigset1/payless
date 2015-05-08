package com.letionik.payless.server.util.product.details;

import com.letionik.payless.server.persistance.model.ProductBO;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Roman Kishchenko
 * @since 4/19/15
 */
public abstract class AbstractZakazUaProductDetailsProvider implements ProductDetailsProvider {

    protected abstract String getUrl();

    protected abstract String getBarcodePrefix();

    @Override
    public ProductBO provide(String barcode) throws Exception {
        ProductBO result = new ProductBO();
        result.setBarcode(barcode);
        String tenDigitsBarCode = StringUtils.leftPad(barcode, 14, '0');
        Document document = getDocument(getUrl() + tenDigitsBarCode);
        if (document == null) {
            document = getDocument(getUrl() + getBarcodePrefix() + tenDigitsBarCode);
        }
        if (document != null) {
            Element name = document.select(".product-details-info h1[itemprop=\"name\"]").first();
            if (name != null) {
                result.setName(name.text());
            }
            Elements productImage = document.select(".product-details-main-image a");
            if (productImage != null) {
                result.setImageUrl(productImage.attr("href"));
            }
            Elements tradeMarks = document.select(".product-details-info-tm");
            for (Element tm : tradeMarks) {
                Element h5 = tm.select("h5").first();
                if (h5 != null && h5.text().equals("Cтрана производитель")) {
                    String country = tm.children().select("div").first().text();
                    result.setCountry(StringUtils.chomp(country).trim());
                }

            }
        }

        return result;
    }

    protected Document getDocument(String url) {
        Document document = null;
        try {
            Connection connection = Jsoup.connect(url);
            document = connection.get();
        } catch (Exception e) {
            // Just ignore
        }

        return document;
    }
}
