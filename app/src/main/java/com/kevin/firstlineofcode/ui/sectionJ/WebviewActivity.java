package com.kevin.firstlineofcode.ui.sectionJ;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.base.BaseActivity;

public class WebviewActivity extends BaseActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);  //根据传入的参数再去加载新的网页
                return true;        //表示当前WebView可以处理打开新网页的请求，不用借助系统浏览器
            }
        });
        webView.loadUrl("http://www.baidu.com");
    }
}
