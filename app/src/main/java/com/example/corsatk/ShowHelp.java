package com.example.corsatk;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ShowHelp extends AppCompatActivity {
    private RecyclerView helplist;
    private DatabaseReference mdata;

    public ShowHelp() {
        // Required empty public constructor
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_help);

        mdata= FirebaseDatabase.getInstance().getReference().child("help requests");
        helplist= (RecyclerView) findViewById(R.id.help_list);
        helplist.setHasFixedSize(true);
        helplist.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<posthelp,bostview> Firebaseadapter= new FirebaseRecyclerAdapter<posthelp, bostview>(
                posthelp.class,
                R.layout.row,
                bostview.class,
                mdata
        ) {
            @Override
            protected void populateViewHolder(bostview viewHolder, posthelp model, int position) {
                viewHolder.setname(model.getName());
                viewHolder.setEmail(model.getEmail());
                viewHolder.setProblem(model.getProblem());
                viewHolder.setimage(getApplicationContext(),model.getImage());

            }
        };

        helplist.setAdapter(Firebaseadapter);
    }



    public static class bostview extends RecyclerView.ViewHolder{
        View mview;
        public bostview(View itemView) {
            super(itemView);
            mview=itemView;
        }
        public void setname(String name){
            TextView textView_name=(TextView)mview.findViewById(R.id.text_name);
            textView_name.setText(name);
        }
        public void setEmail(String phone){
            TextView textView_phone=(TextView)mview.findViewById(R.id.text_phone);
            textView_phone.setText(phone);

        }
        public void setProblem(String problem){
            TextView textView_problem=(TextView)mview.findViewById(R.id.text_problem);
            textView_problem.setText(problem);
            return ;

        }
        public void setimage(Context con, String image){
            ImageView imageView=(ImageView)mview.findViewById(R.id.image_help);
            Picasso.with(con).load(image).into(imageView);


        }

    }
}
