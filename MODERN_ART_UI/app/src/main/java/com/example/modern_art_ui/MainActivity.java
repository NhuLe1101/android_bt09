package com.example.modern_art_ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MyPagerAdapter adapter;
    FragmentManager manager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        solveEvent();
    }
    void initView() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);

        adapter = new MyPagerAdapter(this);
        viewPager2.setAdapter(adapter);
    }
    void solveEvent() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_more_information) {
            showMoreInformationDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void showMoreInformationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("App được xây dựng bởi:");

        TextView messageTextView = new TextView(this);
        messageTextView.setText("\nLê Phan Huỳnh Như - 312560070.\n");
        messageTextView.setMovementMethod(LinkMovementMethod.getInstance());
        messageTextView.setGravity(Gravity.CENTER); // Đặt căn giữa chữ

        SpannableString linkText = new SpannableString("\nGitHub Repository");
        linkText.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Mở liên kết web GitHub
                Uri githubUri = Uri.parse("https://github.com/NhuLe1101");
                Intent intent = new Intent(Intent.ACTION_VIEW, githubUri);
                startActivity(intent);
            }
        }, 0, linkText.length(), 0);

        messageTextView.append(linkText);
        Linkify.addLinks(messageTextView, Linkify.ALL);

        builder.setView(messageTextView);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
