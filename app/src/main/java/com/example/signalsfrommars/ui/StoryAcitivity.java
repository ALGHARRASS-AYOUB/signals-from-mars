package com.example.signalsfrommars.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.example.signalsfrommars.R;

public class StoryAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent from_main_intent=getIntent();
        String name=from_main_intent.getStringExtra(getString(R.string.key_name));
        if(name.isEmpty() || name.equals(""))
            name="guest";

    }
}