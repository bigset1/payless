package com.garage.payless.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.garage.payless.R;
import com.garage.payless.fragment.FragmentShopsProduct;
import com.letionik.payless.model.transport.ProductSearchResult;

import java.util.List;

/**
 * Created by Paryshkura Roman on 19.04.2015.
 */
public class AdapterShopsProduct extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<ProductSearchResult> productSearchResultList;
    private ShopChooseCallback shopChooseCallback;

    public AdapterShopsProduct(Context context, List<ProductSearchResult> productSearchResultList,
                               ShopChooseCallback shopChooseCallback) {
        this.context = context;
        this.shopChooseCallback = shopChooseCallback;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.productSearchResultList = productSearchResultList;
    }

    @Override
    public int getCount() {
        return productSearchResultList.size();
    }

    @Override
    public ProductSearchResult getItem(int position) {
        return productSearchResultList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.adapter_list_shops_product, null, false);
        }
        String distanseStr = String.format("%.2f", getItem(position).getDistance());
        String priceStr = String.format("%.2f", getItem(position).getPrice());
        ((TextView) view.findViewById(R.id.textview_shops)).setText(getItem(position).getStore().getBrand() + " " + distanseStr + "km");
        ((TextView) view.findViewById(R.id.textview_price)).setText("" + priceStr + " UAH");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopChooseCallback.selected(getItem(position).getStore().getLatitude(),
                        getItem(position).getStore().getLongitude());
            }
        });
        return view;
    }
}
