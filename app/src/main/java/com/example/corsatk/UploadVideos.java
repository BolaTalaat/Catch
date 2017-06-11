package com.example.corsatk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UploadVideos extends AppCompatActivity implements View.OnClickListener{
    private Button btnUploadVideos;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_videos);
        btnUploadVideos = (Button) findViewById(R.id.btn_uploadVideos);
        btnUploadVideos.setOnClickListener(this);
       toolbar = (Toolbar) findViewById(R.id.app_bar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Send Your Link");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_uploadVideos:
                sendEmail();
                break;
        }

    }
    protected void sendEmail() {


        String[] TO = {"catchbns@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(UploadVideos.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
