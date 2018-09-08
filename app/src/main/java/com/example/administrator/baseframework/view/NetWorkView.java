package com.example.administrator.baseframework.view;

import com.example.administrator.baseframework.base.BaseView;

public interface NetWorkView extends BaseView {
    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(String data);
}
