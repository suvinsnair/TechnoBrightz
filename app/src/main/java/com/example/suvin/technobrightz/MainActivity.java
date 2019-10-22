package com.example.suvin.technobrightz;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean doubleBackToExitPressedOnce;
    private Handler mHandler = new Handler();

    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            doubleBackToExitPressedOnce = false;
        }
    };

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if (mHandler != null) { mHandler.removeCallbacks(mRunnable); }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press Again to Quit", Toast.LENGTH_SHORT).show();

        mHandler.postDelayed(mRunnable, 2000);
    }





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        WebView WebView = (WebView) findViewById(R.id.Web_View);
        WebSettings WebSettings = (WebSettings) WebView.getSettings();
        WebSettings.setJavaScriptEnabled(true);
        WebView.setVerticalScrollBarEnabled(false);
        WebSettings.setDefaultFontSize(10);
        WebView.setHorizontalScrollBarEnabled(false);
        Toast.makeText(this, "Hi ,Bitty", Toast.LENGTH_SHORT).show();


        final ProgressBar Progress_Bar = (ProgressBar) findViewById(R.id.Progress_Bar);
        WebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);


                return true;


            }

        });




        WebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Progress_Bar.setProgress(newProgress);

                if(newProgress==100){

                    Progress_Bar.setVisibility(View.INVISIBLE);


            }else {

                    Progress_Bar.setVisibility(View.VISIBLE);
                }
        }
        });


        String url = "http://www.alltopnow.com/";

        WebView.loadUrl(url);
        
        public function nouse($request) {
            
            console.log;
        }








    }
}

