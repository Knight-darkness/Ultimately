package com.bw.simulationapplication.mvp.view.fragment;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bw.simulationapplication.R;
import com.bw.simulationapplication.adapter.MyRecyclearViewAdapter;
import com.bw.simulationapplication.base.BaseFragment;
import com.bw.simulationapplication.mvp.content.IConenter;
import com.bw.simulationapplication.mvp.model.entity.CommodityEntity;
import com.bw.simulationapplication.mvp.presenter.IPresenterImpl;
import com.bw.simulationapplication.widgit.FlowLayout;

import java.net.URLEncoder;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<IPresenterImpl> implements IConenter.IView {

    private static final String TAG = "HomeFragment";
    private RecyclerView recyclerView;
    private FlowLayout flow;
    private EditText ed;
    private Button bt;

    @Override
    protected IPresenterImpl initPresenter() {
        return new IPresenterImpl();
    }

    @Override
    protected int layoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recylerView);
        flow = (FlowLayout) view.findViewById(R.id.flow);
        ed = (EditText) view.findViewById(R.id.info_edit);
        bt = (Button) view.findViewById(R.id.info_bt);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setOrientation(StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }

    @Override
    protected void initData() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sid = ed.getText().toString();
                if (sid.isEmpty()) {
                    Toast.makeText(getActivity(), "不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    String encode = URLEncoder.encode(sid);
                    String path = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=" + encode + "&page=1&count=4";
                    presenter.onGetJson(path);
                    flow.AddChiledView(sid);
                }
            }
        });
    }

    @Override
    public void onSuccess(CommodityEntity path) {
       /* for (CommodityEntity.ResultBean bean : path.getResult()) {
            String commodityName = bean.getCommodityName();
            flow.AddChiledView(commodityName);
        }*/
        Log.i(TAG, "onSuccess: " + path.getResult());
        List<CommodityEntity.ResultBean> result = path.getResult();
        recyclerView.setAdapter(new MyRecyclearViewAdapter(getActivity(), result));
        flow.setFlowLayoutClick(new FlowLayout.FlowLayoutClick() {
            @Override
            public void layoutClick(String s) {
               
            }
        });
    }

    @Override
    public void onError(Throwable throwable) {

    }
}
