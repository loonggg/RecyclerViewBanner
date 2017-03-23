# RecyclerViewBanner
使用RecyclerView做的轮播图

### 前言
之前做的轮播图，对于十几个图片什么的能够满足，但是万一有几千张，几万张就容易造成内存泄露，使用RecyclerView做的轮播，可以利用它自身的复用机制，比较节省内存。所以这种方式感觉效果更好。

## 效果图
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
	    compile 'com.github.loonggg:RecyclerViewBanner:v1.1'
	}
 ```

### Step 3. There are a few xml attributes to customise the  RecyclerViewBanner

 * pointFocusBg 设置底部导航小圆点的选中状态颜色
 * pointUnfocusBg 设置底部导航小圆点的未选中状态颜色
 * interval 设置轮播图滚动间隔时间
 * isShowPoint 设置是否显示底部指示导航小圆点

#### Example
```xml
<com.loonggg.rvbanner.lib.RecyclerViewBanner
        android:id="@+id/rv_banner"
        android:layout_width="match_parent"
        android:layout_height="150dp"
        loonggg:interval="3000"
        loonggg:isShowPoint="true" />
```

### Step 4. Impelement Listener
```java
        recyclerViewBanner = (RecyclerViewBanner) findViewById(R.id.rv_banner);
        final List<Banner> banners = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            banners.add(new Banner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487221110004&di=d6043e4b0c90ddf3ea5096c3d8eb8f58&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2014%2F067%2F5116EPAUD762_1000x500.jpg"));
            banners.add(new Banner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487221129421&di=c085432cf7c15836f8a6479138740f39&imgtype=0&src=http%3A%2F%2Fimage85.360doc.com%2FDownloadImg%2F2015%2F05%2F0517%2F53199602_2.jpg"));
            banners.add(new Banner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487221161254&di=fbb99c5dad3d5a2a2c8b0b44e8c0e081&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2013%2F255%2FP52AOTE73EIG_1000x500.jpg"));
        }
        recyclerViewBanner.isShowIndicatorPoint(true);
        recyclerViewBanner.setRvBannerDatas(banners);
        recyclerViewBanner.setOnSwitchRvBannerListener(new RecyclerViewBanner.OnSwitchRvBannerListener() {
            @Override
            public void switchBanner(int position, ImageView bannerView) {
                Glide.with(bannerView.getContext()).load(banners.get(position % banners.size()).getUrl()).placeholder(R.mipmap.ic_launcher).into(bannerView);
            }
        });
        recyclerViewBanner.setOnRvBannerClickListener(new RecyclerViewBanner.OnRvBannerClickListener() {
            @Override
            public void onClick(int position) {
                //点击事件
            }
        });
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
