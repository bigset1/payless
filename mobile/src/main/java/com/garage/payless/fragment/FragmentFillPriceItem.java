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
import com.garage.payless.api.PayLessApi;
import com.garage.payless.api.ResponseCallback;
import com.garage.payless.entity.LocationEvent;
import com.garage.payless.util.RestProvider;
import com.garage.payless.util.ServerRequest;
import com.letionik.payless.model.Product;
import com.letionik.payless.model.Store;
import com.letionik.payless.model.transport.PriceItemDTO;
import com.letionik.payless.model.transport.ProductSearchResult;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.greenrobot.event.EventBus;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FragmentFillPriceItem extends Fragment implements View.OnClickListener {
    private static final String BARCODE = "barcode";
    private TextView textViewBarcode, textViewProductName;
    private Spinner spinner;
    private EditText editTextPrice;
    private String barcode;
    private ProgressDialog progressDialog;
    private ImageView imgProduct;
    private List<Store> storeList;
    private static final double DEFAULT_RADIUS = 1;

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
        textViewBarcode = (TextView) view.findViewById(R.id.tv_barcode);
        textViewBarcode.setText(getString(R.string.barcode) + ": " + barcode);
        textViewProductName = (TextView) view.findViewById(R.id.tv_product_name);
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
        EventBus.getDefault().registerSticky(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        if(progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    private ResponseCallback responseCallbackProduct = new ResponseCallback() {
        @Override
        public void complete(Object response) {
            final Product product = (Product) response;
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textViewProductName.setText(product.getName());
                    String imageUrl = product.getImageUrl();
                    if (!imageUrl.isEmpty()) {
                        Picasso.with(getActivity()).load(imageUrl).into(imgProduct);
                    }
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.cancel();
                    }
                }
            });
        }
    };

    private ResponseCallback responseCallbackStores = new ResponseCallback() {
        @Override
        public void complete(Object response) {
            storeList = (List<Store>) response;
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

            ServerRequest.getProduct(payLessApi, responseCallbackProduct, barcode);
        }
    };

    private ResponseCallback responseCallbackShopsProduct = new ResponseCallback() {
        @Override
        public void complete(Object response) {
            List<ProductSearchResult> productSearchResults = (List<ProductSearchResult>)response;
            EventBus.getDefault().postSticky(productSearchResults);
            FragmentHelper.add(getFragmentManager(), FragmentShopsProduct.newInstance(),
                    MainActivity.FRAME_CONTAINER);
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
                    payLessApi.addPriceItem(new PriceItemDTO(barcode, storeId, price), new Callback<Object>() {
                        @Override
                        public void success(Object o, Response response) {
                            LocationEvent locationEvent = EventBus.getDefault().getStickyEvent(LocationEvent.class);
                            ServerRequest.getShopsProduct(payLessApi, responseCallbackShopsProduct, barcode,
                                    locationEvent.getLatLng().latitude, locationEvent.getLatLng().longitude);
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            String responseStr = error.toString();
                        }
                    });
//                    ServerRequest.addPriceItem(payLessApi, responseCallbackPriceItem, barcode, storeId, price);
                } else {
                    Toast.makeText(getActivity(), getString(R.string.enter_price), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void onEventMainThread(LocationEvent locationEvent) {
//        progressDialog.show();

        ServerRequest.getStores(payLessApi, responseCallbackStores,
                locationEvent.getLatLng().latitude, locationEvent.getLatLng().longitude, DEFAULT_RADIUS);
    }

    public void onEvent(LocationEvent locationEvent) {
    }
}
