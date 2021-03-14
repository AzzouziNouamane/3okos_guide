package com.e3okoss.tesGuide.tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public abstract class SynData extends AsyncTask<String, String, String> {

    protected abstract void onDataPreExecute();

    protected abstract void onDataExecute(String result, String status);

    protected abstract void onAdResult();

    protected BufferedReader bufferedReader;

    @SuppressLint("StaticFieldLeak")
    protected Context context;
    protected String urlLink;

    protected HttpURLConnection connection;
    protected URL url = null;

    protected String status;

    TinyDB tinyDB;

    public SynData(Context context, String url) {
        this.context = context;
        this.urlLink = url;
        this.tinyDB = new TinyDB(context);
    }

    @Override
    protected String doInBackground(String... strings) {
        return buildConnection();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        onDataPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        getDataAd(s);
        onAdResult();
        onDataExecute(s, status);
    }


    protected String getDataAd(String result) {
        try {
            JSONObject urlObject = new JSONObject(result);
            JSONObject jsObj = urlObject.getJSONObject(Constants.JSON_DATA);

            JSONObject info = jsObj.getJSONObject(Constants.JSON_GENERAL_DATA);

            JSONArray admobBannerArray = info.getJSONArray(Constants.JsObjectAdBanner);
            JSONArray admobInterArray = info.getJSONArray(Constants.JsObjectAdInterstitial);
            JSONArray admobNativeArray = info.getJSONArray(Constants.JsObjectAdNative);

            tinyDB.putString(Constants.PREF_ADMOB_ID, info.getString(Constants.JsObjectAdID));

            tinyDB.putString(Constants.PREF_ADMOB_BANNER, admobBannerArray.getString( new Random().nextInt(admobBannerArray.length())));
            tinyDB.putString(Constants.PREF_ADMOB_INTERSTITIAL, admobInterArray.getString( new Random().nextInt(admobInterArray.length())));
            tinyDB.putString(Constants.PREF_ADMOB_NATIVE, admobNativeArray.getString( new Random().nextInt(admobNativeArray.length())));

            tinyDB.putString(Constants.PREF_FACEBOOK_BANNER, info.getString(Constants.JsObjectFbBanner));
            tinyDB.putString(Constants.PREF_FACEBOOK_INTERSTITIAL, info.getString(Constants.JsObjectFbInterstitial));
            tinyDB.putString(Constants.PREF_FACEBOOK_NATIVE, info.getString(Constants.JsObjectFbNative));
            tinyDB.putBoolean(Constants.PREF_CPA_ON, info.getBoolean(Constants.JsObjectImageBanner));
            tinyDB.putString(Constants.PREF_CPA_IMAGE, info.getString(Constants.JsObjectImageBannerImg));
            tinyDB.putString(Constants.PREF_CPA_URL, info.getString(Constants.JsObjectImageBannerURl));


            tinyDB.putString(Constants.PrefShareText, info.getString(Constants.JsObjectShareText));
            tinyDB.putString(Constants.PrefRateText, info.getString(Constants.JsObjectRateText));
            tinyDB.putString(Constants.PrefMoreText, info.getString(Constants.JsObjectMoreText));


            JSONObject activity1Info = jsObj.getJSONObject(Constants.JSON_ACTIVITY1);
            tinyDB.putString(Constants.PREF_ACTIVITY1_BACKGROUND_COLOR, activity1Info.getString(Constants.JSON_ACTIVITY1_BACKGROUND_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY1_TITLE, activity1Info.getString(Constants.JSON_ACTIVITY1_TITLE));
            tinyDB.putString(Constants.PREF_ACTIVITY1_TITLE_COLOR, activity1Info.getString(Constants.JSON_ACTIVITY1_TITLE_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY1_IMAGE, activity1Info.getString(Constants.JSON_ACTIVITY1_IMAGE));
            tinyDB.putString(Constants.PREF_ACTIVITY1_TEXT, activity1Info.getString(Constants.JSON_ACTIVITY1_TEXT));
            tinyDB.putString(Constants.PREF_ACTIVITY1_TEXT_COLOR, activity1Info.getString(Constants.JSON_ACTIVITY1_TEXT_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY1_BUTTON_TEXT, activity1Info.getString(Constants.JSON_ACTIVITY1_BUTTON_TEXT));
            tinyDB.putString(Constants.PREF_ACTIVITY1_BUTTON_BACKGROUND_COLOR, activity1Info.getString(Constants.JSON_ACTIVITY1_BUTTON_BACKGROUND_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY1_BUTTON_TEXT_COLOR, activity1Info.getString(Constants.JSON_ACTIVITY1_BUTTON_TEXT_COLOR));
            tinyDB.putInt(Constants.PREF_ACTIVITY1_BUTTON_RADIUS_TOP_LEFT, activity1Info.getInt(Constants.JSON_ACTIVITY1_BUTTON_RADIUS_TOP_LEFT));
            tinyDB.putInt(Constants.PREF_ACTIVITY1_BUTTON_RADIUS_TOP_RIGHT, activity1Info.getInt(Constants.JSON_ACTIVITY1_BUTTON_RADIUS_TOP_RIGHT));
            tinyDB.putInt(Constants.PREF_ACTIVITY1_BUTTON_RADIUS_BOTTOM_LEFT, activity1Info.getInt(Constants.JSON_ACTIVITY1_BUTTON_RADIUS_BOTTOM_LEFT));
            tinyDB.putInt(Constants.PREF_ACTIVITY1_BUTTON_RADIUS_BOTTOM_RIGHT, activity1Info.getInt(Constants.JSON_ACTIVITY1_BUTTON_RADIUS_BOTTOM_RIGHT));
            tinyDB.putString(Constants.PREF_ACTIVITY1_BUTTON_STROKE, activity1Info.getString(Constants.JSON_ACTIVITY1_BUTTON_STROKE));


            JSONObject activity2Info = jsObj.getJSONObject(Constants.JSON_ACTIVITY2);
            tinyDB.putString(Constants.PREF_ACTIVITY2_BACKGROUND_COLOR, activity2Info.getString(Constants.JSON_ACTIVITY2_BACKGROUND_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY2_TITLE, activity2Info.getString(Constants.JSON_ACTIVITY2_TITLE));
            tinyDB.putString(Constants.PREF_ACTIVITY2_TITLE_COLOR, activity2Info.getString(Constants.JSON_ACTIVITY2_TITLE_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY2_IMAGE, activity2Info.getString(Constants.JSON_ACTIVITY2_IMAGE));
            tinyDB.putString(Constants.PREF_ACTIVITY2_TEXT, activity2Info.getString(Constants.JSON_ACTIVITY2_TEXT));
            tinyDB.putString(Constants.PREF_ACTIVITY2_TEXT_COLOR, activity2Info.getString(Constants.JSON_ACTIVITY2_TEXT_COLOR));
            tinyDB.putInt(Constants.PREF_ACTIVITY2_TIMER, activity2Info.getInt(Constants.JSON_ACTIVITY2_TIMER));
            tinyDB.putString(Constants.PREF_ACTIVITY2_PERCENTAGE_COLOR, activity2Info.getString(Constants.JSON_ACTIVITY2_PERCENTAGE_COLOR));

            JSONObject activity3Info = jsObj.getJSONObject(Constants.JSON_ACTIVITY3);
            tinyDB.putString(Constants.PREF_ACTIVITY3_BACKGROUND_COLOR, activity3Info.getString(Constants.JSON_ACTIVITY3_BACKGROUND_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY3_TITLE, activity3Info.getString(Constants.JSON_ACTIVITY3_TITLE));
            tinyDB.putString(Constants.PREF_ACTIVITY3_TITLE_COLOR, activity3Info.getString(Constants.JSON_ACTIVITY3_TITLE_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY3_IMAGE, activity3Info.getString(Constants.JSON_ACTIVITY3_IMAGE));
            tinyDB.putString(Constants.PREF_ACTIVITY3_TEXT1, activity3Info.getString(Constants.JSON_ACTIVITY3_TEXT1));
            tinyDB.putString(Constants.PREF_ACTIVITY3_TEXT1_COLOR, activity3Info.getString(Constants.JSON_ACTIVITY3_TEXT1_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY3_TEXT2, activity3Info.getString(Constants.JSON_ACTIVITY3_TEXT2));
            tinyDB.putString(Constants.PREF_ACTIVITY3_TEXT2_COLOR, activity3Info.getString(Constants.JSON_ACTIVITY3_TEXT2_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY3_START_BUTTON_BACKGROUND, activity3Info.getString(Constants.JSON_ACTIVITY3_START_BUTTON_BACKGROUND));
            tinyDB.putString(Constants.PREF_ACTIVITY3_SHARE_BUTTON_BACKGROUND, activity3Info.getString(Constants.JSON_ACTIVITY3_SHARE_BUTTON_BACKGROUND));
            tinyDB.putString(Constants.PREF_ACTIVITY3_RATE_BUTTON_BACKGROUND, activity3Info.getString(Constants.JSON_ACTIVITY3_RATE_BUTTON_BACKGROUND));
            tinyDB.putString(Constants.PREF_ACTIVITY3_MORE_BUTTON_BACKGROUND, activity3Info.getString(Constants.JSON_ACTIVITY3_MORE_BUTTON_BACKGROUND));


            JSONArray activity4Info = jsObj.getJSONArray(Constants.JSON_ACTIVITY4);
            tinyDB.putInt(Constants.JSON_TOTAL_ITEMS, activity4Info.length());
            ArrayList<Page4Model> page4Models = new ArrayList<>();

            for(int i = 0; i < activity4Info.length(); i++) {
                JSONObject jsonObject = activity4Info.getJSONObject(i);
                Page4Model page4Model = new Page4Model();
                page4Model.setNetworkAds(jsonObject.getString(Constants.JSON_ACTIVITY4_ADS_NETWORK));
                page4Model.setShowInterstitial(jsonObject.getBoolean(Constants.JSON_ACTIVITY4_SHOW_INTERSTITIAL));
                page4Model.setBackgroundColor(jsonObject.getString(Constants.JSON_ACTIVITY4_BACKGROUND_COLOR));
                page4Model.setTitle(jsonObject.getString(Constants.JSON_ACTIVITY4_TITLE));
                page4Model.setTitleColor(jsonObject.getString(Constants.JSON_ACTIVITY4_TITLE_COLOR));
                page4Model.setImage(jsonObject.getString(Constants.JSON_ACTIVITY4_IMAGE));
                page4Model.setNextText(jsonObject.getString(Constants.JSON_ACTIVITY4_NEXT_TEXT));
                page4Model.setNextColor(jsonObject.getString(Constants.JSON_ACTIVITY4_NEXT_COLOR));
                page4Model.setStartText(jsonObject.getString(Constants.JSON_ACTIVITY4_START_TEXT));
                page4Model.setStartColor(jsonObject.getString(Constants.JSON_ACTIVITY4_START_COLOR));

                page4Models.add(page4Model);
            }

            tinyDB.putListObject(Constants.JSON_LIST, page4Models);

            JSONObject activity5Info = jsObj.getJSONObject(Constants.JSON_ACTIVITY5);
            tinyDB.putString(Constants.PREF_ACTIVITY5_BACKGROUND_COLOR, activity5Info.getString(Constants.JSON_ACTIVITY5_BACKGROUND_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY5_TITLE, activity5Info.getString(Constants.JSON_ACTIVITY5_TITLE));
            tinyDB.putString(Constants.PREF_ACTIVITY5_TITLE_COLOR, activity5Info.getString(Constants.JSON_ACTIVITY5_TITLE_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY5_IMAGE, activity5Info.getString(Constants.JSON_ACTIVITY5_IMAGE));
            tinyDB.putString(Constants.PREF_ACTIVITY5_BUTTON_MAIN_BACKGROUND, activity5Info.getString(Constants.JSON_ACTIVITY5_BUTTON_MAIN_BACKGROUND));
            tinyDB.putString(Constants.PREF_ACTIVITY5_BUTTON1_IMG, activity5Info.getString(Constants.JSON_ACTIVITY5_BUTTON1_IMG));
            tinyDB.putString(Constants.PREF_ACTIVITY5_BUTTON2_IMG, activity5Info.getString(Constants.JSON_ACTIVITY5_BUTTON2_IMG));
            tinyDB.putString(Constants.PREF_ACTIVITY5_BUTTON3_IMG, activity5Info.getString(Constants.JSON_ACTIVITY5_BUTTON3_IMG));
            tinyDB.putBoolean(Constants.PREF_ACTIVITY5_SHOW_RATE, activity5Info.getBoolean(Constants.JSON_ACTIVITY5_SHOW_RATE));
            tinyDB.putString(Constants.PREF_ACTIVITY5_RATE_TEXT, activity5Info.getString(Constants.JSON_ACTIVITY5_RATE_TEXT));


            JSONObject activity6Info = jsObj.getJSONObject(Constants.JSON_ACTIVITY6);
            tinyDB.putString(Constants.PREF_ACTIVITY6_BACKGROUND_COLOR, activity6Info.getString(Constants.JSON_ACTIVITY6_BACKGROUND_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY6_TITLE, activity6Info.getString(Constants.JSON_ACTIVITY6_TITLE));
            tinyDB.putString(Constants.PREF_ACTIVITY6_TITLE_COLOR, activity6Info.getString(Constants.JSON_ACTIVITY6_TITLE_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY6_IMAGE, activity6Info.getString(Constants.JSON_ACTIVITY6_IMAGE));
            tinyDB.putString(Constants.PREF_ACTIVITY6_TEXT, activity6Info.getString(Constants.JSON_ACTIVITY6_TEXT));
            tinyDB.putString(Constants.PREF_ACTIVITY6_TEXT_COLOR, activity6Info.getString(Constants.JSON_ACTIVITY6_TEXT_COLOR));
            tinyDB.putInt(Constants.PREF_ACTIVITY6_TIMER, activity6Info.getInt(Constants.JSON_ACTIVITY6_TIMER));
            tinyDB.putString(Constants.PREF_ACTIVITY6_PERCENTAGE_COLOR, activity6Info.getString(Constants.JSON_ACTIVITY6_PERCENTAGE_COLOR));


            JSONObject activity7Info = jsObj.getJSONObject(Constants.JSON_ACTIVITY7);
            tinyDB.putString(Constants.PREF_ACTIVITY7_BACKGROUND_COLOR, activity7Info.getString(Constants.JSON_ACTIVITY7_BACKGROUND_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY7_TITLE, activity7Info.getString(Constants.JSON_ACTIVITY7_TITLE));
            tinyDB.putString(Constants.PREF_ACTIVITY7_TITLE_COLOR, activity7Info.getString(Constants.JSON_ACTIVITY7_TITLE_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY7_IMAGE, activity7Info.getString(Constants.JSON_ACTIVITY7_IMAGE));
            tinyDB.putString(Constants.PREF_ACTIVITY7_BOX_COLOR, activity7Info.getString(Constants.JSON_ACTIVITY7_BOX_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY7_BOX_BORDER_COLOR, activity7Info.getString(Constants.JSON_ACTIVITY7_BOX_BORDER_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY7_BOX_TEXT, activity7Info.getString(Constants.JSON_ACTIVITY7_BOX_TEXT));
            tinyDB.putString(Constants.PREF_ACTIVITY7_BOX_TEXT_COLOR, activity7Info.getString(Constants.JSON_ACTIVITY7_BOX_TEXT_COLOR));
            tinyDB.putString(Constants.PREF_ACTIVITY7_BOX_BUTTON_BACKGROUND, activity7Info.getString(Constants.JSON_ACTIVITY7_BOX_BUTTON_BACKGROUND));
            tinyDB.putString(Constants.PREF_ACTIVITY7_BOX_BUTTON_TEXT, activity7Info.getString(Constants.JSON_ACTIVITY7_BOX_BUTTON_TEXT));
            tinyDB.putString(Constants.PREF_ACTIVITY7_BOX_BUTTON_TEXT_COLOR, activity7Info.getString(Constants.JSON_ACTIVITY7_BOX_BUTTON_TEXT_COLOR));


            tinyDB.putString(Constants.PREF_ACTIVITY1_ADS_NETWORK, activity1Info.getString(Constants.JSON_ACTIVITY1_ADS_NETWORK));
            tinyDB.putString(Constants.PREF_ACTIVITY2_ADS_NETWORK, activity2Info.getString(Constants.JSON_ACTIVITY2_ADS_NETWORK));
            tinyDB.putString(Constants.PREF_ACTIVITY3_ADS_NETWORK, activity3Info.getString(Constants.JSON_ACTIVITY3_ADS_NETWORK));
            tinyDB.putString(Constants.PREF_ACTIVITY5_ADS_NETWORK, activity5Info.getString(Constants.JSON_ACTIVITY5_ADS_NETWORK));
            tinyDB.putString(Constants.PREF_ACTIVITY6_ADS_NETWORK, activity6Info.getString(Constants.JSON_ACTIVITY6_ADS_NETWORK));
            tinyDB.putString(Constants.PREF_ACTIVITY7_ADS_NETWORK, activity7Info.getString(Constants.JSON_ACTIVITY7_ADS_NETWORK));


            status = Constants.Tags.DONE;

        } catch (JSONException e) {
            e.printStackTrace();
            status = Constants.Tags.FAILED;
            return Constants.Tags.FAILED;
        }
        return Constants.Tags.DONE;


    }


    protected String buildConnection() {

        if (Constants.checkConnection(context)) {
            try {
                url = new URL(urlLink);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return Constants.Tags.FAILED;
            }

            try {

                connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(15000);
                connection.setConnectTimeout(10000);
                connection.setRequestMethod("GET");

            } catch (IOException e1) {
                e1.printStackTrace();
                return Constants.Tags.FAILED;
            }

            try {

                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {

                    InputStream inputStream = connection.getInputStream();
                    return buffToString(new InputStreamReader(inputStream));

                }
            } catch (IOException e2) {
                return Constants.Tags.FAILED;
            } finally {
                connection.disconnect();
            }

        }
        return Constants.Tags.DONE;
    }

    protected String buffToString(Reader ourReader) {
        try {
            bufferedReader = new BufferedReader(ourReader);
            StringBuilder result = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            return (result.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }


}
