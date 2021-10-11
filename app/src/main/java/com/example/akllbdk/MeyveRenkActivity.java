package com.example.akllbdk;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MeyveRenkActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private SlideAdapterMeyveRenk myadapter;
    private Button btn1, btn2, btn3;
    private int position;

    String tospeak;
    TextToSpeech t1;

    public String[] fruits_name = {
            "Çilek",
            "Üzüm",
            "Muz",
            "havuç",
            "elma",
            "kayısı",
            "kiraz",
            "badem",
            "armut"
    };
    // btn_txttoSpeak_list ile butonlara tıklandığında
    // tıklanan butonun rengini söylemek için
    // String tipinde dizi oluşturduk
    public String[] btn1_txttoSpeak_list = {
            "Kırmızı",
            "Mor",
            "Sarı",
            "Turuncu",
            "Pembe",
            "Yeşil",
            "Kırmızı",
            "Mavi",
            "Sarı"};

    public String[] btn2_txttoSpeak_list = {
            "Sarı",
            "Pembe",
            "Mor",
            "Mavi",
            "Sarı",
            "Sarı",
            "Mavi",
            "Turuncu",
            "Kırmızı"};

    public String[] btn3_txttoSpeak_list = {
            "Mavi",
            "Yeşil",
            "Kırmızı",
            "Yeşil",
            "Kırmızı",
            "Mor",
            "Pembe",
            "Yeşil",
            "Pembe"};

    // meyve ile aynı renkli butona tıklanıp tıklanmadığını kontrol edebilmek
    // amacıyla btn id lerini oluşturan int tipinde bi dizi oluturduk.
    public int[] right_btn_list = {
            R.id.btn_meyve_renk_1,
            R.id.btn_meyve_renk_3,
            R.id.btn_meyve_renk_1,
            R.id.btn_meyve_renk_1,
            R.id.btn_meyve_renk_3,
            R.id.btn_meyve_renk_2,
            R.id.btn_meyve_renk_1,
            R.id.btn_meyve_renk_3,
            R.id.btn_meyve_renk_1
    };

    public String[] right_btn_txttospeak_list = {
            "KIRMIZI",
            "YEŞİL",
            "SARI",
            "TURUNCU",
            "KIRMIZI",
            "SARI",
            "KIRMIZI",
            "YEŞİL",
            "SARI"
    };

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meyve_renk);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    t1.setLanguage(new Locale("tr","TR"));
                }
            }
        });

        viewPager = (ViewPager)findViewById(R.id.viewPager_meyve_renk);
        myadapter = new SlideAdapterMeyveRenk(this);
        viewPager.setAdapter(myadapter);

        // renkleri int olarak tanımlayıp renk kodu çevrimi yapıldı.
        int Red = Color.parseColor("#DE1435");
        int Yellow = Color.parseColor("#F2F057");
        int Orange = Color.parseColor("#ED9242");
        int Green = Color.parseColor("#3CB56C");
        int Blue= Color.parseColor("#FF13AEF7");
        int Purple = Color.parseColor("#9B75E6");
        int Pink = Color.parseColor("#E3A8DF");

        // btn_color_list ile her sayfa değiştiğinde değişecek olan
        // buton renkleri Array listesi olarak tanımlandı.
        final List<Integer> btn1_color_list = new ArrayList<Integer>();
        btn1_color_list.add(Red);
        btn1_color_list.add(Purple);
        btn1_color_list.add(Yellow);
        btn1_color_list.add(Orange);
        btn1_color_list.add(Pink);
        btn1_color_list.add(Green);
        btn1_color_list.add(Red);
        btn1_color_list.add(Blue);
        btn1_color_list.add(Yellow);

        final List<Integer> btn2_color_list = new ArrayList<Integer>();
        btn2_color_list.add(Yellow);
        btn2_color_list.add(Pink);
        btn2_color_list.add(Purple);
        btn2_color_list.add(Blue);
        btn2_color_list.add(Yellow);
        btn2_color_list.add(Yellow);
        btn2_color_list.add(Blue);
        btn2_color_list.add(Orange);
        btn2_color_list.add(Red);

        final List<Integer> btn3_color_list = new ArrayList<Integer>();
        btn3_color_list.add(Blue);
        btn3_color_list.add(Green);
        btn3_color_list.add(Red);
        btn3_color_list.add(Green);
        btn3_color_list.add(Red);
        btn3_color_list.add(Purple);
        btn3_color_list.add(Pink);
        btn3_color_list.add(Green);
        btn3_color_list.add(Pink);


        btn1 = (Button)findViewById(R.id.btn_meyve_renk_1);
        btn2 = findViewById(R.id.btn_meyve_renk_2);
        btn3 = findViewById(R.id.btn_meyve_renk_3);

        // Burada ilk sayfa açıldığındaki butonların renkleri ayarlanıyor
        btn1.setBackgroundColor(btn1_color_list.get(position));
        btn2.setBackgroundColor(btn2_color_list.get(position));
        btn3.setBackgroundColor(btn3_color_list.get(position));

        // Burada ilk sayfa açıldığında görüntülenen butonların
        // renkleri ayarlandı.
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        // sayfanın değişimi dinleniyor
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(final int position) {
                tospeak = fruits_name[position];
                t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);

                // Burada sayfa değiştikçe butonların renkleri değişecek
                btn1.setBackgroundColor(btn1_color_list.get(position));
                btn2.setBackgroundColor(btn2_color_list.get(position));
                btn3.setBackgroundColor(btn3_color_list.get(position));

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (v.getId() == right_btn_list[position]){
                            tospeak = right_btn_txttospeak_list[position] + "Tebrikler, Doğru Cevap.";
                            t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
                        }
                        else {
                            tospeak = btn1_txttoSpeak_list[position] + "Yanlış cevap, Tekrar dene";
                            t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });

                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (v.getId() == right_btn_list[position]){
                            tospeak =right_btn_txttospeak_list[position] +  "Tebrikler, Doğru Cevap.";
                            t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
                        }
                        else {
                            tospeak = btn2_txttoSpeak_list[position] + "Yanlış cevap, Tekrar dene";
                            t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });

                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (v.getId() == right_btn_list[position]){
                            tospeak = right_btn_txttospeak_list[position] + "Tebrikler, Doğru Cevap.";
                            t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
                        }
                        else{
                            tospeak = btn3_txttoSpeak_list[position] + "Yanlış cevap, Tekrar dene";
                            t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_meyve_renk_1){
            tospeak = btn1_txttoSpeak_list[position] + "Tebrikler, Doğru Cevap.";
            t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
        }
        else  if (v.getId() == R.id.btn_meyve_renk_2){
            tospeak = btn2_txttoSpeak_list[position] + "Yanlış cevap, Tekrar dene";
            t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
        }
        else  if (v.getId() == R.id.btn_meyve_renk_3){
            tospeak = btn3_txttoSpeak_list[position] + "Yanlış cevap, Tekrar dene";
            t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
        }
    }
}
