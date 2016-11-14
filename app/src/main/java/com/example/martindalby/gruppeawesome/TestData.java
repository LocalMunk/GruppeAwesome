package com.example.martindalby.gruppeawesome;


import junit.framework.Test;

public class TestData {

    //her er data
    private String [] fisk = {"Kage","Snickers"};

    private String [] morgenmad = {"Havregrød", "Omelet", "Cornflakes"};
    private String [] frokost =   {"Rugbrød", "Rugbrød med pålæg", "Chili con carne"};
    private String [] aften =     {"Lasagne", "Pizza", "Durum"};
    private String [] snack =     {"Lasagne", "Pizza", "Durum"};
    private TestData[] aftensmad;
    private TestData[] data;
    private String text;
    private String overskrift;
    private String beskrivelse;
//    private Image opskIcon;

    public  TestData(){

        aftensmad = new TestData[]{
                new TestData("Pizza", "Denne ret smager godt"),
                new TestData("Æggemad", "En lækker aftensmad med æg... og brød"),
                new TestData("Fisk", "Det er godt med fisk"),
                new TestData("Æg", "Lidt af det gode"),
                new TestData("Burger", "kød og kød og kød og kød..."),
                new TestData("Salat", "Jk det er salat... med kød istedet for salat #Prot"),
        };
    }

    public TestData(String overskrift, /*Image opskIcon,*/ String beskrivelse) {
        this.overskrift = overskrift;
 //       this.opskIcon = opskIcon;
        this.beskrivelse = beskrivelse;
    }

    public TestData[] getAftensmad() {
        return aftensmad;
    }

    public String[] getMorgenmad() {
        return morgenmad;
    }

    public String[] getFrokost() {
        return frokost;
    }

    public String[] getAften() {
        return aften;
    }

    public String[] getSnack() {
        return snack;
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
