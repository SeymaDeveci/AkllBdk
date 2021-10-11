package com.example.akllbdk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapterMeyveRenk extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public int[] list_images = {
            R.drawable.cilek,
            R.drawable.uzum,
            R.drawable.muz,
            R.drawable.havuc,
            R.drawable.elma,
            R.drawable.kayisi,
            R.drawable.kiraz,
            R.drawable.badem,
            R.drawable.armut
    };

    public String[] list_fruits_color = {
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

    public SlideAdapterMeyveRenk(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_fruits_color.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (LinearLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_meyve_renk,container,false);

        ImageView imgSlideMeyveRenk = (ImageView) view.findViewById(R.id.image_slide_meyve_renk);
        imgSlideMeyveRenk.setImageResource(list_images[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout) object);

    }
}
