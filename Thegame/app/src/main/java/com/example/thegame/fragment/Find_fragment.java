package com.example.thegame.fragment;

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
import com.example.thegame.fragment.find.first_find_fragment;
import com.example.thegame.fragment.find.second_find_fragment;

import java.util.ArrayList;

public class Find_fragment extends Fragment {
    private View view;
    private ViewPager viewPager;
    private ArrayList<Fragment> list;
    private RadioGroup radioGroup;
    private RadioButton rb_guanzhu, rb_tuijian;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_find, container, false);

        fragmentinit();

        return view;
    }

    private void fragmentinit() {
        viewPager = view.findViewById(R.id.FF_viewpage_fragment);
        radioGroup = view.findViewById(R.id.FF_radiogroup_top);
        rb_guanzhu = view.findViewById(R.id.FF_radiobtn_guanzhu);
        rb_tuijian = view.findViewById(R.id.FF_radiobtn_tuijian);

        list = new ArrayList<Fragment>();

        first_find_fragment first_find_fragment = new first_find_fragment();
        second_find_fragment second_find_fragment = new second_find_fragment();

        list.add(first_find_fragment);
        list.add(second_find_fragment);

        radioGroup.setOnCheckedChangeListener(new MyCheckedChangeLinstener());

        viewPager.setAdapter(new PageAdapter(getFragmentManager(), list));
        viewPager.setCurrentItem(0);
    }

    private class MyCheckedChangeLinstener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int current = 0;
            switch (checkedId) {
                case R.id.FF_radiobtn_guanzhu:
                    current = 0;
                    break;
                case R.id.FF_radiobtn_tuijian:
                    current = 1;
                    break;
            }
            if (viewPager.getCurrentItem() != current)
                viewPager.setCurrentItem(current);
        }
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

}
