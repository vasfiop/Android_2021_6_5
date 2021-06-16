package com.example.thegame.fragment.find;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thegame.R;

public class first_find_fragment extends Fragment {
    final private String[] name = {"居家先锋", "不加滤镜的YY酱", "家电聚焦", "精品惠美妆小能手"};
    final private String[] fensi = {"3.5w粉丝", "18粉丝", "5.8w粉丝", "76粉丝"};
    final private int[] img_head = {R.drawable.find_head_one, R.drawable.find_head_two, R.drawable.find_head_three, R.drawable.find_head_four};
    final private String[] speak = {
            "智能又方便的家电盘点，解锁舒适生活！",
            "远离细菌侵扰，从洗手开始",
            "苏泊尔豆浆机，取悦自己从一杯豆浆开始",
            "超快剃须+免拆清洗，博朗小猎豹5系列体验！"
    };
    final private int[] img_show = {R.drawable.find_first_buyaoshan, R.drawable.find_first_buyaoshaner, R.drawable.find_first_erciyuan, R.drawable.find_first_warframe};
    private View view;

    private TextView txt_name, txt_fensi, txt_speak;
    private ImageButton imageButton;
    private ImageView imageView;

    private LinearLayout linearLayout;
    private LayoutInflater layoutInflater;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_firstfind, container, false);

        layoutInflater = LayoutInflater.from(getActivity());

        init();

        set();

        return view;
    }

    private void set() {

        for (int i = 0; i < name.length; i++) {
            View v = layoutInflater.inflate(R.layout.linearlayout_find_item, linearLayout, false);

            txt_name = v.findViewById(R.id.FF_txt_first_names);
            txt_fensi = v.findViewById(R.id.FF_txt_fensi);
            txt_speak = v.findViewById(R.id.FF_txt_speak);
            imageButton = v.findViewById(R.id.FF_imgbtn_head);
            imageView = v.findViewById(R.id.FF_img_show);

            imageView.setImageResource(img_show[i]);
            txt_name.setText(name[i]);
            txt_fensi.setText(fensi[i]);
            txt_speak.setText(speak[i]);
            imageButton.setImageResource(img_head[i]);

            linearLayout.addView(v);
        }

    }

    private void init() {
        linearLayout = view.findViewById(R.id.FF_linear);
    }
}
