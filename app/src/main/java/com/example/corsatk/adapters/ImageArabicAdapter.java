package com.example.corsatk.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.corsatk.R;


public class ImageArabicAdapter extends BaseAdapter {
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;


    public ImageArabicAdapter(Context context, String[] prgmNameList, int[] prgmImages) {
        result=prgmNameList;
        context=context;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.img_item_courses, null);
        holder.tv=(TextView) rowView.findViewById(R.id.grid_item_label);
        holder.img=(ImageView) rowView.findViewById(R.id.grid_item_image);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);


        return rowView;
    }
    public class Holder
    {
        TextView tv;
        ImageView img;
    }
}