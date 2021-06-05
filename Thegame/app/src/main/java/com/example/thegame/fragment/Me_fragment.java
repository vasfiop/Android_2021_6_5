package com.example.thegame.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thegame.R;
import com.example.thegame.activity.Login_Activity;

import static android.app.Activity.RESULT_OK;

public class Me_fragment extends Fragment {
    private View view;
    private Button button, btn_logout;
    private View logon, lognot;
    private int mode = 0;
    private TextView txt_user;
    String username;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);

        logininit();

        if (mode == 0) {
            logon.setVisibility(View.GONE);
            lognot.setVisibility(View.VISIBLE);
            btn_logout.setVisibility(View.GONE);
        } else {
            logon.setVisibility(View.VISIBLE);
            lognot.setVisibility(View.GONE);
            txt_user.setText("Darling: " + username);
            btn_logout.setVisibility(View.VISIBLE);
        }

        return view;
    }

    private void logininit() {
        logon = view.findViewById(R.id.MF_include_login);
        lognot = view.findViewById(R.id.MF_include_not_login);

        button = view.findViewById(R.id.ME_btn_login);
        btn_logout = view.findViewById(R.id.FM_btn_logout);
        txt_user = view.findViewById(R.id.LA_txt_username);

        button.setOnClickListener(new MyClickListener());
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logon = view.findViewById(R.id.MF_include_login);
                lognot = view.findViewById(R.id.MF_include_not_login);
                logon.setVisibility(View.GONE);
                lognot.setVisibility(View.VISIBLE);
                btn_logout.setVisibility(View.GONE);
                mode = 0;
            }
        });
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), Login_Activity.class);
            startActivityForResult(intent, 200);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == RESULT_OK) {
            username = data.getStringExtra("username");
            mode = 1;
            logon.setVisibility(View.VISIBLE);
            lognot.setVisibility(View.GONE);
            txt_user.setText("Darling: " + username);
            btn_logout.setVisibility(View.VISIBLE);
        }
    }
}
