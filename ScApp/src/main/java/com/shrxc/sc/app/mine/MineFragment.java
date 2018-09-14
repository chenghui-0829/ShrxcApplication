package com.shrxc.sc.app.mine;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shrxc.sc.app.BaseFragment;
import com.shrxc.sc.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    protected void loadData() {
        System.out.println("MineFragment~~");
    }
}
