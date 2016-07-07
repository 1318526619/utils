package com.wbg.tianyi_sj.utils;

import com.wbg.tianyi_sj.bean.ShangpingBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 对Shop数据集合进行排序
 * Created by dafengge on 16/3/3.
 */
public class SortArrayList {
    static ArrayList<ShangpingBean.Data> list;

    public SortArrayList(ArrayList<ShangpingBean.Data> list) {
        this.list = list;
    }
//
//
//
//    /**
//     * A～Z默认排序
//     */
//    public static void sortMingcheng(){

//        Collections.sort(list, new Comparator<ShangpingBean.Data>() {
//            @Override
//            public int compare(ShangpingBean.Data o1, ShangpingBean.Data o2) {
//                return (o1.getTitle().toLowerCase()).compareTo((o2.getTitle().toLowerCase()));
//            }
//        });
//    }
//
//    /**
//     * 综合评分排序
//     */
//    public static void sortPingfen(){
//
//        Collections.sort(list, new Comparator<ShopPaixu>() {
//            @Override
//            public int compare(ShopPaixu o1, ShopPaixu o2) {
//                return (int) (o2.getPingfen() - o1.getPingfen());
//            }
//        });
//    }
//
//    /**
//     * 提成收益排序
//     */
//    public static void sortTicheng(){
//        Collections.sort(list, new Comparator<ShopPaixu>() {
//            @Override
//            public int compare(ShopPaixu o1, ShopPaixu o2) {
//                return Integer.parseInt(o2.getTicheng())-Integer.parseInt(o1.getTicheng());
//            }
//        });
//    }
//
//    /**
//     * 交易数量排序
//     */
//    public static void sortShuliang(){
//        Collections.sort(list, new Comparator<ShopPaixu>() {
//            @Override
//            public int compare(ShopPaixu o1, ShopPaixu o2) {
//                return Integer.parseInt(o1.getShuliang())-Integer.parseInt(o2.getShuliang());
//            }
//        });
//    }
//
//    /**
//     * 价格高到低排序
//     */
//    public static void sortJiageDown(){
//        Collections.sort(list, new Comparator<ShopPaixu>() {
//            @Override
//            public int compare(ShopPaixu o1, ShopPaixu o2) {
//                return Integer.parseInt(o2.getJiage())-Integer.parseInt(o1.getJiage());
//            }
//        });
//    }
//
//    /**
//     * 价格低到高排序
//     */
//    public static void sortJiageUp(){
//        Collections.sort(list, new Comparator<ShopPaixu>() {
//            @Override
//            public int compare(ShopPaixu o1, ShopPaixu o2) {
//                return Integer.parseInt(o1.getJiage())-Integer.parseInt(o2.getJiage());
//            }
//        });
//    }

}
