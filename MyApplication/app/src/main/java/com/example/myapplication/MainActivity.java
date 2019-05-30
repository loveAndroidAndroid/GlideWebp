package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.webp);
        ImageView imageView2 = (ImageView) findViewById(R.id.webp2);
        ImageView imageView3 = (ImageView) findViewById(R.id.webp3);
        ImageView imageView4 = (ImageView) findViewById(R.id.webp4);
        ImageView imageView5 = (ImageView) findViewById(R.id.webp5);
        RequestOptions options =
                new RequestOptions()
                        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).diskCacheStrategy(DiskCacheStrategy.NONE);
        Glide.with(this)
                .load("file:///android_asset/small.webp")
                .apply(options).transition(new DrawableTransitionOptions().crossFade(200))
                .into(imageView);
        Glide.with(this)
                .load("https://asgard.image.mucang.cn/asgard/2017/12/28/10/45ab2f68a13546c1914b61d54160b8ae.webp")
                .apply(options).transition(new DrawableTransitionOptions().crossFade(200))
                .into(imageView2);
        Glide.with(this)
                .load("https://raw.githubusercontent.com/LiPengfei0106/GlideSupport/master/imgs/webp.webp")
                .apply(options).transition(new DrawableTransitionOptions().crossFade(200))
                .into(imageView3);
        Glide.with(this)
                .load(R.mipmap.timg_7)
                .apply(options).transition(new DrawableTransitionOptions().crossFade(200))
                .into(imageView4);
        Glide.with(this)
                .load("https://raw.githubusercontent.com/LiPengfei0106/GlideSupport/master/imgs/gif.gif")
                .apply(options).transition(new DrawableTransitionOptions().crossFade(200))
                .into(imageView5);
    }

    @Override
    protected void onPause() {
        super.onPause();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.get(MainActivity.this).clearDiskCache();
            }
        }).start();
    }
}
