package com.garage.payless.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.garage.payless.adapter.AdapterShopsProduct;
import com.garage.payless.FragmentHelper;
import com.garage.payless.MainActivity;
import com.garage.payless.R;
import com.garage.payless.adapter.ShopChooseCallback;
import com.garage.payless.entity.ListProductEvent;
import com.letionik.payless.model.Product;
import com.squareup.picasso.Picasso;

import de.greenrobot.event.EventBus;

public class FragmentShopsProduct extends Fragment implements ShopChooseCallback{
    private TextView tvProductName, tvProducer;
    private ImageView imgProduct;
    private ListView listviewShops;

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
        tvProductName = (TextView) view.findViewById(R.id.tv_product_name);
        tvProducer = (TextView) view.findViewById(R.id.tv_producer);
        imgProduct = (ImageView) view.findViewById(R.id.img_product);
        listviewShops = (ListView) view.findViewById(R.id.listview_shops);
        view.findViewById(R.id.button_scan_new).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHelper.add(getFragmentManager(), FragmentBarcodeScan.newInstance(),
                        MainActivity.FRAME_CONTAINER);
            }
        });
        return view;
    }

    public void onEventMainThread(ListProductEvent listProductEvent) {
        AdapterShopsProduct adapterShopsProduct = new AdapterShopsProduct(getActivity(),
                listProductEvent.getProductSearchResults(), this);
        listviewShops.setAdapter(adapterShopsProduct);
    }

    public void onEventMainThread(Product product) {
        String imageUrl = product.getImageUrl();
        if (!imageUrl.isEmpty()) {
            Picasso.with(getActivity()).load(imageUrl).into(imgProduct);
        }
        tvProductName.setText(product.getName());
        tvProducer.setText(product.getProducer());
    }

    @Override
    public void selected(double latitude, double longitude) {
        FragmentHelper.add(getFragmentManager(), FragmentShopInMap.newInstance(latitude, longitude, ""),
                MainActivity.FRAME_CONTAINER);
    }
}
