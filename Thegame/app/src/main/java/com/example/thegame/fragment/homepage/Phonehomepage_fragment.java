package com.example.thegame.fragment.homepage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thegame.R;

public class Phonehomepage_fragment extends Fragment {
    private View view;
    private LinearLayout Hlinear;
    private LayoutInflater mlinear;

    private ImageView imageView;
    private TextView txt_jiage;
    private ProgressBar progressBar;
    private TextView txt_baifenbi;

    private static int[] pic = {R.drawable.phone_1, R.drawable.phone_2, R.drawable.phone_3, R.drawable.phone_4,
            R.drawable.phone_5, R.drawable.phone_6, R.drawable.phone_7, R.drawable.phone_8};
    private static String[] money = {"9188", "1799", "6499", "4489",
            "5989", "1399", "5899", "4299"};
    private static int[] num = {93, 49, 22, 67, 11, 80, 8, 19};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_homepage_phone, container, false);
        mlinear = LayoutInflater.from(getActivity());

        init();

        set();

        return view;
    }

    private void set() {

        for (int i = 0; i < pic.length; i++) {
            View v = mlinear.inflate(R.layout.horizontal_homepage_phone_item, Hlinear, false);

            imageView = v.findViewById(R.id.HP_img_in);
            imageView.setImageResource(pic[i]);

            txt_jiage = v.findViewById(R.id.HP_txt_money);
            txt_jiage.setText("￥" + money[i]);

            progressBar = v.findViewById(R.id.HP_Pbar_Pbar);
            progressBar.setProgress(num[i]);

            txt_baifenbi = v.findViewById(R.id.HP_txt_baifenbi);
            txt_baifenbi.setText("已售" + num[i] + "%");

            Hlinear.addView(v);
        }
    }

    private void init() {
        Hlinear = view.findViewById(R.id.HP_linear_forhorizontal);

    }

}