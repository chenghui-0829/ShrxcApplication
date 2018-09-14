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
import android.widget.TextView;

import com.shrxc.sc.app.R;
import com.shrxc.sc.app.utils.SystemBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressActivity extends AppCompatActivity {

    private Context context = AddressActivity.this;
    @BindView(R.id.address_activity_list)
    ListView addressListView;
    @BindView(R.id.address_activity_add_text)
    TextView addTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        SystemBarUtil.SetStatusColor(this, R.drawable.app_title_bg);

        addressListView.setAdapter(new ListAdapter());

    }

    @OnClick({R.id.address_activity_add_text})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.address_activity_add_text:
                startActivity(new Intent(context, AddAddressActivity.class));
                break;
        }
    }


    private class ListAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return 4;
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

            View v = LayoutInflater.from(context).inflate(R.layout.address_activity_list_adapter_layout, viewGroup, false);

            return v;
        }
    }

}
