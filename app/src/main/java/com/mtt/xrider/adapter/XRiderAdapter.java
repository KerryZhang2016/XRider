package com.mtt.xrider.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mtt.xrider.R;
import com.mtt.xrider.model.riding.SimpleRidingData;
import com.mtt.xrider.model.riding.WeekData;

/**
 * Created by Kerry on 16/3/4.
 */
public class XRiderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    // 两种类型
    private final int TYPE_ONE = 0;
    private final int TYPE_TWO = 1;

    private WeekData weekData;
    private SimpleRidingData simpleRidingData;

    public XRiderAdapter(Context context,WeekData weekData,SimpleRidingData simpleRidingData){
        this.context = context;
        this.weekData = weekData;
        this.simpleRidingData = simpleRidingData;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == TYPE_ONE){
            return TYPE_ONE;
        }
        if(position == TYPE_TWO){
            return TYPE_TWO;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_ONE){
            // 周总结
            return  new WeekDataViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.item_weekdata,parent,false));
        }

        if(viewType == TYPE_TWO){
            // 最近一次记录
            return  new SimpleRidingDataViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.item_simpleridingdata,parent,false));
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class WeekDataViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_mileage;
        private TextView tv_time;

        public WeekDataViewHolder(View itemView) {
            super(itemView);
            tv_mileage = (TextView) itemView.findViewById(R.id.tv_weekdata_mileage);
            tv_time = (TextView) itemView.findViewById(R.id.tv_weekdata_time);
        }
    }

    class SimpleRidingDataViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_date;
        private TextView tv_title;
        private TextView tv_mileage;
        private TextView tv_time;

        public SimpleRidingDataViewHolder(View itemView) {
            super(itemView);
            tv_date = (TextView) itemView.findViewById(R.id.tv_simpleridingdata_date);
            tv_title = (TextView) itemView.findViewById(R.id.tv_simpleridingdata_title);
            tv_mileage = (TextView) itemView.findViewById(R.id.tv_simpleridingdata_mileage);
            tv_time = (TextView) itemView.findViewById(R.id.tv_simpleridingdata_time);
        }
    }
}
