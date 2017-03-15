package com.example.anthonyferry.appmobile_android_bdd_anthony_ferry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Anthony FERRY on 15/03/2017.
 */

public class ChapitreBDD {

    public static final int VERSION = 1;
    public static final String NOM_BDD = "chapitre.db";
    public static final String NOM_TABLE = ChapitreBaseSQLite.nom_Table;
    public static final String COL_ID = "ID";
    public static final int NUM_COL_ID = 0;
    public static final String COL_NOM = "NOM";
    public static final int NUM_COL_NOM = 1;
    public static final String COL_DESC = "DESCRIPTION";
    public static final int NUM_COL_DESC = 2;

    private SQLiteDatabase bdd;
    private ChapitreBaseSQLite chapitres;

    public ChapitreBDD(Context context)
    {
        chapitres = new ChapitreBaseSQLite(context, NOM_BDD, null, VERSION);
    }

    public void openForWrite(){
        bdd = chapitres.getWritableDatabase();
    }

    public void openForRead(){
        bdd = chapitres.getReadableDatabase();
    }

    public void close(){
        bdd.close();
    }

    public SQLiteDatabase getBdd() {
        return bdd;
    }

    public long insertChapter(Chapitre chapitre) {
        ContentValues content = new ContentValues();
        content.put(COL_NOM, chapitre.getNom());
        content.put(COL_DESC, chapitre.getDescription());
        return bdd.insert(NOM_TABLE, null, content);
    }

    public int updateChapter(int id, Chapitre chapitre) {
        ContentValues content = new ContentValues();
        content.put(COL_NOM, chapitre.getNom());
        content.put(COL_DESC, chapitre.getDescription());
        return bdd.update(NOM_TABLE, content, COL_ID + " = " + id, null);
    }

    public int removeChapter(String name) {
        return bdd.delete(NOM_TABLE, COL_NOM + " = " + name, null);
    }

    public Chapitre getChapter(String name) {
        Cursor c = bdd.query(NOM_TABLE, new String[] {COL_ID, COL_NOM, COL_DESC}, COL_NOM + " LIKE \"" + name + "\"", null, null, null, COL_NOM);
        return cursorToChapter(c);
    }

    public Chapitre cursorToChapter(Cursor c)
    {
        if (c.getCount() == 0)
        {
            c.close();
            return null;
        }

        Chapitre chapter = new Chapitre();
        chapter.setId(c.getInt(NUM_COL_ID));
        chapter.setNom(c.getString(NUM_COL_NOM));
        chapter.setDescription(c.getString(NUM_COL_DESC));
        c.close();
        return chapter;
    }

    public ArrayList<Chapitre> getAllChapters() {

        Cursor c = bdd.query(NOM_TABLE, new String[]{ COL_ID, COL_NOM, COL_DESC }, null, null, null, null, COL_NOM);
        if (c.getCount() == 0)
        {
            c.close();
            return null;
        }

        ArrayList<Chapitre> chapterList = new ArrayList<Chapitre>();
        while (c.moveToNext())
        {
            Chapitre chapter = new Chapitre();
            chapter.setId(c.getInt(NUM_COL_ID));
            chapter.setNom(c.getString(NUM_COL_NOM));
            chapter.setDescription(c.getString(NUM_COL_DESC));
            chapterList.add(chapter);
        }

        c.close();
        return chapterList;
    }
}
