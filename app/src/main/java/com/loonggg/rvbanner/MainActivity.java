package com.loonggg.rvbanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.loonggg.rvbanner.lib.RecyclerViewBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerViewBanner recyclerViewBanner1 = (RecyclerViewBanner) findViewById(R.id.rv_banner_1);
        RecyclerViewBanner recyclerViewBanner2 = (RecyclerViewBanner) findViewById(R.id.rv_banner_2);
        RecyclerViewBanner recyclerViewBanner3 = (RecyclerViewBanner) findViewById(R.id.rv_banner_3);
        RecyclerViewBanner recyclerViewBanner4 = (RecyclerViewBanner) findViewById(R.id.rv_banner_4);
        RecyclerViewBanner recyclerViewBanner5 = (RecyclerViewBanner) findViewById(R.id.rv_banner_5);

        final List<Banner> banners = new ArrayList<>();
        banners.add(new Banner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487221110004&di=d6043e4b0c90ddf3ea5096c3d8eb8f58&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2014%2F067%2F5116EPAUD762_1000x500.jpg"));
        banners.add(new Banner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487221129421&di=c085432cf7c15836f8a6479138740f39&imgtype=0&src=http%3A%2F%2Fimage85.360doc.com%2FDownloadImg%2F2015%2F05%2F0517%2F53199602_2.jpg"));
        banners.add(new Banner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490438881557&di=e61065ccc8d7b44591e1c4ba8df672ee&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F18d8bc3eb13533fa00428309a0d3fd1f41345b24.jpg"));
        banners.add(new Banner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491018668060&di=b96bf4ac065ab547eddc5af24dfbedd5&imgtype=0&src=http%3A%2F%2Fi2.sanwen8.cn%2Fdoc%2F1610%2F704-161024211H3.jpg"));
        banners.add(new Banner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490440556037&di=ade75ba29126922124b063a2a57873f7&imgtype=0&src=http%3A%2F%2Fi2.download.fd.pchome.net%2Ft_960x600%2Fg1%2FM00%2F0E%2F05%2FooYBAFTbGOmIDPSLAAXPs6l7AQMAACSVgDyBqkABc_L421.jpg"));
        //recyclerViewBanner1.setRvAutoPlaying(false);
        recyclerViewBanner1.setRvBannerData(banners);
        recyclerViewBanner1.setOnSwitchRvBannerListener(new RecyclerViewBanner.OnSwitchRvBannerListener() {
            @Override
            public void switchBanner(int position, AppCompatImageView bannerView) {
                Glide.with(bannerView.getContext())
                        .load(banners.get(position).getUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(bannerView);
            }
        });
        recyclerViewBanner1.setOnRvBannerClickListener(new RecyclerViewBanner.OnRvBannerClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, "position: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerViewBanner2.setRvBannerData(banners);
        recyclerViewBanner2.setOnSwitchRvBannerListener(new RecyclerViewBanner.OnSwitchRvBannerListener() {
            @Override
            public void switchBanner(int position, AppCompatImageView bannerView) {
                Glide.with(bannerView.getContext())
                        .load(banners.get(position).getUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(bannerView);
            }
        });
        recyclerViewBanner3.setRvBannerData(banners);
        recyclerViewBanner3.setOnSwitchRvBannerListener(new RecyclerViewBanner.OnSwitchRvBannerListener() {
            @Override
            public void switchBanner(int position, AppCompatImageView bannerView) {
                Glide.with(bannerView.getContext())
                        .load(banners.get(position).getUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(bannerView);
            }
        });
        recyclerViewBanner4.setIndicatorInterval(2000);
        recyclerViewBanner4.setRvBannerData(banners);
        recyclerViewBanner4.setOnSwitchRvBannerListener(new RecyclerViewBanner.OnSwitchRvBannerListener() {
            @Override
            public void switchBanner(int position, AppCompatImageView bannerView) {
                Glide.with(bannerView.getContext())
                        .load(banners.get(position).getUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(bannerView);
            }
        });
        recyclerViewBanner5.setRvBannerData(banners);
        recyclerViewBanner5.setOnSwitchRvBannerListener(new RecyclerViewBanner.OnSwitchRvBannerListener() {
            @Override
            public void switchBanner(int position, AppCompatImageView bannerView) {
                Glide.with(bannerView.getContext())
                        .load(banners.get(position).getUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(bannerView);
            }
        });
    }

    private class Banner {

        String url;

        public Banner(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }
}
