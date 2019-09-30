package com.example.joshuaevanarijanto.dicodingrecyclerview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {


    TextView tv_name,tv_quote, tv_biodata;
    ImageView img;

    int indexData;

    private ArrayList<Dream> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        list = new ArrayList<>();
        list.addAll(DreamData.getListData());

        img = findViewById(R.id.img);
        tv_name = findViewById(R.id.tv_name);
        tv_quote = findViewById(R.id.tv_quote);
        tv_biodata = findViewById(R.id.tv_biodata);
        indexData = getIntent().getIntExtra("indexData",0);


        tv_name.setText((CharSequence) list.get(indexData).getName());
        tv_quote.setText((CharSequence) list.get(indexData).getRemarks());
        tv_biodata.setText((CharSequence) list.get(indexData).getBiodata());
        new DownloadImageTask((ImageView) findViewById(R.id.img))
                .execute(list.get(indexData).getPhoto());

    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}
