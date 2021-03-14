package com.e3okoss.tesGuide.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class Constants {

    public final static int FirstTimer = new Random().nextInt(((15000 - 5000) + 1) + 5000); // First Timer in MilliSec, Random ((max - min) + 1 + min)  or Constant
    public final static int SecTimer = new Random().nextInt(((15000 - 5000) + 1) + 5000); // First Timer in MilliSec, Random ((max - min) + 1 + min)  or Constant

    public static final String JSON_DATA = "Data";

    public static final String JSON_GENERAL_DATA = "GeneralData";
    public static final String JsObjectAdID = "AdMobId" ;
    public static final String JsObjectAdBanner = "BannerAdmob" ;
    public static final String JsObjectAdInterstitial = "InterstitialAdmob" ;
    public static final String JsObjectAdNative = "NativeAdmob" ;
    public static final String JsObjectFbBanner = "BannerFacebook" ;
    public static final String JsObjectFbInterstitial = "InterstitialFacebook" ;
    public static final String JsObjectFbNative = "NativeFacebook" ;
    public static final String JsObjectImageBanner = "ImageBanner";
    public static final String JsObjectImageBannerImg = "ImageBannerImg";
    public static final String JsObjectImageBannerURl = "ImageBannerURL";

    public static final String JsObjectShareText = "shareText";
    public static final String PrefShareText = "PrefShareText";
    public static final String JsObjectRateText = "ratePackageName";
    public static final String PrefRateText = "PrefRatePackageName";
    public static final String JsObjectMoreText = "moreLink";
    public static final String PrefMoreText = "PrefMoreLink";

    public static final String JSON_ACTIVITY1 = "Activity1";
    public static final String JSON_ACTIVITY2 = "Activity2";
    public static final String JSON_ACTIVITY3 = "Activity3";
    public static final String JSON_ACTIVITY4 = "Activity4";
    public static final String JSON_ACTIVITY5 = "Activity5";
    public static final String JSON_ACTIVITY6 = "Activity6";
    public static final String JSON_ACTIVITY7 = "Activity7";

    // Ads Const
    public static final String PREF_ADMOB_ID = "prefAdmobID";
    public static final String PREF_ADMOB_BANNER = "prefAdmobBanner";
    public static final String PREF_ADMOB_INTERSTITIAL = "prefAdmobInterstitial";
    public static final String PREF_ADMOB_NATIVE = "prefAdmobNative";
    public static final String PREF_FACEBOOK_BANNER = "prefFacebookBanner";
    public static final String PREF_FACEBOOK_INTERSTITIAL = "prefFacebookInterstitial";
    public static final String PREF_FACEBOOK_NATIVE = "prefFacebookNative";
    public static final String PREF_CPA_ON = "prefCPAOn";
    public static final String PREF_CPA_IMAGE = "prefCPAImage";
    public static final String PREF_CPA_URL = "prefCPAUrl";


    public static final String JSON_ACTIVITY1_ADS_NETWORK = "NetworkAds";
    public static final String PREF_ACTIVITY1_ADS_NETWORK = "prefActivity1AdsNetwork";

    public static final String JSON_ACTIVITY2_ADS_NETWORK = "NetworkAds";
    public static final String PREF_ACTIVITY2_ADS_NETWORK = "prefActivity2AdsNetwork";

    public static final String JSON_ACTIVITY3_ADS_NETWORK = "NetworkAds";
    public static final String PREF_ACTIVITY3_ADS_NETWORK = "prefActivity3AdsNetwork";

    public static final String JSON_ACTIVITY5_ADS_NETWORK = "NetworkAds";
    public static final String PREF_ACTIVITY5_ADS_NETWORK = "prefActivity5AdsNetwork";

    public static final String JSON_ACTIVITY6_ADS_NETWORK = "NetworkAds";
    public static final String PREF_ACTIVITY6_ADS_NETWORK = "prefActivity6AdsNetwork";

    public static final String JSON_ACTIVITY7_ADS_NETWORK = "NetworkAds";
    public static final String PREF_ACTIVITY7_ADS_NETWORK = "prefActivity7AdsNetwork";

    // Activity 1
    public static final String JSON_ACTIVITY1_BACKGROUND_COLOR = "backgroundColor";
    public static final String JSON_ACTIVITY1_TITLE = "title";
    public static final String JSON_ACTIVITY1_TITLE_COLOR = "titleColor";
    public static final String JSON_ACTIVITY1_IMAGE = "image";
    public static final String JSON_ACTIVITY1_TEXT = "text";
    public static final String JSON_ACTIVITY1_TEXT_COLOR = "textColor";
    public static final String JSON_ACTIVITY1_BUTTON_TEXT = "buttonText";
    public static final String JSON_ACTIVITY1_BUTTON_BACKGROUND_COLOR = "buttonBackgroundColor";
    public static final String JSON_ACTIVITY1_BUTTON_TEXT_COLOR = "buttonTextColor";
    public static final String JSON_ACTIVITY1_BUTTON_RADIUS_TOP_LEFT = "buttonRadiusTopLeft";
    public static final String JSON_ACTIVITY1_BUTTON_RADIUS_TOP_RIGHT = "buttonRadiusTopRight";
    public static final String JSON_ACTIVITY1_BUTTON_RADIUS_BOTTOM_LEFT = "buttonRadiusBottomLeft";
    public static final String JSON_ACTIVITY1_BUTTON_RADIUS_BOTTOM_RIGHT = "buttonRadiusBottomRight";
    public static final String JSON_ACTIVITY1_BUTTON_STROKE = "buttonStroke";

    public static final String PREF_ACTIVITY1_BACKGROUND_COLOR = "PrefAct1backgroundColor";
    public static final String PREF_ACTIVITY1_TITLE = "PrefAct1title";
    public static final String PREF_ACTIVITY1_TITLE_COLOR = "PrefAct1titleColor";
    public static final String PREF_ACTIVITY1_IMAGE = "PrefAct1image";
    public static final String PREF_ACTIVITY1_TEXT = "PrefAct1text";
    public static final String PREF_ACTIVITY1_TEXT_COLOR = "PrefAct1textColor";
    public static final String PREF_ACTIVITY1_BUTTON_TEXT = "PrefAct1buttonText";
    public static final String PREF_ACTIVITY1_BUTTON_BACKGROUND_COLOR = "PrefAct1buttonBackgroundColor";
    public static final String PREF_ACTIVITY1_BUTTON_TEXT_COLOR = "PrefAct1buttonTextColor";
    public static final String PREF_ACTIVITY1_BUTTON_RADIUS_TOP_LEFT = "PrefAct1buttonRadiusTopLeft";
    public static final String PREF_ACTIVITY1_BUTTON_RADIUS_TOP_RIGHT = "PrefAct1buttonRadiusTopRight";
    public static final String PREF_ACTIVITY1_BUTTON_RADIUS_BOTTOM_LEFT = "PrefAct1buttonRadiusBottomLeft";
    public static final String PREF_ACTIVITY1_BUTTON_RADIUS_BOTTOM_RIGHT = "PrefAct1buttonRadiusBottomRight";
    public static final String PREF_ACTIVITY1_BUTTON_STROKE = "PrefAct1buttonStroke";


    // Activity 2
    public static final String JSON_ACTIVITY2_BACKGROUND_COLOR = "backgroundColor";
    public static final String JSON_ACTIVITY2_TITLE = "title";
    public static final String JSON_ACTIVITY2_TITLE_COLOR = "titleColor";
    public static final String JSON_ACTIVITY2_IMAGE = "image";
    public static final String JSON_ACTIVITY2_TEXT = "text";
    public static final String JSON_ACTIVITY2_TEXT_COLOR = "textColor";
    public static final String JSON_ACTIVITY2_TIMER = "timer";
    public static final String JSON_ACTIVITY2_PERCENTAGE_COLOR = "percentageColor";

    public static final String PREF_ACTIVITY2_BACKGROUND_COLOR = "PrefAct2backgroundColor";
    public static final String PREF_ACTIVITY2_TITLE = "PrefAct2title";
    public static final String PREF_ACTIVITY2_TITLE_COLOR = "PrefAct2titleColor";
    public static final String PREF_ACTIVITY2_IMAGE = "PrefAct2image";
    public static final String PREF_ACTIVITY2_TEXT = "PrefAct2text";
    public static final String PREF_ACTIVITY2_TEXT_COLOR = "PrefAct2textColor";
    public static final String PREF_ACTIVITY2_TIMER = "PrefAct2timer";
    public static final String PREF_ACTIVITY2_PERCENTAGE_COLOR = "PrefAct2percentageColor";

    // Activity 3
    public static final String JSON_ACTIVITY3_BACKGROUND_COLOR = "backgroundColor";
    public static final String JSON_ACTIVITY3_TITLE = "title";
    public static final String JSON_ACTIVITY3_TITLE_COLOR = "titleColor";
    public static final String JSON_ACTIVITY3_IMAGE = "image";
    public static final String JSON_ACTIVITY3_TEXT1 = "text1";
    public static final String JSON_ACTIVITY3_TEXT1_COLOR = "text1Color";
    public static final String JSON_ACTIVITY3_TEXT2 = "text2";
    public static final String JSON_ACTIVITY3_TEXT2_COLOR = "text2Color";
    public static final String JSON_ACTIVITY3_START_BUTTON_BACKGROUND = "startButtonBackground";
    public static final String JSON_ACTIVITY3_SHARE_BUTTON_BACKGROUND = "shareButtonBackground";
    public static final String JSON_ACTIVITY3_RATE_BUTTON_BACKGROUND = "rateButtonBackground";
    public static final String JSON_ACTIVITY3_MORE_BUTTON_BACKGROUND = "moreButtonBackground";

    public static final String PREF_ACTIVITY3_BACKGROUND_COLOR = "PrefAct3backgroundColor";
    public static final String PREF_ACTIVITY3_TITLE = "PrefAct3title";
    public static final String PREF_ACTIVITY3_TITLE_COLOR = "PrefAct3titleColor";
    public static final String PREF_ACTIVITY3_IMAGE = "PrefAct3image";
    public static final String PREF_ACTIVITY3_TEXT1 = "PrefAct3text1";
    public static final String PREF_ACTIVITY3_TEXT1_COLOR = "PrefAct3text1Color";
    public static final String PREF_ACTIVITY3_TEXT2 = "PrefAct3text2";
    public static final String PREF_ACTIVITY3_TEXT2_COLOR = "PrefAct3text2Color";
    public static final String PREF_ACTIVITY3_START_BUTTON_BACKGROUND = "PrefAct3startButtonBackground";
    public static final String PREF_ACTIVITY3_SHARE_BUTTON_BACKGROUND = "PrefAct3shareButtonBackground";
    public static final String PREF_ACTIVITY3_RATE_BUTTON_BACKGROUND = "PrefAct3rateButtonBackground";
    public static final String PREF_ACTIVITY3_MORE_BUTTON_BACKGROUND = "PrefAct3moreButtonBackground";

    // Activity 4
    public static final String JSON_LIST = "activity4List";
    public static final String JSON_TOTAL_ITEMS = "activity4TotalItems";
    public static final String JSON_ACTIVITY4_ADS_NETWORK = "NetworkAds";
    public static final String JSON_ACTIVITY4_SHOW_INTERSTITIAL = "showInterstitial";
    public static final String JSON_ACTIVITY4_BACKGROUND_COLOR = "backgroundColor";
    public static final String JSON_ACTIVITY4_TITLE = "title";
    public static final String JSON_ACTIVITY4_TITLE_COLOR = "titleColor";
    public static final String JSON_ACTIVITY4_IMAGE = "image";
    public static final String JSON_ACTIVITY4_NEXT_TEXT = "nextText";
    public static final String JSON_ACTIVITY4_NEXT_COLOR = "nextColor";
    public static final String JSON_ACTIVITY4_START_TEXT = "startText";
    public static final String JSON_ACTIVITY4_START_COLOR = "startColor";


    // Activity 5
    public static final String JSON_ACTIVITY5_BACKGROUND_COLOR = "backgroundColor";
    public static final String JSON_ACTIVITY5_TITLE = "title";
    public static final String JSON_ACTIVITY5_TITLE_COLOR = "titleColor";
    public static final String JSON_ACTIVITY5_IMAGE = "image";
    public static final String JSON_ACTIVITY5_BUTTON_MAIN_BACKGROUND = "buttonsMainBackground";
    public static final String JSON_ACTIVITY5_BUTTON1_IMG = "button1Img";
    public static final String JSON_ACTIVITY5_BUTTON2_IMG = "button2Img";
    public static final String JSON_ACTIVITY5_BUTTON3_IMG = "button3Img";
    public static final String JSON_ACTIVITY5_SHOW_RATE = "showRate";
    public static final String JSON_ACTIVITY5_RATE_TEXT = "rateText";

    public static final String PREF_ACTIVITY5_BACKGROUND_COLOR = "PrefAct5backgroundColor";
    public static final String PREF_ACTIVITY5_TITLE = "PrefAct5title";
    public static final String PREF_ACTIVITY5_TITLE_COLOR = "PrefAct5titleColor";
    public static final String PREF_ACTIVITY5_IMAGE = "PrefAct5image";
    public static final String PREF_ACTIVITY5_BUTTON_MAIN_BACKGROUND = "PrefAct5buttonsMainBackground";
    public static final String PREF_ACTIVITY5_BUTTON1_IMG = "PrefAct5button1Img";
    public static final String PREF_ACTIVITY5_BUTTON2_IMG = "PrefAct5button2Img";
    public static final String PREF_ACTIVITY5_BUTTON3_IMG = "PrefAct5button3Img";
    public static final String PREF_ACTIVITY5_SHOW_RATE = "PrefAct5showRate";
    public static final String PREF_ACTIVITY5_RATE_TEXT = "PrefAct5rateText";

    // Activity 6
    public static final String JSON_ACTIVITY6_BACKGROUND_COLOR = "backgroundColor";
    public static final String JSON_ACTIVITY6_TITLE = "title";
    public static final String JSON_ACTIVITY6_TITLE_COLOR = "titleColor";
    public static final String JSON_ACTIVITY6_IMAGE = "image";
    public static final String JSON_ACTIVITY6_TEXT = "text";
    public static final String JSON_ACTIVITY6_TEXT_COLOR = "textColor";
    public static final String JSON_ACTIVITY6_TIMER = "timer";
    public static final String JSON_ACTIVITY6_PERCENTAGE_COLOR = "percentageColor";

    public static final String PREF_ACTIVITY6_BACKGROUND_COLOR = "PrefAct6backgroundColor";
    public static final String PREF_ACTIVITY6_TITLE = "PrefAct6title";
    public static final String PREF_ACTIVITY6_TITLE_COLOR = "PrefAct6titleColor";
    public static final String PREF_ACTIVITY6_IMAGE = "PrefAct6image";
    public static final String PREF_ACTIVITY6_TEXT = "PrefAct6text";
    public static final String PREF_ACTIVITY6_TEXT_COLOR = "PrefAct6textColor";
    public static final String PREF_ACTIVITY6_TIMER = "PrefAct6timer";
    public static final String PREF_ACTIVITY6_PERCENTAGE_COLOR = "PrefAct6percentageColor";

    // Activity 7
    public static final String JSON_ACTIVITY7_BACKGROUND_COLOR = "backgroundColor";
    public static final String JSON_ACTIVITY7_TITLE = "title";
    public static final String JSON_ACTIVITY7_TITLE_COLOR = "titleColor";
    public static final String JSON_ACTIVITY7_IMAGE = "image";
    public static final String JSON_ACTIVITY7_BOX_COLOR = "boxColor";
    public static final String JSON_ACTIVITY7_BOX_BORDER_COLOR = "boxBorderColor";
    public static final String JSON_ACTIVITY7_BOX_TEXT = "boxText";
    public static final String JSON_ACTIVITY7_BOX_TEXT_COLOR = "boxTextColor";
    public static final String JSON_ACTIVITY7_BOX_BUTTON_BACKGROUND = "boxButtonBackground";
    public static final String JSON_ACTIVITY7_BOX_BUTTON_TEXT = "boxButtonText";
    public static final String JSON_ACTIVITY7_BOX_BUTTON_TEXT_COLOR = "boxButtonTextColor";

    public static final String PREF_ACTIVITY7_BACKGROUND_COLOR = "PrefAct7backgroundColor";
    public static final String PREF_ACTIVITY7_TITLE = "PrefAct7title";
    public static final String PREF_ACTIVITY7_TITLE_COLOR = "PrefAct7titleColor";
    public static final String PREF_ACTIVITY7_IMAGE = "PrefAct7image";
    public static final String PREF_ACTIVITY7_BOX_COLOR = "PrefAct7boxColor";
    public static final String PREF_ACTIVITY7_BOX_BORDER_COLOR = "PrefAct7boxBorderColor";
    public static final String PREF_ACTIVITY7_BOX_TEXT = "PrefAct7boxText";
    public static final String PREF_ACTIVITY7_BOX_TEXT_COLOR = "PrefAct7boxTextColor";
    public static final String PREF_ACTIVITY7_BOX_BUTTON_BACKGROUND = "PrefAct7boxButtonBackground";
    public static final String PREF_ACTIVITY7_BOX_BUTTON_TEXT = "PrefAct7boxButtonText";
    public static final String PREF_ACTIVITY7_BOX_BUTTON_TEXT_COLOR = "PrefAct7boxButtonTextColor";

    public static class Tags{
        public static String DONE ="done";
        public static String FAILED ="failed";
        public static String ADMOB = "admob";
        public static String FACEBOOK = "facebook";
        public static String CUSTOMBANNER = "custome_banner";
    }


    //path
    public static final String DROID_LOGO = "M 495.00,0.00\n" +
            "           C 495.00,0.00 495.00,417.00 495.00,417.00\n" +
            "             495.00,417.00 0.00,417.00 0.00,417.00\n" +
            "             0.00,417.00 0.00,0.00 0.00,0.00\n" +
            "             0.00,0.00 495.00,0.00 495.00,0.00 Z\n" +
            "           M 81.18,219.39\n" +
            "           C 75.28,224.66 73.26,233.55 71.61,241.00\n" +
            "             68.81,256.26 68.66,271.70 71.61,287.00\n" +
            "             72.76,294.37 74.47,301.98 79.68,307.70\n" +
            "             85.29,313.85 91.52,314.81 99.00,316.73\n" +
            "             99.00,316.73 126.00,321.96 126.00,321.96\n" +
            "             126.00,321.96 134.00,321.96 134.00,321.96\n" +
            "             134.00,321.96 144.00,323.00 144.00,323.00\n" +
            "             156.04,323.14 168.13,322.58 180.00,320.39\n" +
            "             187.27,319.04 193.58,317.17 198.20,310.91\n" +
            "             202.27,305.40 200.54,300.30 201.28,294.00\n" +
            "             201.28,294.00 202.00,244.00 202.00,244.00\n" +
            "             201.98,234.15 201.61,228.06 192.91,221.85\n" +
            "             187.58,218.04 176.56,216.51 170.00,215.41\n" +
            "             153.07,212.57 126.99,210.70 110.00,212.28\n" +
            "             101.11,213.56 88.05,213.25 81.18,219.39 Z";







    public static void customView(View v, int backgroundColor, int borderColor, float topLeft, float topRight, float bottomRight, float bottomLeft) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadii(new float[] { topLeft, topLeft, topRight, topRight, bottomRight, bottomRight, bottomLeft, bottomLeft });
        shape.setColor(backgroundColor);
        shape.setStroke(3, borderColor);
        v.setBackground(shape);
    }

    public static boolean checkConnection(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if (activeNetworkInfo != null) {

            if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                return true;
            } else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                return true;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    public static boolean isPrefEmpty(Context context, String prefStr) {
        TinyDB tinyDB = new TinyDB(context);
        return tinyDB.getString(prefStr).isEmpty();
    }

    public static boolean isIntPrefNotZero(Context context, String prefStr) {
        TinyDB tinyDB = new TinyDB(context);
        return tinyDB.getInt(prefStr) > 0;
    }

    public static String getTinyPref(Context context, String prefStr){
        TinyDB tinyDB = new TinyDB(context);
        return tinyDB.getString(prefStr);
    }

    public static int getTinyIntPref(Context context, String prefStr){
        TinyDB tinyDB = new TinyDB(context);
        return tinyDB.getInt(prefStr);
    }

    public static boolean getTinyBoolPref(Context context, String prefStr){
        TinyDB tinyDB = new TinyDB(context);
        return tinyDB.getBoolean(prefStr, true);
    }


    public static int getScreenSize(Activity activity, boolean getWidth) {
        Point size = new Point();
        WindowManager w = activity.getWindowManager();

        w.getDefaultDisplay().getSize(size);
        if(getWidth)
            return size.x;
        else
            return size.y;
    }

    public static void setCustomBanner(final Context context, RelativeLayout relativeLayout, String imageBannerImg, final String imageBannerURL) {
        ImageView imageView = new ImageView(context);


//setting image position
        relativeLayout.addView(imageView);


        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        // imageView.setScaleType(ImageView.ScaleType.FIT_XY);


        Picasso.get()
                .load(imageBannerImg)
                .resize(width, height / 8)
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(imageBannerURL));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    public static void showInterstitial(final Context context, String adNetwork, final Class<?> nextClass, final boolean finishActivity) {
        if(adNetwork.equalsIgnoreCase("admob")) {
            final InterstitialAd mInterstitialAd = new InterstitialAd(context);
            mInterstitialAd.setAdUnitId(getTinyPref(context, Constants.PREF_ADMOB_INTERSTITIAL));
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    // Code to be executed when an ad finishes loading.
                    mInterstitialAd.show();
                }

                @Override
                public void onAdFailedToLoad(LoadAdError adError) {
                    // Code to be executed when an ad request fails.
                    if(nextClass !=null) {
                        Intent newI = new Intent(context, nextClass);
                        context.startActivity(newI);
                        if (finishActivity) {
                            ((Activity) context).finish();
                        }
                    }
                }

                @Override
                public void onAdOpened() {
                    // Code to be executed when the ad is displayed.
                }

                @Override
                public void onAdClicked() {
                    // Code to be executed when the user clicks on an ad.
                }

                @Override
                public void onAdLeftApplication() {
                    // Code to be executed when the user has left the app.
                }

                @Override
                public void onAdClosed() {
                    // Code to be executed when the interstitial ad is closed.
                    if(nextClass !=null) {
                        Intent newI = new Intent(context, nextClass);
                        context.startActivity(newI);
                        if (finishActivity) {
                            ((Activity) context).finish();
                        }
                    }
                }
            });
        }
        else {
            final com.facebook.ads.InterstitialAd interstitialAd = new com.facebook.ads.InterstitialAd(context, getTinyPref(context, Constants.PREF_FACEBOOK_INTERSTITIAL));
            com.facebook.ads.InterstitialAdListener interstitialAdListener = new com.facebook.ads.InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    // Interstitial ad displayed callback
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
                    // Interstitial dismissed callback
                    if(nextClass !=null) {
                        Intent newI = new Intent(context, nextClass);
                        context.startActivity(newI);
                        if (finishActivity) {
                            ((Activity) context).finish();
                        }
                    }
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    if(nextClass !=null) {
                        Intent newI = new Intent(context, nextClass);
                        context.startActivity(newI);
                        if (finishActivity) {
                            ((Activity) context).finish();
                        }
                    }
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    // Interstitial ad is loaded and ready to be displayed
                    // Show the ad
                    interstitialAd.show();
                }

                @Override
                public void onAdClicked(Ad ad) {
                    // Ad clicked callback
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    // Ad impression logged callback
                }
            };

            // For auto play video ads, it's recommended to load the ad
            // at least 30 seconds before it is shown
            interstitialAd.loadAd(
                    interstitialAd.buildLoadAdConfig()
                            .withAdListener(interstitialAdListener)
                            .build());

        }
    }
}
