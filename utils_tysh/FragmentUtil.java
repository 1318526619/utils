package com.wbg.tianyi_sj.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.wbg.tianyi_sj.base.BaseActivity;
import com.wbg.tianyi_sj.base.BaseFragment;

import java.util.List;

/**
 * Created by WBG-016 on 2016/5/17.
 * Fragment切换的工具类
 */
public class FragmentUtil {

    private static final String TAG = LogUtil.TAG;

    /**
     * 根据不同position切换fragment
     *
     * @param position
     * @param resId     framelayout的id
     * @param fragments List<Fragment>集合
     * @param activity
     */
    public static void showFragmentByPosition(int position, int resId, List<BaseFragment> fragments, FragmentActivity activity) {
        for (int i = 0; i < fragments.size(); i++) {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            Fragment fragment = fragments.get(i);
            if (i == position) {
                if (!fragment.isAdded()) {
                    transaction.add(resId, fragment);
                }
                transaction.show(fragment).commit();
            } else {
                transaction.hide(fragment).commit();
            }
        }
    }

}
