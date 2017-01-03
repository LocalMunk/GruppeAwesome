package com.example.martindalby.gruppeawesome.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.Ovelse;

/**
 * Created by frederik on 03-01-2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "BodyBook";
    // Table name
    private static final String TABLE_Ovelse = "ovelse";
    // Ovelse Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DONE = "done";
    private static final String KEY_SETS = "sets";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_OVELSE_TABLE = "CREATE TABLE " + TABLE_Ovelse + "(" + KEY_ID +
                " INTERGER PRIMARY KEY, " +KEY_NAME + " TEXT, " + KEY_DONE + " BOOLEAN, " + KEY_SETS
                + " INTERGER, " + ")";
                db.execSQL(CREATE_OVELSE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Ovelse);
        // Creating tables again
        onCreate(db);

    }


    //Addring new Ovelse
    public void addOvelse(OvelseData Ovelse) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, Ovelse.getId());
        values.put(KEY_NAME, Ovelse.getNavn());
        values.put(KEY_DONE, Ovelse.isDone());
        values.put(KEY_SETS, Ovelse.getSets());

    // Inserting Row
        db.insert(TABLE_Ovelse, null, values);
        db.close(); // Closing database connection
    }

    // Getting one shop
    public OvelseData getOvelse(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_Ovelse, new String[] { KEY_ID,
                        KEY_NAME, KEY_DONE, KEY_SETS }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        OvelseData contact = new OvelseData(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getInt(2), cursor.getInt(3));
// return shop
        return contact;
    }
}
