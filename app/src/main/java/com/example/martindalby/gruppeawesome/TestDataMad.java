package com.example.martindalby.gruppeawesome;


public class TestDataMad {

    //her er data



    private TestDataMad[] aftensmad;
    private TestDataMad[] frokost;
    private TestDataMad[] morgenmad;
    private TestDataMad[] snack;
    private String overskrift;
    private String beskrivelse;
    private String ingredienser;
    private int img;

    public TestDataMad(){

        aftensmad = new TestDataMad[]{
                new TestDataMad("Pizza", "Denne ret smager godt","1 stk. ost \n2 æg \n100g kød \n\n200g prot" ,R.drawable.pizzalistepic),
                new TestDataMad("Æggemad", "En lækker aftensmad med æg... og brød","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.pizzalistepic),
                new TestDataMad("Fisk", "Det er godt med fisk","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.pizzalistepic),
                new TestDataMad("Æg", "Lidt af det gode","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.pizzalistepic),
                new TestDataMad("Burger", "kød og kød og kød og kød...","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.pizzalistepic),
                new TestDataMad("Salat", "Jk det er salat... med kød istedet for salat #Prot","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.pizzalistepic)
        };
        frokost = new TestDataMad[]{
                new TestDataMad("Prot mad", "En god mad med masser af prot","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.pizzalistepic),
                new TestDataMad("Oste mad", "Den gode gamle Ole... på mad","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.pizzalistepic),
                new TestDataMad("Pastaprot", "Pasta med gode prots i!","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.pizzalistepic),
                new TestDataMad("God mad", "Det her er en rigtig god mad, til dig der kan lide mad!","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.pizzalistepic)
        };
        morgenmad = new TestDataMad[]{
                new TestDataMad("Gode gryd", "God skål gryn med masser af prot! og ost","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.morgenmad),
                new TestDataMad("Lækker æg!", "Æg er godt om morgenen! og sundt!","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.morgenmad),
                new TestDataMad("Appelsin juice", "Altid dejlig med en morgen Appelsin juice at starte dagen på!","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.morgenmad),
                new TestDataMad("Sund mad", "Vil du være sund? spis det her","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.morgenmad)
        };
        snack = new TestDataMad[] {
                new TestDataMad("Snickers self", "kan du lide sukker? spis snickers","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.morgenmad),
                new TestDataMad("Gulerod", "Smager ikke så spændende, men er godt","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.morgenmad),
                new TestDataMad("Noger der er sundt?", "Her er en snack","1 stk. ost \n2 æg \n100g kød \n\n200g prot" , R.drawable.morgenmad)
        };

    }

    public TestDataMad(String overskrift, String beskrivelse, String ingredienser, int img) {
        this.overskrift = overskrift;
        this.beskrivelse = beskrivelse;
        this.ingredienser = ingredienser;
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

    public String getIngredienser() {return ingredienser;}

    public int getImg() {return img;}
}
