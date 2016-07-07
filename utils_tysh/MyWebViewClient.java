package com.wbg.tianyi_sj.utils;

/**
 * Created by wenrui on 16/5/18.
 */

import android.webkit.WebView;


public class MyWebViewClient extends  WVJBWebViewClient {


    public MyWebViewClient(WebView webView) {

        //需要支持JS send 方法时
        super(webView, new WVJBWebViewClient.WVJBHandler() {
            @Override
            public void request(Object data, WVJBResponseCallback callback) {
                //处理代码
            }
        });

      /*
      //不需要支持JS send 方法时
      super(webView);
      */
    }


    @Override
    public void onPageFinished(WebView view, String url) {
        //处理代码
        super.onPageFinished(view, url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        //处理代码
        return super.shouldOverrideUrlLoading(view, url);
    }





}
