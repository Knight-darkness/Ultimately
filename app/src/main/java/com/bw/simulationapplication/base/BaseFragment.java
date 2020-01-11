package com.bw.simulationapplication.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.simulationapplication.R;

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
public abstract class BaseFragment<p extends BaseIPresenter> extends Fragment {

    protected p presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(layoutID(), container, false);
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract p initPresenter();

    protected abstract int layoutID();

    protected abstract void initView(View view);

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
