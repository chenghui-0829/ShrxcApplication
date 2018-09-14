package com.shrxc.sc.app.dntz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.shrxc.sc.app.R;
import com.shrxc.sc.app.adapter.SsfxFxListAdapter;
import com.shrxc.sc.app.adapter.SsfxSlListAdapter;
import com.shrxc.sc.app.utils.SystemBarUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 赛事分析(蓝球)
 */
public class SsfxActivity extends AppCompatActivity {

    private Context context = SsfxActivity.this;
    @BindView(R.id.ssfx_activity_fx_layout_list)
    ListView fxListView;
    @BindView(R.id.ssfx_activity_sl_layout_list)
    ListView slListView;
    @BindViews({R.id.ssfx_activity_fx_con_layout, R.id.ssfx_activity_sl_con_layout})
    List<View> contViews;
    @BindViews({R.id.ssfx_activity_fx_text, R.id.ssfx_activity_sl_text, R.id.ssfx_activity_tj_text, R.id.ssfx_activity_sk_text})
    List<TextView> textViews;
    @BindViews({R.id.ssfx_activity_fx_line, R.id.ssfx_activity_sl_line, R.id.ssfx_activity_tj_line, R.id.ssfx_activity_sk_line})
    List<View> lineViews;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssfx);
        ButterKnife.bind(this);
        SystemBarUtil.SetStatusColor(this, R.drawable.app_title_bg);

        fxListView.setAdapter(new SsfxFxListAdapter(context));
        slListView.setAdapter(new SsfxSlListAdapter(context));

    }

    @OnClick({R.id.ssfx_activity_fx_layout, R.id.ssfx_activity_sl_layout, R.id.ssfx_activity_tj_layout, R.id.ssfx_activity_sk_layout})
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ssfx_activity_fx_layout:
                if (index != 0) {
                    showContentView(0);
                }
                break;
            case R.id.ssfx_activity_sl_layout:
                if (index != 1) {
                    showContentView(1);
                }
                break;
            case R.id.ssfx_activity_tj_layout:
                if (index != 2) {
                    showContentView(2);
                }
                break;
            case R.id.ssfx_activity_sk_layout:
                if (index != 3) {
                    showContentView(3);
                }
                break;
        }
    }

    private void showContentView(int index) {

        this.index = index;

        for (int i = 0; i < contViews.size(); i++) {
            if (i == index) {
                contViews.get(i).setVisibility(View.VISIBLE);
                textViews.get(i).setTextColor(getResources().getColor(R.color.app_red_color_fa3243));
                lineViews.get(i).setVisibility(View.VISIBLE);
            } else {
                contViews.get(i).setVisibility(View.GONE);
                textViews.get(i).setTextColor(getResources().getColor(R.color.app_text_color_333333));
                lineViews.get(i).setVisibility(View.GONE);
            }
        }
    }
}
