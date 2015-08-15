package com.garage.payless.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.garage.payless.FragmentHelper;
import com.garage.payless.MainActivity;
import com.garage.payless.R;
import com.garage.payless.api.RetrofitCallback;
import com.garage.payless.entity.ListProductEvent;
import com.garage.payless.entity.LocationEvent;
import com.garage.payless.util.NetworkHelper;
import com.garage.payless.util.SharedPreferencesHelper;
import com.google.android.gms.maps.model.LatLng;
import com.letionik.payless.model.Product;
import com.letionik.payless.model.Store;
import com.letionik.payless.model.transport.PriceItemDTO;
import com.letionik.payless.model.transport.ProductSearchResult;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.greenrobot.event.EventBus;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FragmentFillPriceItem extends Fragment implements View.OnClickListener {

    private static final double DEFAULT_RADIUS = 1;
    private static final String BARCODE = "barcode";
    
    private TextView textViewBarcode, textViewProductName, textViewProducer;
    private Spinner spinner;
    private EditText editTextPrice;
    private String barcode;
    private ProgressDialog progressDialog;
    private ImageView imgProduct;
    private List<Store> storeList;
    private Product product;
    
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
        textViewBarcode = (TextView) view.findViewById(R.id.tv_barcode);
        textViewBarcode.setText(getString(R.string.barcode) + ": " + barcode);
        textViewProductName = (TextView) view.findViewById(R.id.tv_product_name);
        textViewProducer = (TextView) view.findViewById(R.id.tv_producer);
        view.findViewById(R.id.btn_submit_price).setOnClickListener(this);
        editTextPrice = (EditText) view.findViewById(R.id.et_price);
        imgProduct = (ImageView) view.findViewById(R.id.img_product);

        spinner = (Spinner) view.findViewById(R.id.spinner_closest_store);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...Please wait");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        LatLng latLng = SharedPreferencesHelper.retreiveLatLng(getActivity());
//        latLng.longitude = 30.5150145
//        latLng.latitude = 50.4396704
        progressDialog.show();
        NetworkHelper.payLessApi.getStores(latLng.latitude, latLng.longitude, DEFAULT_RADIUS, retrofitCallbackStores);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    private RetrofitCallback<List<ProductSearchResult>> retrofitCallbackShopsProduct =
            new RetrofitCallback<List<ProductSearchResult>>(getActivity()) {
        @Override
        public void success(List<ProductSearchResult> productSearchResults, Response response) {
            EventBus.getDefault().postSticky(new ListProductEvent(productSearchResults));
            EventBus.getDefault().postSticky(product);
            FragmentHelper.add(getFragmentManager(), FragmentShopsProduct.newInstance(),
                    MainActivity.FRAME_CONTAINER);
        }
    };
    
    private RetrofitCallback<Product> retrofitCallbackProduct = new RetrofitCallback<Product>(getActivity()) {
        @Override
        public void success(final Product product, Response response) {
            FragmentFillPriceItem.this.product = product;

            String productName = product.getName();
            if(productName != null) {
                textViewProductName.setText(product.getName());
                textViewProducer.setText(product.getProducer());
                String imageUrl = product.getImageUrl();
                if (imageUrl != null && !imageUrl.isEmpty()){
                    Picasso.with(getActivity()).load(imageUrl).into(imgProduct);
                }
            } else {
                textViewProductName.setText("product not found");
            }

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.cancel();
            }
        }

        @Override
        public void failure(RetrofitError error) {
            super.failure(error);

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.cancel();
            }
        }
    };

    private RetrofitCallback<Object> retrofitCallbackAddPriceItem = new RetrofitCallback<Object>(getActivity()) {
        @Override
        public void success(Object o, Response response) {
            LocationEvent locationEvent = EventBus.getDefault().getStickyEvent(LocationEvent.class);
            NetworkHelper.payLessApi.getShopsProduct(barcode, locationEvent.getLatLng().latitude,
                    locationEvent.getLatLng().longitude, retrofitCallbackShopsProduct);
        }
    };

    private RetrofitCallback<List<Store>> retrofitCallbackStores = new RetrofitCallback<List<Store>>(getActivity()) {
        @Override
        public void success(List<Store> stores, Response response) {
            storeList = stores;
            String array_spinner[] = new String[storeList.size()];
            for (int i = 0; i < storeList.size(); i++) {
                array_spinner[i] = storeList.get(i).getBrand();
            }
            final ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.spinner_item, array_spinner);
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    spinner.setAdapter(adapter);
                }
            });

            NetworkHelper.payLessApi.getProduct(barcode, retrofitCallbackProduct);
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit_price:
                String priceStr = editTextPrice.getText().toString();
                if (!priceStr.isEmpty()) {
                    double price = Double.parseDouble(priceStr);
                    int selectedIndex = (int) spinner.getSelectedItemId();
                    String storeId = storeList.get(selectedIndex).getId();
                    NetworkHelper.payLessApi.addPriceItem(new PriceItemDTO(barcode, storeId, price), retrofitCallbackAddPriceItem);
                } else {
                    Toast.makeText(getActivity(), getString(R.string.enter_price), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
