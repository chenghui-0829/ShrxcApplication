package com.shrxc.sc.app.adapter;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shrxc.sc.app.R;
import com.shrxc.sc.app.utils.MyCheckLinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by CH on 2018/8/17.
 */

public class JzDgtzElvAdapter extends BaseExpandableListAdapter {

    private Context context;
    private Map<Integer, Map<Integer, Map<Integer, Integer>>> childs;

    public JzDgtzElvAdapter(Context context) {
        this.context = context;
        childs = JzAdapterUtil.initChilds(4, 3, 54);
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
    public View getChildView(final int gPos, final int cPos, boolean b, View view, ViewGroup viewGroup) {
        ChildViewHolder cvh;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.jz_dgtz_elv_child_layout, viewGroup, false);
            cvh = new ChildViewHolder(view);
            view.setTag(cvh);
        } else {
            cvh = (ChildViewHolder) view.getTag();
        }


        int selected = 0;

        for (Integer key : childs.get(gPos).get(cPos).keySet()) {

            if (key > 0 && childs.get(gPos).get(cPos).get(key) == 1) {
                selected++;
            }
            if (key < 4) {
                if (key == 0) {
                    if (childs.get(gPos).get(cPos).get(key) == 0) {
                        cvh.fxDetailLayout.setVisibility(View.GONE);
                        cvh.fxImageView.setImageResource(R.mipmap.app_down_gray_arow_icon);
                    } else {
                        cvh.fxDetailLayout.setVisibility(View.VISIBLE);
                        cvh.fxImageView.setImageResource(R.mipmap.app_up_gray_arow_icon);
                    }
                } else {
                    initViewState(childs.get(gPos).get(cPos).get(key), (LinearLayout) cvh.selectLayout.getChildAt(key - 1));
                }
            }
        }

        if (selected > 0) {
            cvh.selectedTextView.setText(Html.fromHtml("<font color='#fa3243'>" + selected + "</font>" + "项"));
            cvh.selectTextview.setText("已选");
        } else {
            cvh.selectTextview.setText("全部");
            cvh.selectedTextView.setText("选项");
        }

