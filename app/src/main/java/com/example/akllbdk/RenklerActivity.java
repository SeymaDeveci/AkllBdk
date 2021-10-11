package com.example.akllbdk;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class RenklerActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton kirmizi, sari, yesil, mavi, turuncu, siyah, beyaz, pembe, gri, kahverengi, mor;
    TextToSpeech t1;
    String toSpeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renkler);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.holo_blue_bright)));
        actionBar.show();

        kirmizi = findViewById(R.id.kirmizi_btn);
        kirmizi.setOnClickListener(this);
        sari = findViewById(R.id.sari_btn);
        sari.setOnClickListener(this);
        mavi = findViewById(R.id.mavi_btn);
        mavi.setOnClickListener(this);
        yesil = findViewById(R.id.yesil_btn);
        yesil.setOnClickListener(this);
        turuncu = findViewById(R.id.turuncu_btn);
        turuncu.setOnClickListener(this);
        siyah = findViewById(R.id.siyah_btn);
        siyah.setOnClickListener(this);
        beyaz = findViewById(R.id.beyaz_btn);
        beyaz.setOnClickListener(this);
        kahverengi = findViewById(R.id.kahverengi_btn);
        kahverengi.setOnClickListener(this);
        gri = findViewById(R.id.gri_btn);
        gri.setOnClickListener(this);
        pembe = findViewById(R.id.pembe_btn);
        pembe.setOnClickListener(this);
        mor = findViewById(R.id.mor_btn);
        mor.setOnClickListener(this);


        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status!=TextToSpeech.ERROR){
                    t1.setLanguage(new Locale("tr","TR"));
                }
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case (R.id.kirmizi_btn):
                toSpeak = "Kırmızı";
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                break;

            case (R.id.mavi_btn) :
                toSpeak = "Mavi";
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
                break;

            case (R.id.sari_btn) :
                toSpeak = "Sarı";
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
                break;

            case (R.id.yesil_btn) :
                toSpeak = "Yeşil";
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
                break;

            case (R.id.turuncu_btn) :
                toSpeak = "Turuncu";
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
                break;

            case (R.id.siyah_btn) :
                toSpeak = "Siyah";
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
                break;

            case (R.id.beyaz_btn) :
                toSpeak = "Beyaz";
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
                break;

            case (R.id.kahverengi_btn) :
                toSpeak = "Kahverengi";
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
                break;

            case (R.id.mor_btn) :
                toSpeak = "Mor";
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
                break;

            case (R.id.pembe_btn) :
                toSpeak = "Pembe";
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
                break;

            case (R.id.gri_btn) :
                toSpeak = "Gri";
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
                break;

            default:
                break;
        }
    }
}
