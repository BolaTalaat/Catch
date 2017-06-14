
package com.example.corsatk.controller;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;

import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.corsatk.view.About;
import com.example.corsatk.view.ChattingNames;
import com.example.corsatk.view.ShowHelp;
import com.example.corsatk.view.UploadVideos;
import com.example.corsatk.courses.ArabicCourses;
import com.example.corsatk.courses.EnglishCourses;
import com.example.corsatk.R;
import com.example.corsatk.view.LoginMainDesign;
import com.example.corsatk.view.RateUs;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
        ,BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

   //Saving Image Profile
    private StorageReference mstorage;
    private ProgressDialog mprogressDialog;
    private static final int GALLERY_INTENT=2;

    private static String PlayList_ID;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ImageView imgProfile;
    private int SELECT_PICTURE;
    private String myTag = "TAG";
    private SharedPreferences myPrefs;
    private View header;
    private GridView gridView;
    SliderLayout sliderLayout;   //image slider
    HashMap<String,String> Hash_file_maps ;  //image slider
    private Uri selectedImageURI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Saving Image Profile
        mstorage= FirebaseStorage.getInstance().getReference();
        mprogressDialog=new ProgressDialog(this);



        // to do image slider
        Hash_file_maps = new HashMap<String, String>();
        sliderLayout = (SliderLayout)findViewById(R.id.slider);
        Hash_file_maps.put("Android ", "http://www.imagesfb.com/photo/img_1389112357_433.png");
        Hash_file_maps.put("C #", "https://traineralsafafeer.files.wordpress.com/2016/02/c-sharp-2.png");
        Hash_file_maps.put("C ++", "https://lh3.ggpht.com/flU87hPIiLSVJYzBclssr8I4xjn-Vr4e1AulB0Piy6HyRv0877E3DrmjBzRbBsYkHNu_=w300");
        Hash_file_maps.put("Java", "https://www.edx.org/sites/default/files/styles/course_video_banner/public/course/image/featured-card/java-course-318x210.jpg?itok=XUP4YmE1");
        Hash_file_maps.put("SQL ", "http://www.kdnuggets.com/wp-content/uploads/sql.jpg");

        for(String name : Hash_file_maps.keySet()){

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(MainActivity.this);


        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        initNavigationDrawer();
    }
    @Override
    // related to image slider
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    // related to image slider
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    // related to image slider
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    // related to image slider
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    // related to image slider
    public void onPageScrollStateChanged(int state) {}




    public void initNavigationDrawer() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.arabicCourses:
                        Toast.makeText(getApplicationContext(), "Arabic Courses", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, ArabicCourses.class);
                        startActivity(intent);

                        drawerLayout.closeDrawers();
                        break;
                    case R.id.englishCourses:
                        Toast.makeText(getApplicationContext(), "English Courses", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this, EnglishCourses.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.favorite:
                        Toast.makeText(getApplicationContext(), "Find courses", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.aboutUs:
                        Toast.makeText(getApplicationContext(), "about", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this,About.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.help:
                        //Toast.makeText(getApplicationContext(), "Please rate us", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this, MakeHelp.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.Showhelp:
                        //Toast.makeText(getApplicationContext(), "Please rate us", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this, ShowHelp.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.ratetUs:
                        Toast.makeText(getApplicationContext(), "Please rate us", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this, RateUs.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.chat:
                        Toast.makeText(getApplicationContext(), "Lets start chatting", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this, ChattingNames.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.uploadVideos:
                        intent = new Intent(MainActivity.this, UploadVideos.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.logout:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Attention");
                        builder.setMessage("Are you sure sir !!!");
                        builder.setIcon(android.R.drawable.ic_dialog_alert);
                        builder.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(MainActivity.this, LoginMainDesign.class);
                                        startActivity(intent);
                                    }
                                }
                        );
                        builder.setPositiveButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "you are still login", Toast.LENGTH_LONG).show();

                            }
                        });
                        builder.show();


                }
                return true;
            }
        });
        header = navigationView.getHeaderView(0);
        TextView tv_email = (TextView) header.findViewById(R.id.tv_email);

        imgProfile = (ImageView) header.findViewById(R.id.image_profile);


        imgProfile.setOnClickListener(this);
        tv_email.setText("Toni@gmail.com");
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.image_profile:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {

                selectedImageURI = data.getData();

                Picasso.with(MainActivity.this).load(selectedImageURI).noPlaceholder().centerCrop().fit()
                        .into((ImageView) findViewById(R.id.image_profile));
                myPrefs = getSharedPreferences(myTag, 0);
                SharedPreferences.Editor myPrefsEdit = myPrefs.edit();
                myPrefsEdit.putString("url", selectedImageURI.toString());
                myPrefsEdit.commit();
            }
        }
    }
}

