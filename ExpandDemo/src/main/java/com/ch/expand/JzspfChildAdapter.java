package com.ch.expand;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author Apathy、恒
 *         <p>
 *         <br/>
 *         <br/>
 *         <p>
 *         子类分组的适配器
 *         <p>
 *         <br/>
 *         <br/>
 *         <p>
 *         方法{@link #isChildSelectable(int, int)} <b><font color='#ff00ff'
 *         size='2'>必须返回true</font></b>
 */
public class JzspfChildAdapter extends BaseExpandableListAdapter {

    private Context mContext;// 上下文
    GroupHolder holder = null;
    private ArrayList<ChildEntity> mChilds;// 数据源

    public JzspfChildAdapter(Context context, ArrayList<ChildEntity> childs) {
        this.mContext = context;
        this.mChilds = childs;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mChilds.get(groupPosition).getChildNames() != null ? mChilds
                .get(groupPosition).getChildNames().size() : 0;
    }

    @Override
    public String getChild(int groupPosition, int childPosition) {
        if (mChilds.get(groupPosition).getChildNames() != null
                && mChilds.get(groupPosition).getChildNames().size() > 0)
            return mChilds.get(groupPosition).getChildNames()
                    .get(childPosition).toString();
        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isExpanded, View convertView, ViewGroup parent) {
        ChildHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.jz_ssfx_layout, null);
            holder = new ChildHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ChildHolder) convertView.getTag();
        }
//        holder.update(getChild(groupPosition, childPosition));
        return convertView;
    }

    /**
     * @author Apathy、恒
     *         <p>
     *         Holder优化
     */
    class ChildHolder {


        private TextView childChildTV;

        public ChildHolder(View v) {
            childChildTV = (TextView) v.findViewById(R.id.childChildTV);
        }

        public void update(String str) {
            childChildTV.setText(str);
            childChildTV.setTextColor(Color.parseColor("#00ffff"));
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        if (mChilds != null && mChilds.size() > 0)
            return mChilds.get(groupPosition);
        return null;
    }

    @Override
    public int getGroupCount() {
        return mChilds != null ? mChilds.size() : 0;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
//        GroupHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.jz_spf_elv_child_layout, null);
            holder = new GroupHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (GroupHolder) convertView.getTag();
        }

//        holder.layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(mContext, "55555", Toast.LENGTH_SHORT).show();
//            }
//        });

        holder.sLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.sLayout.isChecked()) {
                    holder.sLayout.setBackgroundResource(R.drawable.app_gray_stroke_color);
                    holder.sLayout.setChecked(false);
                } else {
                    holder.sLayout.setBackgroundResource(R.color.app_red_color_fa3243);
                    holder.sLayout.setChecked(true);
                }
            }
        });

        holder.pLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.pLayout.isChecked()) {
                    holder.pLayout.setBackgroundResource(R.drawable.app_gray_stroke_color);
                    holder.pLayout.setChecked(false);
                } else {
                    holder.pLayout.setBackgroundResource(R.color.app_red_color_fa3243);
                    holder.pLayout.setChecked(true);
                }
            }
        });

        holder.fLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.fLayout.isChecked()) {
                    holder.fLayout.setBackgroundResource(R.drawable.app_gray_stroke_color);
                    holder.fLayout.setChecked(false);
                } else {
                    holder.fLayout.setBackgroundResource(R.color.app_red_color_fa3243);
                    holder.fLayout.setChecked(true);
                }
            }
        });

//        holder.update(mChilds.get(groupPosition));
        return convertView;
    }

    /**
     * @author Apathy、恒
     *         <p>
     *         Holder优化
     */
    class GroupHolder {

        private TextView childGroupTV;
        MyCheckLinearLayout layout, sLayout, pLayout, fLayout;

        public GroupHolder(View v) {
//            layout = v.findViewById(R.id.jz_spf_elv_child_bf_layout);
            sLayout = v.findViewById(R.id.jz_spf_elv_child_s_layout);
            pLayout = v.findViewById(R.id.jz_spf_elv_child_p_layout);
            fLayout = v.findViewById(R.id.jz_spf_elv_child_f_layout);
//            childGroupTV = (TextView) v.findViewById(R.id.childGroupTV);
        }

//        public void update(ChildEntity model) {
//            childGroupTV.setText(model.getGroupName());
//            childGroupTV.setTextColor(model.getGroupColor());
//        }
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        /**
         * ==============================================
         * 此处必须返回true，否则无法响应子项的点击事件===============
         * ==============================================
         **/
        return true;
    }

}
