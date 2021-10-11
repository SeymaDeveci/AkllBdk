package com.example.akllbdk;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.Locale;

public class MeyvelerOgrenmeActivity extends AppCompatActivity {

    private int position;

    private ViewPager viewPager;
    private SlideAdapterMeyvelerOgrenme myAdapter;
    private Button btn_fruits;
    TextToSpeech t1;
    String tospeak;

    public String[] txttoSpeak = {
            "ARMUT",
            "BADEM",
            "ÇİLEK",
            "ELMA",
            "ERİK",
            "HAVUÇ",
            "İNCİR",
            "KARPUZ",
            "KAVUN",
            "KAYISI",
            "KİRAZ",
            "KİVİ",
            "MANDALİNA",
            "MUZ",
            "PORTAKAL",
            "ŞEFTALİ",
            "ÜZÜM",
            "YENİ DÜNYA"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meyveler_ogrenme);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    t1.setLanguage(new Locale("tr","TR"));
                }
            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewPager_meyveler_ogrenme);
        myAdapter = new SlideAdapterMeyvelerOgrenme(this);
        viewPager.setAdapter(myAdapter);

        btn_fruits = findViewById(R.id.btn_listen_fruits);
        btn_fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tospeak = txttoSpeak[position];
                t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(final int position) {

                tospeak = txttoSpeak[position];
                t1.speak(tospeak, TextToSpeech.QUEUE_FLUSH,null);

                btn_fruits.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tospeak = txttoSpeak[position];
                        t1.speak(tospeak, TextToSpeech.QUEUE_FLUSH,null);
                    }
                });
            }
        });
    }
}
