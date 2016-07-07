package com.wbg.tianyi_sj.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public class MyImageCache implements ImageLoader.ImageCache {

	private static LruCache<String, Bitmap> cache;
	private static HashMap<String, SoftReference<Bitmap>> map;

	private MyImageCache() {
		// TODO Auto-generated constructor stub
	}

	public static MyImageCache mc;

	public static MyImageCache getInstance() {
		if (mc == null) {
			mc = new MyImageCache();
			cache = new LruCache<String, Bitmap>(10) {
				@Override
				protected int sizeOf(String key, Bitmap value) {
					// TODO Auto-generated method stub
					return 1;
				}

				@Override
				protected void entryRemoved(boolean evicted, String key,
											Bitmap oldValue, Bitmap newValue) {
					// TODO Auto-generated method stub
					super.entryRemoved(evicted, key, oldValue, newValue);
					map.put(key, new SoftReference<Bitmap>(oldValue));
				}
			};

			map = new HashMap<String, SoftReference<Bitmap>>();

		}

		return mc;

	}

	@Override
	public Bitmap getBitmap(String url) {
		// TODO Auto-generated method stub
		Bitmap result = cache.get(url);
		if (result == null) {
			SoftReference<Bitmap> soft = map.get(url);
			if (soft != null) {
				result = soft.get();
				return result;
			} else {
				return null;
			}
		}
		return result;
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		// TODO Auto-generated method stub
		cache.put(url, bitmap);
	}

}