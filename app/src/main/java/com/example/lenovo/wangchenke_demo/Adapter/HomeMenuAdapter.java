/*
package com.example.lenovo.wangchenke_demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import com.example.lenovo.wangchenke_demo.Models.HomeMenu;
import com.example.lenovo.wangchenke_demo.R;

import java.util.List;

public class HomeMenuAdapter extends BaseAdapter {


    private final List<HomeMenu> menus;
    private final Context context;


    public HomeMenuAdapter(Context context, List<HomeMenu> menus){
       this.context=context;
        this.menus=menus;

    }
    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int i) {
        return menus.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView( final  int i, View view, ViewGroup viewGroup) {
        RadioButton rb=new RadioButton(context);
        if (i==(menus.size()-1)){
            rb.setButtonDrawable(R.mipmap.ic_launcher);
            rb.setText("更多");
            rb.
        }
        rb.setButtonDrawable(menus.get(i).getImg());
        rb.setText(menus.get(i).getName());

rb.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(context,menus.get(i).getUrl());
    }
});

        return null;
    }
}
*/
