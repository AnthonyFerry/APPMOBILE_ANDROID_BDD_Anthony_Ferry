package com.example.anthonyferry.appmobile_android_bdd_anthony_ferry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RemoveActivity extends AppCompatActivity {

    private Button btnRemoveChapter;
    private EditText editTitle;

    private ChapitreBDD bdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        GetObjectsId();

        bdd = new ChapitreBDD(this);

        btnRemoveChapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = editTitle.getText().toString();

                removeChapterFromBdd(title);

                Intent returnIntent = new Intent();

                setResult(MainActivity.REMOVE_SUCCESS, returnIntent);
                finish();

            }
        });
    }

    private void GetObjectsId()
    {
        btnRemoveChapter = (Button) findViewById(R.id.btnRemoveChapter);
        editTitle = (EditText) findViewById(R.id.editTitleRemove);
    }

    private void removeChapterFromBdd(String title)
    {
        bdd.openForWrite();
        bdd.removeChapter(title);
        bdd.close();
    }
}
