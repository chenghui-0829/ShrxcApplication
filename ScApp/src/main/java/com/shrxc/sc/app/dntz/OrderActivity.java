package com.shrxc.sc.app.dntz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.shrxc.sc.app.R;
import com.shrxc.sc.app.utils.SystemBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends AppCompatActivity {

    private Context context = OrderActivity.this;
    @BindView(R.id.order_activity_order_list)
    ListView orderListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        SystemBarUtil.SetStatusColor(this, R.drawable.app_title_bg);
        orderListView.setAdapter(new ListAdapter());

    }

    @OnClick(R.id.order_activity_qxd_but)
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.order_activity_qxd_but:

                startActivity(new Intent(context, TxddActivity.class));

                break;

        }


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

            View v = LayoutInflater.from(context).inflate(R.layout.order_activity_list_adapter_layout, viewGroup, false);

            return v;
        }
    }


}
