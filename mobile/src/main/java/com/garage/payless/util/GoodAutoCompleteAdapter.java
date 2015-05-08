package com.garage.payless.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.garage.payless.MainActivity;
import com.garage.payless.R;
import com.garage.payless.api.PayLessApi;
import com.garage.payless.api.ResponseCallback;
import com.letionik.payless.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виталий on 18.04.15.
 */
public class GoodAutoCompleteAdapter  extends BaseAdapter implements Filterable {

    private static final int MAX_RESULTS = 10;

    private final Context mContext;
    private List<String> mResults;
    List<String> productsNames = new ArrayList<String>();
    List<Product> products = new ArrayList<Product>();
    public static final PayLessApi payLessApi =
            RestProvider.getInstanse().create(PayLessApi.class);

    public GoodAutoCompleteAdapter(Context context) {
        mContext = context;
        mResults = new ArrayList<String>();
    }

    @Override
    public int getCount() {
        return mResults.size();
    }

    @Override
    public String getItem(int index) {
        return mResults.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private ResponseCallback responseCallbackProduct = new ResponseCallback() {
        @Override
        public void complete(Object response) {
            products = (List<Product>) response;
//            mContext.getApplicationContext().runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
            for (Product p : products) {
                productsNames.add(p.getName());
            }
//    }
//            });
        }

        @Override
        public void failed() {
            Toast.makeText(mContext, "failed", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.simple_dropdown_item_2line, parent, false);
        }
        String product = getItem(position);
        ((TextView) convertView.findViewById(R.id.text1)).setText(product);
        ((TextView) convertView.findViewById(R.id.text2)).setText(product);

        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    List<String> products = findProducts(mContext, constraint.toString());
                    // Assign the data to the FilterResults
                    filterResults.values = products;
                    filterResults.count = products.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    mResults = (List<String>) results.values;
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }};

        return filter;
    }

    /**
     * Returns a search result for the given book title.
     */
    private List<String> findProducts(Context context, String name) {
        // GoogleBooksService is a wrapper for the Google Books API
//        GoogleBooksService service = new GoogleBooksService (mContext, MAX_RESULTS);
//        return service.findProducts(bookTitle);
        if(!name.isEmpty()) {
            ServerRequest.getProductsByName(payLessApi, responseCallbackProduct, name);
        }
        return productsNames;
    }
}