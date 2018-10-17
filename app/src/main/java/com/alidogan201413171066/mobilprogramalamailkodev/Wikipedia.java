package com.alidogan201413171066.mobilprogramalamailkodev;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by alido on 29.03.2017.
 */

public class Wikipedia extends AppCompatActivity {

    WebView wv;
    LocationManager lm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        wv = (WebView) findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);
        Bundle extras = getIntent().getExtras();
        String str = extras.getString("send_string");
        wv.loadUrl(str);

    }
}
