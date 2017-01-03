package com.example.martindalby.gruppeawesome.DataFiles;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class OvelseData {

    private String navn;
    private boolean done;
    private Graf graf;
    private int sets, id;

    public OvelseData(String navn, boolean done, Graf graf, int sets, int id) {
        this.navn = navn;
        this.done = done;
        this.graf = graf;
        this.sets = sets;
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Graf getGraf() {
        return graf;
    }

    public void setGraf(Graf graf) {
        this.graf = graf;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
