package com.bw.simulationapplication.base;

/**
 * @ProjectName: SimulationApplication
 * @Package: com.bw.simulationapplication.base
 * @ClassName: BaseIModel
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/1/11 11:35
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public abstract class BaseIPresenter<view> {
    protected view iBaseView;

    public BaseIPresenter() {
        initModel();
    }

    //初始化model
    protected abstract void initModel();

    //绑定视图
    public void attachView(view iBaseView) {
        this.iBaseView = iBaseView;
    }

    //解绑视图
    public void detachView() {
        if (iBaseView != null) {
            iBaseView = null;
        }
    }

}
