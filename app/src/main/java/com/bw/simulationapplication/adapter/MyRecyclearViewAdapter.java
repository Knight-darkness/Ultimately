package com.bw.simulationapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.simulationapplication.R;
import com.bw.simulationapplication.mvp.model.entity.CommodityEntity;

import java.util.List;

/**
 * @ProjectName: SimulationApplication
 * @Package: com.bw.simulationapplication.adapter
 * @ClassName: MyRecyclearViewAdapter
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/1/11 14:13
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class MyRecyclearViewAdapter extends RecyclerView.Adapter<MyRecyclearViewAdapter.ViewHolder> {
    private Context context;
    private List<CommodityEntity.ResultBean> result;

    public MyRecyclearViewAdapter(Context context, List<CommodityEntity.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CommodityEntity.ResultBean resultBean = result.get(position);
        //获得的是名字
        String name = resultBean.getCommodityName();
        //获得的是照片地址
        String masterPic = resultBean.getMasterPic();
        holder.text.setText(name);
        Glide.with(context).load(masterPic).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            text = itemView.findViewById(R.id.item_text);
        }
    }
}
