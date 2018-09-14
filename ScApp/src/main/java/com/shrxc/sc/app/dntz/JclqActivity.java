package com.shrxc.sc.app.dntz;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shrxc.sc.app.R;
import com.shrxc.sc.app.adapter.JlDgtzElvAdapter;
import com.shrxc.sc.app.adapter.JlDxfElvAdapter;
import com.shrxc.sc.app.adapter.JlHhggElvAdapter;
import com.shrxc.sc.app.adapter.JlRfsfElvAdapter;
import com.shrxc.sc.app.adapter.JlSfElvAdapter;
import com.shrxc.sc.app.adapter.JlSfcElvAdapter;
import com.shrxc.sc.app.utils.SystemBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 竞彩篮球
 */
public class JclqActivity extends AppCompatActivity {


    private Context context = JclqActivity.this;
    @BindView(R.id.jl_activity_select_type_text)
    TextView selectTextView;
    @BindView(R.id.jl_activity_title_layout)
    RelativeLayout titleLayout;
    @BindViews({R.id.jl_activity_sf_elv, R.id.jl_activity_rfsf_elv, R.id.jl_activity_sfc_elv,
            R.id.jl_activity_dxf_elv, R.id.jl_activity_hhgg_elv, R.id.jl_activity_dgtz_elv})
    List<ExpandableListView> elvList;
    @BindView(R.id.jl_activity_tm_view)
    View tmView;
    private List<TextView> textList;
    private int select = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jclq);
        ButterKnife.bind(this);
        SystemBarUtil.SetStatusColor(this, R.drawable.app_title_bg);

        elvList.get(0).setAdapter(new JlSfElvAdapter(context));
        elvList.get(1).setAdapter(new JlRfsfElvAdapter(context));
        elvList.get(2).setAdapter(new JlSfcElvAdapter(context));
        elvList.get(3).setAdapter(new JlDxfElvAdapter(context));
        elvList.get(4).setAdapter(new JlHhggElvAdapter(context));
        elvList.get(5).setAdapter(new JlDgtzElvAdapter(context));
        showTzTypeElv(0, "胜负");
    }

    private void showTzTypeElv(int type, String title) {

        selectTextView.setText(title);
        select = type;
        for (int i = 0; i < elvList.size(); i++) {
            if (i == type) {
                elvList.get(i).setVisibility(View.VISIBLE);
                elvList.get(i).expandGroup(0);
            } else {
                elvList.get(i).setVisibility(View.GONE);
            }
        }
    }

    @OnClick({R.id.jl_activity_select_type_text, R.id.jl_activity_more_icon})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jl_activity_select_type_text:
                showTzTypeDialog();
                break;
            case R.id.jl_activity_more_icon:
                startActivity(new Intent(context, SsfxActivity.class));
                break;
        }
    }

    private void showTzTypeDialog() {


        View view = LayoutInflater.from(context).inflate(R.layout.jc_lqtz_type_window_layout, null);
        TextView sfTextView = view.findViewById(R.id.jc_lqtz_type_dialog_sf_text);
        TextView rfsfTextView = view.findViewById(R.id.jc_lqtz_type_dialog_rfsf_text);
        TextView sfcTextView = view.findViewById(R.id.jc_lqtz_type_dialog_sfc_text);
        TextView dxfTextView = view.findViewById(R.id.jc_lqtz_type_dialog_dxf_text);
        TextView hhggTextView = view.findViewById(R.id.jc_lqtz_type_dialog_hhgg_text);
        TextView dgtzTextView = view.findViewById(R.id.jc_lqtz_type_dialog_dgtz_text);

        textList = new ArrayList<>();
        textList.add(sfTextView);
        textList.add(rfsfTextView);
        textList.add(sfcTextView);
        textList.add(dxfTextView);
        textList.add(hhggTextView);
        textList.add(dgtzTextView);

        for (int i = 0; i < textList.size(); i++) {
            if (i == select) {
                textList.get(i).setTextColor(getResources().getColor(R.color.app_white_color_ffffff));
                textList.get(i).setBackgroundResource(R.drawable.jc_type_button_bg);
            } else {
                textList.get(i).setTextColor(getResources().getColor(R.color.app_text_color_666666));
                textList.get(i).setBackgroundResource(R.drawable.app_gray_stroke_circle_color);
            }
        }

        final PopupWindow pw = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, true);
        pw.setOutsideTouchable(true);
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.showAsDropDown(titleLayout);
        tmView.setVisibility(View.VISIBLE);
//        WindowManager.LayoutParams lp = getWindow().getAttributes();
//        lp.alpha = 0.8f;
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        getWindow().setAttributes(lp);
        pw.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                tmView.setVisibility(View.GONE);
            }
        });
        /**
         * 胜负
         */
        sfTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTzTypeElv(0, "胜负");
                pw.dismiss();
            }
        });

        /**
         * 让分胜负
         */
        rfsfTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTzTypeElv(1, "让分胜负");
                pw.dismiss();
            }
        });
        /**
         * 胜分差
         */
        sfcTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTzTypeElv(2, "胜分差");
                pw.dismiss();
            }
        });
        /**
         * 大小分
         */
        dxfTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTzTypeElv(3, "大小分");
                pw.dismiss();
            }
        });

        /**
         * 混合过关
         */
        hhggTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTzTypeElv(4, "混合过关");
                pw.dismiss();
            }
        });
        /**
         * 单关投注
         */
        dgtzTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTzTypeElv(5, "单关投注");
                pw.dismiss();
            }
        });
    }
}
