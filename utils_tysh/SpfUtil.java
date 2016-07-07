package com.wbg.tianyi_sj.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

/**
 * SharePreferences的工具类
 */
public class SpfUtil {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public SpfUtil(Context context, String name) {
        sp = context.getSharedPreferences(name, context.MODE_PRIVATE);
        editor = sp.edit();
    }

    /**
     * 写入分销店id
     *
     * @param id
     */
    public void setStoreId(String id) {
        editor.putString("storeid", id);
        editor.commit();
    }

    public String getStoreId() {
        return sp.getString("storeid", null);
    }

    public void setId(String id) {
        editor.putString("id", id);
        editor.commit();
    }


    public String getId() {
        return sp.getString("id", null);
    }

    public void setToken(String token) {
        LogUtil.i("保存在本地的token:" + token);
        editor.putString("token", token);
        editor.commit();
    }

    public String getToken() {
        return sp.getString("token", null);
    }

    /**
     * 写入登陆状态
     *
     * @param login
     */
    public void setLogin(boolean login) {
        editor.putBoolean("isLogin", login);
        editor.commit();
    }

    /**
     * 是否已登录过
     *
     * @return
     */
    public boolean isLogin() {
        return sp.getBoolean("isLogin", false);
    }

    /**
     * 保存位置到本地
     *
     * @param location
     */
    public void setlocation(String location) {
        editor.putString("location", location);
        editor.commit();
    }

    /**
     * 从本地获取地址信息
     *
     * @return
     */
    public String getLocation() {
        return sp.getString("location", "");
    }


    public void setUsername(String name) {
        editor.putString("username", name);
        editor.commit();
    }

    public String getUsername() {
        return sp.getString("username", "");
    }

    public void setShopName(String name) {
        editor.putString("shopname", name);
        editor.commit();
    }

    public String getShopName() {
        return sp.getString("shopname", "天易商户");
    }

    public void setShopId(String id) {
        editor.putString("shopid", id);
        editor.commit();
    }

    public String getShopId() {
        return sp.getString("shopid", "");
    }

    /**
     * 保存用户头像地址
     *
     * @param url
     */
    public void setIconUrl(String url) {
        editor.putString("icon", url);
        editor.commit();
    }

    public String getIconUrl() {
        return sp.getString("icon", null);
    }

    public void removeStroeId() {
        LogUtil.i("remove storeid from SharedPreferences");
        editor.remove("storeid");
        editor.commit();
    }

    public void removeIsLogin() {
        LogUtil.i("remove loginstate from SharedPreferences");
        editor.remove("isLogin");
        editor.commit();
    }

    public void removeToken() {
        LogUtil.i("remove token from SharedPreferences");
        editor.remove("token");
        editor.commit();
    }

    public void removeId() {
        LogUtil.i("remove id from SharedPreferences");
        editor.remove("id");
        editor.commit();
    }


}
