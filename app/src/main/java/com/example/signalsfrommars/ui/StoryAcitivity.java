package com.example.signalsfrommars.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.signalsfrommars.R;
import com.example.signalsfrommars.model.Page;
import com.example.signalsfrommars.model.Story;

public class StoryAcitivity extends AppCompatActivity {

    private  Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1_button;
    private Button choice2_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent from_main_intent=getIntent();
        String name=from_main_intent.getStringExtra(getString(R.string.key_name));
        if(name.isEmpty() || name.equals(""))
            name="guest";
            story=new Story();
            loadPage(0);

    }

    private void loadPage(int numPage) {
        Page page=story.getPage(numPage);
        Drawable image= ContextCompat.getDrawable(this,page.getImageId());
        storyImageView.setImageDrawable(image);
//        storyTextView.setText(page.getTextId());

    }
}