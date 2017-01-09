package com.customview.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.customview.AppSingleton;
import com.customview.R;

/**
 * Created by suresh on 3/1/17.
 */

public class FragmentHome extends Fragment {

    private Button openCustomView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.homepage_layout, container, false);

        openCustomView = (Button) rootView.findViewById(R.id.open_custom_view);

        openCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppSingleton.getSingleton().getMainActivity().getSupportFragmentManager().beginTransaction().add(R.id.frameContainer, new FragmentCustomGrid(), "boxes_fragment").addToBackStack(null).commit();
            }
        });

        return rootView;
    }
}
