package com.shrxc.sc.app.dntz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.shrxc.sc.app.R;
import com.shrxc.sc.app.utils.SystemBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JzSsfxActivity extends AppCompatActivity {

    @BindView(R.id.jz_ssfx_activity_op_text)
    TextView opTextView;
    @BindView(R.id.jz_ssfx_activity_yp_text)
    TextView ypTextView;
    @BindView(R.id.jz_ssfx_activity_pllb_text2)
    TextView pllbT2TextView;
    @BindView(R.id.jz_ssfx_activity_pllb_text3)
    TextView pllbT3TextView;
    @BindView(R.id.jz_ssfx_activity_yp_list)
    ListView ypListView;
    @BindView(R.id.jz_ssfx_activity_pl_layout)
    LinearLayout plLayout;
    @BindView(R.id.jz_ssfx_activity_dz_layout)
    LinearLayout dzLayout;
    @BindView(R.id.jz_ssfx_activity_dz_elv)
    ExpandableListView dzElv;
    private Context context = JzSsfxActivity.this;
    @BindView(R.id.jz_ssfx_activity_op_list)
    ListView opListView;
    @BindView(R.id.jz_ssfx_activity_pl_content_layout)
    View plContentView;
    @BindView(R.id.jz_ssfx_activity_dz_content_layout)
    View dzContentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jz_ssfx);
        ButterKnife.bind(this);
        SystemBarUtil.SetStatusColor(this, R.drawable.app_title_bg);
        opListView.setAdapter(new OpListAdapter());
        dzElv.setAdapter(new DzElvAdapter());
    }

    @OnClick({R.id.jz_ssfx_activity_op_text, R.id.jz_ssfx_activity_yp_text, R.id.jz_ssfx_activity_pl_layout
            , R.id.jz_ssfx_activity_dz_layout})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.jz_ssfx_activity_op_text:
                opTextView.setBackgroundResource(R.drawable.left_red_circle_bg);
                opTextView.setTextColor(getResources().getColor(R.color.app_white_color_ffffff));
                ypTextView.setBackgroundResource(R.color.app_transparent_color);
                ypTextView.setTextColor(getResources().getColor(R.color.app_red_color_fa3243));
                pllbT2TextView.setText("初始奖金");
                pllbT3TextView.setText("即时奖金");
                opListView.setAdapter(new OpListAdapter());
                opListView.setVisibility(View.VISIBLE);
                ypListView.setVisibility(View.GONE);
                break;
            case R.id.jz_ssfx_activity_yp_text:
                ypTextView.setBackgroundResource(R.drawable.right_red_circle_bg);
                ypTextView.setTextColor(getResources().getColor(R.color.app_white_color_ffffff));
                opTextView.setBackgroundResource(R.color.app_transparent_color);
                opTextView.setTextColor(getResources().getColor(R.color.app_red_color_fa3243));
                pllbT2TextView.setText("初始盘口");
                pllbT3TextView.setText("即时盘口");
                ypListView.setAdapter(new YpListAdapter());
                opListView.setVisibility(View.GONE);
                ypListView.setVisibility(View.VISIBLE);
                break;
            case R.id.jz_ssfx_activity_pl_layout:
                ((TextView) plLayout.getChildAt(0)).setTextColor(getResources().getColor(R.color.app_red_color_fa3243));
                ((TextView) dzLayout.getChildAt(0)).setTextColor(getResources().getColor(R.color.app_text_color_333333));
                plLayout.getChildAt(1).setVisibility(View.VISIBLE);
                dzLayout.getChildAt(1).setVisibility(View.GONE);
                plContentView.setVisibility(View.VISIBLE);
                dzContentView.setVisibility(View.GONE);
                break;
            case R.id.jz_ssfx_activity_dz_layout:
                ((TextView) plLayout.getChildAt(0)).setTextColor(getResources().getColor(R.color.app_text_color_333333));
                ((TextView) dzLayout.getChildAt(0)).setTextColor(getResources().getColor(R.color.app_red_color_fa3243));
                plLayout.getChildAt(1).setVisibility(View.GONE);
                dzLayout.getChildAt(1).setVisibility(View.VISIBLE);
                plContentView.setVisibility(View.GONE);
                dzContentView.setVisibility(View.VISIBLE);
                break;
        }
    }


    private class OpListAdapter extends BaseAdapter {

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

            View v = LayoutInflater.from(context).inflate(R.layout.jz_ssfx_activity_op_list_adapter_layout, viewGroup,
                    false);
            return v;
        }
    }

    private class YpListAdapter extends BaseAdapter {

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

            View v = LayoutInflater.from(context).inflate(R.layout.jz_ssfx_activity_yp_list_adapter_layout, viewGroup,
                    false);
            return v;
        }
    }

    private class DzElvAdapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return 3;
        }

        @Override
        public int getChildrenCount(int i) {
            return 3;
        }

        @Override
        public Object getGroup(int i) {
            return null;
        }

        @Override
        public Object getChild(int i, int i1) {
            return null;
        }

        @Override
        public long getGroupId(int i) {
            return 0;
        }

        @Override
        public long getChildId(int i, int i1) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

            view = LayoutInflater.from(context).inflate(R.layout.jz_ssfx_activity_dz_elv_group_adaptr_layout, viewGroup, false);

            return view;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(context).inflate(R.layout.jz_ssfx_activity_dz_elv_child_adaptr_layout, viewGroup, false);

            return view;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }
    }


}
