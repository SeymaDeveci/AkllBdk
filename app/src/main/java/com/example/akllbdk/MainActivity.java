package com.example.akllbdk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnSayilar, btnMeyveler, btnRenkler, btnSekiller, btnHayvanlar;
    TextToSpeech t1;
    String toSpeak;
   // TextView txtSayilar, txtMeyveler, txtRenkler, txtSekiller, txtHayvanlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.holo_blue_bright)));
        actionBar.show();

        /*txtSayilar = (TextView) findViewById(R.id.txtsayilar);
        txtMeyveler = (TextView) findViewById(R.id.txtmeyveler);
        txtRenkler = (TextView) findViewById(R.id.txtrenkler);
        txtSekiller = (TextView) findViewById(R.id.txtsekiller);
        txtHayvanlar = (TextView) findViewById(R.id.txthayvanlar);*/

        btnSayilar = (ImageButton) findViewById(R.id.sayilar);
        btnSayilar.setOnClickListener(this);
        btnMeyveler = (ImageButton) findViewById(R.id.meyveler);
        btnMeyveler.setOnClickListener(this);
        btnRenkler = (ImageButton) findViewById(R.id.renkler);
        btnRenkler.setOnClickListener(this);
        btnSekiller = (ImageButton) findViewById(R.id.sekiller);
        btnSekiller.setOnClickListener(this);
        btnHayvanlar = (ImageButton) findViewById(R.id.hayvanlar);
        btnHayvanlar.setOnClickListener(this);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    t1.setLanguage(new Locale("tr", "TR"));
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sayilar:
                toSpeak = "Sayılar";
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                Intent intentSayilar = new Intent(MainActivity.this,SayilarActivity.class);
                startActivity(intentSayilar);
                break;
            case R.id.meyveler:
                toSpeak = "Meyveler";
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                Intent intentMeyveler = new Intent(MainActivity.this,MeyvelerActivity.class);
                startActivity(intentMeyveler);
                break;
            case R.id.renkler:
                toSpeak = "Renkler";
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                Intent intentRenkler = new Intent(MainActivity.this,RenklerActivity.class);
                startActivity(intentRenkler);
                break;
            case R.id.sekiller:
                toSpeak = "Şekiller";
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null);
                Intent intentSekiller = new Intent(MainActivity.this,SekillerActivity.class);
                startActivity(intentSekiller);
                break;
            case R.id.hayvanlar:
                toSpeak = "Hayvanlar";
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                Intent intentHayvanlar = new Intent(MainActivity.this,HayvanlarActivity.class);
                startActivity(intentHayvanlar);
                break;

            default:
                break;
        }
    }
}