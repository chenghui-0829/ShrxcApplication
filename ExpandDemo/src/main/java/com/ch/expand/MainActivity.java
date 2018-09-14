package com.ch.expand;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;

/**
 * @author Apathy、恒
 *         <p>
 *         <br/>
 * @email shexiaoheng@163.com
 * @blog <a href='http://blog.csdn.net/shexiaoheng'>http://blog.csdn.net/shexiaoheng</a >
 * <p>
 * <br/>
 * <br/>
 * @Detail 本Demo为ExpandableListView嵌套ExpandableListView实现三级菜单的例子
 * <p>
 * #JzspfGroupAdapter.OnChildTreeViewClickListener
 */
public class MainActivity extends Activity {

    private Context mContext;

    private ExpandableListView eList;

    private ArrayList<ParentEntity> parents;

    private JzspfGroupAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;

        setContentView(R.layout.activity_main);

        loadData();

        initEList();


        final MyCheckLinearLayout myview = findViewById(R.id.jz_spf_elv_child_s_layout);

        myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myview.isChecked()) {
                    myview.setBackgroundResource(R.color.app_red_color_fa3243);
                    myview.setChecked(false);
                } else {
                    myview.setBackgroundResource(R.drawable.app_gray_stroke_color);
                    myview.setChecked(true);
                }
                System.out.println("---------->" + myview.isChecked());
            }
        });
    }

    /**
     * @author Apathy、恒
     * <p>
     * 初始化菜单数据源
     */
    private void loadData() {

        parents = new ArrayList<ParentEntity>();

        for (int i = 0; i < 10; i++) {

            ParentEntity parent = new ParentEntity();

            parent.setGroupName("父类父分组第" + i + "项");

            parent.setGroupColor(getResources().getColor(
                    android.R.color.holo_red_light));

            ArrayList<ChildEntity> childs = new ArrayList<ChildEntity>();

            for (int j = 0; j < 5; j++) {

                ChildEntity child = new ChildEntity();

                child.setGroupName("子类父分组第" + j + "项");

                child.setGroupColor(Color.parseColor("#ff00ff"));

                ArrayList<String> childNames = new ArrayList<String>();

                ArrayList<Integer> childColors = new ArrayList<Integer>();

                for (int k = 0; k < 1; k++) {

                    childNames.add("子类第" + k + "项");

                    childColors.add(Color.parseColor("#ff00ff"));

                }

                child.setChildNames(childNames);

                childs.add(child);

            }

            parent.setChilds(childs);

            parents.add(parent);

        }
    }

    /**
     * @author Apathy、恒
     * <p>
     * 初始化ExpandableListView
     */
    private void initEList() {

        eList = (ExpandableListView) findViewById(R.id.eList);
        adapter = new JzspfGroupAdapter(mContext, parents);

        eList.setAdapter(adapter);
        eList.expandGroup(0);
//        adapter.setOnChildTreeViewClickListener(this);
    }

    /**
     * @author Apathy、恒
     * <p>
     * 点击子ExpandableListView的子项时，回调本方法，根据下标获取值来做相应的操作
     */
//    @Override
//    public void onClickPosition(int parentPosition, int groupPosition,
//                                int childPosition) {
//        // do something
//        String childName = parents.get(parentPosition).getChilds()
//                .get(groupPosition).getChildNames().get(childPosition)
//                .toString();
//        Toast.makeText(
//                mContext,
//                "点击的下标为： parentPosition=" + parentPosition
//                        + "   groupPosition=" + groupPosition
//                        + "   childPosition=" + childPosition + "\n点击的是："
//                        + childName, Toast.LENGTH_SHORT).show();
//    }


}
