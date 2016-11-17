package com.example.martindalby.gruppeawesome;


public class TestDataMad {

    //her er data



    private TestDataMad[] aftensmad;
    private TestDataMad[] frokost;
    private TestDataMad[] morgenmad;
    private TestDataMad[] snack;
    private String text;
    private String overskrift;
    private String beskrivelse;
    private int img;

    public TestDataMad(){

        aftensmad = new TestDataMad[]{
                new TestDataMad("Pizza", "Denne ret smager godt", R.drawable.pizzalistepic),
                new TestDataMad("Æggemad", "En lækker aftensmad med æg... og brød", R.drawable.pizzalistepic),
                new TestDataMad("Fisk", "Det er godt med fisk", R.drawable.pizzalistepic),
                new TestDataMad("Æg", "Lidt af det gode", R.drawable.pizzalistepic),
                new TestDataMad("Burger", "kød og kød og kød og kød...", R.drawable.pizzalistepic),
                new TestDataMad("Salat", "Jk det er salat... med kød istedet for salat #Prot", R.drawable.pizzalistepic)
        };
        frokost = new TestDataMad[]{
                new TestDataMad("Prot mad", "En god mad med masser af prot", R.drawable.pizzalistepic),
                new TestDataMad("Oste mad", "Den gode gamle Ole... på mad", R.drawable.pizzalistepic),
                new TestDataMad("Pastaprot", "Pasta med gode prots i!", R.drawable.pizzalistepic),
                new TestDataMad("God mad", "Det her er en rigtig god mad, til dig der kan lide mad!", R.drawable.pizzalistepic)
        };
        morgenmad = new TestDataMad[]{
                new TestDataMad("Gode gryd", "God skål gryn med masser af prot! og ost", R.drawable.morgenmad),
                new TestDataMad("Lækker æg!", "Æg er godt om morgenen! og sundt!", R.drawable.morgenmad),
                new TestDataMad("Bajer juice", "Altid dejlig med en morgen bajr at starte dagen på!", R.drawable.morgenmad),
                new TestDataMad("Sund mad", "Vil du være sund? spis det her", R.drawable.morgenmad)
        };
        snack = new TestDataMad[] {
                new TestDataMad("Snickers self", "kan du lide sukker? spis snickers", R.drawable.morgenmad),
                new TestDataMad("Gulerod", "Smager ikke så spændende, men er godt", R.drawable.morgenmad),
                new TestDataMad("Noger der er sundt?", "Her er en snack", R.drawable.morgenmad)
        };

    }

    public TestDataMad(String overskrift, String beskrivelse, int img) {
        this.overskrift = overskrift;
        this.beskrivelse = beskrivelse;
        this.img = img;
    }


    public TestDataMad[] getMorgenmad() {
        return morgenmad;
    }

    public TestDataMad[] getFrokost() {
        return frokost;
    }

    public TestDataMad[] getAftensmad() {
        return aftensmad;
    }

    public TestDataMad[] getSnack() {
        return snack;
    }

    public String getOverskrift() {
        return overskrift;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getImg() {return img;}
}
