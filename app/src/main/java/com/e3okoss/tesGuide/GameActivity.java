package com.e3okoss.tesGuide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.e3okoss.tesGuide.tools.Constants;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;

public class GameActivity extends AppCompatActivity {


    RelativeLayout mainLayout;
    TextView titleTV;
    ImageView mainLogo;
    LinearLayout bottomLayout;
    ImageView newGameBtn, optionBtn, MultiplayerBtn;
    RelativeLayout adsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mainLayout = findViewById(R.id.mainLayout);
        titleTV = findViewById(R.id.titleTV);
        mainLogo = findViewById(R.id.main_logo);
        bottomLayout = findViewById(R.id.bottomLayout);
        newGameBtn = findViewById(R.id.newGameBtn);
        optionBtn = findViewById(R.id.optionBtn);
        MultiplayerBtn = findViewById(R.id.MultiplayerBtn);

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY5_BACKGROUND_COLOR)) {
            mainLayout.setBackgroundColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY5_BACKGROUND_COLOR)));
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY5_TITLE)) {
            titleTV.setText(Constants.getTinyPref(this, Constants.PREF_ACTIVITY5_TITLE));
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY5_TITLE_COLOR)) {
            titleTV.setTextColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY5_TITLE_COLOR)));
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY5_IMAGE)) {
            Picasso.get().load(Constants.getTinyPref(this, Constants.PREF_ACTIVITY5_IMAGE)).into(mainLogo);
        } else {
            Picasso.get().load(R.drawable.main_img).into(mainLogo);
        }


        adsLayout = findViewById(R.id.adsLayout);
          if(Constants.getTinyBoolPref(this, Constants.PREF_CPA_ON)) {
            Constants.setCustomBanner(this, adsLayout, Constants.PREF_CPA_IMAGE, Constants.PREF_CPA_URL);
        }
        else {
              if (Constants.getTinyPref(this, Constants.PREF_ACTIVITY5_ADS_NETWORK).equalsIgnoreCase("admob")) {
                  AdView adView = new AdView(this);
                  adView.setAdSize(AdSize.SMART_BANNER);
                  adView.setAdUnitId(Constants.getTinyPref(this, Constants.PREF_ADMOB_BANNER));


                  adsLayout.addView(adView);

                  AdRequest adRequest = new AdRequest.Builder().build();
                  adView.loadAd(adRequest);
              } else {
                  com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, Constants.getTinyPref(this, Constants.PREF_FACEBOOK_BANNER), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
                  // Add the ad view to your activity layout
                  adsLayout.addView(adView);
                  // Request an ad
                  adView.loadAd();
              }
          }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY5_BUTTON_MAIN_BACKGROUND)) {
            final ImageView img = new ImageView(this);
            Picasso.get()
                    .load(Constants.getTinyPref(this, Constants.PREF_ACTIVITY5_BUTTON_MAIN_BACKGROUND))
                    .fit()
                    .centerCrop()
                    .into(img, new Callback() {
                        @Override
                        public void onSuccess() {

                            bottomLayout.setBackground(img.getDrawable());
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY5_BUTTON1_IMG)) {
            Picasso.get().load(Constants.getTinyPref(this, Constants.PREF_ACTIVITY5_BUTTON1_IMG)).into(newGameBtn);
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY5_BUTTON2_IMG)) {
            Picasso.get().load(Constants.getTinyPref(this, Constants.PREF_ACTIVITY5_BUTTON2_IMG)).into(optionBtn);
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY5_BUTTON3_IMG)) {
            Picasso.get().load(Constants.getTinyPref(this, Constants.PREF_ACTIVITY5_BUTTON3_IMG)).into(MultiplayerBtn);
        }


        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRate();
            }
        });

        optionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRate();
            }
        });

        MultiplayerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRate();
            }
        });

    }

    private void showRate() {
        if(Constants.getTinyBoolPref(this, Constants.PREF_ACTIVITY5_SHOW_RATE)) {
            new LovelyStandardDialog(this, LovelyStandardDialog.ButtonLayout.VERTICAL)
                    .setTopColorRes(R.color.colorAccent)
                    .setButtonsColorRes(R.color.black)
                    .setIcon(R.drawable.ic_rate_review)
                    .setTitle(R.string.dialog_title)
                    .setMessage(!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY5_RATE_TEXT) ? Constants.getTinyPref(this, Constants.PREF_ACTIVITY5_RATE_TEXT) :
                            getString(R.string.dialog_str))
                    .setPositiveButton(R.string.dialog_btn, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            launchMarket();
                        }
                    })
                    .setNegativeButton(android.R.string.no, null)
                    .show()
                    .setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialogInterface) {

                           /* startActivity(new Intent(GameActivity.this, LoadingActivity.class));
                            finish();*/
                            Constants.showInterstitial(GameActivity.this, Constants.getTinyPref(GameActivity.this, Constants.PREF_ACTIVITY5_ADS_NETWORK),
                                    LoadingActivity.class, true);
                        }
                    });

        }

    }

    private void launchMarket() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }

    }
}