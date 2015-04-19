/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.garage.payless.fragment;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.garage.payless.MainActivity;
import com.garage.payless.R;
import com.garage.payless.util.DelayAutoCompleteTextView;
import com.garage.payless.util.GoodAutoCompleteAdapter;

public class FragmentList extends Fragment implements View.OnClickListener{

    public static FragmentList newInstance() {
        FragmentList fragment = new FragmentList();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView =
                inflater.inflate(R.layout.list_fragment, container, false);

        DelayAutoCompleteTextView bookTitle = (DelayAutoCompleteTextView) rootView.findViewById(R.id.book_title);
        bookTitle.setThreshold(4);
        bookTitle.setAdapter(new GoodAutoCompleteAdapter(getActivity().getApplicationContext()));
        bookTitle.setLoadingIndicator((ProgressBar) rootView.findViewById(R.id.progress_bar));
        bookTitle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                LinearLayout basketList = (LinearLayout)rootView.findViewById(R.id.basket);
                LinearLayout row = new LinearLayout(getActivity().getApplicationContext());
                row.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.FILL_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                row.setOrientation(LinearLayout.HORIZONTAL);
                TextView valueTV = new TextView(getActivity().getApplicationContext());
                valueTV.setText((String) adapterView.getItemAtPosition(position));
                valueTV.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.FILL_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                row.addView(valueTV);
                ImageButton cancel = new ImageButton(getActivity().getApplicationContext());
                cancel.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                cancel.setImageDrawable(Drawable.createFromPath("@android:drawable/ic_menu_close_clear_cancel"));
                row.addView(cancel);
                basketList.addView(row);
            }
        });
        rootView.findViewById(R.id.create_btn).setOnClickListener(this);
        return rootView;
    }

    public void onClick(View v) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.create_btn:
                BasketFragment listFragment = new BasketFragment();
                ft.replace(MainActivity.FRAME_CONTAINER, listFragment);
                ft.addToBackStack("replacingListFragment");
                break;
        }
        ft.commit();
    }
}