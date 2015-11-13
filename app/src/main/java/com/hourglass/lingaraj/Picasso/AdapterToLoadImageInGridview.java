package com.hourglass.lingaraj.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by lingaraj on 11/12/15.
 */


public class AdapterToLoadImageInGridview extends BaseAdapter {

    private String[] imagePathArray;
    private Context tcontext;
    private LayoutInflater inflater;
    public ViewHolder holder;



    public AdapterToLoadImageInGridview(Context context,String imagePathArray[]) {

        this.imagePathArray=imagePathArray;
        this.tcontext=context;
        this.inflater=LayoutInflater.from(context);



    }

    @Override
    public int getCount() {
        return imagePathArray.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView=inflater.inflate(R.layout.layoutforimageview,null);
            holder=new ViewHolder();
            holder.imageView=(ImageView)convertView.findViewById(R.id.imageViewForAdapter);
            convertView.setTag(holder);




        }
        else {

            holder=(ViewHolder)convertView.getTag();


        }


        Picasso.with(tcontext).load(imagePathArray[position]).placeholder(R.drawable.downloading).error(R.drawable.error).into(holder.imageView);


        return convertView;
    }

    static class ViewHolder {

        ImageView imageView;


    }







    }
