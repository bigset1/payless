package com.garage.payless.entity;

import com.letionik.payless.model.transport.ProductSearchResult;

import java.util.List;

/**
 * Created by Paryshkura Roman on 19.04.2015.
 */
public class ListProductEvent {
    private List<ProductSearchResult> productSearchResults;

    public ListProductEvent(List<ProductSearchResult> productSearchResults) {
        this.productSearchResults = productSearchResults;
    }

    public List<ProductSearchResult> getProductSearchResults() {
        return productSearchResults;
    }

    public void setProductSearchResults(List<ProductSearchResult> productSearchResults) {
        this.productSearchResults = productSearchResults;
    }
}
