package com.example.akllbdk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapterMeyvelerOgrenme extends PagerAdapter {

    Context context;
    LayoutInflater inflater;


    // list of images
    public int[] list_images = {
            R.drawable.armut,
            R.drawable.badem,
            R.drawable.cilek,
            R.drawable.elma,
            R.drawable.erik,
            R.drawable.havuc,
            R.drawable.incir,
            R.drawable.karpuz,
            R.drawable.kavun,
            R.drawable.kayisi,
            R.drawable.kiraz,
            R.drawable.kivi,
            R.drawable.mandalina,
            R.drawable.muz,
            R.drawable.portakal,
            R.drawable.seftali,
            R.drawable.uzum,
            R.drawable.yenidunya
    };

    // list of titles
    public String[] list_fruit = {
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
    public SlideAdapterMeyvelerOgrenme(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_fruit.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view== (LinearLayout)o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_meyveler_ogrenme,container,false);

        ImageView imgslide = (ImageView) view.findViewById(R.id.image_slide);
        TextView txtTitle = (TextView) view.findViewById(R.id.txt_title);
        imgslide.setImageResource(list_images[position]);
        txtTitle.setText(list_fruit[position]);


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,  Object object) {
        container.removeView((LinearLayout)object);
    }
}
