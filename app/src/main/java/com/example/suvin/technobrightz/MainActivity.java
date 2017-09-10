package com.example.suvin.technobrightz;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView WebView = (WebView) findViewById(R.id.Web_View);
        WebSettings WebSettings = (WebSettings) WebView.getSettings();
        WebSettings.setJavaScriptEnabled(true);
        final ProgressBar Progress_Bar = (ProgressBar) findViewById(R.id.Progress_Bar);




        WebView.setWebChromeClient(new WebChromeClient() {

            public void onProgressChanged(WebView view, int progress) {

                if (progress == 100) {


                    Progress_Bar.setVisibility(View.INVISIBLE);

                }
            }
        });


        String url = "http://www.alltopnow.com/";

        WebView.loadUrl(url);
    }
}
