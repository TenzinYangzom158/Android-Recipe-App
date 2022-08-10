package gvs.com.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView w = findViewById(R.id.web);
        w.loadUrl("https://www.youtube.com/watch?v=Y-Y9CXGRJPU");
        w.getSettings().setJavaScriptEnabled(true);
        w.setWebViewClient(new WebViewClient());
    }
}