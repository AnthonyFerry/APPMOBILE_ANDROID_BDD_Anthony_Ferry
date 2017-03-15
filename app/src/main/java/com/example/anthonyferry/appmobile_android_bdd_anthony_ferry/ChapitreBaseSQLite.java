package com.example.anthonyferry.appmobile_android_bdd_anthony_ferry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anthony FERRY on 15/03/2017.
 */

public class ChapitreBaseSQLite extends SQLiteOpenHelper {

    public static final String nom_Table = "CHAPITRE";
    public static final String Ma_Colonne_Id = "ID";
    public static final String Ma_Colonne_Nom = "NOM";
    public static final String Ma_Colonne_Description = "DESCRIPTION";

    public static final String CREATE_BDD = "CREATE TABLE " + nom_Table + "(" + Ma_Colonne_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Ma_Colonne_Nom + " VARCHAR(32) NOT NULL, " + Ma_Colonne_Description + " TEXT NOT NULL);";

    public ChapitreBaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super (context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + nom_Table);
        onCreate(db);
    }
}
