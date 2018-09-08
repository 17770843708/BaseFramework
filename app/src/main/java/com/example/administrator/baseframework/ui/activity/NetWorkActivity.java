package com.example.administrator.baseframework.ui.activity;

import android.os.Bundle;
import android.widget.Button;

import com.example.administrator.baseframework.R;
import com.example.administrator.baseframework.base.BaseActivity;
import com.example.administrator.baseframework.presenter.NetWorkPresenter;
import com.example.administrator.baseframework.view.NetWorkView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NetWorkActivity extends BaseActivity implements NetWorkView {
    NetWorkPresenter netWorkPresenter;
    @BindView(R.id.netWorkBtn)
    Button netWorkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);
        ButterKnife.bind(this);

        netWorkPresenter = new NetWorkPresenter();
        netWorkPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        netWorkPresenter.detachView();
    }

    @Override
    public void showData(String data) {
        showToast(data);
    }

    @OnClick(R.id.netWorkBtn)
    public void onViewClicked() {
        netWorkPresenter.getData();
    }
}
