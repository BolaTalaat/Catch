package com.example.corsatk.adapters;

/**
 * Created by root on 4/27/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.corsatk.R;

//jbjnbjnbnb
public class ImageAdapter extends BaseAdapter {
    private Context context;
    private final String[] mCourseContent;

    public ImageAdapter(Context context, String[] mCourseContent) {
        this.context = context;
        this.mCourseContent = mCourseContent;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from img_item_courses.xmlourses.xml
            gridView = inflater.inflate(R.layout.img_item_courses, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(mCourseContent[position]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);

            String mCourses = mCourseContent[position];

            if (mCourses.equals("Android")) {
                imageView.setImageResource(R.drawable.android);
            } else if (mCourses.equals("Python")) {
                imageView.setImageResource(R.drawable.python);
            } else if (mCourses.equals("JavaAdvanced")) {
                imageView.setImageResource(R.drawable.java_adv);
            } else  {
                imageView.setImageResource(R.drawable.c_plus);
            }

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return mCourseContent.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}