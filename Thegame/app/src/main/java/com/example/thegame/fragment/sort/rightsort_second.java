package com.example.thegame.fragment.sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.thegame.R;

import java.util.ArrayList;

public class rightsort_second extends Fragment {
    final private int[] first_names = {R.string.jianguochaohuo, R.string.tangguoqiaokeli, R.string.xiuxianlingshi, R.string.penghuashipin, R.string.rouganroupu, R.string.binggandangao, R.string.mijianguogan, R.string.ditangshipin, R.string.zhonghualaozihao};
    final private int[] first_imgs = {};

    final private int[] second_names = {R.string.baijiu, R.string.putaojiu, R.string.yangjiu, R.string.pijiu, R.string.huangjiuyangshengjiu, R.string.chennianlaojiu};
    final private int[] second_imgs = {};

    final private int[] third_names = {R.string.xinxianshuiguo, R.string.haixianshuichan, R.string.jingxuanroulei, R.string.danlei, R.string.xinxianshucai, R.string.sudongshipin, R.string.rupinlengyin, R.string.dazhaxie, R.string.mangguo};
    final private int[] third_imgs = {};

    final private String[] fourth_names = {"大米", "面粉", "杂粮", "食用油", "调味品", "方便速食", "烘焙原料", "有机食品", "南北干货"};
    final private int[] fourth_imgs = {};

    private View view;
    private ViewPager viewPager;
    private ArrayList<Fragment> list;
    private RadioGroup radioGroup;
    private RadioButton rb_1, rb_2, rb_3, rb_4, rb_5, rb_6, rb_7, rb_8;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rightsort_second, container, false);

        fragmentinit();

        return view;
    }

    private void fragmentinit() {
        viewPager = view.findViewById(R.id.FS_viewpager_right_second_fragment);
        list = new ArrayList<Fragment>();
        rb_1 = view.findViewById(R.id.FS_radiobtn_rightsortsecond_1);
        rb_2 = view.findViewById(R.id.FS_radiobtn_rightsortsecond_2);
        rb_3 = view.findViewById(R.id.FS_radiobtn_rightsortsecond_3);
        rb_4 = view.findViewById(R.id.FS_radiobtn_rightsortsecond_4);
        rb_5 = view.findViewById(R.id.FS_radiobtn_rightsortsecond_5);
        rb_6 = view.findViewById(R.id.FS_radiobtn_rightsortsecond_6);
        rb_7 = view.findViewById(R.id.FS_radiobtn_rightsortsecond_7);
        rb_8 = view.findViewById(R.id.FS_radiobtn_rightsortsecond_8);

        radioGroup = view.findViewById(R.id.FS_radiogroup_rightsortsecond);
        radioGroup.setOnCheckedChangeListener(new MyCheckedListener());

        rightsort_second_bulid another = new rightsort_second_bulid();
        rightsort_second_first first = new rightsort_second_first();

        list.add(first);
        list.add(another);

        viewPager.setAdapter(new PageAdapter(getFragmentManager(), list));
        viewPager.setCurrentItem(0);
    }

    class PageAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> fragments;

        PageAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    private class MyCheckedListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int current = 0;
            switch (checkedId) {
                case R.id.FS_radiobtn_rightsortsecond_1:
                    current = 0;
                    break;
                default:
                    current = 1;
                    break;
            }
            if (viewPager.getCurrentItem() != current)
                viewPager.setCurrentItem(current);
        }
    }
}
