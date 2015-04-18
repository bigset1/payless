package com.garage.payless.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.garage.payless.R;
import com.garage.payless.api.PayLessApi;
import com.garage.payless.api.ResponseCallback;
import com.garage.payless.util.RestProvider;
import com.garage.payless.util.ServerRequest;
import com.letionik.payless.model.PriceItem;
import com.letionik.payless.model.Product;

public class FragmentFillPriceItem extends Fragment {
    private static final String BARCODE = "barcode";
    private TextView textViewBarcode, textViewProductName;
    private Spinner spinner;
    private String barcode;

    public static final PayLessApi payLessApi =
            RestProvider.getInstanse().create(PayLessApi.class);

    public static FragmentFillPriceItem newInstance(String barcode) {
        FragmentFillPriceItem fragment = new FragmentFillPriceItem();
        Bundle args = new Bundle();
        args.putString(BARCODE, barcode);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentFillPriceItem() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            barcode = getArguments().getString(BARCODE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fill_price_item, container, false);
        textViewBarcode = (TextView) view.findViewById(R.id.textview_barcode);
        textViewBarcode.setText(getString(R.string.barcode) + ": " + barcode);
        textViewProductName = (TextView) view.findViewById(R.id.textview_product_name);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        //TEST
        int size = 5;
        String array_spinner[] = new String[size];
        for (int i = 0; i < size; i++) {
            array_spinner[i] = "shop " + i;
        }
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, array_spinner);
        spinner.setAdapter(adapter);

        ServerRequest.getProduct(payLessApi, responseCallbackPriceItem, barcode);

        return view;
    }

    private ResponseCallback responseCallbackPriceItem = new ResponseCallback() {
        @Override
        public void complete(Object response) {
            final Product product = (Product)response;
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textViewProductName.setText(product.getName());
                }
            });
        }
    };
}
