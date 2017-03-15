package com.example.anthonyferry.appmobile_android_bdd_anthony_ferry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd, btnRemove, btnSearch;
    private ListView listChapitre;

    public static final int ADD_SUCCESS = 0;
    public static final int REMOVE_SUCCESS = 1;

    private ChapitreBDD bdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetObjectsId();

        bdd = new ChapitreBDD(this);

        displayChapterList();

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, ADD_SUCCESS);
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, RemoveActivity.class);
                startActivityForResult(intent, REMOVE_SUCCESS);
            }
        });
    }

    private void GetObjectsId()
    {
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnRemove = (Button) findViewById(R.id.btnRemove);
        btnSearch = (Button) findViewById(R.id.btnSearch);

        listChapitre = (ListView) findViewById(R.id.listChapitres);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == ADD_SUCCESS) {
            Toast.makeText(this, "Chapitre ajouté avec succes", Toast.LENGTH_SHORT).show();
            displayChapterList();
        }else if (requestCode == REMOVE_SUCCESS) {
            Toast.makeText(this, "Le chapitre a été supprimé", Toast.LENGTH_SHORT).show();
            displayChapterList();
        }
    }

    private void displayChapterList(){

        bdd.openForRead();
        ArrayList<Chapitre> chapitres = bdd.getAllChapters();

        if (chapitres != null)
        {
            ArrayAdapter<Chapitre> adapter = new ArrayAdapter<Chapitre>(this, android.R.layout.simple_list_item_1, chapitres);
            listChapitre.setAdapter(adapter);
        }
    }
}
