package com.wbg.tianyi_sj.utils;

import android.content.Context;

import com.wbg.tianyi_sj.R;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by WBG-016 on 2016/5/23.
 * 分享的工具类
 */
public class ShareUtil {
    /**
     * 分享
     *
     * @param context
     * @param imgUrl  预览图片的url
     * @param title   标题
     * @param content 内容主体
     * @param url     点击跳转的链接
     */
    public static void showShare(Context context, String imgUrl, String title, String content, String url) {
        ShareSDK.initSDK(context);

        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(title);
        // titleUrl是标题的网络链接，QQ空间使用
        oks.setTitleUrl(url);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(content);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        if (imgUrl != null) {
            oks.setImageUrl(imgUrl);
        }
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(url);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("[天易商户]");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(context.getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://sharesdk.cn");
        // 启动分享GUI
        oks.show(context);
    }
}
