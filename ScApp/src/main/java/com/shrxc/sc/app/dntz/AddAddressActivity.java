package com.shrxc.sc.app.dntz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.shrxc.sc.app.R;
import com.shrxc.sc.app.utils.SystemBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddAddressActivity extends AppCompatActivity {

    private Context context = AddAddressActivity.this;
    @BindView(R.id.add_address_activity_selelct_address_layout)
    RelativeLayout selelctAddressLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        ButterKnife.bind(this);
        SystemBarUtil.SetStatusColor(this, R.drawable.app_title_bg);
    }

    @OnClick({R.id.add_address_activity_selelct_address_layout})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.add_address_activity_selelct_address_layout:
                startActivity(new Intent(context, GetAddressActivity.class));
                break;
        }
    }

}
