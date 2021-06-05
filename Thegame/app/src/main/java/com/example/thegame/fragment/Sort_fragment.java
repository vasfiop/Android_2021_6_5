package com.example.thegame.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.thegame.R;
import com.example.thegame.fragment.sort.rightsort_another;
import com.example.thegame.fragment.sort.rightsort_first;
import com.example.thegame.fragment.sort.rightsort_second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort_fragment extends Fragment {
    private final String[] sortleft_names = {
            "推荐分类", "京东超市", "食品酒饮", "母婴童装", "京东国际", "手机", " 户外运动", "电脑办公", "家居厨具", "男装",
            "美妆护肤 ", "女装", "鞋靴", "家居家装", "内衣配饰", "个护清洁", "宠物鲜花", "加点", "钟表珠宝", "医药保健",
            "生鲜", "箱包", "数码", "玩具乐器", "汽摩生活", "二手商品", "奢饰品", "计生情趣", "生活旅行", "图书文娱", "京东服务", "拍卖", "工业品"
    };
    private ListView listView;
    private ArrayList<Map<String, Object>> leftsort_list;
    private SimpleAdapter simpleAdapter;

    private ViewPager viewPager;
    private ArrayList<Fragment> list;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sort, container, false);

        fragmentinit();

        return view;
    }

    private void fragmentinit() {
        viewPager = view.findViewById(R.id.FS_viewpager_rightfragment);
        list = new ArrayList<Fragment>();

        rightsort_first rightsort_first_fragment = new rightsort_first();
        rightsort_second rightsort_second_fragment = new rightsort_second();
        rightsort_another rightsort_another_fragment = new rightsort_another();

        list.add(rightsort_first_fragment);
        list.add(rightsort_second_fragment);
        list.add(rightsort_another_fragment);

        leftsort_list = new ArrayList<Map<String, Object>>();
        listView = view.findViewById(R.id.FS_listview_left);

        simpleAdapter = new SimpleAdapter(getActivity(), LeftSort_SetData(), R.layout.listview_leftsort_item, new String[]{"names"}, new int[]{R.id.FS_txtview_names});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int current = 0;
                switch (position) {
                    case 0:
                        current = 0;
                        break;
                    case 1:
                        current = 1;
                        break;
                    default:
                        current = 2;
                        break;
                }
                if (viewPager.getCurrentItem() != current)
                    viewPager.setCurrentItem(current);
            }
        });

        viewPager.setAdapter(new PageAdapter(getFragmentManager(), list));
        viewPager.setCurrentItem(0);
    }

    private List<Map<String, Object>> LeftSort_SetData() {
        for (int i = 0; i < sortleft_names.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("names", sortleft_names[i]);
            leftsort_list.add(map);
        }
        return leftsort_list;
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
