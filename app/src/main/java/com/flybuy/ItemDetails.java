package com.flybuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;

public class ItemDetails extends AppCompatActivity {

    ImageView headingPhoto;
    ImageView backButton;
    TextView headingText;
    TextView starMarks;
    TextView priceChange;
    ImageView photography01;
    ImageView photography02;
    ImageView photography03;
    TextView about, qty;
    Button payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        this.backButton = findViewById(R.id.imageView4);
        this.payment = findViewById(R.id.button);

        this.headingPhoto = findViewById(R.id.imageView3);
        this.headingText = findViewById(R.id.textView6);
        this.starMarks = findViewById(R.id.textView7);
        this.priceChange = findViewById(R.id.textView11);
        this.qty = findViewById(R.id.textView10);

        this.photography01 = findViewById(R.id.imageView8);
        this.photography02 = findViewById(R.id.imageView9);
        this.photography03 = findViewById(R.id.imageView10);

        this.about = findViewById(R.id.textView14);


        headingPhoto.setImageResource(Integer.parseInt(readFile("imageUrlHeading")));
        headingText.setText(readFile("nameItem"));
        starMarks.setText(readFile("rating"));
        priceChange.setText(readFile("price"));
        qty.setText(readFile("qty"));
//
        photography01.setImageResource(Integer.parseInt(readFile("imageUrlHeading")));
        photography02.setImageResource(Integer.parseInt(readFile("imageUrlHeading")));
        photography03.setImageResource(Integer.parseInt(readFile("imageUrlHeading")));

        about.setText(readFile("about"));

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pay = new Intent(ItemDetails.this, Payment.class);
                startActivity(pay);
            }
        });

    }


    public String readFile(String fileName) {
        File path = getFilesDir();
        File readfrom = new File(path, fileName);

        byte[] content = new byte[(int) readfrom.length()];
        try {

            FileInputStream reader = new FileInputStream(readfrom);
            reader.read(content);
            return new String(content);

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}