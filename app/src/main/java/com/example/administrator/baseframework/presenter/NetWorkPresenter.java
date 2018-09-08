package com.example.administrator.baseframework.presenter;

import com.example.administrator.baseframework.base.BasePresenter;
import com.example.administrator.baseframework.model.NetWorkModel;
import com.example.administrator.baseframework.view.NetWorkView;

public class NetWorkPresenter extends BasePresenter<NetWorkView> {
    private NetWorkModel netWorkModel = new NetWorkModel();

    public void getData(){
        if (!isViewAttached()){
            return;
        }
        getView().showLoading();
        netWorkModel.getNetData("normal", new NetWorkModel.Callback<String>() {
            @Override
            public void onSuccess(String data) {
                if (isViewAttached()){
                    getView().showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()){
                    getView().showToast(msg);
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()){
                    getView().showErr();
                }
            }

            @Override
            public void onComplete() {
                if (isViewAttached()){
                    getView().hideLoading();
                }
            }
        });
    }
}
