package com.example.thegame.fragment.sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thegame.R;

public class rightsort_second_first extends Fragment {
    private View view;
    private GridLayout gridLayout;
    private LayoutInflater layoutInflater;

    private static int[] imgs = {R.drawable.rightsort_xiuxianlingshi_1, R.drawable.rightsort_xiuxianlingshi_2, R.drawable.rightsort_xiuxianlingshi_3,
            R.drawable.rightsort_xiuxianlingshi_4, R.drawable.rightsort_xiuxianlingshi_5, R.drawable.rightsort_xiuxianlingshi_6,
            R.drawable.rightsort_xiuxianlingshi_7, R.drawable.rightsort_xiuxianlingshi_8, R.drawable.rightsort_xiuxianlingshi_9};
    private static int[] names = {R.string.jianguochaohuo, R.string.tangguoqiaokeli, R.string.xiuxianlingshi, R.string.penghuashipin,
            R.string.rouganroupu, R.string.binggandangao, R.string.mijianguogan, R.string.ditangshipin, R.string.zhonghualaozihao};

    private static int[] imgs_2 = {R.drawable.rightsort_jiu_1, R.drawable.rightsort_jiu_2, R.drawable.rightsort_jiu_3, R.drawable.rightsort_jiu_4, R.drawable.rightsort_jiu_5};
    private static int[] names_2 = {R.string.baijiu, R.string.putaojiu, R.string.yangjiu, R.string.pijiu, R.string.huangjiuyangshengjiu};

    private static int[] imgs_3 = {R.drawable.rightsort_shengxian_1, R.drawable.rightsort_shengxian_2, R.drawable.rightsort_shengxian_3,
            R.drawable.rightsort_shengxian_4, R.drawable.rightsort_shengxian_5, R.drawable.rightsort_shengxian_6, R.drawable.rightsort_shengxian_7,
            R.drawable.rightsort_shengxian_8, R.drawable.rightsort_shengxian_9, R.drawable.rightsort_shengxian_10};
    private static int[] names_3 = {R.string.xinxianshuiguo, R.string.haixianshuichan, R.string.jingxuanroulei, R.string.danlei,
            R.string.xinxianshuiguo, R.string.sudongshipin, R.string.rupinlengyin, R.string.dazhaxie, R.string.mangguo, R.string.yinyongshui};

    private ImageView imageView;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rightsort_second_first, container, false);
        layoutInflater = LayoutInflater.from(getActivity());

        set();

        return view;
    }

    private void set() {
        gridLayout = view.findViewById(R.id.RF_gridlayout_first_1);

        for (int i = 0; i < names.length; i++) {
            View v = layoutInflater.inflate(R.layout.gridlayout_rightsort_first_item, gridLayout, false);

            imageView = v.findViewById(R.id.RF_img_first);
            imageView.setImageResource(imgs[i]);

            textView = v.findViewById(R.id.RF_txt_first);
            textView.setText(getString(names[i]));

            gridLayout.addView(v);
        }

        gridLayout = view.findViewById(R.id.RF_gridlayout_first_2);

        for (int i = 0; i < names_2.length; i++) {
            View v = layoutInflater.inflate(R.layout.gridlayout_rightsort_first_item, gridLayout, false);

            imageView = v.findViewById(R.id.RF_img_first);
            imageView.setImageResource(imgs_2[i]);

            textView = v.findViewById(R.id.RF_txt_first);
            textView.setText(getString(names_2[i]));

            gridLayout.addView(v);
        }

        gridLayout = view.findViewById(R.id.RF_gridlayout_first_3);

        for (int i = 0; i < names_3.length; i++) {
            View v = layoutInflater.inflate(R.layout.gridlayout_rightsort_first_item, gridLayout, false);

            imageView = v.findViewById(R.id.RF_img_first);
            imageView.setImageResource(imgs_3[i]);

            textView = v.findViewById(R.id.RF_txt_first);
            textView.setText(getString(names_3[i]));

            gridLayout.addView(v);
        }
    }
}
