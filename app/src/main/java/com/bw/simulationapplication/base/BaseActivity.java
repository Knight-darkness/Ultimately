package com.bw.simulationapplication.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutID());
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutID();
}
