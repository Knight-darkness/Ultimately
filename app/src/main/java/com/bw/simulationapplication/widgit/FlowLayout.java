package com.bw.simulationapplication.widgit;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;

import com.bw.simulationapplication.R;

/**
 * @ProjectName: SimulationApplication
 * @Package: com.bw.simulationapplication.widgit
 * @ClassName: FlowLayout
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/1/11 14:46
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean bn, int l, int t, int r, int b) {
        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;
        int count = getChildCount();
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                View view = getChildAt(i);
                view.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView textView = (TextView) view;
                        flowLayoutClick.layoutClick(textView.getText().toString());
                    }
                });

                //从这里转折
                view.measure(0, 0);
                int width = view.getMeasuredWidth();
                int height = view.getMeasuredHeight();
                int widthPixels = getResources().getDisplayMetrics().widthPixels;
                right = left + width;
                if (right > widthPixels) {
                    left = 0;
                    top = bottom + 30;
                    right = left + width;
                }
                bottom = top + 30;
                view.layout(left, top, right, bottom);
                left = left + width + height;
            }
        }
    }

    public void AddChiledView(String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextColor(Color.BLACK);
        textView.setPadding(20, 0, 20, 0);
        textView.setBackgroundResource(R.drawable.flitemlayout);
        Addanimator(textView);
        addView(textView);
    }

    private void Addanimator(View textView){
        ViewPropertyAnimator animate = textView.animate();
        animate.rotationX(0).rotationY(1800);
        animate.setDuration(5000);
        animate.start();
    }

    public interface FlowLayoutClick {
        void layoutClick(String s);
    }

    public FlowLayoutClick flowLayoutClick;

    public void setFlowLayoutClick(FlowLayoutClick flowLayoutClick) {
        this.flowLayoutClick = flowLayoutClick;
    }
}
