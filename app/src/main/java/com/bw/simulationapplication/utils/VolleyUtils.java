package com.bw.simulationapplication.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bw.simulationapplication.app.App;

import java.util.Map;

/**
 * @ProjectName: SimulationApplication
 * @Package: com.bw.simulationapplication.utils
 * @ClassName: ValleyUtils
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/1/11 10:35
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class VolleyUtils {
    private static VolleyUtils instance;
    private final RequestQueue requestQueue;

    private VolleyUtils() {
        requestQueue = Volley.newRequestQueue(App.getContext());
    }

    public static VolleyUtils getInstance() {
        //双重校验锁
        if (instance == null) {
            synchronized (VolleyUtils.class) {
                instance = new VolleyUtils();
            }
        }
        return instance;
    }

    //doget请求
    public void doGet(String path, final VolleyCallBack volleyCallBack) {
        StringRequest stringRequest = new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //注意判空
                if (response != null) {
                    volleyCallBack.onGetDataSuccess(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //判空
                if (error != null) {
                    volleyCallBack.onGetDataError(error);
                }
            }
        });
        requestQueue.add(stringRequest);
    }

    //dopost请求
    public void doPost(String path, final Map<String, String> map, final VolleyCallBack volleyCallBack) {
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    volleyCallBack.onGetDataSuccess(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error != null) {
                    volleyCallBack.onGetDataError(error);
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }


    //接口
    public interface VolleyCallBack {
        void onGetDataSuccess(String path);

        void onGetDataError(Throwable throwable);
    }


}
