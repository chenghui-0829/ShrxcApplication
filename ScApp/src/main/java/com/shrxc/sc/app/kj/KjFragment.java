package com.shrxc.sc.app.kj;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.shrxc.sc.app.BaseFragment;
import com.shrxc.sc.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class KjFragment extends BaseFragment {

    private Unbinder unbinder;
    @BindView(R.id.kj_fragment_list)
    ListView listView;
    @BindView(R.id.kj_fragment_title_zq_text)
    TextView zqTextView;
    @BindView(R.id.kj_fragment_title_lq_text)
    TextView lqTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kj, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initView() {

        listView.setAdapter(new ListAdapter());

    }

    @OnClick({R.id.kj_fragment_title_zq_text, R.id.kj_fragment_title_lq_text, R.id.kj_fragment_ls_text})
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.kj_fragment_title_zq_text:
                zqTextView.setTextColor(getResources().getColor(R.color.app_red_color_fa3243));
                zqTextView.setBackgroundResource(R.drawable.kj_zq_title_bg);
                lqTextView.setTextColor(getResources().getColor(R.color.app_white_color_ffffff));
                lqTextView.setBackgroundResource(R.color.app_transparent_color);
                break;

            case R.id.kj_fragment_title_lq_text:
                zqTextView.setTextColor(getResources().getColor(R.color.app_white_color_ffffff));
                zqTextView.setBackgroundResource(R.color.app_transparent_color);
                lqTextView.setTextColor(getResources().getColor(R.color.app_red_color_fa3243));
                lqTextView.setBackgroundResource(R.drawable.kj_lq_title_bg);
                break;

            case R.id.kj_fragment_ls_text:

                startActivity(new Intent(getContext(), LskActivity.class));

                break;


        }


    }


    @Override
    protected void loadData() {
        System.out.println("KjFragment~~");
    }


    private class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View v = LayoutInflater.from(getContext()).inflate(R.layout.kj_fragment_list_adapter_layout,
                    viewGroup, false);
            return v;
        }
    }


}
