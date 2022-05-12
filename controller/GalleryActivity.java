package com.example.galeria.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.galeria.R;

public class GalleryActivity extends AppCompatActivity {

    ImageView imageView ;
    TextView indexTextView;
    Button previousButton;
    Button nextButton;

    int index = 0;
    String []images = new String[]{"stadium1", "stadium2", "stadium3", "stadium4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        imageView = findViewById(R.id.imageView);
        indexTextView = findViewById(R.id.indexTextView);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                updateImageDetails();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                updateImageDetails();
            }
        });

        updateImageDetails();
    }

    void updateImageDetails() {
        if (index <= 0) {
            index = 0;
            previousButton.setVisibility(View.INVISIBLE);
        } else {
            previousButton.setVisibility(View.VISIBLE);
        }

        if (index >= (images.length - 1)) {
            index = images.length - 1;
            nextButton.setVisibility(View.INVISIBLE);
        } else {
            nextButton.setVisibility(View.VISIBLE);
        }

        imageView.setImageDrawable(getImageDrawable(images[index]));
        indexTextView.setText("" + (index+1) + "/" + images.length);
    }

    Drawable getImageDrawable(String imageName) {
        return getResources().getDrawable(
                getResources().getIdentifier(imageName, "drawable", getPackageName()),
                getTheme()
        );
    }
}