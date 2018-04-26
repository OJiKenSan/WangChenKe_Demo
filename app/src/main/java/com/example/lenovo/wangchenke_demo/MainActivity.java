package com.example.lenovo.wangchenke_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.lenovo.wangchenke_demo.Fragment.Fragment_exchange;
import com.example.lenovo.wangchenke_demo.Fragment.Fragment_home;
import com.example.lenovo.wangchenke_demo.Fragment.Fragment_me;
import com.example.lenovo.wangchenke_demo.Fragment.Fragment_questions;
import com.example.lenovo.wangchenke_demo.Fragment.Fragment_thinktank;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mNavigation;
    private Fragment_home fragment_home;
    private Fragment_exchange fragment_exchange;
    private Fragment_me fragment_me;
    private Fragment_thinktank fragment_thinktank;
    private Fragment_questions fragment_questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //默认设置在主页显示
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.main_frame, new Fragment_home());
        ft.commit();


        mNavigation = (RadioGroup) findViewById(R.id.rg_btn_navigation);
        mNavigation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_bottom_navigation_home:
                        if (fragment_home == null) {
                            fragment_home = new Fragment_home();
                        }
                        changeFragment(fragment_home);
                        break;
                    case R.id.rb_bottom_navigation_thinktank:
                        if (fragment_thinktank == null) {
                            fragment_thinktank = new Fragment_thinktank();
                        }
                        changeFragment(fragment_thinktank);

                        break;
                    case R.id.rb_bottom_navigation_questions:
                        if (fragment_questions == null) {
                            fragment_questions = new Fragment_questions();
                        }
                        changeFragment(fragment_questions);
                        break;
                    case R.id.rb_bottom_navigation_exchange:
                        if (fragment_exchange == null) {
                            fragment_exchange = new Fragment_exchange();
                        }
                        changeFragment(fragment_exchange);
                        break;
                    case R.id.rb_bottom_navigation_me:
                        if (fragment_me == null) {
                            fragment_me = new Fragment_me();
                        }
                        changeFragment(fragment_me);
                        break;
                }
            }
        });

    }

    private void changeFragment(android.support.v4.app.Fragment fragment) {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_frame, fragment);
        ft.commit();

    }
}
