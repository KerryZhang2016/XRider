package com.mtt.xrider.model.riding;

/**
 * Created by Kerry on 16/3/4.
 *
 * 周记录统计数据
 */
public class WeekData {

    /**
     * 骑行里程，km，2位小数
     * */
    private float mileage;
    /**
     * 骑行时间，h，1位小数
     * */
    private float time;

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
}
