package com.example.martindalby.gruppeawesome.DataFiles;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class OvelseData {

    public String navn;
    public int done;
    public Graf graf;
    public int sets, id;

    public OvelseData(int id, String navn, int done, int sets) {
        this.navn = navn;
        this.done = done;
        this.sets = sets;
        this.id = id;
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
