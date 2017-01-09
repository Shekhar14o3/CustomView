package com.customview.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.customview.R;
import com.customview.customView.ViewBoxGrid;

/**
 * Created by suresh on 3/1/17.
 */

public class FragmentCustomGrid extends Fragment {

    private ViewBoxGrid viewBoxGrid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_custom_grid, container, false);

        viewBoxGrid = (ViewBoxGrid) rootView.findViewById(R.id.viewBoxGrid);

        return rootView;
    }
}
