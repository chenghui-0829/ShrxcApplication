package com.shrxc.sc.app.order;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.shrxc.sc.app.BaseFragment;
import com.shrxc.sc.app.R;
import com.shrxc.sc.app.dntz.OrderDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends BaseFragment {

    private Unbinder unbinder;
    @BindView(R.id.order_fragment_list)
    ListView orderListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        unbinder = ButterKnife.bind(this, view);

        orderListView.setAdapter(new ListAdapter());
        initData();
        return view;
    }

    private void initData() {

        orderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getActivity(), OrderDetailsActivity.class));
            }
        });
    }

    @Override
    protected void loadData() {

    }


    private class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 3;
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
            view = LayoutInflater.from(getActivity()).inflate(R.layout.order_fragment_list_adapter_layout, viewGroup, false);
            return view;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
