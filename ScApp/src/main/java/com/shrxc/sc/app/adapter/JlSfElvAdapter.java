package com.shrxc.sc.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.shrxc.sc.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CH on 2018/8/17.
 */

public class JlSfElvAdapter extends BaseExpandableListAdapter {

    private Context context;

    public JlSfElvAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return 4;
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

        GroupViewHolder gvh;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.jz_elv_group_layout, viewGroup, false);
            gvh = new GroupViewHolder();
            view.setTag(gvh);
        } else {
            gvh = (GroupViewHolder) view.getTag();
        }
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildViewHolder cvh;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.jl_sf_elv_child_layout, viewGroup, false);
            cvh = new ChildViewHolder(view);
            view.setTag(cvh);
        } else {
            cvh = (ChildViewHolder) view.getTag();
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }


    private class GroupViewHolder {


    }

    class ChildViewHolder {

        @BindView(R.id.jl_sf_elv_fx_icon)
        ImageView fxIcon;
        @BindView(R.id.jl_sf_elv_fx_layout)
        LinearLayout fxLayout;
        @BindView(R.id.jl_sf_elv_fx_detail_layout)
        LinearLayout fxDetailsLayout;

        public ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}