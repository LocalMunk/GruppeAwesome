package com.example.martindalby.gruppeawesome;


public class TestData {

    //her er data


    private String [] morgenmad = {"Havregrød", "Omelet", "Cornflakes"};
    private String [] frokost =   {"Rugbrød", "Rugbrød med pålæg", "Chili con carne"};
    private String [] aften =     {"Lasagne", "Pizza", "Durum"};
    private String [] snack =     {"Snickers", "Gulerod", "sand"};
    private TestDataWorkout[] aftensmad;
    private TestDataWorkout[] data;
    private String text;
    private String overskrift;
    private String beskrivelse;
//    private Image opskIcon;

    public  TestData(){

        aftensmad = new TestDataWorkout[]{
                new TestDataWorkout("Pizza", "Denne ret smager godt"),
                new TestDataWorkout("Æggemad", "En lækker aftensmad med æg... og brød"),
                new TestDataWorkout("Fisk", "Det er godt med fisk"),
                new TestDataWorkout("Æg", "Lidt af det gode"),
                new TestDataWorkout("Burger", "kød og kød og kød og kød..."),
                new TestDataWorkout("Salat", "Jk det er salat... med kød istedet for salat #Prot"),
        };
    }

    public TestData(String overskrift, /*Image opskIcon,*/ String beskrivelse) {
        this.overskrift = overskrift;
 //       this.opskIcon = opskIcon;
        this.beskrivelse = beskrivelse;
    }

    public TestDataWorkout[] getAftensmad() {
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

    public TestDataWorkout[] getdata() {
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
