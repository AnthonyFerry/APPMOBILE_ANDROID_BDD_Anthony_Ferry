package com.example.anthonyferry.appmobile_android_bdd_anthony_ferry;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anthony FERRY on 15/03/2017.
 */

public class ChapitreBaseSQLite extends SQLiteOpenHelper {

    public static final String nom_Table;
    public static final String Ma_Colonne_Id;
    public static final String Ma_Colonne_Nom;
    public static final String Ma_Colonne_Description;

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
