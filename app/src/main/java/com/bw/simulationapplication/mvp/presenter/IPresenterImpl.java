package com.bw.simulationapplication.mvp.presenter;

import com.bw.simulationapplication.base.BaseIPresenter;
import com.bw.simulationapplication.mvp.content.IConenter;
import com.bw.simulationapplication.mvp.model.IModelImpl;
import com.bw.simulationapplication.mvp.model.entity.CommodityEntity;

/**
 * @ProjectName: SimulationApplication
 * @Package: com.bw.simulationapplication.mvp.presenter
 * @ClassName: IPresenterImpl
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/1/11 11:44
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class IPresenterImpl extends BaseIPresenter<IConenter.IView> implements IConenter.IPresenter {

    private IModelImpl iModel;

    @Override
    protected void initModel() {
        iModel = new IModelImpl();
    }

    @Override
    public void onGetJson(String path) {
        iModel.onGetJson(path, new IConenter.IModel.ModelCallBack() {
            @Override
            public void onSuccess(CommodityEntity path) {
                iBaseView.onSuccess(path);
            }

            @Override
            public void onError(Throwable throwable) {
                iBaseView.onError(throwable);
            }
        });
    }
}
