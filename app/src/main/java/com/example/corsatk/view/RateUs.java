package com.example.corsatk.view;

import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.corsatk.R;

import static android.R.attr.value;

public class RateUs extends AppCompatActivity  {


    RatingBar ArabicBar,EnglishBar,CommunicationBar,OverAllBar;
    TextView ArabicValue,EnglishValue,CommunicationValue,OverAllValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Rate Us");
        ArabicBar=(RatingBar)findViewById(R.id.ArabicRatingBar);
        EnglishBar=(RatingBar)findViewById(R.id.EnglishRatingBar);
        CommunicationBar= (RatingBar) findViewById(R.id.CommunicationRatingBar);
        OverAllBar= (RatingBar) findViewById(R.id.OverAllRatingBar);
        ArabicValue= (TextView) findViewById(R.id.ArabicValueText);
        EnglishValue= (TextView) findViewById(R.id.EnglishValueText);
        CommunicationValue= (TextView) findViewById(R.id.CommunicationValueText);
        OverAllValue= (TextView) findViewById(R.id.OverAllValueText);

        //Arabic Videos Rate
        ArabicBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
            {

                ArabicValue.setText("value is "+rating);
                Toast.makeText(RateUs.this,"Thank You For Your Rating",Toast.LENGTH_SHORT).show();
            }
        });

        //English Videos Rate
        EnglishBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
            {
                EnglishValue.setText("value is "+rating);
                Toast.makeText(RateUs.this,"Thank You For Your Rating",Toast.LENGTH_SHORT).show();
            }
        });

        //Communication Rate
        CommunicationBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
            {
                CommunicationValue.setText("value is "+rating);
                Toast.makeText(RateUs.this,"Thank You For Your Rating",Toast.LENGTH_SHORT).show();
            }
        });

        //Over All Rate
        OverAllBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
            {
                OverAllValue.setText("value is "+rating);
                Toast.makeText(RateUs.this,"Thank You For Your Rating",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
