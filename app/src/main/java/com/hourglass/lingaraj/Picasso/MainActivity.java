package com.hourglass.lingaraj.Picasso;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.annotation.Target;

public class MainActivity extends AppCompatActivity {

    Button cacheAndDisplayImage,cachewithWidthAndHeight,handleDownloadFailure,saveImageToPhone,loadImageToAdapter;
    ImageView displayImageHere;
    Bitmap bitmapToSaveImageOnImageView;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cacheAndDisplayImage = (Button) findViewById(R.id.cacheAndDisplayImage);
        cachewithWidthAndHeight = (Button) findViewById(R.id.cachewithWidthandHeight);
        handleDownloadFailure = (Button) findViewById(R.id.LoadDefaultImageOnFailure);
        saveImageToPhone = (Button) findViewById(R.id.saveImageToPhone);
        displayImageHere = (ImageView) findViewById(R.id.displayImageHere);
        loadImageToAdapter = (Button) findViewById(R.id.loadImagesToAdapter);

        final com.squareup.picasso.Target saveImageToDirectory = new com.squareup.picasso.Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                ProgressDialog mydialog = new ProgressDialog(MainActivity.this);
                mydialog.setMessage("saving Image to phone");
                mydialog.show();
                try {
                    file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"bird.jpeg");
                    //new File(path for the file to be saved, saving file name)
                    if (!file.exists()) {
                        //check if the file already exist or if not create a new file
                        //if exist the file will be overrighted with the new image
                        file.createNewFile();

                    }
                    FileOutputStream ostream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 70, ostream);
                    //Normal file creation process.
                    //With Image needed type.


                    Toast.makeText(MainActivity.this, "File Saved here" + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();

                    ostream.close();
                    mydialog.dismiss();

                } catch (Exception e) {
                    mydialog.dismiss();
                    Log.e("file creation error", e.toString());

                }


            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };



        cacheAndDisplayImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Picasso.with(MainActivity.this).load("http://www.gettyimages.co.uk/gi-resources/images/Homepage/Category-Creative/UK/UK_Creative_462809583.jpg").placeholder(R.drawable.downloading).error(R.drawable.error).into(displayImageHere);
                //cache and display the image to ImageView placeHolder(image) an image which show information to the user showing it's downloading.
                //.error(image) display the default image on the image if there is an cache error(like Cache Image failed due to network error)

            }
        });

        cachewithWidthAndHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Picasso.with(MainActivity.this).load("http://www.gettyimages.co.uk/gi-resources/images/Homepage/Category-Creative/UK/UK_Creative_462809583.jpg").placeholder(R.drawable.downloading).error(R.drawable.error).resize(500, 500).centerCrop().into(displayImageHere);

            }
        });

        handleDownloadFailure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Picasso.with(MainActivity.this).load("hello").placeholder(R.drawable.downloading).placeholder(R.drawable.downloading).error(R.drawable.error).into(displayImageHere);

            }
        });


        saveImageToPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Picasso.with(MainActivity.this).load("http://www.gettyimages.co.uk/gi-resources/images/Homepage/Category-Creative/UK/UK_Creative_462809583.jpg").placeholder(R.drawable.downloading).error(R.drawable.error).into(saveImageToDirectory);







            }
        });



        loadImageToAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,GridviewForAdapter.class);
                startActivity(intent);

            }
        });





    }
}
