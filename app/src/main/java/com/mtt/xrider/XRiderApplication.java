package com.mtt.xrider;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by Kerry on 16/3/2.
 */
public class XRiderApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"itGRpRqsBKoj2Pvsj3vFoYSi-gzGzoHsz","4RJnx2QeSmQUE353uYfDIwwJ");
    }
}
