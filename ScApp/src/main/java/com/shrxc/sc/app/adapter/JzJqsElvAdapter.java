package com.shrxc.sc.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.shrxc.sc.app.R;

import java.util.Map;

/**
 * Created by CH on 2018/8/17.
 */

public class JzJqsElvAdapter extends BaseExpandableListAdapter {

    private Context context;
    private Map<Integer, Map<Integer, Map<Integer, Integer>>> childs;

    public JzJqsElvAdapter(Context context) {
        this.context = context;
        childs = JzAdapterUtil.initChilds(4, 3, 9);
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
            gvh = new GroupViewHolder(view);
            view.setTag(gvh);
        } else {
            gvh = (GroupViewHolder) view.getTag();
        }
        if (b) {
            gvh.arrowImage.setImageResource(R.mipmap.app_up_gray_arow_icon);
        } else {
            gvh.arrowImage.setImageResource(R.mipmap.app_down_gray_arow_icon);
        }
        return view;
    }

    @Override
    public View getChildView(final int gPos, final int cPos, boolean b, View view, ViewGroup viewGroup) {
        ChildViewHolder cvh;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.jz_jqs_elv_child_layout, viewGroup, false);
            cvh = new ChildViewHolder(view);
            view.setTag(cvh);
        } else {
            cvh = (ChildViewHolder) view.getTag();
        }

        for (Integer key : childs.get(gPos).get(cPos).keySet()) {
            if (key == 0) {
                if (childs.get(gPos).get(cPos).get(key) == 0) {
                    cvh.fxDetailLayout.setVisibility(View.GONE);
                    cvh.fxImageView.setImageResource(R.mipmap.app_down_gray_arow_icon);
                } else {
                    cvh.fxDetailLayout.setVisibility(View.VISIBLE);
                    cvh.fxImageView.setImageResource(R.mipmap.app_up_gray_arow_icon);
                }
            } else {
                JzAdapterUtil.initViewState(context, childs.get(gPos).get(cPos).get(key), (LinearLayout) cvh.jqsGridLayout.getChildAt(key - 1));
            }
        }

        cvh.fxLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JzAdapterUtil.changeViewSet(JzJqsElvAdapter.this, gPos, cPos, 0, childs);
            }
        });

        cvh.jqsGridLayout.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JzAdapterUtil.changeViewSet(JzJqsElvAdapter.this, gPos, cPos, 1, childs);
            }
        });
        cvh.jqsGridLayout.getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JzAdapterUtil.changeViewSet(JzJqsElvAdapter.this, gPos, cPos, 2, childs);
            }
        });
        cvh.jqsGridLayout.getChildAt(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JzAdapterUtil.changeViewSet(JzJqsElvAdapter.this, gPos, cPos, 3, childs);
            }
        });
        cvh.jqsGridLayout.getChildAt(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JzAdapterUtil.changeViewSet(JzJqsElvAdapter.this, gPos, cPos, 4, childs);
            }
        });
        cvh.jqsGridLayout.getChildAt(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JzAdapterUtil.changeViewSet(JzJqsElvAdapter.this, gPos, cPos, 5, childs);
            }
        });
        cvh.jqsGridLayout.getChildAt(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JzAdapterUtil.changeViewSet(JzJqsElvAdapter.this, gPos, cPos, 6, childs);
            }
        });
        cvh.jqsGridLayout.getChildAt(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JzAdapterUtil.changeViewSet(JzJqsElvAdapter.this, gPos, cPos, 7, childs);
            }
        });
        cvh.jqsGridLayout.getChildAt(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JzAdapterUtil.changeViewSet(JzJqsElvAdapter.this, gPos, cPos, 8, childs);
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }


    private class GroupViewHolder {

        private ImageView arrowImage;

        public GroupViewHolder(View view) {
            arrowImage = view.findViewById(R.id.jz_group_arrow_icon);
        }

    }

    private class ChildViewHolder {

        private LinearLayout fxLayout, fxDetailLayout;
        private ImageView fxImageView;
        private GridLayout jqsGridLayout;

        public ChildViewHolder(View view) {
            fxLayout = view.findViewById(R.id.jz_jqs_elv_fx_layout);
            fxDetailLayout = view.findViewById(R.id.jz_jqs_elv_fx_detail_layout);
            fxImageView = view.findViewById(R.id.jz_jqs_elv_fx_icon);
            jqsGridLayout = view.findViewById(R.id.jz_jqs_elv_jqs_select_layout);
        }
    }

}