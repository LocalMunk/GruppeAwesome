package com.example.martindalby.gruppeawesome;


public class TestData {

    //her er data



    private TestData[] aftensmad;
    private TestData[] frokost;
    private TestData[] morgenmad;
    private TestData[] snack;
    private TestData[] data;
    private String text;
    private String overskrift;
    private String beskrivelse;
    private int img;

    public  TestData(){

        aftensmad = new TestData[]{
                new TestData("Pizza", "Denne ret smager godt", R.drawable.pizzalistepic),
                new TestData("Æggemad", "En lækker aftensmad med æg... og brød", R.drawable.pizzalistepic),
                new TestData("Fisk", "Det er godt med fisk", R.drawable.pizzalistepic),
                new TestData("Æg", "Lidt af det gode", R.drawable.pizzalistepic),
                new TestData("Burger", "kød og kød og kød og kød...", R.drawable.pizzalistepic),
                new TestData("Salat", "Jk det er salat... med kød istedet for salat #Prot", R.drawable.pizzalistepic),
        };
        frokost = new TestData[]{
                new TestData("Prot mad", "En god mad med masser af prot", R.drawable.pizzalistepic),
                new TestData("Oste mad", "Den gode gamle Ole... på mad", R.drawable.pizzalistepic),
                new TestData("Pastaprot", "Pasta med gode prots i!", R.drawable.pizzalistepic),
                new TestData("God mad", "Det her er en rigtig god mad, til dig der kan lide mad!", R.drawable.pizzalistepic)
        };
        frokost = new TestData[]{
                new TestData("Gode gryd", "God skål gryn med masser af prot! og ost", R.drawable.morgenmad),
                new TestData("Lækker æg!", "Æg er godt om morgenen! og sundt!", R.drawable.pizzalistepic),
                new TestData("Bajer juice", "Altid dejlig med en morgen bajr at starte dagen på!", R.drawable.pizzalistepic),
                new TestData("Sund mad", "Vil du være sund? spis det her", R.drawable.pizzalistepic)
        };
        snack = new TestData[] {
                new TestData("Snickers self", "kan du lide sukker? spis snickers", R.drawable.morgenmad),
                new TestData("Gulerod", "Smager ikke så spændende, men er godt", R.drawable.morgenmad),
                new TestData("Noger der er sundt?", "Her er en snack", R.drawable.morgenmad)
        };

    }

    public TestData(String overskrift, String beskrivelse, int img) {
        this.overskrift = overskrift;
        this.beskrivelse = beskrivelse;
        this.img = img;
    }


    public TestData[] getMorgenmad() {
        return morgenmad;
    }

    public TestData[] getFrokost() {
        return frokost;
    }

    public TestData[] getAftensmad() {
        return aftensmad;
    }

    public TestData[] getSnack() {
        return snack;
    }

    public TestData[] getdata() {return data;}

    public String getOverskrift() {
        return overskrift;
    }

    public void setOverskrift(String overskrift) {
        this.overskrift = overskrift;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getImg() {return img;}
}
