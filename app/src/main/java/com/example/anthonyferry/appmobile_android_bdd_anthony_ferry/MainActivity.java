package com.example.anthonyferry.appmobile_android_bdd_anthony_ferry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd, btnRemove, btnSearch;
    private ListView listChapitre;

    private ChapitreBDD bdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetObjectsId();

        bdd = new ChapitreBDD(this);
        bdd.openForWrite();

        Chapitre chapitre1 = new Chapitre("titre 1", "description 1");
        Chapitre chapitre2 = new Chapitre("titre 2", "description 2");
        Chapitre chapitre3 = new Chapitre("titre 3", "description 3");
        Chapitre chapitre4 = new Chapitre("titre 4", "description 4");
        Chapitre chapitre5 = new Chapitre("titre 5", "description 5");

        bdd.insertChapter(chapitre1);
        bdd.insertChapter(chapitre2);
        bdd.insertChapter(chapitre3);
        bdd.insertChapter(chapitre4);
        bdd.insertChapter(chapitre5);

        ArrayList<Chapitre> chapitres = bdd.getAllChapters();

        ArrayAdapter<Chapitre> adapter = new ArrayAdapter<Chapitre>(this, android.R.layout.simple_list_item_1, chapitres);

        listChapitre.setAdapter(adapter);
    }

    private void GetObjectsId()
    {
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnRemove = (Button) findViewById(R.id.btnRemove);
        btnSearch = (Button) findViewById(R.id.btnSearch);

        listChapitre = (ListView) findViewById(R.id.listChapitres);
    }
}
