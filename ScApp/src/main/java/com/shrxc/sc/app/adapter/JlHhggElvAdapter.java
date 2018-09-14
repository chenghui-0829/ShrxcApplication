package com.shrxc.sc.app.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.shrxc.sc.app.R;

/**
 * Created by CH on 2018/8/17.
 */

public class JlHhggElvAdapter extends BaseExpandableListAdapter {

    private Context context;

    public JlHhggElvAdapter(Context context) {
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
            view = LayoutInflater.from(context).inflate(R.layout.jl_hhgg_elv_child_layout, viewGroup, false);
            cvh = new ChildViewHolder();
            cvh.qbxxTextView = view.findViewById(R.id.jl_hhgg_elv_child_qbxx_text);
            view.setTag(cvh);
        } else {
            cvh = (ChildViewHolder) view.getTag();
        }

        cvh.qbxxTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(context, R.style.dialog);
                View view = LayoutInflater.from(context).inflate(
                        R.layout.jl_hhgg_elv_qbxx_dialog_layout, null);
                dialog.setContentView(view);
                dialog.show();
                Window dialogWindow = dialog.getWindow();
                dialogWindow.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialogWindow.setAttributes(lp);

            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }


    private class GroupViewHolder {


    }

    private class ChildViewHolder {


        private TextView qbxxTextView;


    }

}