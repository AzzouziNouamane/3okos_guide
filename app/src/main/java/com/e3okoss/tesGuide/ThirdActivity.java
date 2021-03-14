package com.e3okoss.tesGuide;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.e3okoss.tesGuide.tools.Constants;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    RelativeLayout mainLayout;
    TextView titleTV, textTV1, textTV2;
    ImageView mainLogo, bottomStartBtn, bottomShareBtn, bottomRateBtn, bottomMoreBtn;

    RelativeLayout adsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        mainLayout = findViewById(R.id.mainLayout);
        titleTV = findViewById(R.id.titleTV);
        textTV1 = findViewById(R.id.textTV1);
        textTV2 = findViewById(R.id.textTV2);
        mainLogo = findViewById(R.id.main_logo);
        bottomStartBtn = findViewById(R.id.bottomStartBtn);
        bottomShareBtn = findViewById(R.id.bottomShareBtn);
        bottomRateBtn = findViewById(R.id.bottomRateBtn);
        bottomMoreBtn = findViewById(R.id.bottomMoreBtn);


        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY3_BACKGROUND_COLOR)) {
            mainLayout.setBackgroundColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_BACKGROUND_COLOR)));
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY3_TITLE)) {
            titleTV.setText(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_TITLE));
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY3_TITLE_COLOR)) {
            titleTV.setTextColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_TITLE_COLOR)));
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY3_IMAGE)) {
            Picasso.get().load(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_IMAGE)).into(mainLogo);
        } else {
            Picasso.get().load(R.drawable.main_img).into(mainLogo);
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY3_TEXT1)) {
            textTV1.setText(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_TEXT1));
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY3_TEXT1_COLOR)) {
            textTV1.setTextColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_TEXT1_COLOR)));
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY3_TEXT2)) {
            textTV2.setText(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_TEXT2));
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY3_TEXT2_COLOR)) {
            textTV2.setTextColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_TEXT2_COLOR)));
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY3_START_BUTTON_BACKGROUND)) {
            final ImageView img = new ImageView(this);
            Picasso.get()
                    .load(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_START_BUTTON_BACKGROUND))
                    .fit()
                    .centerCrop()
                    .into(img, new Callback() {
                        @Override
                        public void onSuccess() {

                            bottomStartBtn.setBackground(img.getDrawable());
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY3_SHARE_BUTTON_BACKGROUND)) {
            final ImageView img = new ImageView(this);
            Picasso.get()
                    .load(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_SHARE_BUTTON_BACKGROUND))
                    .fit()
                    .centerCrop()
                    .into(img, new Callback() {
                        @Override
                        public void onSuccess() {

                            bottomShareBtn.setBackground(img.getDrawable());
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY3_RATE_BUTTON_BACKGROUND)) {
            final ImageView img = new ImageView(this);
            Picasso.get()
                    .load(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_RATE_BUTTON_BACKGROUND))
                    .fit()
                    .centerCrop()
                    .into(img, new Callback() {
                        @Override
                        public void onSuccess() {

                            bottomRateBtn.setBackground(img.getDrawable());
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY3_MORE_BUTTON_BACKGROUND)) {
            final ImageView img = new ImageView(this);
            Picasso.get()
                    .load(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_MORE_BUTTON_BACKGROUND))
                    .fit()
                    .centerCrop()
                    .into(img, new Callback() {
                        @Override
                        public void onSuccess() {

                            bottomMoreBtn.setBackground(img.getDrawable());
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
        }

        if(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_ADS_NETWORK).equalsIgnoreCase("admob")) {
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

        adsLayout = findViewById(R.id.adsLayout);
        if(Constants.getTinyBoolPref(this, Constants.PREF_CPA_ON)) {
            Constants.setCustomBanner(this, adsLayout, Constants.PREF_CPA_IMAGE, Constants.PREF_CPA_URL);
        }
        else {
            if(Constants.getTinyPref(this, Constants.PREF_ACTIVITY3_ADS_NETWORK).equalsIgnoreCase("admob")) {
                AdView adView = new AdView(this);
                adView.setAdSize(AdSize.SMART_BANNER);
                adView.setAdUnitId(Constants.getTinyPref(this, Constants.PREF_ADMOB_BANNER));


                adsLayout.addView(adView);

                AdRequest adRequest = new AdRequest.Builder().build();
                adView.loadAd(adRequest);
            }
            else {
                com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, Constants.getTinyPref(this, Constants.PREF_FACEBOOK_BANNER), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
                // Add the ad view to your activity layout
                adsLayout.addView(adView);
                // Request an ad
                adView.loadAd();
            }
        }





        bottomStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(new Intent(ThirdActivity.this, SliderActivity.class));
                Constants.showInterstitial(ThirdActivity.this, Constants.getTinyPref(ThirdActivity.this, Constants.PREF_ACTIVITY3_ADS_NETWORK),
                        SliderActivity.class, true);
            }
        });

        bottomShareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txtShare = getString(R.string.share_txt) + BuildConfig.APPLICATION_ID;
                if(!Constants.isPrefEmpty(ThirdActivity.this, Constants.PrefShareText)) {
                    txtShare = Constants.getTinyPref(ThirdActivity.this, Constants.PrefShareText);
                }

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, txtShare);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        bottomRateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String appPackageName = !Constants.isPrefEmpty(ThirdActivity.this, Constants.PrefRateText) ?
                        Constants.getTinyPref(ThirdActivity.this, Constants.PrefRateText) : BuildConfig.APPLICATION_ID;

                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
                }
            }
        });

        bottomMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String developerLink = !Constants.isPrefEmpty(ThirdActivity.this, Constants.PrefMoreText) ?
                        Constants.getTinyPref(ThirdActivity.this, Constants.PrefMoreText) : getString(R.string.more_link);

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(developerLink)));

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
        LayoutInflater inflater = LayoutInflater.from(ThirdActivity.this);
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        LinearLayout adView = (LinearLayout) inflater.inflate(R.layout.native_ad_layout, nativeAdLayout, false);
        nativeAdLayout.addView(adView);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(ThirdActivity.this, nativeAd, nativeAdLayout);
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
