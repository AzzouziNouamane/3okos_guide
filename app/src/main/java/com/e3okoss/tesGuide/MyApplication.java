package com.e3okoss.tesGuide;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.e3okoss.tesGuide.tools.SynData;
import com.e3okoss.tesGuide.tools.TinyDB;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MyApplication extends MultiDexApplication {

    Context mContext;
    TinyDB tinyDB;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        tinyDB = new TinyDB(mContext);

        Detector.init(getApplicationContext());

        buildRequestOfJSON();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AudienceNetworkAds.initialize(this);
    }

    @SuppressLint("StaticFieldLeak")
    private void buildRequestOfJSON() {
        new SynData(getApplicationContext(), Detector.getsys()) {

            @Override
            protected void onDataPreExecute() {

            }

            @Override
            protected void onDataExecute(String result, String status) {

            }

            @Override
            protected void onAdResult() {

            }
        }.execute();
    }

}
