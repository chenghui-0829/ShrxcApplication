package com.shrxc.sc.app.dntz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shrxc.sc.app.R;
import com.shrxc.sc.app.utils.SystemBarUtil;

import butterknife.ButterKnife;

/**
 * 足球筛选
 */
public class JzsxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jzsx);
        ButterKnife.bind(this);
        SystemBarUtil.SetStatusColor(this, R.drawable.app_title_bg);
    }
}
