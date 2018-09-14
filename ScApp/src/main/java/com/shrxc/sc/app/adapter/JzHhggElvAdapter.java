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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by CH on 2018/8/17.
 */

public class JzHhggElvAdapter extends BaseExpandableListAdapter {


    @BindViews({R.id.jz_hhgg_elv_qbxx_dialog_frq_s_layout, R.id.jz_hhgg_elv_qbxx_dialog_frq_p_layout, R.id.jz_hhgg_elv_qbxx_dialog_frq_f_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_rq_s_layout, R.id.jz_hhgg_elv_qbxx_dialog_rq_p_layout, R.id.jz_hhgg_elv_qbxx_dialog_rq_f_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_1_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_2_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_2_1_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_3_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_3_1_layout, R.id.jz_hhgg_elv_qbxx_dialog_3_2_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_4_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_4_1_layout, R.id.jz_hhgg_elv_qbxx_dialog_4_2_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_5_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_5_1_layout, R.id.jz_hhgg_elv_qbxx_dialog_5_2_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_s_other_layout, R.id.jz_hhgg_elv_qbxx_dialog_0_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_1_1_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_2_2_layout, R.id.jz_hhgg_elv_qbxx_dialog_3_3_layout, R.id.jz_hhgg_elv_qbxx_dialog_p_other_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_0_1_layout, R.id.jz_hhgg_elv_qbxx_dialog_0_2_layout, R.id.jz_hhgg_elv_qbxx_dialog_1_2_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_0_3_layout, R.id.jz_hhgg_elv_qbxx_dialog_1_3_layout, R.id.jz_hhgg_elv_qbxx_dialog_2_3_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_0_4_layout, R.id.jz_hhgg_elv_qbxx_dialog_1_4_layout, R.id.jz_hhgg_elv_qbxx_dialog_2_4_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_0_5_layout, R.id.jz_hhgg_elv_qbxx_dialog_1_5_layout, R.id.jz_hhgg_elv_qbxx_dialog_2_5_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_f_other_layout, R.id.jz_hhgg_elv_qbxx_dialog_jqs_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_jqs_1_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_jqs_2_layout, R.id.jz_hhgg_elv_qbxx_dialog_jqs_3_layout, R.id.jz_hhgg_elv_qbxx_dialog_jqs_4_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_jqs_5_layout, R.id.jz_hhgg_elv_qbxx_dialog_jqs_6_layout, R.id.jz_hhgg_elv_qbxx_dialog_jqs_7_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_bqc_ss_layout, R.id.jz_hhgg_elv_qbxx_dialog_bqc_sp_layout, R.id.jz_hhgg_elv_qbxx_dialog_bqc_sf_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_bqc_ps_layout, R.id.jz_hhgg_elv_qbxx_dialog_bqc_pp_layout, R.id.jz_hhgg_elv_qbxx_dialog_bqc_pf_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_bqc_fs_layout, R.id.jz_hhgg_elv_qbxx_dialog_bqc_fp_layout, R.id.jz_hhgg_elv_qbxx_dialog_bqc_ff_layout})
    List<MyCheckLinearLayout> allSelects;

    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_cancle_text)
    TextView dialogCancleText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_sure_text)
    TextView dialogSureText;
    @BindView(R.id.dgelv_child_bottom_linear)
    LinearLayout dgelvChildBottomLinear;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_frq_s_text)
    TextView dialogFrqSText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_frq_s_pl_text)
    TextView dialogFrqSPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_frq_s_layout)
    MyCheckLinearLayout dialogFrqSLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_frq_p_text)
    TextView dialogFrqPText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_frq_p_pl_text)
    TextView dialogFrqPPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_frq_p_layout)
    MyCheckLinearLayout dialogFrqPLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_frq_f_text)
    TextView dialogFrqFText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_frq_f_pl_text)
    TextView dialogFrqFPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_frq_f_layout)
    MyCheckLinearLayout dialogFrqFLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_rq_s_text)
    TextView dialogRqSText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_rq_s_pl_text)
    TextView dialogRqSPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_rq_s_layout)
    MyCheckLinearLayout dialogRqSLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_rq_p_text)
    TextView dialogRqPText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_rq_p_pl_text)
    TextView dialogRqPPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_rq_p_layout)
    MyCheckLinearLayout dialogRqPLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_rq_f_text)
    TextView dialogRqFText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_rq_f_pl_text)
    TextView dialogRqFPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_rq_f_layout)
    MyCheckLinearLayout dialogRqFLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_0_text)
    TextView dialog10Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_0_pl_text)
    TextView dialog10PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_0_layout)
    MyCheckLinearLayout dialog10Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_0_text)
    TextView dialog20Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_0_pl_text)
    TextView dialog20PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_0_layout)
    MyCheckLinearLayout dialog20Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_1_text)
    TextView dialog21Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_1_pl_text)
    TextView dialog21PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_1_layout)
    MyCheckLinearLayout dialog21Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_3_0_text)
    TextView dialog30Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_3_0_pl_text)
    TextView dialog30PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_3_0_layout)
    MyCheckLinearLayout dialog30Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_3_1_text)
    TextView dialog31Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_3_1_pl_text)
    TextView dialog31PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_3_1_layout)
    MyCheckLinearLayout dialog31Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_3_2_text)
    TextView dialog32Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_3_2_pl_text)
    TextView dialog32PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_3_2_layout)
    MyCheckLinearLayout dialog32Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_4_0_text)
    TextView dialog40Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_4_0_pl_text)
    TextView dialog40PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_4_0_layout)
    MyCheckLinearLayout dialog40Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_4_1_text)
    TextView dialog41Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_4_1_pl_text)
    TextView dialog41PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_4_1_layout)
    MyCheckLinearLayout dialog41Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_4_2_text)
    TextView dialog42Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_4_2_pl_text)
    TextView dialog42PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_4_2_layout)
    MyCheckLinearLayout dialog42Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_5_0_text)
    TextView dialog50Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_5_0_pl_text)
    TextView dialog50PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_5_0_layout)
    MyCheckLinearLayout dialog50Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_5_1_text)
    TextView dialog51Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_5_1_pl_text)
    TextView dialog51PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_5_1_layout)
    MyCheckLinearLayout dialog51Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_5_2_text)
    TextView dialog52Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_5_2_pl_text)
    TextView dialog52PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_5_2_layout)
    MyCheckLinearLayout dialog52Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_s_other_text)
    TextView dialogSOtherText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_s_other_pl_text)
    TextView dialogSOtherPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_s_other_layout)
    MyCheckLinearLayout dialogSOtherLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_0_text)
    TextView dialog00Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_0_pl_text)
    TextView dialog00PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_0_layout)
    MyCheckLinearLayout dialog00Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_1_text)
    TextView dialog11Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_1_pl_text)
    TextView dialog11PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_1_layout)
    MyCheckLinearLayout dialog11Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_2_text)
    TextView dialog22Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_2_pl_text)
    TextView dialog22PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_2_layout)
    MyCheckLinearLayout dialog22Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_3_3_text)
    TextView dialog33Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_3_3_pl_text)
    TextView dialog33PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_3_3_layout)
    MyCheckLinearLayout dialog33Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_p_other_text)
    TextView dialogPOtherText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_p_other_pl_text)
    TextView dialogPOtherPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_p_other_layout)
    MyCheckLinearLayout dialogPOtherLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_1_text)
    TextView dialog01Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_1_pl_text)
    TextView dialog01PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_1_layout)
    MyCheckLinearLayout dialog01Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_2_text)
    TextView dialog02Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_2_pl_text)
    TextView dialog02PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_2_layout)
    MyCheckLinearLayout dialog02Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_2_text)
    TextView dialog12Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_2_pl_text)
    TextView dialog12PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_2_layout)
    MyCheckLinearLayout dialog12Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_3_text)
    TextView dialog03Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_3_pl_text)
    TextView dialog03PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_3_layout)
    MyCheckLinearLayout dialog03Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_3_text)
    TextView dialog13Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_3_pl_text)
    TextView dialog13PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_3_layout)
    MyCheckLinearLayout dialog13Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_3_text)
    TextView dialog23Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_3_pl_text)
    TextView dialog23PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_3_layout)
    MyCheckLinearLayout dialog23Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_4_text)
    TextView dialog04Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_4_pl_text)
    TextView dialog04PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_4_layout)
    MyCheckLinearLayout dialog04Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_4_text)
    TextView dialog14Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_4_pl_text)
    TextView dialog14PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_4_layout)
    MyCheckLinearLayout dialog14Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_4_text)
    TextView dialog24Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_4_pl_text)
    TextView dialog24PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_4_layout)
    MyCheckLinearLayout dialog24Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_5_text)
    TextView dialog05Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_5_pl_text)
    TextView dialog05PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_0_5_layout)
    MyCheckLinearLayout dialog05Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_5_text)
    TextView dialog15Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_5_pl_text)
    TextView dialog15PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_1_5_layout)
    MyCheckLinearLayout dialog15Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_5_text)
    TextView dialog25Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_5_pl_text)
    TextView dialog25PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_2_5_layout)
    MyCheckLinearLayout dialog25Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_f_other_text)
    TextView dialogFOtherText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_f_other_pl_text)
    TextView dialogFOtherPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_f_other_layout)
    MyCheckLinearLayout dialogFOtherLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_0_text)
    TextView dialogJqs0Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_0_pl_text)
    TextView dialogJqs0PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_0_layout)
    MyCheckLinearLayout dialogJqs0Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_1_text)
    TextView dialogJqs1Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_1_pl_text)
    TextView dialogJqs1PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_1_layout)
    MyCheckLinearLayout dialogJqs1Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_2_text)
    TextView dialogJqs2Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_2_pl_text)
    TextView dialogJqs2PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_2_layout)
    MyCheckLinearLayout dialogJqs2Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_3_text)
    TextView dialogJqs3Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_3_pl_text)
    TextView dialogJqs3PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_3_layout)
    MyCheckLinearLayout dialogJqs3Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_4_text)
    TextView dialogJqs4Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_4_pl_text)
    TextView dialogJqs4PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_4_layout)
    MyCheckLinearLayout dialogJqs4Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_5_text)
    TextView dialogJqs5Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_5_pl_text)
    TextView dialogJqs5PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_5_layout)
    MyCheckLinearLayout dialogJqs5Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_6_text)
    TextView dialogJqs6Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_6_pl_text)
    TextView dialogJqs6PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_6_layout)
    MyCheckLinearLayout dialogJqs6Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_7_text)
    TextView dialogJqs7Text;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_7_pl_text)
    TextView dialogJqs7PlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_jqs_7_layout)
    MyCheckLinearLayout dialogJqs7Layout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_ss_text)
    TextView dialogBqcSsText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_ss_pl_text)
    TextView dialogBqcSsPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_ss_layout)
    MyCheckLinearLayout dialogBqcSsLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_sp_text)
    TextView dialogBqcSpText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_sp_pl_text)
    TextView dialogBqcSpPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_sp_layout)
    MyCheckLinearLayout dialogBqcSpLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_sf_text)
    TextView dialogBqcSfText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_sf_pl_text)
    TextView dialogBqcSfPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_sf_layout)
    MyCheckLinearLayout dialogBqcSfLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_ps_text)
    TextView dialogBqcPsText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_ps_pl_text)
    TextView dialogBqcPsPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_ps_layout)
    MyCheckLinearLayout dialogBqcPsLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_pp_text)
    TextView dialogBqcPpText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_pp_pl_text)
    TextView dialogBqcPpPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_pp_layout)
    MyCheckLinearLayout dialogBqcPpLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_pf_text)
    TextView dialogBqcPfText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_pf_pl_text)
    TextView dialogBqcPfPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_pf_layout)
    MyCheckLinearLayout dialogBqcPfLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_fs_text)
    TextView dialogBqcFsText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_fs_pl_text)
    TextView dialogBqcFsPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_fs_layout)
    LinearLayout dialogBqcFsLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_fp_text)
    TextView dialogBqcFpText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_fp_pl_text)
    TextView dialogBqcFpPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_fp_layout)
    LinearLayout dialogBqcFpLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_ff_text)
    TextView dialogBqcFfText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_rr_pl_text)
    TextView dialogBqcRrPlText;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_ff_layout)
    LinearLayout dialogBqcFfLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_sf_layout)
    GridLayout dialogSfLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bf_layout)
    GridLayout dialogBfLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_zjq_layout)
    GridLayout dialogZjqLayout;
    @BindView(R.id.jz_hhgg_elv_qbxx_dialog_bqc_layout)
    GridLayout dialogBqcLayout;
    private Context context;
    private Map<Integer, Map<Integer, Map<Integer, Integer>>> childs;

    public JzHhggElvAdapter(Context context) {
        this.context = context;
        initChilds();
    }

    private void initChilds() {

        childs = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            Map<Integer, Map<Integer, Integer>> cPos = new HashMap<>();
            for (int j = 0; j < 3; j++) {
                Map<Integer, Integer> selects = new HashMap<>();
                for (int k = 0; k < 55; k++) {
                    selects.put(k, 0);
                }
                cPos.put(j, selects);
            }
            childs.put(i, cPos);
        }
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
            view = LayoutInflater.from(context).inflate(R.layout.jz_hhgg_elv_child_layout, viewGroup, false);
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
            if (key < 7) {
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
        }

        if (selected > 0) {
            cvh.selectedTextView.setText(Html.fromHtml("<font color='#fa3243'>" + selected + "</font>" + "项"));
            cvh.selectTextview.setText("已选");
        } else {
            cvh.selectTextview.setText("全部");
            cvh.selectedTextView.setText("选项");
        }

        /***
         * 全部选项
         */
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
        /**
         * 让球-胜
         */
        cvh.rq_sLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeViewSet(gPos, cPos, 4);
            }
        });
        /**
         * 让球-平
         */
        cvh.rq_pLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeViewSet(gPos, cPos, 5);
            }
        });
        /**
         * 让球-负
         */
        cvh.rq_fLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeViewSet(gPos, cPos, 6);
            }
        });
        return view;
    }

    private void showQbxxDialog(final int gPos, final int cPos) {

        final Dialog dialog = new Dialog(context, R.style.dialog);
        View view = LayoutInflater.from(context).inflate(
                R.layout.jz_hhgg_elv_child_qbxx_dialog_layout, null);
        dialog.setContentView(view);
        ButterKnife.bind(this, view);
        dialog.show();
        Window dialogWindow = dialog.getWindow();
        dialogWindow.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogWindow.setAttributes(lp);

        for (Integer key : childs.get(gPos).get(cPos).keySet()) {
            if (key > 0 && childs.get(gPos).get(cPos).get(key) == 1) {
                allSelects.get(key - 1).setChecked(false);
                dialoChangeViewState(allSelects.get(key - 1));
            }
        }

        dialogSureText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < allSelects.size(); i++) {
                    if (allSelects.get(i).isChecked()) {
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
    }

    @OnClick({R.id.jz_hhgg_elv_qbxx_dialog_frq_s_layout, R.id.jz_hhgg_elv_qbxx_dialog_frq_p_layout, R.id.jz_hhgg_elv_qbxx_dialog_frq_f_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_rq_s_layout, R.id.jz_hhgg_elv_qbxx_dialog_rq_p_layout, R.id.jz_hhgg_elv_qbxx_dialog_rq_f_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_1_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_2_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_2_1_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_3_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_3_1_layout, R.id.jz_hhgg_elv_qbxx_dialog_3_2_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_4_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_4_1_layout, R.id.jz_hhgg_elv_qbxx_dialog_4_2_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_5_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_5_1_layout, R.id.jz_hhgg_elv_qbxx_dialog_5_2_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_s_other_layout, R.id.jz_hhgg_elv_qbxx_dialog_0_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_1_1_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_2_2_layout, R.id.jz_hhgg_elv_qbxx_dialog_3_3_layout, R.id.jz_hhgg_elv_qbxx_dialog_p_other_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_0_1_layout, R.id.jz_hhgg_elv_qbxx_dialog_0_2_layout, R.id.jz_hhgg_elv_qbxx_dialog_1_2_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_0_3_layout, R.id.jz_hhgg_elv_qbxx_dialog_1_3_layout, R.id.jz_hhgg_elv_qbxx_dialog_2_3_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_0_4_layout, R.id.jz_hhgg_elv_qbxx_dialog_1_4_layout, R.id.jz_hhgg_elv_qbxx_dialog_2_4_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_0_5_layout, R.id.jz_hhgg_elv_qbxx_dialog_1_5_layout, R.id.jz_hhgg_elv_qbxx_dialog_2_5_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_f_other_layout, R.id.jz_hhgg_elv_qbxx_dialog_jqs_0_layout, R.id.jz_hhgg_elv_qbxx_dialog_jqs_1_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_jqs_2_layout, R.id.jz_hhgg_elv_qbxx_dialog_jqs_3_layout, R.id.jz_hhgg_elv_qbxx_dialog_jqs_4_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_jqs_5_layout, R.id.jz_hhgg_elv_qbxx_dialog_jqs_6_layout, R.id.jz_hhgg_elv_qbxx_dialog_jqs_7_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_bqc_ss_layout, R.id.jz_hhgg_elv_qbxx_dialog_bqc_sp_layout, R.id.jz_hhgg_elv_qbxx_dialog_bqc_sf_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_bqc_ps_layout, R.id.jz_hhgg_elv_qbxx_dialog_bqc_pp_layout, R.id.jz_hhgg_elv_qbxx_dialog_bqc_pf_layout,
            R.id.jz_hhgg_elv_qbxx_dialog_bqc_fs_layout, R.id.jz_hhgg_elv_qbxx_dialog_bqc_fp_layout, R.id.jz_hhgg_elv_qbxx_dialog_bqc_ff_layout})
    public void dialogOnClick(View v) {
        switch (v.getId()) {
            case R.id.jz_hhgg_elv_qbxx_dialog_frq_s_layout://胜
                dialoChangeViewState((MyCheckLinearLayout) dialogSfLayout.getChildAt(0));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_frq_p_layout://平
                dialoChangeViewState((MyCheckLinearLayout) dialogSfLayout.getChildAt(1));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_frq_f_layout://负
                dialoChangeViewState((MyCheckLinearLayout) dialogSfLayout.getChildAt(2));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_rq_s_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogSfLayout.getChildAt(3));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_rq_p_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogSfLayout.getChildAt(4));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_rq_f_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogSfLayout.getChildAt(5));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_1_0_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(0));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_2_0_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(1));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_2_1_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(2));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_3_0_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(3));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_3_1_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(4));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_3_2_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(5));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_4_0_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(6));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_4_1_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(7));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_4_2_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(8));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_5_0_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(9));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_5_1_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(10));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_5_2_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(11));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_s_other_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(12));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_0_0_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(13));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_1_1_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(14));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_2_2_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(15));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_3_3_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(16));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_p_other_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(17));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_0_1_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(18));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_0_2_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(19));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_1_2_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(20));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_0_3_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(21));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_1_3_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(22));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_2_3_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(23));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_0_4_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(24));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_1_4_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(25));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_2_4_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(26));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_0_5_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(27));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_1_5_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(28));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_2_5_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(29));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_f_other_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBfLayout.getChildAt(30));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_jqs_0_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogZjqLayout.getChildAt(0));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_jqs_1_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogZjqLayout.getChildAt(1));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_jqs_2_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogZjqLayout.getChildAt(2));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_jqs_3_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogZjqLayout.getChildAt(3));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_jqs_4_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogZjqLayout.getChildAt(4));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_jqs_5_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogZjqLayout.getChildAt(5));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_jqs_6_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogZjqLayout.getChildAt(6));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_jqs_7_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogZjqLayout.getChildAt(7));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_bqc_ss_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBqcLayout.getChildAt(0));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_bqc_sp_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBqcLayout.getChildAt(1));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_bqc_sf_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBqcLayout.getChildAt(2));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_bqc_ps_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBqcLayout.getChildAt(3));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_bqc_pp_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBqcLayout.getChildAt(4));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_bqc_pf_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBqcLayout.getChildAt(5));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_bqc_fs_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBqcLayout.getChildAt(6));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_bqc_fp_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBqcLayout.getChildAt(7));
                break;
            case R.id.jz_hhgg_elv_qbxx_dialog_bqc_ff_layout:
                dialoChangeViewState((MyCheckLinearLayout) dialogBqcLayout.getChildAt(8));
                break;
        }
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


    private void initViewState(int state, LinearLayout layout, TextView[] texts) {
        if (state == 0) {
            layout.setBackgroundResource(R.color.app_white_color_ffffff);
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

    private class GroupViewHolder {

        private ImageView arrowImage;

        public GroupViewHolder(View view) {
            arrowImage = view.findViewById(R.id.jz_group_arrow_icon);
        }

    }

    private class ChildViewHolder {

        private TextView s_Textview, s_plTextview, p_Textview, p_plTextview, f_Textview,
                f_plTextview, rq_s_Textview, rq_s_plTextview, rq_p_Textview, rq_p_plTextview, rq_f_Textview,
                rq_f_plTextview, selectedTextView, selectTextview;
        private ImageView fxImageView;
        private LinearLayout qbxxLayout, fxLayout, sLayout, pLayout, fLayout, rq_sLayout, rq_pLayout, rq_fLayout,
                fxDetailLayout;
        private LinearLayout[] layouts;
        private TextView[][] texts;

        public ChildViewHolder(View view) {

            qbxxLayout = view.findViewById(R.id.jz_hhgg_elv_qbxx_layout);
            s_Textview = view.findViewById(R.id.jz_hhgg_elv_frq_s_text);
            s_plTextview = view.findViewById(R.id.jz_hhgg_elv_frq_s_pl_text);
            p_Textview = view.findViewById(R.id.jz_hhgg_elv_frq_p_text);
            p_plTextview = view.findViewById(R.id.jz_hhgg_elv_frq_p_pl_text);
            f_Textview = view.findViewById(R.id.jz_hhgg_elv_frq_f_text);
            f_plTextview = view.findViewById(R.id.jz_hhgg_elv_frq_f_pl_text);
            rq_s_Textview = view.findViewById(R.id.jz_hhgg_elv_rq_s_text);
            rq_s_plTextview = view.findViewById(R.id.jz_hhgg_elv_rq_s_pl_text);
            rq_p_Textview = view.findViewById(R.id.jz_hhgg_elv_rq_p_text);
            rq_p_plTextview = view.findViewById(R.id.jz_hhgg_elv_rq_p_pl_text);
            rq_f_Textview = view.findViewById(R.id.jz_hhgg_elv_rq_f_text);
            rq_f_plTextview = view.findViewById(R.id.jz_hhgg_elv_rq_f_pl_text);
            fxImageView = view.findViewById(R.id.jz_hhgg_elv_child_fx_icon);

            fxLayout = view.findViewById(R.id.jz_hhgg_elv_child_fx_layout);
            sLayout = view.findViewById(R.id.jz_hhgg_elv_frq_s_layout);
            pLayout = view.findViewById(R.id.jz_hhgg_elv_frq_p_layout);
            fLayout = view.findViewById(R.id.jz_hhgg_elv_frq_f_layout);
            rq_sLayout = view.findViewById(R.id.jz_hhgg_elv_rq_s_layout);
            rq_pLayout = view.findViewById(R.id.jz_hhgg_elv_rq_p_layout);
            rq_fLayout = view.findViewById(R.id.jz_hhgg_elv_rq_f_layout);
            fxDetailLayout = view.findViewById(R.id.jz_hhgg_elv_fx_detail_layout);
            selectedTextView = view.findViewById(R.id.jz_hhgg_elv_qbxx_selected_size_text);
            selectTextview = view.findViewById(R.id.jz_hhgg_elv_qbxx_selected_text);


            layouts = new LinearLayout[]{sLayout, pLayout, fLayout, rq_sLayout, rq_pLayout, rq_fLayout};
            texts = new TextView[][]{{s_Textview, s_plTextview}, {p_Textview, p_plTextview}, {f_Textview,
                    f_plTextview}, {rq_s_Textview, rq_s_plTextview}, {rq_p_Textview, rq_p_plTextview}, {rq_f_Textview,
                    rq_f_plTextview}};

        }
    }

}