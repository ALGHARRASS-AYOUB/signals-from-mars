package com.example.signalsfrommars.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.signalsfrommars.R;

public class MainActivity extends AppCompatActivity {
        EditText name_edit_text;
        Button start_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name_edit_text=findViewById(R.id.NameEditText);
        start_button=findViewById(R.id.startButton  );

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=name_edit_text.getText().toString();
                startStory(name);
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        name_edit_text.setText("");
    }

    private void startStory(String name) {
        Intent intent=new Intent(getApplicationContext(),StoryAcitivity.class);
        Resources resources=getResources();
        String key=resources.getString(R.string.key_name);
        intent.putExtra(key,name);
        startActivity(intent);
    }
}