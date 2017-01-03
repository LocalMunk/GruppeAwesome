package com.example.martindalby.gruppeawesome.DataFiles;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class OpskriftData {

    private String navn, ingrediens, fremgangsmåde, imglink;

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

    public OpskriftData(String navn, String ingrediens, String fremgangsmåde, String imglink) {
        this.navn = navn;
        this.ingrediens = ingrediens;
        this.fremgangsmåde = fremgangsmåde;
        this.imglink = imglink;

    }
}
