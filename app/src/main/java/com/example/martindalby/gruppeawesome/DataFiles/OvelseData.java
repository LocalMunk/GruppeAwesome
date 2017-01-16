package com.example.martindalby.gruppeawesome.DataFiles;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class OvelseData {

    public String navn;
    public int done;
    public GrafData graf;
    public int sets, id;

    public OvelseData(int id, String navn, int done, int sets) {
        this.navn = navn;
        this.done = done;
        this.sets = sets;
        this.id = id;
    }

    public int getDone() {
        return done;
    }

    public OvelseData(){


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

    public GrafData getGraf() {
        return graf;
    }

    public void setGraf(GrafData graf) {
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

    @Override
    public String toString() {
        return "done: " + done;

    }
}
