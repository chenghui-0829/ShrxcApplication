package com.shrxc.sc.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shrxc.sc.app.R;
import com.shrxc.sc.app.bean.JzRqspfChildEntity;
import com.shrxc.sc.app.bean.JzRqspfGroupEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CH on 2018/8/17.
 */

public class JzRqspfElvAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<JzRqspfGroupEntity> mGroupList;
    private Map<Integer, Map<Integer, Map<Integer, Integer>>> childs;

    public JzRqspfElvAdapter(Context context, List<JzRqspfGroupEntity> groupList) {
        this.context = context;
        this.mGroupList = groupList;
        initChilds();
    }

    private void initChilds() {

        childs = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            Map<Integer, Map<Integer, Integer>> cPos = new HashMap<>();
            for (int j = 0; j < 5; j++) {
                Map<Integer, Integer> selects = new HashMap<>();
                for (int k = 0; k < 4; k++) {
                    selects.put(k, 0);
                }
                cPos.put(j, selects);
            }
            childs.put(i, cPos);
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroupList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return mGroupList != null ? mGroupList.size() : 0;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }


    @Override
    public int getChildrenCount(int groupPosition) {
        return mGroupList.get(groupPosition).getChildList() != null ? mGroupList
                .get(groupPosition).getChildList().size() : 0;
    }

    @Override
    public JzRqspfChildEntity getChild(int groupPosition, int childPosition) {
        return mGroupList.get(groupPosition).getChildList().get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
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

        final ChildViewHolder cvh;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.jz_rqspf_elv_child_layout, viewGroup, false);
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
                initViewState(childs.get(gPos).get(cPos).get(key), cvh.layouts[key - 1], cvh.texts[key - 1]);
            }
        }
        /**
         * 分析
         */
        cvh.fxLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeViewSet(gPos, cPos, 0);
            }
        });
        /**
         * 胜
         */
        cvh.sLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeViewSet(gPos, cPos, 1);
            }
        });
        /**
         * 平
         */cvh.pLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeViewSet(gPos, cPos, 2);
            }
        });
        /***
         * 负
         */
        cvh.fLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeViewSet(gPos, cPos, 3);
            }
        });
        return view;
    }

    private void initViewState(int state, LinearLayout layout, TextView[] texts) {
        if (state == 0) {
            layout.setBackgroundResource(R.drawable.app_gray_stroke_color);
            for (int i = 0; i < texts.length; i++) {
                if (i == 0) {
                    texts[i].setTextColor(context.getResources().getColor(R.color.app_text_color_333333));
                } else {
                    texts[i].setTextColor(context.getResources().getColor(R.color.app_text_color_999999));
                }
            }
        } else {
            layout.setBackgroundResource(R.color.app_red_color_fa3243);
            for (int i = 0; i < texts.length; i++) {
                texts[i].setTextColor(context.getResources().getColor(R.color.app_white_color_ffffff));
            }
        }
    }

    private void changeViewSet(int gPos, int cPos, int index) {

        int state = childs.get(gPos).get(cPos).get(index);
        if (state == 0) {
            childs.get(gPos).get(cPos).put(index, 1);
        } else {
            childs.get(gPos).get(cPos).put(index, 0);
        }
        notifyDataSetChanged();
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

        private TextView s_numTextview, s_nameTextview, s_plTextview, p_vsTextview, p_plTextview, f_nameTextview,
                f_numTextview, f_plTextview;
        private ImageView fxImageView;
        private LinearLayout fxLayout, sLayout, pLayout, fLayout, fxDetailLayout;
        private LinearLayout[] layouts;
        private TextView[][] texts;

        public ChildViewHolder(View view) {

            fxLayout = view.findViewById(R.id.jz_rqspf_elv_child_fx_layout);
            fxDetailLayout = view.findViewById(R.id.jz_rqspf_elv_child_fx_detail_layout);
            fxImageView = view.findViewById(R.id.jz_rqspf_elv_child_fx_icon);
            sLayout = view.findViewById(R.id.jz_rqspf_elv_s_pl_layout);
            pLayout = view.findViewById(R.id.jz_rqspf_elv_p_pl_layout);
            fLayout = view.findViewById(R.id.jz_rqspf_elv_f_pl_layout);
            s_numTextview = view.findViewById(R.id.jz_rqspf_elv_s_num_text);
            s_nameTextview = view.findViewById(R.id.jz_rqspf_elv_s_name_text);
            s_plTextview = view.findViewById(R.id.jz_rqspf_elv_s_pl_text);
            p_vsTextview = view.findViewById(R.id.jz_rqspf_elv_p_vs_text);
            p_plTextview = view.findViewById(R.id.jz_rqspf_elv_p_pl_text);
            f_nameTextview = view.findViewById(R.id.jz_rqspf_elv_f_name_text);
            f_numTextview = view.findViewById(R.id.jz_rqspf_elv_f_num_text);
            f_plTextview = view.findViewById(R.id.jz_rqspf_elv_f_pl_text);
            layouts = new LinearLayout[]{sLayout, pLayout, fLayout};

            texts = new TextView[][]{{s_nameTextview, s_numTextview, s_plTextview}, {p_vsTextview,
                    p_plTextview}, {f_nameTextview, f_numTextview, f_plTextview}};
        }
    }

}