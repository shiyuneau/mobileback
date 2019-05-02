package com.sy.mobileback.accessdb.domain;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-27 22:36
 */
public class AnalysisEntity {
    private String name;
    private Integer count;
    private Float percent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getPercent() {
        return percent;
    }

    public void setPercent(Float percent) {
        this.percent = percent;
    }
}
