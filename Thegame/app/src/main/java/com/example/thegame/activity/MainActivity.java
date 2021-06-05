package com.example.thegame.activity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.thegame.R;
import com.example.thegame.fragment.Car_fragment;
import com.example.thegame.fragment.Find_fragment;
import com.example.thegame.fragment.Homepage_fragment;
import com.example.thegame.fragment.Me_fragment;
import com.example.thegame.fragment.Sort_fragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RadioButton home_rb, sort_rb, find_rb, car_rb, me_rb;
    private RadioGroup radioGroup_bottom;
    private ViewPager viewPager;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
//取消标题栏
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        fragmentinit();
    }

    private void fragmentinit() {
        home_rb = findViewById(R.id.HP_radiobtn_homepage);
        sort_rb = findViewById(R.id.HP_radiobtn_sort);
        find_rb = findViewById(R.id.HP_radiobtn_find);
        car_rb = findViewById(R.id.HP_radiobtn_car);
        me_rb = findViewById(R.id.HP_radiobtn_me);

        radioGroup_bottom = findViewById(R.id.HP_radiogroup_bottom);
        radioGroup_bottom.setOnCheckedChangeListener(new MyCheckedChangeListener());

        viewPager = findViewById(R.id.HP_viewpager_fragment);

        list = new ArrayList<Fragment>();

        Homepage_fragment home_Fragment = new Homepage_fragment();
        Sort_fragment sort_fragment = new Sort_fragment();
        Find_fragment find_fragment = new Find_fragment();
        Car_fragment car_fragment = new Car_fragment();
        Me_fragment me_fragment = new Me_fragment();

        list.add(home_Fragment);
        list.add(sort_fragment);
        list.add(find_fragment);
        list.add(car_fragment);
        list.add(me_fragment);

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), list));
        viewPager.setCurrentItem(0);

        viewPager.setOnPageChangeListener(new viewPagerListener());
    }

    private class viewPagerListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            int current = viewPager.getCurrentItem();
            switch (current) {
                case 0:
                    radioGroup_bottom.check(R.id.HP_radiobtn_homepage);
                    break;
                case 1:
                    radioGroup_bottom.check(R.id.HP_radiobtn_sort);
                    break;
                case 2:
                    radioGroup_bottom.check(R.id.HP_radiobtn_find);
                    break;
                case 3:
                    radioGroup_bottom.check(R.id.HP_radiobtn_car);
                    break;
                case 4:
                    radioGroup_bottom.check(R.id.HP_radiobtn_me);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

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

    private class MyCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int current = 0;
            switch (checkedId) {
                case R.id.HP_radiobtn_homepage:
                    current = 0;
                    break;
                case R.id.HP_radiobtn_sort:
                    current = 1;
                    break;
                case R.id.HP_radiobtn_find:
                    current = 2;
                    break;
                case R.id.HP_radiobtn_car:
                    current = 3;
                    break;
                case R.id.HP_radiobtn_me:
                    current = 4;
                    break;
                default:
                    break;
            }
            if (viewPager.getCurrentItem() != current)
                viewPager.setCurrentItem(current);
        }
    }
}
