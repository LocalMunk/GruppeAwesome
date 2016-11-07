package com.example.martindalby.gruppeawesome;


import android.media.Image;
import android.widget.ImageView;

public class TestData {

    //her er data
    private String overskrift;
    private String beskrivelse;
//    private Image opskIcon;

    public TestData(String overskrift, /*Image opskIcon,*/ String beskrivelse) {
        this.overskrift = overskrift;
 //       this.opskIcon = opskIcon;
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
}
