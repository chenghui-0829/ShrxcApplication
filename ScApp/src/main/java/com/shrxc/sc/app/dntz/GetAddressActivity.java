package com.shrxc.sc.app.dntz;

import android.content.Context;
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

public class GetAddressActivity extends AppCompatActivity {

    private Context context = GetAddressActivity.this;
    @BindView(R.id.get_address_activity_list)
    ListView getAddressListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_address);
        ButterKnife.bind(this);
        SystemBarUtil.SetStatusColor(this, R.drawable.app_title_bg);

        getAddressListView.setAdapter(new ListAdapter());

    }


    private class ListAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return 5;
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

            View v = LayoutInflater.from(context).inflate(R.layout.get_address_activity_adapter_layout, viewGroup, false);

            return v;
        }
    }


}
