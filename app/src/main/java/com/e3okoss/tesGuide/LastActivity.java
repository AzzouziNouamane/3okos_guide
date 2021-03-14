package com.e3okoss.tesGuide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.e3okoss.tesGuide.tools.Constants;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;

public class LastActivity extends AppCompatActivity {

    RelativeLayout mainLayout;
    TextView titleTV, textTV ;
    RelativeLayout linearL;
    ImageView mainLogo;
    Button okBtn;
    RelativeLayout adsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        linearL = findViewById(R.id.linearL);
        okBtn = findViewById(R.id.okBtn);
        mainLayout = findViewById(R.id.mainLayout);
        textTV = findViewById(R.id.textTV);
        mainLogo = findViewById(R.id.main_logo);
        titleTV = findViewById(R.id.titleTV);

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY7_BACKGROUND_COLOR)) {
            mainLayout.setBackgroundColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY7_BACKGROUND_COLOR)));
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY7_TITLE)) {
            titleTV.setText(Constants.getTinyPref(this, Constants.PREF_ACTIVITY7_TITLE));
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY7_TITLE_COLOR)) {
            titleTV.setTextColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY7_TITLE_COLOR)));
        }

        if (!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY7_IMAGE)) {
            Picasso.get().load(Constants.getTinyPref(this, Constants.PREF_ACTIVITY7_IMAGE)).into(mainLogo);
        } else {
            Picasso.get().load(R.drawable.main_img).into(mainLogo);
        }


        int layoutBg = !Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY7_BOX_COLOR) ? Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY7_BOX_COLOR))
                : ContextCompat.getColor(this, R.color.blue);

        int layoutStork = !Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY7_BOX_BORDER_COLOR) ? Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY7_BOX_BORDER_COLOR))
                : ContextCompat.getColor(this, R.color.white);

        Constants.customView(linearL, layoutBg, layoutStork, 10,10,10,10);

        if(!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY7_BOX_TEXT)) {
            textTV.setText(Constants.getTinyPref(this, Constants.PREF_ACTIVITY7_BOX_TEXT));
        }

        if(!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY7_BOX_TEXT_COLOR)) {
            textTV.setTextColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY7_BOX_TEXT_COLOR)));
        }


        int buttonBg = !Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY7_BOX_COLOR) ? Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY7_BOX_COLOR))
                : ContextCompat.getColor(this, R.color.activity_bg);

        Constants.customView(okBtn, buttonBg,
                ContextCompat.getColor(this, R.color.white), 20, 20, 20, 20);


        if(!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY7_BOX_BUTTON_TEXT)) {
            okBtn.setText(Constants.getTinyPref(this, Constants.PREF_ACTIVITY7_BOX_BUTTON_TEXT));
        }

        if(!Constants.isPrefEmpty(this, Constants.PREF_ACTIVITY7_BOX_BUTTON_TEXT_COLOR)) {
            okBtn.setTextColor(Color.parseColor(Constants.getTinyPref(this, Constants.PREF_ACTIVITY7_BOX_BUTTON_TEXT_COLOR)));
        }

        adsLayout = findViewById(R.id.adsLayout);
        if(Constants.getTinyBoolPref(this, Constants.PREF_CPA_ON)) {
            Constants.setCustomBanner(this, adsLayout, Constants.PREF_CPA_IMAGE, Constants.PREF_CPA_URL);
        }
        else {
            if (Constants.getTinyPref(this, Constants.PREF_ACTIVITY7_ADS_NETWORK).equalsIgnoreCase("admob")) {
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

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}