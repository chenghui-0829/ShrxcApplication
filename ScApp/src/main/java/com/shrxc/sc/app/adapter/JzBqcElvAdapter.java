package com.shrxc.sc.app.adapter;

import android.app.Dialog;
import android.content.Context;
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

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CH on 2018/8/17.
 */

public class JzBqcElvAdapter extends BaseExpandableListAdapter {

    @BindView(R.id.jz_bqc_elv_dialog_select_layout)
    GridLayout dialogSelectLayout;
    @BindView(R.id.jz_bqc_elv_dialog_cancle_text)
    TextView dialogCancleText;
    @BindView(R.id.jz_bqc_elv_dialog_sure_text)
    TextView dialogSureText;
    private Context context;
    private Map<Integer, Map<Integer, Map<Integer, Integer>>> childs;

    public JzBqcElvAdapter(Context context) {
        this.context = context;
        childs = JzAdapterUtil.initChilds(4, 3, 10);
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
            view = LayoutInflater.from(context).inflate(R.layout.jz_bcq_elv_child_layout, viewGroup, false);
            cvh = new ChildViewHolder(view);
            view.setTag(cvh);
        } else {
            cvh = (ChildViewHolder) view.getTag();
        }

        StringBuffer sb = new StringBuffer();
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
                if (childs.get(gPos).get(cPos).get(key) == 1) {
                    if (childs.get(gPos).get(cPos).get(key) == 1) {
                        String text=((TextView)((MyCheckLinearLayout)dialogSelectLayout.getChildAt(key-1)).getChildAt(0)).getText().toString().trim();
                        sb.append(text+" ");
                    }
                }
            }
        }
        if (sb.length() == 0) {
            cvh.bqcxxTextView.setText("点击展开半全场选项");
            cvh.bqcxxTextView.setTextColor(context.getResources().getColor(R.color.app_text_color_666666));
        } else {
            cvh.bqcxxTextView.setText(sb.toString());
            cvh.bqcxxTextView.setTextColor(context.getResources().getColor(R.color.app_red_color_fa3243));
        }

        cvh.fxLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JzAdapterUtil.changeViewSet(JzBqcElvAdapter.this, gPos, cPos, 0, childs);
            }
        });


        cvh.bqcxxTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBqcDialog(gPos, cPos);
            }
        });
        return view;
    }


    private void showBqcDialog(final int gPos, final int cPos) {
        final Dialog dialog = new Dialog(context, R.style.dialog);
        View view = LayoutInflater.from(context).inflate(
                R.layout.jz_bcq_elv_child_bcqxx_dialog_layout, null);
        dialog.setContentView(view);
        dialog.show();
        ButterKnife.bind(this, view);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogWindow.setAttributes(lp);

        for (Integer key : childs.get(gPos).get(cPos).keySet()) {
            if (key > 0 && childs.get(gPos).get(cPos).get(key) == 1) {
                ((MyCheckLinearLayout) dialogSelectLayout.getChildAt(key - 1)).setChecked(false);
                dialoChangeViewState((MyCheckLinearLayout) dialogSelectLayout.getChildAt(key - 1));
            }
        }

        dialogSureText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < dialogSelectLayout.getChildCount(); i++) {
                    if (((MyCheckLinearLayout) dialogSelectLayout.getChildAt(i)).isChecked()) {
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
        dialogCancleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                dialog.cancel();
            }
        });


        dialogSelectLayout.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) dialogSelectLayout.getChildAt(0));
            }
        });
        dialogSelectLayout.getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) dialogSelectLayout.getChildAt(1));
            }
        });
        dialogSelectLayout.getChildAt(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) dialogSelectLayout.getChildAt(2));
            }
        });
        dialogSelectLayout.getChildAt(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) dialogSelectLayout.getChildAt(3));
            }
        });
        dialogSelectLayout.getChildAt(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) dialogSelectLayout.getChildAt(4));
            }
        });
        dialogSelectLayout.getChildAt(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) dialogSelectLayout.getChildAt(5));
            }
        });
        dialogSelectLayout.getChildAt(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) dialogSelectLayout.getChildAt(6));
            }
        });
        dialogSelectLayout.getChildAt(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) dialogSelectLayout.getChildAt(7));
            }
        });
        dialogSelectLayout.getChildAt(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoChangeViewState((MyCheckLinearLayout) dialogSelectLayout.getChildAt(8));
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
        private ImageView arrowImage;

        public GroupViewHolder(View view) {
            arrowImage = view.findViewById(R.id.jz_group_arrow_icon);
        }

    }

    private class ChildViewHolder {

        private TextView bqcxxTextView;
        private ImageView fxImageView;
        private LinearLayout fxLayout, fxDetailLayout;

        public ChildViewHolder(View view) {
            bqcxxTextView = view.findViewById(R.id.jz_bqc_elv_child_bqcxx_text);
            fxLayout = view.findViewById(R.id.jz_bqc_elv_fx_layout);
            fxDetailLayout = view.findViewById(R.id.jz_bqc_elv_child_fx_detail_layout);
            fxImageView = view.findViewById(R.id.jz_bqc_elv_fx_icon);
        }
    }

}