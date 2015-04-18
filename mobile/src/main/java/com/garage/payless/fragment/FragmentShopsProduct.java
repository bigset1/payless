package com.garage.payless.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.garage.payless.R;
import com.letionik.payless.model.transport.ProductSearchResult;

import java.util.List;

import de.greenrobot.event.EventBus;

public class FragmentShopsProduct extends Fragment {

    public static FragmentShopsProduct newInstance() {
        FragmentShopsProduct fragment = new FragmentShopsProduct();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentShopsProduct() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().registerSticky(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shops_product, container, false);
        return view;
    }

    public void onEventMainThread(List<ProductSearchResult> productSearchResults) {
        Toast.makeText(getActivity(), "" + productSearchResults.size(), Toast.LENGTH_SHORT).show();
    }
}
