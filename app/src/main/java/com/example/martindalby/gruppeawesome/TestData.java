package com.example.martindalby.gruppeawesome;


import android.widget.ImageView;

public class TestData {

    //her er data
    private String overskrift;
    private String beskrivelse;
    private ImageView opskIcon;

    public TestData(String overskrift, ImageView opskIcon, String beskrivelse) {
        this.overskrift = overskrift;
        this.opskIcon = opskIcon;
        this.beskrivelse = beskrivelse;
    }

    public String getOverskrift() {
        return overskrift;
    }

    public void setOverskrift(String overskrift) {
        this.overskrift = overskrift;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public ImageView getOpskIcon() {
        return opskIcon;
    }

    public void setOpskIcon(ImageView opskIcon) {
        this.opskIcon = opskIcon;
    }
}
