package com.e3okoss.tesGuide;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.e3okoss.tesGuide.tools.Constants;
import com.e3okoss.tesGuide.tools.Page4Model;
import com.e3okoss.tesGuide.tools.TinyDB;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SliderActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Button button;
    private SliderPagerAdapter adapter;
    boolean lastPage = false;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tinyDB = new TinyDB(this);

        // making activity full screen
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView()
                    .setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_pager);
        // hide action bar you can use NoAction theme as well
        // bind views
        viewPager = findViewById(R.id.pagerIntroSlider);
        TabLayout tabLayout = findViewById(R.id.tabs);
        button = findViewById(R.id.button);

        // init slider pager adapter
        adapter = new SliderPagerAdapter(this, getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        // set adapter
        viewPager.setAdapter(adapter);

        // set dot indicators
        tabLayout.setupWithViewPager(viewPager);

        // make status bar transparent
        changeStatusBarColor();

        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {



                if (lastPage) {
                    startActivity(new Intent(SliderActivity.this, GameActivity.class));
                }

                if (viewPager.getCurrentItem() < adapter.getCount()) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }

            }
        });

        /**
         * Add a listener that will be invoked whenever the page changes
         * or is incrementally scrolled
         */
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override public void onPageSelected(int position) {
                ArrayList<Page4Model> page4Models = tinyDB.getListObject(Constants.JSON_LIST);

                if(page4Models.get(position).getShowInterstitial()) {
                    Constants.showInterstitial(SliderActivity.this, page4Models.get(position).getNetworkAds(),
                            null, false);
                }
                if (position == adapter.getCount() - 1) {
                    lastPage = true;
                    button.setText(R.string.get_started);
                } else {
                    lastPage = false;
                    button.setText((!page4Models.get(position).getNextText().isEmpty()) ? page4Models.get(position).getNextText() : getString(R.string.next));
                    if(!page4Models.get(position).getNextColor().isEmpty()) {
                        button.setTextColor(Color.parseColor(page4Models.get(position).getNextColor()));
                    }
                }
            }

            @Override public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
