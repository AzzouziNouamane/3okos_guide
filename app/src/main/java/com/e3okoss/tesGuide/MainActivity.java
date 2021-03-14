package com.e3okoss.tesGuide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.e3okoss.tesGuide.tools.CircleTransform;
import com.e3okoss.tesGuide.tools.Constants;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mainLayout;
    TextView titleTV, textTV;
    ImageView mainLogo;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        titleTV = findViewById(R.id.titleTV);
        textTV = findViewById(R.id.textTV);
        mainLogo = findViewById(R.id.main_logo);
        startBtn = findViewById(R.id.startBtn);

        if(!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY1_BACKGROUND_COLOR)) {
            mainLayout.setBackgroundColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY1_BACKGROUND_COLOR)));
        }

        if(!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY1_TITLE)) {
            titleTV.setText(Constants.getTinyPref(this, Constants.PREF_ACTIVITY1_TITLE));
        }

        if(!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY1_TITLE_COLOR)) {
            titleTV.setTextColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY1_TITLE_COLOR)));
        }

        if(!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY1_IMAGE)) {
            Picasso.get().load(Constants.getTinyPref(this, Constants.PREF_ACTIVITY1_IMAGE)).transform(new CircleTransform())
                    .resize(Constants.getScreenSize(this, true)/2, Constants.getScreenSize(this, true)/2).into(mainLogo);
        }
        else {
            Picasso.get().load(R.drawable.main_img).transform(new CircleTransform())
                    .resize(Constants.getScreenSize(this, true)/2, Constants.getScreenSize(this, true)/2).into(mainLogo);
        }

        if(!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY1_TEXT)) {
            textTV.setText(Constants.getTinyPref(this, Constants.PREF_ACTIVITY1_TEXT));
        }

        if(!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY1_TEXT_COLOR)) {
            textTV.setTextColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY1_TEXT_COLOR)));
        }

        if(!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY1_BUTTON_TEXT)) {
            startBtn.setText(Constants.getTinyPref(this, Constants.PREF_ACTIVITY1_BUTTON_TEXT));
        }


        if(!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY1_BUTTON_TEXT_COLOR)) {
            startBtn.setTextColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY1_BUTTON_TEXT_COLOR)));
        }

        if(Constants.getTinyPref(this, Constants.PREF_ACTIVITY1_ADS_NETWORK).equalsIgnoreCase("admob")) {
            (findViewById(R.id.my_template)).setVisibility(View.VISIBLE);
            (findViewById(R.id.native_ad_container)).setVisibility(View.GONE);
            AdLoader adLoader = new AdLoader.Builder(this, Constants.getTinyPref(this, Constants.PREF_ADMOB_NATIVE))
                    .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                        @Override
                        public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                            TemplateView template = findViewById(R.id.my_template);
                            template.setNativeAd(unifiedNativeAd);
                        }
                    })
                    .build();

            adLoader.loadAd(new AdRequest.Builder().build());

        }
        else {
            (findViewById(R.id.my_template)).setVisibility(View.GONE);
            (findViewById(R.id.native_ad_container)).setVisibility(View.VISIBLE);
            loadNativeAd();
        }


        int buttonBg = !Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY1_BUTTON_BACKGROUND_COLOR) ? Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY1_BUTTON_BACKGROUND_COLOR))
                : ContextCompat.getColor(this, R.color.blue);

        int buttonStork = !Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY1_BUTTON_STROKE) ? Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY1_BUTTON_STROKE))
                : ContextCompat.getColor(this, R.color.white);




        Constants.customView(startBtn, buttonBg, buttonStork, Constants.getTinyIntPref(this, Constants.PREF_ACTIVITY1_BUTTON_RADIUS_TOP_LEFT),
                Constants.getTinyIntPref(this, Constants.PREF_ACTIVITY1_BUTTON_RADIUS_TOP_RIGHT), Constants.getTinyIntPref(this, Constants.PREF_ACTIVITY1_BUTTON_RADIUS_BOTTOM_LEFT),
                Constants.getTinyIntPref(this, Constants.PREF_ACTIVITY1_BUTTON_RADIUS_BOTTOM_RIGHT));


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(new Intent(MainActivity.this, SecActivity.class));
                Constants.showInterstitial(MainActivity.this, Constants.getTinyPref(MainActivity.this, Constants.PREF_ACTIVITY1_ADS_NETWORK),
                        SecActivity.class, false);
            }
        });
    }

    private com.facebook.ads.NativeAd nativeAd;

    private void loadNativeAd() {
        // Instantiate a NativeAd object.
        // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
        // now, while you are testing and replace it later when you have signed up.
        // While you are using this temporary code you will only get test ads and if you release
        // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
        nativeAd = new com.facebook.ads.NativeAd(this, Constants.getTinyPref(this, Constants.PREF_FACEBOOK_NATIVE));

        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                // Native ad finished downloading all assets
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Native ad failed to load
                Log.e("ADS", "Native ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Native ad is loaded and ready to be displayed
                if (nativeAd == null || nativeAd != ad) {
                    return;
                }
                // Inflate Native Ad into Container
                inflateAd(nativeAd);
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Native ad clicked
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Native ad impression
            }
        };

        // Request an ad
        nativeAd.loadAd(
                nativeAd.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());
    }
    NativeAdLayout nativeAdLayout;
    private void inflateAd(com.facebook.ads.NativeAd nativeAd) {

        nativeAd.unregisterView();

        // Add the Ad view into the ad container.
        nativeAdLayout = findViewById(R.id.native_ad_container);
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        LinearLayout adView = (LinearLayout) inflater.inflate(R.layout.native_ad_layout, nativeAdLayout, false);
        nativeAdLayout.addView(adView);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(MainActivity.this, nativeAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        // Create native UI using the ad metadata.
        com.facebook.ads.MediaView nativeAdIcon = adView.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = adView.findViewById(R.id.native_ad_title);
        com.facebook.ads.MediaView nativeAdMedia = adView.findViewById(R.id.native_ad_media);
        TextView nativeAdSocialContext = adView.findViewById(R.id.native_ad_social_context);
        TextView nativeAdBody = adView.findViewById(R.id.native_ad_body);
        TextView sponsoredLabel = adView.findViewById(R.id.native_ad_sponsored_label);
        Button nativeAdCallToAction = adView.findViewById(R.id.native_ad_call_to_action);

        // Set the Text.
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

        // Create a list of clickable views
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);

        // Register the Title and CTA button to listen for clicks.
        nativeAd.registerViewForInteraction(
                adView, nativeAdMedia, nativeAdIcon, clickableViews);
    }
}