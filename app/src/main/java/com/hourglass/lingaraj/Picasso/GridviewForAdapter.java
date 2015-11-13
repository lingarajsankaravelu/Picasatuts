package com.hourglass.lingaraj.Picasso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

/**
 * Created by lingaraj on 11/12/15.
 */
public class GridviewForAdapter extends AppCompatActivity {

    GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridviewforadapter);
        gridview=(GridView) findViewById(R.id.gridView);
        String[] imagePath={"http://www.gettyimages.co.uk/gi-resources/images/Homepage/Category-Creative/UK/UK_Creative_462809583.jpg","http://www.freestockphotos.name/wallpaper-original/wallpapers/download-images-of-gentle-dogs-6866.jpg","http://www.travel-tw.com.tw/img/p3.jpg","http://i1008.photobucket.com/albums/af201/visuallightbox/Butterfly/13.jpg","http://www.thinkstockphotos.in/CMS/StaticContent/Hero/TS_AnonHP_462882495_01.jpg","http://www.quicksprout.com/images/foggygoldengatebridge.jpg","http://www.gettyimages.in/gi-resources/images/CreativeImages/Hero-534897989.jpg"};
        AdapterToLoadImageInGridview adapterToLoadImageInGridview=new AdapterToLoadImageInGridview(GridviewForAdapter.this,imagePath);
        gridview.setAdapter(adapterToLoadImageInGridview);



    }
}
