package com.example.lenovo.wangchenke_demo.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
/*import com.example.lenovo.wangchenke_demo.Models.HomeMenu;*/
import com.example.lenovo.wangchenke_demo.R;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_home extends Fragment implements OnBannerListener {
    private Banner banner;
    /*  private List<HomeMenu> menus;*/
    private ArrayList<String> list_path;
    private GridView mGridView;

    public Fragment_home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RefreshLayout refreshLayout = view.findViewById(R.id.home_layout_fresh);
        banner = view.findViewById(R.id.bn_home_banner);
        initbanner();
        initView();
        /*    menus=new ArrayList<>();*/

        refreshlistener(refreshLayout);

    }
    /*private void createHomeMenu(){
        HomeMenu
    }*/

    private void refreshlistener(RefreshLayout refreshLayout) {

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(2000/*,false*/);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000/*,false*/);
            }
        });
    }

    private void initbanner() {
        banner.setFocusable(true);
        banner.setFocusableInTouchMode(true);
        banner.requestFocus();
    }

    public void OnBannerClick(int position) {
        Log.i("tag", "你点了第" + position + "张轮播图");
    }

    private void initView() {
        list_path = new ArrayList<>();
        list_path.add("http://object.jsnjy.net.cn/OSS/20180420/c4c048d7df1f48f696c235479a0e5dfd.JPG");
        list_path.add("http://object.jsnjy.net.cn/OSS/20171121/20171121145500487.jpg");
        list_path.add("http://object.jsnjy.net.cn/OSS/20180418/25a724f273594598a892dfb14f2e7303.jpg");
        list_path.add("http://object.jsnjy.net.cn/OSS/20180409/079c9dc1ca74470e9beffaac25350e83.jpg");
        list_path.add("http://object.jsnjy.net.cn/OSS/20180309/20180309002607779.JPG");
        list_path.add("http://object.jsnjy.net.cn/OSS/20180103/20180103190917483.jpg");
        list_path.add("http://object.jsnjy.net.cn/OSS/20180328/20180328145730090.jpg");
        banner.setImageLoader(new MyLoader());
        banner.setImages(list_path);
        banner.setBannerAnimation(Transformer.Default);
        banner.setDelayTime(3000);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.CENTER).setOnBannerListener(this).start();
        /*  banner.setIndicatorGravity()*/
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}
