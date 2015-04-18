package com.garage.payless.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.garage.payless.FragmentHelper;
import com.garage.payless.MainActivity;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class FragmentBarcodeScan extends Fragment implements  ZBarScannerView.ResultHandler {
    private ZBarScannerView mZBarScannerView;
    private String LOG_TAG = "FragmentBarcodeScan";

    public static FragmentBarcodeScan newInstance() {
        FragmentBarcodeScan fragment = new FragmentBarcodeScan();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentBarcodeScan() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mZBarScannerView = new ZBarScannerView(getActivity());
        return mZBarScannerView;
//        View view = inflater.inflate(R.layout.fragment_barcode_scan, container, false);
//        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mZBarScannerView.setResultHandler(this);
        mZBarScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mZBarScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Log.e(LOG_TAG, result.getContents());
        FragmentHelper.add(getFragmentManager(), FragmentFillPriceItem.newInstance(result.getContents()),
                MainActivity.FRAME_CONTAINER);
    }
}
