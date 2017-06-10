package com.example.corsatk;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MakeHelp extends AppCompatActivity {
  private   EditText name,phone,problem;
   private Button upload,share;
   private ImageView imageView;
    private StorageReference mstorage;
    private ProgressDialog mprogress;
    private DatabaseReference mdata;

    private Uri imageuri=null;
    private static final int gallery_request = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_help);
        mstorage= FirebaseStorage.getInstance().getReference();
        mdata= FirebaseDatabase.getInstance().getReference().child("help requests");

        name=(EditText)findViewById(R.id.edittextname);
        phone=(EditText)findViewById(R.id.edittextphone);
        problem=(EditText)findViewById(R.id.edittextproblem);
        upload=(Button) findViewById(R.id.upload);
        share=(Button) findViewById(R.id.share);
        mprogress=new ProgressDialog(this);

        imageView=(ImageView)findViewById(R.id.imageview1);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/*");
                startActivityForResult(i,gallery_request);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startshare();

            }
        });
    }
    public void  startshare(){
        mprogress.setMessage("share ....");
        mprogress.show();
        final  String n = name.getText().toString().trim();
        final String p = phone.getText().toString().trim();
        final String prob = problem.getText().toString().trim();
        if(  (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(p)&& !TextUtils.isEmpty(prob)&&imageuri !=null)){
            final StorageReference fielpath=mstorage.child("image").child(imageuri.getLastPathSegment());
            fielpath.putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @SuppressWarnings("VisibleForTests")
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    DatabaseReference post=mdata.push();
                    post.child("name").setValue(n);
                    post.child("phone").setValue(p);
                    post.child("problem").setValue(prob);
                    post.child("image").setValue(downloadUrl.toString());
                    mprogress.dismiss();
                   Intent intent=new Intent(MakeHelp.this,ShowHelp.class);
                    startActivity(intent);

                }
            });
        }else {
            mprogress.dismiss();
            Toast.makeText(this, "please Fill data ", Toast.LENGTH_SHORT).show();
        }




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==gallery_request && resultCode==RESULT_OK){
            imageuri=data.getData();
            imageView.setImageURI(imageuri);

        }

    }
}
