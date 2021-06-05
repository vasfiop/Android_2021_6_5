package com.example.thegame.fragment.find;

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

public class second_find_fragment extends Fragment {
    private View view;

    final private int[] imgs = {R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test};
    final private String[] show = {
            "iPhone 12白色版开箱贴膜：颜值非常高！",
            "黑科技机器人来了，他扫地拖地，你只需要到脏垃圾",
            "超级好用的兔头妈妈纸尿裤来了.",
            "一直用联想，期待的小新终于到了.",
            "iPad 2020款价格不变，性能翻倍",
            "金士顿 雷电系列内存条，创造属于你的memory",
            "兰蔻粉水难用的真想，要这样用才对",
            "苹果12 Pro max 后置三摄手机，你会喜欢吗"
    };
    final private int[] head_img = {R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo};
    final private String[] names = {"惊叹者", "冷冷种草", "大幅贵贵", "飞天峰0532", "羊羊生活馆", "金士顿京东", "羊羊生活馆", "丹尼尔菌"};
    final private String[] shownum = {"255", "564", "654", "123", "12", "64", "987", "9783"};

    private GridView gridView;

    ArrayList<Map<String, Object>> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_secondfind, container, false);

        gridViewinit();

        return view;
    }

    private void gridViewinit() {
        gridView = view.findViewById(R.id.FF_gridview);
        list = new ArrayList<>();

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), setlist(), R.layout.gridview_find_item,
                new String[]{"img", "speak", "head", "names", "shownum"}, new int[]{R.id.FF_img_second, R.id.FF_txt_second_speak, R.id.FF_imgbtn_headsecond, R.id.FF_txt_second_name, R.id.FF_txt_shownum});
        gridView.setAdapter(adapter);
    }

    private List<Map<String, Object>> setlist() {
        for (int i = 0; i < imgs.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("img", imgs[i]);
            map.put("speak", show[i]);
            map.put("head", head_img[i]);
            map.put("names", names[i]);
            map.put("shownum", shownum[i]);
            list.add(map);
        }
        return list;
    }
}
