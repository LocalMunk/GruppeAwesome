package com.example.martindalby.gruppeawesome.DAL;

import android.content.Context;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class DatabaseController {

    private DBHandler DBH;

    public DatabaseController() {
    }

    public void createDBHAndler (Context con) {
        DBHandler DBH = new DBHandler(con);
    }

    public DBHandler getDBH() {
        return DBH;
    }

}
