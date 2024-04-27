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

public class relative_layout extends Fragment {
    SeekBar seekBar;
    TextView cube1, cube2, cube3, cube4, cube5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relative_layout, container, false);
        // Khởi tạo SeekBar
        seekBar = view.findViewById(R.id.seekbar2);

        // Thiết lập sự kiện thay đổi cho SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Xử lý sự kiện khi giá trị của SeekBar thay đổi
                setRectangleColors(progress);
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

    private void setRectangleColors(int progress) {
        // Lấy các TextViews của các hình chữ nhật
        TextView cube1 = getView().findViewById(R.id.cube1);
        TextView cube2 = getView().findViewById(R.id.cube2);
        TextView cube3 = getView().findViewById(R.id.cube3);
        TextView cube4 = getView().findViewById(R.id.cube4);
        TextView cube5 = getView().findViewById(R.id.cube5);
        if (progress == 0) {
            cube1.setBackgroundColor(Color.parseColor("#6977b6"));
            cube2.setBackgroundColor(Color.parseColor("#d74f97"));
            cube3.setBackgroundColor(Color.parseColor("#a41d21"));
            cube4.setBackgroundColor(Color.parseColor("#e6e6e6"));
            cube5.setBackgroundColor(Color.parseColor("#273a98"));
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
            cube1.setBackgroundColor(colors[random.nextInt(colors.length)]);
            cube2.setBackgroundColor(colors[random.nextInt(colors.length)]);
            cube3.setBackgroundColor(colors[random.nextInt(colors.length)]);
            cube4.setBackgroundColor(colors[random.nextInt(colors.length)]);
            cube5.setBackgroundColor(colors[random.nextInt(colors.length)]);
        }
    }
}