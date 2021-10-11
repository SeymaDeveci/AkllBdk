package com.example.akllbdk;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MeyvelerActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnmeyveogrenme, btnmeyverenk, btnmeyvesayi, btnmeyvesepet;
    TextToSpeech t1;
    String tospeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meyveler);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.holo_blue_bright)));
        actionBar.show();

        btnmeyveogrenme = findViewById(R.id.btn_meyve_ogrenme);
        btnmeyveogrenme.setOnClickListener(this);
        btnmeyverenk = findViewById(R.id.btn_meyve_renk);
        btnmeyverenk.setOnClickListener(this);
        btnmeyvesayi = findViewById(R.id.btn_meyve_sayi);
        btnmeyvesayi.setOnClickListener(this);
        btnmeyvesepet = findViewById(R.id.btn_meyve_sepet);
        btnmeyvesepet.setOnClickListener(this);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    t1.setLanguage(new Locale("tr","TR"));
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_meyve_ogrenme :
                tospeak = "Meyveleri Öğreniyorum.";
                t1.speak(tospeak, TextToSpeech.QUEUE_FLUSH,null);
                Intent intentMeyveOgrenme = new Intent(MeyvelerActivity.this, MeyvelerOgrenmeActivity.class);
                startActivity(intentMeyveOgrenme);
                break;

            case R.id.btn_meyve_renk :
                tospeak = "Bil Bakalım Rengim Ne?";
                t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
                Intent intentMeyveRenk = new Intent(MeyvelerActivity.this, MeyveRenkActivity.class);
                startActivity(intentMeyveRenk);
                break;

            case R.id.btn_meyve_sayi :
                tospeak = "Kaç Meyve var?";
                t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
                Intent intentMeyveSayi = new Intent(MeyvelerActivity.this, MeyveSayiActivity.class);
                startActivity(intentMeyveSayi);
                break;

            case R.id.btn_meyve_sepet :
                tospeak = "Sepete Meyve Koyalım";
                t1.speak(tospeak, TextToSpeech.QUEUE_FLUSH,null);
                Intent intentMeyveSepet = new Intent(MeyvelerActivity.this, MeyveSepetiActivity.class);
                break;
            default:
                break;
        }

    }
}
