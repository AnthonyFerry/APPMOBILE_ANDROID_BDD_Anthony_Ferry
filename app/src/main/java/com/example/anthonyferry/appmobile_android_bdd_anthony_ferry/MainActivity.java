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
