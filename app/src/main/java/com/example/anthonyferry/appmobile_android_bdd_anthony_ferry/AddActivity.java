package com.example.anthonyferry.appmobile_android_bdd_anthony_ferry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    private Button btnAddChapter;
    private EditText editTitle, editDescription;

    private ChapitreBDD bdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        GetObjectsId();

        bdd = new ChapitreBDD(this);

        btnAddChapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = editTitle.getText().toString();
                String description = editDescription.getText().toString();

                Chapitre newChapitre = new Chapitre(title, description);


                int resultValue = addChapterToBdd(newChapitre) ? MainActivity.ADD_SUCCESS : 666;

                Intent returnIntent = new Intent();


                setResult(resultValue, returnIntent);
                finish();

            }
        });
    }


    private void GetObjectsId()
    {
        btnAddChapter = (Button) findViewById(R.id.btnAddChapter);
        editTitle = (EditText) findViewById(R.id.editTitle);
        editDescription = (EditText) findViewById(R.id.editDescription);
    }

    private boolean addChapterToBdd(Chapitre chapter)
    {
        boolean res;

        bdd.openForWrite();
        res = (bdd.insertChapter(chapter) > 0);
        bdd.close();

        return res;
    }
}
