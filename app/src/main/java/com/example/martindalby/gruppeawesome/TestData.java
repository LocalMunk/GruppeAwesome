package com.example.martindalby.gruppeawesome;


import android.media.Image;
import android.widget.ImageView;

public class TestData {

    //her er data
    private TestData [] data;
    private  int imgRescourceId;
    private String text;
    private String overskrift;
    private String beskrivelse;

private int[] i ={R.drawable.pizzalistepic,R.drawable.grafbb};

    public  TestData(){
        data = new TestData[]{
                new TestData("Pizza", "Denne ret smager godt",R.drawable.pizzalistepic),
                new TestData("Æggemad", "En lækker mad med æd... og brød",R.drawable.pizzalistepic),
                new TestData("Fisk", "Det er godt med fisk",R.drawable.pizzalistepic),
                new TestData("Æg", "Lidt af det gode",R.drawable.pizzalistepic),
                new TestData("Burger", "kød og kød og kød og kød...",R.drawable.pizzalistepic),
                new TestData("Salat", "Jk det er salat... med kød istedet for salat #Prot",R.drawable.pizzalistepic),
        };

    }

    public TestData(String overskrift, String beskrivelse, int i) {
        this.overskrift = overskrift;
 //       this.opskIcon = opskIcon;
        this.beskrivelse = beskrivelse;
    }

    public TestData[] getdata() {
        return data;
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
