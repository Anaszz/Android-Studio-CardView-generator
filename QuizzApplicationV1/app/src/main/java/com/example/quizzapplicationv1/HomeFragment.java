package com.example.quizzapplicationv1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.quizzapplicationv1.adapter.SliderAdapter;
import com.example.quizzapplicationv1.R;
import com.example.quizzapplicationv1.adapter.SliderAdapter;

public class HomeFragment extends Fragment {


    Button play;
    private ViewPager slideViewpager;
    private LinearLayout linearMain;
    private SliderAdapter sliderAdapter;
    private TextView[] dots;

    private int currentPage;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        play = (Button) rootView.findViewById(R.id.btn_play);

        play.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), new GameActivity().getClass());
                        startActivity(intent);
                    }
                }
        );

        slideViewpager = (ViewPager) rootView.findViewById(R.id.slideViewpager_main);
        linearMain = (LinearLayout) rootView.findViewById(R.id.linear_main);
        sliderAdapter = new SliderAdapter(getActivity());
        slideViewpager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        slideViewpager.addOnPageChangeListener(viewListener);

        return rootView;
    }

    public void addDotsIndicator(int position){
        dots = new TextView[3];
        linearMain.removeAllViews();

        for(int i = 0; i < dots.length; i++ ){
            dots[i] = new TextView(getActivity());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            linearMain.addView(dots[i]);
        }
        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            currentPage = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
