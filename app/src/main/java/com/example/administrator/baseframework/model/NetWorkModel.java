package com.example.administrator.baseframework.model;

import android.os.Handler;

public class NetWorkModel {
    /**
     * 获取网络接口数据
     * @param param 请求参数
     * @param callback 数据回调接口
     */
    public void getNetData(final String param, final Callback<String> callback){
        // 利用postDelayed方法模拟网络请求数据的耗时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (param){
                    case "normal":
                        callback.onSuccess("根据参数"+param+"的请求网络数据成功");
                        break;
                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        callback.onError();
                        break;
                }
                callback.onComplete();
            }
        },2000);
    }

    public interface Callback<T> {
        /**
         * 数据请求成功
         * @param data 请求到的数据
         */
        void onSuccess(T data);
        /**
         *  使用网络API接口请求方式时，虽然已经请求成功但是由
         *  于{@code msg}的原因无法正常返回数据。
         */
        void onFailure(String msg);
        /**
         * 请求数据失败，指在请求网络API接口请求方式时，出现无法联网、
         * 缺少权限，内存泄露等原因导致无法连接到请求数据源。
         */
        void onError();
        /**
         * 当请求数据结束时，无论请求结果是成功，失败或是抛出异常都会执行此方法给用户做处理，通常做网络
         * 请求时可以在此处隐藏“正在加载”的等待控件
         */
        void onComplete();
    }
}
