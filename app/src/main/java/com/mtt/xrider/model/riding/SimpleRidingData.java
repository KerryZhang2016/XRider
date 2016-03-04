package com.mtt.xrider.model.riding;

/**
 * Created by Kerry on 16/3/4.
 *
 * 单次骑行简单数据统计
 */
public class SimpleRidingData {

    private String imgUrl;// 轨迹概要图地址

    private String date;// 日期（YYYY-MM-DD）

    private String title;// 标题:晨间骑行、早上骑行、午后骑行、下午骑行、傍晚骑行和夜晚骑行

    private float mileage;// 里程，km，2位小数

    private float time;// 时间，h，1位小数

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
