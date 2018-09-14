package com.shrxc.sc.app.adapter;

import android.content.Context;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shrxc.sc.app.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CH on 2018/9/7.
 */

public class JzAdapterUtil {


    public static Map<Integer, Map<Integer, Map<Integer, Integer>>> initChilds(int groupCount, int childCount, int selectCount) {

        Map<Integer, Map<Integer, Map<Integer, Integer>>> childs = new HashMap<>();
        for (int i = 0; i < groupCount; i++) {
            Map<Integer, Map<Integer, Integer>> cPos = new HashMap<>();
            for (int j = 0; j < childCount; j++) {
                Map<Integer, Integer> selects = new HashMap<>();
                for (int k = 0; k < selectCount; k++) {
                    selects.put(k, 0);
                }
                cPos.put(j, selects);
            }
            childs.put(i, cPos);
        }
        return childs;
    }

    public static void initViewState(Context context, int state, LinearLayout layout) {
        if (state == 0) {
            layout.setBackgroundResource(R.color.app_white_color_ffffff);
            for (int i = 0; i < layout.getChildCount(); i++) {
                if (i == 0) {
                    ((TextView) layout.getChildAt(0)).setTextColor(context.getResources().getColor(R.color.app_text_color_333333));
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

    public static void changeViewSet(BaseExpandableListAdapter adapter, int gPos, int cPos, int index, Map<Integer, Map<Integer, Map<Integer, Integer>>> childs) {

        int state = childs.get(gPos).get(cPos).get(index);
        if (state == 0) {
            childs.get(gPos).get(cPos).put(index, 1);
        } else {
            childs.get(gPos).get(cPos).put(index, 0);
        }
        adapter.notifyDataSetChanged();
    }

    public static TextView[] getLayoutChild(LinearLayout layout, int type) {

        TextView[] textViews = new TextView[0];
        if (type == 0) {
            textViews[0] = (TextView) layout.getChildAt(0);
            textViews[1] = (TextView) layout.getChildAt(1);
        } else if (type == 1) {
            LinearLayout childLayout = (LinearLayout) layout.getChildAt(0);
            textViews[0] = (TextView) childLayout.getChildAt(1);
            textViews[1] = (TextView) childLayout.getChildAt(0);
            textViews[2] = (TextView) layout.getChildAt(1);
        } else if (type == 2) {
            LinearLayout childLayout = (LinearLayout) layout.getChildAt(0);
            textViews[0] = (TextView) childLayout.getChildAt(0);
            textViews[1] = (TextView) childLayout.getChildAt(1);
            textViews[2] = (TextView) layout.getChildAt(1);
        }
        return textViews;
    }
}
