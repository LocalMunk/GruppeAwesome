package com.example.martindalby.gruppeawesome.DataFiles;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class OpskriftData {

    public String navn, ingrediens, fremgangsmåde, imglink, id;
    public int type;

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getIngrediens() {
        return ingrediens;
    }

    public void setIngrediens(String ingrediens) {
        this.ingrediens = ingrediens;
    }

    public String getFremgangsmåde() {
        return fremgangsmåde;
    }

    public void setFremgangsmåde(String fremgangsmåde) {
        this.fremgangsmåde = fremgangsmåde;
    }

    public String getImglink() {
        return imglink;
    }

    public void setImglink(String imglink) {
        this.imglink = imglink;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public int getType() {return type;}

    public void setType(int type) {this.type = type;}

    public OpskriftData () {

    }

    public OpskriftData(String navn, String ingrediens, String fremgangsmåde, String imglink, String id, int type) {
        this.navn = navn;
        this.ingrediens = ingrediens;
        this.fremgangsmåde = fremgangsmåde;
        this.imglink = imglink;
        this.id = id;
        this.type = type;

    }
}
