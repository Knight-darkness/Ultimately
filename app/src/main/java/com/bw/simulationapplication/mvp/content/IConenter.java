package com.bw.simulationapplication.mvp.content;

import com.bw.simulationapplication.base.IBaseView;
import com.bw.simulationapplication.mvp.model.entity.CommodityEntity;

/**
 * @ProjectName: SimulationApplication
 * @Package: com.bw.simulationapplication.mvp.content
 * @ClassName: IConenter
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/1/11 10:51
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public interface IConenter {
    interface IModel {
        void onGetJson(String path, ModelCallBack modelCallBack);

        interface ModelCallBack {
            void onSuccess(CommodityEntity path);

            void onError(Throwable throwable);
        }
    }

    interface IView extends IBaseView {
        void onSuccess(CommodityEntity path);

        void onError(Throwable throwable);

    }

    interface IPresenter {
        void onGetJson(String path);
    }

}
