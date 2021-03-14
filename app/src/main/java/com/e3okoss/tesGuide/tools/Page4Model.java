package com.e3okoss.tesGuide.tools;

public class Page4Model {
    private String NetworkAds;
    private boolean showInterstitial;
    private String backgroundColor;
    private String title;
    private String titleColor;
    private String image;
    private String nextText;
    private String nextColor;
    private String startText;
    private String startColor;

    public Page4Model() {
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public void setNetworkAds(String networkAds) {
        NetworkAds = networkAds;
    }

    public void setNextColor(String nextColor) {
        this.nextColor = nextColor;
    }

    public void setNextText(String nextText) {
        this.nextText = nextText;
    }

    public void setShowInterstitial(boolean showInterstitial) {
        this.showInterstitial = showInterstitial;
    }

    public void setStartColor(String startColor) {
        this.startColor = startColor;
    }

    public void setStartText(String startText) {
        this.startText = startText;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getImage() {
        return image;
    }

    public String getNetworkAds() {
        return NetworkAds;
    }

    public String getNextColor() {
        return nextColor;
    }

    public String getNextText() {
        return nextText;
    }

    public boolean getShowInterstitial() {
        return showInterstitial;
    }

    public String getStartColor() {
        return startColor;
    }

    public String getStartText() {
        return startText;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleColor() {
        return titleColor;
    }
}
