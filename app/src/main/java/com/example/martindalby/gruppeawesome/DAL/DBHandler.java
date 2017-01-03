package com.example.martindalby.gruppeawesome.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;
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
    private static final String TABLE_workout ="workout";


    // Ovelse Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DONE = "done";
    private static final String KEY_SETS = "sets";
    //Workout table colum names
    private static final String KEY_WID = "wid";
    private static  final  String Key_Wname = "wname";
    private  static  final  String Key_Excersise1 = "exe1";
    private  static  final  String Key_Excersise2 = "exe2";
    private  static  final  String Key_Excersise3 = "exe3";
    private  static  final  String Key_Excersise4 = "exe4";
    private  static  final  String Key_Excersise5 = "exe5";
    private  static  final  String Key_Excersise6 = "exe6";
    private  static  final  String Key_Excersise7 = "exe7";
    private  static  final  String Key_Excersise8 = "exe8";



    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            // Create ovelse
        String CREATE_OVELSE_TABLE = "CREATE TABLE " + TABLE_Ovelse + "(" + KEY_ID +
                " INTERGER PRIMARY KEY, " +KEY_NAME + " TEXT, " + KEY_DONE + " BOOLEAN, " + KEY_SETS
                + " INTERGER, " + ")";
                db.execSQL(CREATE_OVELSE_TABLE);

        // Create workout
        String CREATE_WORKOUT_TABLE = "CREATE TABLE " + TABLE_workout + "(" + KEY_WID +
                " INTERGER PRIMARY KEY, " +Key_Wname + " TEXT, " + Key_Excersise1 + " INTEGER, " + Key_Excersise2
                + " INTEGER , " + Key_Excersise3 + "INTEGER"+ Key_Excersise4 + "INTEGER"+ Key_Excersise5 + "INTEGER"+Key_Excersise6 + "INTEGER"+Key_Excersise7 + "INTEGER"+Key_Excersise8 + "INTEGER"+ ")";
        db.execSQL(CREATE_WORKOUT_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_workout);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Ovelse);
        // Creating tables again
        onCreate(db);

    }


    //Adds a new Ovelse to the database
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

    // ADDSs a new Workout to the database
    public void addWorkout(WorkoutData workout){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_WID,workout.getWorkoutid());
        values.put(Key_Wname, workout.getWorkoutname());
        values.put(Key_Excersise1, workout.getOvelsesid());
        values.put(Key_Excersise2, workout.getOvelsesid2());
        values.put(Key_Excersise3, workout.getOvelsesid3());
        values.put(Key_Excersise4, workout.getOvelsesid4());
        values.put(Key_Excersise5, workout.getOvelsesid5());
        values.put(Key_Excersise6, workout.getOvelsesid6());
        values.put(Key_Excersise7, workout.getOvelsesid7());
        values.put(Key_Excersise8, workout.getOvelsesid8());

        // Inserting Row
        db.insert(TABLE_workout, null, values);
        db.close(); // Closing database connection



    }

     // Getting one Workout
    public WorkoutData getWorkout(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_workout, new String[] { KEY_WID,
                        Key_Wname, Key_Excersise1,Key_Excersise1,Key_Excersise2,Key_Excersise3,Key_Excersise4,Key_Excersise5,Key_Excersise6,Key_Excersise7,Key_Excersise8 }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        WorkoutData contact = new WorkoutData(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getInt(2), cursor.getInt(3),cursor.getInt(4),cursor.getInt(5),cursor.getInt(6),cursor.getInt(7),cursor.getInt(8),cursor.getInt(9));
// return shop
        return contact;



    }


    // Getting one Ovelse
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
