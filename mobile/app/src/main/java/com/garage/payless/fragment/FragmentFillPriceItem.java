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

public class FragmentFillPriceItem extends Fragment {
    private static final String BARCODE = "barcode";
    private TextView textView;
    private Spinner spinner;

    private String barcode;

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
        textView = (TextView) view.findViewById(R.id.textview_barcode);
        textView.setText(getString(R.string.barcode) + ": " + barcode);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        //TEST
        int size = 5;
        String array_spinner[] = new String[size];
        for (int i = 0; i < size; i++) {
            array_spinner[i] = "shop " + i;
        }
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, array_spinner);
        spinner.setAdapter(adapter);
        return view;
    }
}
