package com.example.thegame.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thegame.R;

public class Car_fragment extends Fragment {
    private View view;
    private LinearLayout linearLayout;
    private LayoutInflater layoutInflater;
    private TextView txt_name, txt_title, txt_mode, txt_money;
    private ImageView imageView;

    private static String[] name = {"西部数据京东自营旗舰店", "西部数据京东自营旗舰店", "荣耀泽林平板电脑专卖店", "金士顿京东自营旗舰店", "图玛斯特京东自营旗舰店"};
    private static String[] title = {"西部数据(WD)篮板 4TB SATA6Gb/s 256MB 台式机械硬盘", "西部数据(Western Digital) 500G SSD 固态硬盘 M.2接口(NVMe协议) WD_BLACK SN750 游戏高性能坂",
            "HONOR荣耀笔记本MagicBookPro 16.1英寸酷睿10代手提学生全面屏轻薄笔记本电脑 i7-10510u 16G内存2G独显 PCIe 521G固态", "金士顿(Kingston)16GB DDR4 3200 笔记本内存条 骇客神条 Impact系列",
            "图玛斯特(THRUSTMASTER)模拟飞行节流阀控制器"};
    private static int[] img = {R.drawable.test_red_64};
    private static String[] mode = {"蓝盘|日常家用硬盘", "游戏黑盘/五年保值", "i7-10510u 16g内存2g独显", "[D4 3200频率]", "TWCS 飞行油门"};
    private static String[] money = {"669", "589", "6799", "699", "699"};

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_car, container, false);
        layoutInflater = LayoutInflater.from(getActivity());

        init();

        set();

        return view;
    }

    private void set() {
        for (int i = 0; i < name.length; i++) {
            View v = layoutInflater.inflate(R.layout.linear_car_item, linearLayout, false);

            txt_name = v.findViewById(R.id.CF_txt_name);
            txt_title = v.findViewById(R.id.CF_txt_title);
            txt_mode = v.findViewById(R.id.CF_txt_mode);
            txt_money = v.findViewById(R.id.CF_txt_money);
            imageView = v.findViewById(R.id.CF_img);

            txt_name.setText(name[i]);
            txt_title.setText(title[i]);
            txt_mode.setText(mode[i]);
            txt_money.setText("￥" + money[i]);
            imageView.setImageResource(img[0]);

            linearLayout.addView(v);
        }
    }

    private void init() {
        linearLayout = view.findViewById(R.id.CF_linear);
    }
}
