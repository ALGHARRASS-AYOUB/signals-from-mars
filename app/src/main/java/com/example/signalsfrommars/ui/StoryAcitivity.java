package com.example.signalsfrommars.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.signalsfrommars.R;
import com.example.signalsfrommars.model.Page;
import com.example.signalsfrommars.model.Story;

public class StoryAcitivity extends AppCompatActivity {

    private  Story story=new Story();
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1_button;
    private Button choice2_button;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView=findViewById(R.id.StoryImageView);
        storyTextView=findViewById(R.id.StoryTextView);
        choice1_button=findViewById(R.id.choice1_button);
        choice2_button=findViewById(R.id.choice2_button);



        Intent from_main_intent=getIntent();
         name=from_main_intent.getStringExtra(getString(R.string.key_name));
        if(name.isEmpty() || name.equals("")){

            name="guest";
        }

            loadPage(0,name);

    }

    private void loadPage(int numPage,String name) {
        Page page=this.story.getPage(numPage);
        Drawable image= ContextCompat.getDrawable(getApplicationContext(),page.getImageId());

        storyImageView.setImageDrawable(image);
        String text=getString(page.getTextId());
        String pagetext=String.format(text, name);
        storyTextView.setText(pagetext);

        if(page.isFinalPage()){
            choice1_button.setVisibility(View.INVISIBLE);
            choice2_button.setText(R.string.play_again);
        }
        else{
            createButtons(name, page);
        }

    }

    private void createButtons(String name, Page page) {
        choice1_button.setText(page.getChoice1().getTextId());
        choice1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage= page.getChoice1().getNextPage();
                loadPage(nextPage, name);
            }
        });
        choice2_button.setText(page.getChoice2().getTextId());
        choice2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage= page.getChoice2().getNextPage();
                loadPage(nextPage, name);
            }
        });
    }
}