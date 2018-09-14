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
import com.shrxc.sc.app.adapter.JzBfElvAdapter;
import com.shrxc.sc.app.adapter.JzBqcElvAdapter;
import com.shrxc.sc.app.adapter.JzDgtzElvAdapter;
import com.shrxc.sc.app.adapter.JzHhggElvAdapter;
import com.shrxc.sc.app.adapter.JzJqsElvAdapter;
import com.shrxc.sc.app.adapter.JzRqspfElvAdapter;
import com.shrxc.sc.app.adapter.JzSpfElvAdapter;
import com.shrxc.sc.app.bean.JzRqspfChildEntity;
import com.shrxc.sc.app.bean.JzRqspfGroupEntity;
import com.shrxc.sc.app.utils.SystemBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 竞彩足球
 */
public class JczqActivity extends AppCompatActivity {

    private Context context = JczqActivity.this;
    @BindView(R.id.jz_activity_select_type_text)
    TextView selectTextView;
    @BindView(R.id.jz_activity_title_layout)
    RelativeLayout titleLayout;
    @BindViews({R.id.jz_activity_spf_elv, R.id.jz_activity_rqspf_elv, R.id.jz_activity_hhgg_elv,
            R.id.jz_activity_bf_elv, R.id.jz_activity_jqs_elv, R.id.jz_activity_bqc_elv, R.id.jz_activity_dgtz_elv})
    List<ExpandableListView> elvList;
    @BindView(R.id.jz_activity_tm_view)
    View tmView;
    @BindView(R.id.jz_activity_sure_text)
    TextView sureTextView;

    private List<TextView> textList;
    private int select = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jczq);
        ButterKnife.bind(this);
        SystemBarUtil.SetStatusColor(this, R.drawable.app_title_bg);

        elvList.get(0).setAdapter(new JzSpfElvAdapter(context));
//        initData();

        initRqspfElvData();

//        elvList.get(1).setAdapter(new JzRqspfElvAdapter(context));
        elvList.get(2).setAdapter(new JzHhggElvAdapter(context));
        elvList.get(3).setAdapter(new JzBfElvAdapter(context));
        elvList.get(4).setAdapter(new JzJqsElvAdapter(context));
        elvList.get(5).setAdapter(new JzBqcElvAdapter(context));
        elvList.get(6).setAdapter(new JzDgtzElvAdapter(context));
        showTzTypeElv(0, "胜平负");
    }

    private void initRqspfElvData() {

        List<JzRqspfGroupEntity> groupList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            JzRqspfGroupEntity groupEntity = new JzRqspfGroupEntity();
            groupEntity.setData("2018-08-0" + i);
            List<JzRqspfChildEntity> childList = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                JzRqspfChildEntity childEntity = new JzRqspfChildEntity();
                childEntity.setName("超人" + i + "号");
                childList.add(childEntity);
            }
            groupEntity.setChildList(childList);
            groupList.add(groupEntity);
        }

        elvList.get(1).setAdapter(new JzRqspfElvAdapter(context, groupList));
    }

    private void initData() {
//        JzspfGroupAdapter adapter = new JzspfGroupAdapter(context);
//        elvList.get(0).setAdapter(adapter);


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


    @OnClick({R.id.jz_activity_select_type_text, R.id.jz_activity_sx_icon, R.id.jz_activity_sure_text, R.id.jz_activity_more_icon})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jz_activity_select_type_text:
                showTzTypeDialog();
                break;
            case R.id.jz_activity_sx_icon:
                startActivity(new Intent(context, JzsxActivity.class));
                break;
            case R.id.jz_activity_sure_text:
                startActivity(new Intent(context, OrderActivity.class));
                break;
            case R.id.jz_activity_more_icon:
                startActivity(new Intent(context, JzSsfxActivity.class));
                break;
        }
    }

    private void showTzTypeDialog() {

        View view = LayoutInflater.from(context).inflate(R.layout.jc_zqtz_type_window_layout, null);

        TextView spfTextView = view.findViewById(R.id.jc_zqtz_type_dialog_spf_text);
        TextView rqspfTextView = view.findViewById(R.id.jc_zqtz_type_dialog_rqspf_text);
        TextView hhggTextView = view.findViewById(R.id.jc_zqtz_type_dialog_hhgg_text);
        TextView bfTextView = view.findViewById(R.id.jc_zqtz_type_dialog_bf_text);
        TextView jqsTextView = view.findViewById(R.id.jc_zqtz_type_dialog_jqs_text);
        TextView bqcTextView = view.findViewById(R.id.jc_zqtz_type_dialog_bqc_text);
        TextView dgtzTextView = view.findViewById(R.id.jc_zqtz_type_dialog_dgtz_text);

        textList = new ArrayList<>();
        textList.add(spfTextView);
        textList.add(rqspfTextView);
        textList.add(hhggTextView);
        textList.add(bfTextView);
        textList.add(jqsTextView);
        textList.add(bqcTextView);
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
        pw.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                tmView.setVisibility(View.GONE);
            }
        });

        /**
         * 胜平负
         */
        spfTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showTzTypeElv(0, "胜平负");
                pw.dismiss();
            }
        });

        /**
         * 让球胜平负
         */
        rqspfTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTzTypeElv(1, "让球胜平负");
                pw.dismiss();
            }
        });

        /**
         * 混合过关
         */
        hhggTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTzTypeElv(2, "混合过关");
                pw.dismiss();
            }
        });

        /**
         * 比分
         */
        bfTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTzTypeElv(3, " 比分");
                pw.dismiss();
            }
        });

        /**
         * 进球数
         */
        jqsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTzTypeElv(4, "进球数");
                pw.dismiss();
            }
        });

        /**
         * 半全场
         */
        bqcTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTzTypeElv(5, "半全场");
                pw.dismiss();
            }
        });

        /**
         * 单关投注
         */
        dgtzTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTzTypeElv(6, "单关投注");
                pw.dismiss();
            }
        });
    }
}
