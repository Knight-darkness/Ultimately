package com.bw.simulationapplication.mvp.model;

import android.util.Log;

import com.bw.simulationapplication.mvp.content.IConenter;
import com.bw.simulationapplication.mvp.model.entity.CommodityEntity;
import com.bw.simulationapplication.utils.VolleyUtils;
import com.google.gson.Gson;

/**
 * @ProjectName: SimulationApplication
 * @Package: com.bw.simulationapplication.mvp.model
 * @ClassName: IModelImpl
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/1/11 11:22
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class IModelImpl implements IConenter.IModel {
    private static final String TAG = "IModelImpl";
    @Override
    public void onGetJson(String path, final ModelCallBack modelCallBack) {
        VolleyUtils.getInstance().doGet(path, new VolleyUtils.VolleyCallBack() {
            @Override
            public void onGetDataSuccess(String path) {
                CommodityEntity commodityEntity = new Gson().fromJson(path, CommodityEntity.class);
                if (modelCallBack != null) {
                    Log.i(TAG, "onGetDataSuccess: "+commodityEntity.getMessage());
                    modelCallBack.onSuccess(commodityEntity);
                }
            }

            @Override
            public void onGetDataError(Throwable throwable) {
                if (throwable != null) {
                    modelCallBack.onError(throwable);
                }
            }
        });
    }
}
