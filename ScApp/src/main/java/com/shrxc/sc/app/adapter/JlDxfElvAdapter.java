package com.shrxc.sc.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.shrxc.sc.app.R;

/**
 * Created by CH on 2018/8/17.
 */

public class JlDxfElvAdapter extends BaseExpandableListAdapter {

    private Context context;

    public JlDxfElvAdapter(Context context) {
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

        JlDxfElvAdapter.GroupViewHolder gvh;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.jz_elv_group_layout, viewGroup, false);
            gvh = new JlDxfElvAdapter.GroupViewHolder();
            view.setTag(gvh);
        } else {
            gvh = (JlDxfElvAdapter.GroupViewHolder) view.getTag();
        }
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        JlDxfElvAdapter.ChildViewHolder cvh;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.jl_dxf_elv_child_layout, viewGroup, false);
            cvh = new JlDxfElvAdapter.ChildViewHolder();
            view.setTag(cvh);
        } else {
            cvh = (JlDxfElvAdapter.ChildViewHolder) view.getTag();
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }


    private class GroupViewHolder {


    }

    private class ChildViewHolder {


    }

}