        cvh.qbxxLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQbxxDialog(gPos, cPos);
            }
        });

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
         * 非让球-胜
         */
        cvh.sLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeViewSet(gPos, cPos, 1);
            }
        });
        /**
         * 非让球-平
         */
        cvh.pLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeViewSet(gPos, cPos, 2);
            }
        });
        /**
         * 非让球-负
         */
        cvh.fLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeViewSet(gPos, cPos, 3);
            }
        });
        return view;
    }

    private void initViewState(int state, LinearLayout layout) {
        if (state == 0) {
            layout.setBackgroundResource(R.color.app_white_color_ffffff);
            for (int i = 0; i < layout.getChildCount(); i++) {
                if (i == 0) {
                    ((TextView) layout.getChildAt(i)).setTextColor(context.getResources().getColor(R.color.app_text_color_333333));
                } else {
                    ((TextView) layout.getChildAt(i)).setTextColor(context.getResources().getColor(R.color.app_text_color_999999));
                }
            }
        } else {
            layout.setBackgroundResource(R.color.app_red_color_fa3243);
            for (int i = 0; i < layout.getChildCount(); i++) {
                ((TextView) layout.getChildAt(i)).setTextColor(context.getResources().getColor(R.color.app_white_color_ffffff));
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


    private void showQbxxDialog(final int gPos, final int cPos) {

        final Dialog dialog = new Dialog(context, R.style.dialog);
        View view = LayoutInflater.from(context).inflate(
                R.layout.jz_dgtz_elv_child_qbxx_dialog_layout, null);

        final GridLayout sfLayout = view.findViewById(R.id.jz_dgtz_elv_qbxx_dialog_sf_layout);
        final GridLayout bfLayout = view.findViewById(R.id.jz_dgtz_elv_qbxx_dialog_bf_layout);
        final GridLayout zjqLayout = view.findViewById(R.id.jz_dgtz_elv_qbxx_dialog_zjq_layout);
        final GridLayout bcqLayout = view.findViewById(R.id.jz_dgtz_elv_qbxx_dialog_bqc_layout);
        final TextView sureTextView = view.findViewById(R.id.jz_dgtz_elv_qbxx_dialog_sure_text);
        final TextView cancleTextView = view.findViewById(R.id.jz_dgtz_elv_qbxx_dialog_cancle_text);


        dialog.setContentView(view);
        dialog.show();
        Window dialogWindow = dialog.getWindow();
        dialogWindow.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogWindow.setAttributes(lp);

        final List<MyCheckLinearLayout> allSelect = new ArrayList<>();
        for (int i = 0; i < sfLayout.getChildCount(); i++) {
            allSelect.add((MyCheckLinearLayout) sfLayout.getChildAt(i));
        }
        for (int i = 0; i < bfLayout.getChildCount(); i++) {
            allSelect.add((MyCheckLinearLayout) bfLayout.getChildAt(i));
        }
        for (int i = 0; i < zjqLayout.getChildCount(); i++) {
            allSelect.add((MyCheckLinearLayout) zjqLayout.getChildAt(i));
        }
        for (int i = 0; i < bcqLayout.getChildCount(); i++) {
            allSelect.add((MyCheckLinearLayout) bcqLayout.getChildAt(i));
        }

        for (Integer key : childs.get(gPos).get(cPos).keySet()) {
            if (key > 0 && childs.get(gPos).get(cPos).get(key) == 1) {
                allSelect.get(key - 1).setChecked(false);
                dialoChangeViewState(allSelect.get(key - 1));
            }
        }

        sureTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < allSelect.size(); i++) {
                    if (allSelect.get(i).isChecked()) {
                        childs.get(gPos).get(cPos).put(i + 1, 1);
                    } else {
                        childs.get(gPos).get(cPos).put(i + 1, 0);
                    }
                }
                dialog.dismiss();
                dialog.cancel();
                notifyDataSetChanged();
            }
        });
        cancleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                dialog.cancel();
            }
        });


        sfLayout.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) sfLayout.getChildAt(0));
            }
        });
        sfLayout.getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) sfLayout.getChildAt(1));
            }
        });
        sfLayout.getChildAt(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) sfLayout.getChildAt(2));
            }
        });

        bfLayout.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(0));
            }
        });
        bfLayout.getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(1));
            }
        });
        bfLayout.getChildAt(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(2));
            }
        });
        bfLayout.getChildAt(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(3));
            }
        });
        bfLayout.getChildAt(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(4));
            }
        });
        bfLayout.getChildAt(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(5));
            }
        });
        bfLayout.getChildAt(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(6));
            }
        });
        bfLayout.getChildAt(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(7));
            }
        });
        bfLayout.getChildAt(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(8));
            }
        });
        bfLayout.getChildAt(9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(9));
            }
        });
        bfLayout.getChildAt(10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(10));
            }
        });
        bfLayout.getChildAt(11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(11));
            }
        });
        bfLayout.getChildAt(12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(12));
            }
        });
        bfLayout.getChildAt(13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(13));
            }
        });
        bfLayout.getChildAt(14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(14));
            }
        });
        bfLayout.getChildAt(15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(15));
            }
        });
        bfLayout.getChildAt(16).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(16));
            }
        });
        bfLayout.getChildAt(17).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(17));
            }
        });
        bfLayout.getChildAt(18).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(18));
            }
        });
        bfLayout.getChildAt(19).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(19));
            }
        });
        bfLayout.getChildAt(20).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(20));
            }
        });
        bfLayout.getChildAt(21).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(21));
            }
        });
        bfLayout.getChildAt(22).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(22));
            }
        });
        bfLayout.getChildAt(23).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(23));
            }
        });
        bfLayout.getChildAt(24).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(24));
            }
        });
        bfLayout.getChildAt(25).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(25));
            }
        });
        bfLayout.getChildAt(26).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(26));
            }
        });
        bfLayout.getChildAt(27).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(27));
            }
        });
        bfLayout.getChildAt(28).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(28));
            }
        });
        bfLayout.getChildAt(29).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(29));
            }
        });
        bfLayout.getChildAt(30).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bfLayout.getChildAt(30));
            }
        });

        zjqLayout.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) zjqLayout.getChildAt(0));
            }
        });
        zjqLayout.getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) zjqLayout.getChildAt(1));
            }
        });
        zjqLayout.getChildAt(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) zjqLayout.getChildAt(2));
            }
        });
        zjqLayout.getChildAt(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) zjqLayout.getChildAt(3));
            }
        });
        zjqLayout.getChildAt(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) zjqLayout.getChildAt(4));
            }
        });
        zjqLayout.getChildAt(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) zjqLayout.getChildAt(5));
            }
        });
        zjqLayout.getChildAt(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) zjqLayout.getChildAt(6));
            }
        });
        zjqLayout.getChildAt(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) zjqLayout.getChildAt(7));
            }
        });

        bcqLayout.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bcqLayout.getChildAt(0));
            }
        });
        bcqLayout.getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bcqLayout.getChildAt(1));
            }
        });
        bcqLayout.getChildAt(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bcqLayout.getChildAt(2));
            }
        });
        bcqLayout.getChildAt(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bcqLayout.getChildAt(3));
            }
        });
        bcqLayout.getChildAt(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bcqLayout.getChildAt(4));
            }
        });
        bcqLayout.getChildAt(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bcqLayout.getChildAt(5));
            }
        });
        bcqLayout.getChildAt(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bcqLayout.getChildAt(6));
            }
        });
        bcqLayout.getChildAt(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bcqLayout.getChildAt(7));
            }
        });
        bcqLayout.getChildAt(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) bcqLayout.getChildAt(8));
            }
        });
    }

    private void dialoChangeViewState(MyCheckLinearLayout layout) {

        TextView t1 = (TextView) layout.getChildAt(0);
        TextView t2 = (TextView) layout.getChildAt(1);
        if (layout.isChecked()) {
            layout.setBackgroundResource(R.color.app_white_color_ffffff);
            t1.setTextColor(context.getResources().getColor(R.color.app_text_color_333333));
            t2.setTextColor(context.getResources().getColor(R.color.app_text_color_999999));
            layout.setChecked(false);
        } else {
            layout.setBackgroundResource(R.color.app_red_color_fa3243);
            t1.setTextColor(context.getResources().getColor(R.color.app_white_color_ffffff));
            t2.setTextColor(context.getResources().getColor(R.color.app_white_color_ffffff));
            layout.setChecked(true);
        }
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }


    private class GroupViewHolder {


    }

    private class ChildViewHolder {

        private LinearLayout qbxxLayout, fxLayout, sLayout, pLayout, fLayout, fxDetailLayout;
        private ImageView fxImageView;
        private TextView selectedTextView, selectTextview;
        private GridLayout selectLayout;

        public ChildViewHolder(View view) {

            qbxxLayout = view.findViewById(R.id.jz_dgtz_elv_qbxx_layout);
            fxLayout = view.findViewById(R.id.jz_dgtz_elv_child_fx_layout);
            sLayout = view.findViewById(R.id.jz_dgtz_elv_s_layout);
            pLayout = view.findViewById(R.id.jz_dgtz_elv_p_layout);
            fLayout = view.findViewById(R.id.jz_dgtz_elv_f_layout);
            fxDetailLayout = view.findViewById(R.id.jz_dgtz_elv_fx_detail_layout);
            fxImageView = view.findViewById(R.id.jz_dgtz_elv_child_fx_icon);
            selectLayout = view.findViewById(R.id.jz_dgtz_elv_select_layout);
            selectedTextView = view.findViewById(R.id.jz_dgtz_elv_qbxx_selected_size_text);
            selectTextview = view.findViewById(R.id.jz_dgtz_elv_qbxx_selected_text);
        }
    }
}