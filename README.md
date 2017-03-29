# RecyclerViewBanner
使用RecyclerView做的轮播图

### 前言
之前做的轮播图，对于十几个图片什么的能够满足，但是万一有几千张，几万张就容易造成内存泄露，使用RecyclerView做的轮播，可以利用它自身的复用机制，比较节省内存。所以这种方式感觉效果更好。

### 1.2版本更新内容
    1. 指示器Indicator相关属性前缀同一为“indicator”。
    2. 增加几个Indicator的相关属性：
        rvb_indicatorSize：单个Indicator元素的方形区域尺寸；
        rvb_indicatorSpace：两个Indicator元素的间距；
        rvb_indicatorMargin：Indicator距离外边框的间距；
        rvb_indicatorGravity：Indicator在广告栏内底部的相对位置。

    3. 将BannerView和IndicatorView的ImageView替换为AppCompatImageView，这样在Fragment中也可使用Compat属性，如使用svg矢量图等。
    4. 可通过xml自由配置选中和未选中状态的资源，支持color, shape, png, svg，相当灵活。
    5. lib的build.gradle中改compile为provided，这样当app的build.gradle中的版本低于lib也不会报错。
		注意：SnapHelper是support-compat:24.2.0才引入的，compile的版本必须高于24.2.0才可以。 

## 效果图
![](https://github.com/loonggg/RecyclerViewBanner/blob/master/image/demo1.gif?raw=true)
![](https://github.com/loonggg/RecyclerViewBanner/blob/master/image/sss.gif?raw=true)

## 使用方法
### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```java
  allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
  }
```

### Step 2. Add the dependency
```java
	dependencies {
	    compile 'com.github.loonggg:RecyclerViewBanner:v1.2'
	}
 ```

### Step 3. There are a few xml attributes to customise the  RecyclerViewBanner

 * rvb_indicatorSelectedSrc 设置底部导航指示器或者点选中的样式
 * rvb_indicatorUnselectedSrc 设置底部导航指示器或者点未选中状态的样式
 * rvb_interval 设置轮播图滚动间隔时间
 * rvb_showIndicator 设置是否显示底部指示导航小圆点
 * rvb_indicatorSize 设置指示器的大小
 * rvb_indicatorSpace 设置轮播指示器的间隔
 * rvb_indicatorMargin 设置轮播指示器Indicator距离外边框的间距
 * rvb_indicatorGravity 设置底部轮播导航指示器的位置，[left，center，right]

#### Example
```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView
    android:id="@+id/activity_main"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:loonggg="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.loonggg.rvbanner.MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <com.loonggg.rvbanner.lib.RecyclerViewBanner
            android:id="@+id/rv_banner_1"
            android:layout_width="match_parent"
            android:layout_height="140dp"
            tools:background="@color/colorPrimaryDark"/>
        <!--tools:background在编译运行时会被忽略，此处添加可以方便查看Indicator的状态-->

        <com.loonggg.rvbanner.lib.RecyclerViewBanner
            android:id="@+id/rv_banner_2"
            android:layout_width="match_parent"
            android:layout_height="140dp"
            loonggg:rvb_indicatorSelectedSrc="@drawable/svg_ic_selected"
            loonggg:rvb_indicatorUnselectedSrc="@drawable/svg_ic_unselected"
            tools:background="@color/colorPrimaryDark"/>
        <!--支持svg矢量图-->

        <com.loonggg.rvbanner.lib.RecyclerViewBanner
            android:id="@+id/rv_banner_3"
            android:layout_width="match_parent"
            android:layout_height="140dp"
            loonggg:rvb_indicatorSelectedSrc="@drawable/shape_indicator_selected"
            loonggg:rvb_indicatorUnselectedSrc="@drawable/shape_indicator_unselected"
            tools:background="@color/colorPrimaryDark"/>

        <com.loonggg.rvbanner.lib.RecyclerViewBanner
            android:id="@+id/rv_banner_4"
            android:layout_width="match_parent"
            android:layout_height="140dp"
            loonggg:rvb_indicatorGravity="left"
            loonggg:rvb_indicatorSelectedSrc="@mipmap/ic_selected"
            loonggg:rvb_indicatorUnselectedSrc="@mipmap/ic_unselected"
            tools:background="@color/colorPrimaryDark"/>

        <com.loonggg.rvbanner.lib.RecyclerViewBanner
            android:id="@+id/rv_banner_5"
            android:layout_width="match_parent"
            android:layout_height="140dp"
            loonggg:rvb_indicatorGravity="right"
            loonggg:rvb_indicatorMargin="2dp"
            loonggg:rvb_indicatorSelectedSrc="@color/colorPrimary"
            loonggg:rvb_indicatorUnselectedSrc="#ffffff"
            loonggg:rvb_indicatorSize="8dp"
            loonggg:rvb_indicatorSpace="8dp"
            loonggg:rvb_interval="2000"
            tools:background="@color/colorPrimaryDark"/>
    </LinearLayout>
</ScrollView>
```

### Step 4. Impelement Listener
```java
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
        banners.add(new Banner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490440243430&di=6f8d7c608a4e3fbe4130c93fc0f20850&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201509%2F09%2F20150909184342_mkrWc.jpeg"));
        banners.add(new Banner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490440556037&di=ade75ba29126922124b063a2a57873f7&imgtype=0&src=http%3A%2F%2Fi2.download.fd.pchome.net%2Ft_960x600%2Fg1%2FM00%2F0E%2F05%2FooYBAFTbGOmIDPSLAAXPs6l7AQMAACSVgDyBqkABc_L421.jpg"));

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
```
### 公众号
欢迎大家关注我的微信公众号：非著名程序员（smart_android），更多好的原创文章均首发于微信订阅号：非著名程序员
![](https://raw.githubusercontent.com/loonggg/BlogImages/master/%E5%85%AC%E4%BC%97%E5%8F%B7%E4%BA%8C%E7%BB%B4%E7%A0%81/erweima.jpg)

# License
```xml
Copyright 2017 loonggg

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
