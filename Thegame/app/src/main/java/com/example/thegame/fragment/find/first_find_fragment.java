package com.example.thegame.fragment.find;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thegame.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class first_find_fragment extends Fragment {
    final private String[] name = {"居家先锋", "不加滤镜的YY酱", "家电聚焦", "精品惠美妆小能手"};
    final private String[] fensi = {"3.5w粉丝", "18粉丝", "5.8w粉丝", "76粉丝"};
    final private int[] img_head = {R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo};
    final private String[] speak = {
            "智能又方便的家电盘点，解锁舒适生活！",
            "远离细菌侵扰，从洗手开始",
            "苏泊尔豆浆机，取悦自己从一杯豆浆开始",
            "超快剃须+免拆清洗，博朗小猎豹5系列体验！"
    };
    final private int[] img_show = {R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test};
    private View view;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_firstfind, container, false);

        listViewinit();

        return view;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void listViewinit() {
        listView = view.findViewById(R.id.FF_listview);

        ArrayList<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), SetData(list1), R.layout.listview_find_item,
                new String[]{"names", "img_head", "fensi", "speak", "img"}, new int[]{R.id.FF_txt_first_names, R.id.FF_imgbtn_head, R.id.FF_txt_fensi, R.id.FF_txt_speak, R.id.FF_img_show});
        listView.setAdapter(simpleAdapter);
    }

    private List<Map<String, Object>> SetData(ArrayList<Map<String, Object>> list) {
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("names", name[i]);
            map.put("img_head", img_head[i]);
            map.put("fensi", fensi[i]);
            map.put("speak", speak[i]);
            map.put("img", img_show[i]);

            list.add(map);
        }
        return list;
    }
}
