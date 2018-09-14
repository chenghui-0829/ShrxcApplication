package com.shrxc.sc.app.dntz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shrxc.sc.app.R;
import com.shrxc.sc.app.utils.SystemBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TxddActivity extends AppCompatActivity {

    private Context context = TxddActivity.this;
    @BindView(R.id.txdd_activity_buy_zdzz_layout)
    LinearLayout zdzzLayout;
    @BindView(R.id.txdd_activity_buy_jjmd_text)
    TextView jjmdText;
    @BindView(R.id.txdd_activity_select_md_layout)
    RelativeLayout selectMdLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txdd);
        ButterKnife.bind(this);
        SystemBarUtil.SetStatusColor(this, R.drawable.app_title_bg);
    }

    @OnClick({R.id.txdd_activity_buy_zdzz_layout, R.id.txdd_activity_buy_jjmd_text, R.id.txdd_activity_address_select_address_layout,
            R.id.txdd_activity_select_md_layout, R.id.txdd_activity_tjdd_text})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.txdd_activity_buy_zdzz_layout:
                zdzzLayout.setBackgroundResource(R.drawable.app_red_stroke_color);
                jjmdText.setBackgroundResource(R.drawable.app_gray_stroke_color);
                selectMdLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.txdd_activity_buy_jjmd_text:
                zdzzLayout.setBackgroundResource(R.drawable.app_gray_stroke_color);
                jjmdText.setBackgroundResource(R.drawable.app_red_stroke_color);
                selectMdLayout.setVisibility(View.GONE);
                break;
            case R.id.txdd_activity_address_select_address_layout:
                startActivity(new Intent(context, AddressActivity.class));
                break;
            case R.id.txdd_activity_select_md_layout:
                startActivity(new Intent(context, MdActivity.class));
                break;
            case R.id.txdd_activity_tjdd_text:
                startActivity(new Intent(context, WaitOrderActivity.class));
                break;
        }
    }
}
