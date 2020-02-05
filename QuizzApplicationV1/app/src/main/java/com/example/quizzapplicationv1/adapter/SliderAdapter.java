package com.example.quizzapplicationv1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.quizzapplicationv1.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ImageView slideImageView;
    TextView slideHeader;
    TextView slideDescr;

    public SliderAdapter(Context context ){

        this.context = context;
    }

    //Arrays contenant les valeurs en int et en String que l'on veut afficher dans les Views de notre layout slide_layout
    public int[] slide_images = {

            R.drawable.icon_game2,
            R.drawable.icon_docs,
            R.drawable.icon_login

    };

    public String[] slide_header ={

            "GAME",
            "DOCS",
            "LOGIN"
    };

    public  String[] slide_desc = {

            "ritas, et alioqui coalito more in ordinarias dignitates asperum semper et, ut satisfaceret atque monstraret, quam ob causam annonae convectio sit impedita.",
            "Quam ob rem id primum videamus, si placet, quatenus amor in amicitia progredi debeat. Numne, si Coriolanus habuit amicos, ferre contra patriam arma i",
            "Unde Rufinus ea tempestate praefectus praetorio ad discrimen trusus est ultimum. ire enim ipse compellebatur ad militem, quem exagitabat inopia simul et fe"

    };

    @Override
    public int getCount() {
        return slide_header.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.side_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.image_slide);
        TextView slideHeader = (TextView) view.findViewById(R.id.header_slide);
        TextView slideDescr= (TextView) view.findViewById(R.id.description_slide);

        slideImageView.setImageResource(slide_images[position]);
        slideHeader.setText(slide_header[position]);
        slideDescr.setText(slide_desc[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);

    }
}
