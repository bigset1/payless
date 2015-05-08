package com.letionik.payless.server.service.impl.product;

/**
* @author Roman Kishchenko
* @since 4/19/15
*/
class PriceItemKey {

    private String barcode;
    private String storeId;

    PriceItemKey(String barcode, String storeId) {
        this.barcode = barcode;
        this.storeId = storeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceItemKey that = (PriceItemKey) o;

        if (barcode != null ? !barcode.equals(that.barcode) : that.barcode != null) return false;
        if (storeId != null ? !storeId.equals(that.storeId) : that.storeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = barcode != null ? barcode.hashCode() : 0;
        result = 31 * result + (storeId != null ? storeId.hashCode() : 0);
        return result;
    }
}
