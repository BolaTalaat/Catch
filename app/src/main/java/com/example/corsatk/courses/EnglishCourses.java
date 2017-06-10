package com.example.corsatk.courses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.corsatk.R;
import com.example.corsatk.adapters.ImageEnglishAdapter;
import com.example.corsatk.controller.CourseDetails;

public class EnglishCourses extends AppCompatActivity {
    public static String PlayList_ID;
    private GridView gridView;
    public static String [] mCourseName={
            "OOP",
            "C++",
            "C#",
            "JavaBeginner",
            "JavaAdvanced",
            "Python",
            "ASP",
            "PHP",
            "AndroidBeginner",
            "AndroidAdvanced",
            "IOSBeginner",
            "IOSAdvanced",
            "SQL"};
    public static int [] mCourseImage={
            R.drawable.oop,
            R.drawable.c_plus_plus,
            R.drawable.c_sharp,
            R.drawable.java_beginner,
            R.drawable.java_advanced,
            R.drawable.python,
            R.drawable.asp,
            R.drawable.php,
            R.drawable.android_beginner,
            R.drawable.android_advanced,
            R.drawable.ios_beginner,
            R.drawable.ios_advanced,
            R.drawable.sql
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_courses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("English Courses");
        gridView = (GridView) findViewById(R.id.gridviewEnglish);
        gridView.setAdapter(new ImageEnglishAdapter(this, mCourseName,mCourseImage));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                switch (position){
                    // OOP
                    case 0:
                        PlayList_ID="PLfVsf4Bjg79DLA5K3GLbIwf3baNVFO2Lq";
                        Intent intent0 = new Intent(getBaseContext(), CourseDetails.class);
                        intent0.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent0);
                        break;
                    // C++
                    case 1:
                        PlayList_ID="PLfVsf4Bjg79Cu5MYkyJ-u4SyQmMhFeC1C";
                        Intent intent = new Intent(getBaseContext(), CourseDetails.class);
                        intent.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent);
                        break;
                    //C#
                    case 2:
                        PlayList_ID="PLAC325451207E3105";
                        Intent intent2 = new Intent(getBaseContext(), CourseDetails.class);
                        intent2.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent2);
                        break;
                    //Java Basic
                    case 3:
                        PlayList_ID="PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al";
                        Intent intent3 = new Intent(getBaseContext(), CourseDetails.class);
                        intent3.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent3);
                        break;
                    // Java Advanced
                    case 4:
                        PlayList_ID="PLVlQHNRLflP9OiTKTQuq3UWJNA_wOPlFr";
                        Intent intent4 = new Intent(getBaseContext(), CourseDetails.class);
                        intent4.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent4);
                        break;
                    // Paython
                    case 5:
                        PlayList_ID="PL6gx4Cwl9DGAcbMi1sH6oAMk4JHw91mC_";
                        Intent intent5 = new Intent(getBaseContext(), CourseDetails.class);
                        intent5.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent5);
                        break;
                    //ASP
                    case 6:
                        PlayList_ID="PL6n9fhu94yhXQS_p1i-HLIftB9Y7Vnxlo";
                        Intent intent6 = new Intent(getBaseContext(), CourseDetails.class);
                        intent6.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent6);
                        break;
                    //PHP
                    case 7:
                        PlayList_ID="PL442FA2C127377F07";
                        Intent intent7 = new Intent(getBaseContext(), CourseDetails.class);
                        intent7.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent7);
                        break;
                    //android basic
                    case 8:
                        PlayList_ID="PLonJJ3BVjZW6hYgvtkaWvwAVvOFB7fkLa";
                        Intent intent8 = new Intent(getBaseContext(), CourseDetails.class);
                        intent8.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent8);
                        break;
                    //advanced android
                    case 9:
                        PlayList_ID="PLonJJ3BVjZW6CtAMbJz1XD8ELUs1KXaTD";
                        Intent intent9 = new Intent(getBaseContext(), CourseDetails.class);
                        intent9.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent9);
                        break;
                    //ios beginner
                    case 10:
                        PlayList_ID="PL6gx4Cwl9DGDgp7nGSUnnXihbTLFZJ79B";
                        Intent intent10 = new Intent(getBaseContext(), CourseDetails.class);
                        intent10.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent10);
                        break;
                    //ios advanced
                    case 11:
                        PlayList_ID="PLIwSqSAJUgD7bzhodLoYYCGxpZ-oBtXzV";
                        Intent intent11 = new Intent(getBaseContext(), CourseDetails.class);
                        intent11.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent11);
                        break;
                    // sql
                    case 12:
                        PlayList_ID="PL08903FB7ACA1C2FB";
                        Intent intent12 = new Intent(getBaseContext(), CourseDetails.class);
                        intent12.putExtra("EXTRA_SESSION_ID", PlayList_ID);
                        startActivity(intent12);
                        break;
                }
            }
        });


    }
}
