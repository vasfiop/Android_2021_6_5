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
import com.example.thegame.fragment.homepage.Buildhomepage_fragment;
import com.example.thegame.fragment.homepage.Firsthomepage_fragment;
import com.example.thegame.fragment.homepage.Officehomepage_fragment;
import com.example.thegame.fragment.homepage.Phonehomepage_fragment;

import java.util.ArrayList;

public class Homepage_fragment extends Fragment {

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton rb_home, rb_pc, rb_phone;
    private ArrayList<Fragment> list;

    private View view;

    Firsthomepage_fragment firsthomepage_fragment;
    Officehomepage_fragment officehomepage_fragment;
    Phonehomepage_fragment phonehomepage_fragment;
    Buildhomepage_fragment buildhomepage_fragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_homepage, container, false);

        fragmentinit();

        return view;
    }

    private void fragmentinit() {
        rb_home = view.findViewById(R.id.HP_radiobtn_home);
        rb_pc = view.findViewById(R.id.HP_radiobtn_pc);
        rb_phone = view.findViewById(R.id.HP_radiobtn_phone);

        radioGroup = view.findViewById(R.id.HP_radiogroup_spinner);
        radioGroup.setOnCheckedChangeListener(new MyCheckedListener());

        viewPager = view.findViewById(R.id.HP_viewpaget_first);
        list = new ArrayList<Fragment>();

        firsthomepage_fragment = new Firsthomepage_fragment();
        officehomepage_fragment = new Officehomepage_fragment();
        phonehomepage_fragment = new Phonehomepage_fragment();
        buildhomepage_fragment = new Buildhomepage_fragment();

        list.add(firsthomepage_fragment);
        list.add(officehomepage_fragment);
        list.add(phonehomepage_fragment);
        list.add(buildhomepage_fragment);

        viewPager.setAdapter(new PageAdapter(getFragmentManager(), list));
        viewPager.setCurrentItem(0);
    }

    private class MyCheckedListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int current = 0;
            switch (checkedId) {
                case R.id.HP_radiobtn_home:
                    current = 0;
                    break;
                case R.id.HP_radiobtn_pc:
                    current = 1;
                    break;
                case R.id.HP_radiobtn_phone:
                    current = 2;
                    break;
                default:
                    current = 3;
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
