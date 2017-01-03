package com.example.martindalby.gruppeawesome.DataFiles;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class OvelseData {

    private String navn;
    private int done;
    private Graf graf;
    private int sets, id;

    public OvelseData(int id, String navn, int done, int sets) {
        this.navn = navn;
        this.done = done;
        this.sets = sets;
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int isDone() {
        return done;
    }

    public void setDone(int done) {
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
