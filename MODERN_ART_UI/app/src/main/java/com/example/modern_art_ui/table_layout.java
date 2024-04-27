package com.example.modern_art_ui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class table_layout extends Fragment {
    SeekBar seekBar;
    TextView hcn1, hcn2, hcn3, hcn4, hcn5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_table_layout, container, false);
        // Khởi tạo SeekBar
        seekBar = view.findViewById(R.id.seekbar3);
        // Thiết lập sự kiện thay đổi cho SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Xử lý sự kiện khi giá trị của SeekBar thay đổi
                changeRectangleColors(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Không cần xử lý
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Không cần xử lý
            }
        });

        return view;

    }
    private void changeRectangleColors(int progress) {
        // Lấy các TextViews của các hình chữ nhật
        TextView hcn1 = getView().findViewById(R.id.hcn1);
        TextView hcn2 = getView().findViewById(R.id.hcn2);
        TextView hcn3 = getView().findViewById(R.id.hcn3);
        TextView hcn4 = getView().findViewById(R.id.hcn4);
        TextView hcn5 = getView().findViewById(R.id.hcn5);
        if (progress == 0) {
            hcn1.setBackgroundColor(Color.parseColor("#6977b6"));
            hcn2.setBackgroundColor(Color.parseColor("#d74f97"));
            hcn3.setBackgroundColor(Color.parseColor("#a41d21"));
            hcn4.setBackgroundColor(Color.parseColor("#e6e6e6"));
            hcn5.setBackgroundColor(Color.parseColor("#273a98"));
        }
        else {
            int[] colors = {
                    Color.RED,
                    Color.BLUE,
                    Color.GREEN,
                    Color.YELLOW,
                    Color.CYAN,
                    Color.MAGENTA,
                    Color.WHITE,
                    Color.LTGRAY,
                    Color.DKGRAY,
            };
            Random random = new Random();

            // Chọn một màu sắc ngẫu nhiên từ mảng và thiết lập cho mỗi hình chữ nhật
            hcn1.setBackgroundColor(colors[random.nextInt(colors.length)]);
            hcn2.setBackgroundColor(colors[random.nextInt(colors.length)]);
            hcn3.setBackgroundColor(colors[random.nextInt(colors.length)]);
            hcn4.setBackgroundColor(colors[random.nextInt(colors.length)]);
            hcn5.setBackgroundColor(colors[random.nextInt(colors.length)]);
        }
    }
}