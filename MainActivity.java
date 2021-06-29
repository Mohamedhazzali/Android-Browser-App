package com.Hazzali.androidbrowser;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button SearchButtonHome;
    private EditText InputURL;
    private Button facebook_btn;
    private Button youtube_btn;
    private Button instagram_btn;
    private Button Snapchat_btn;
    private Button yahoo_btn;
    private Button google_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SearchButtonHome = (Button) findViewById(R.id.search_btn_home);
        InputURL = (EditText) findViewById(R.id.search_url);
        facebook_btn = (Button) findViewById(R.id.facebook);
        youtube_btn= (Button) findViewById(R.id.youtube);
        instagram_btn = (Button) findViewById(R.id.instagram);
        Snapchat_btn = (Button) findViewById(R.id.snapchat);
        yahoo_btn= (Button) findViewById(R.id.yahoo);
        google_btn= (Button) findViewById(R.id.google);




        SearchButtonHome.setOnClickListener(this);
        facebook_btn.setOnClickListener(this);
        youtube_btn.setOnClickListener(this);
        instagram_btn.setOnClickListener(this);
        Snapchat_btn.setOnClickListener(this);
        yahoo_btn.setOnClickListener(this);
        google_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == SearchButtonHome)
        {
           OpenWebSite();
        }
        if (v == facebook_btn)
        {
            Intent open_facebook = new Intent(MainActivity.this,UrlSearch.class);
            open_facebook.putExtra("url_address","https://www.facebook.com");
            startActivity(open_facebook);
        }
        if (v == youtube_btn)
        {
            Intent open_youtube = new Intent(MainActivity.this,UrlSearch.class);
            open_youtube.putExtra("url_address","https://www.youtube.com");

            startActivity(open_youtube);
        }
        if (v == instagram_btn)
        {
            Intent open_instagram = new Intent(MainActivity.this,UrlSearch.class);
            open_instagram.putExtra("url_address","https://www.instagram.com");

            startActivity(open_instagram);
        }
        if (v == Snapchat_btn)
        {
            Intent open_snapchat= new Intent(MainActivity.this,UrlSearch.class);
            open_snapchat.putExtra("url_address","https://www.snapchat.com");

            startActivity(open_snapchat);
        }
        if (v == yahoo_btn)
        {
            Intent open_yahoo = new Intent(MainActivity.this,UrlSearch.class);
            open_yahoo.putExtra("url_address","https://www.yahoo.com");

            startActivity(open_yahoo);
        }
        if (v == google_btn)
        {
            Intent open_google = new Intent(MainActivity.this,UrlSearch.class);
            open_google.putExtra("url_address","https://www.google.com");

            startActivity(open_google);
        }
    }

    private void OpenWebSite() {

        String Url_Address = InputURL.getText().toString();
        if (TextUtils.isEmpty(Url_Address)){
            Toast empty = Toast.makeText(MainActivity.this," Please enter Url or web address",Toast.LENGTH_LONG);
            empty.show();
        }
        else{
            String url_without_https = Url_Address.replaceAll("https://www.","");
            String https = "https://";
            String www= "www.";
            Intent search = new Intent(MainActivity.this,UrlSearch.class);
            search.putExtra("url_address",https+www+url_without_https);
            startActivity(search);

            InputURL.setText("");
            InputURL.requestFocus();
        }
    }
}