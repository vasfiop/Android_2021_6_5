package com.example.thegame.fragment.sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thegame.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class rightsort_first extends Fragment {
    //    21
    final private String[] names = {"电压力锅", "外国小说", "电动牙刷", "吊灯", "网卡", "男士内裤", "AMD有礼",
            "家具522", "夏桐和杨洋", "笔记本", "空调", "手机", "服饰", "休闲零食", "生鲜", "图书", "面膜", "投资金", "瑞表", "牛奶", "纸品湿巾"};
    final private int[] imgs = {R.drawable.dianyaliguo, R.drawable.waiguoxiaoshuo, R.drawable.diandongyashua, R.drawable.diaodeng,
            R.drawable.wangka, R.drawable.nanshineiku, R.drawable.amd, R.drawable.jiaju, R.drawable.jiu,
            R.drawable.dianyaliguo, R.drawable.waiguoxiaoshuo, R.drawable.diandongyashua, R.drawable.diaodeng,
            R.drawable.wangka, R.drawable.nanshineiku, R.drawable.amd, R.drawable.jiaju, R.drawable.jiu,
            R.drawable.dianyaliguo, R.drawable.waiguoxiaoshuo, R.drawable.diandongyashua};

    private View view;
    private ArrayList<Map<String, Object>> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rightsort, container, false);

        gridViewinit();

        return view;
    }

    private void gridViewinit() {
        GridView gridView = view.findViewById(R.id.FS_gridview_first);
        list = new ArrayList<>();

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), setlist(), R.layout.gridview_rightsort_firstfragment_item, new String[]{"names", "imgs"},
                new int[]{R.id.FS_textview_firstfragment, R.id.FS_imgbtn_firstfragment});
        gridView.setAdapter(adapter);
    }

    private List<Map<String, Object>> setlist() {
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("names", names[i]);
            map.put("imgs", imgs[i]);
            list.add(map);
        }
        return list;
    }
}
