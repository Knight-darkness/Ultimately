package com.bw.simulationapplication.app;

import android.app.Application;
import android.content.Context;

/**
 * @ProjectName: SimulationApplication
 * @Package: com.bw.simulationapplication.app
 * @ClassName: App
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/1/11 10:43
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
