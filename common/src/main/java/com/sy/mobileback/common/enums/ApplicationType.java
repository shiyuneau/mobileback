package com.sy.mobileback.common.enums;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-06 11:26
 */
public enum ApplicationType {
    /**
     * 留学申请
     */
    STUDYABROAD(1),
    /**
     * 奖学金申请
     */
    SCHOLORSHIP(2);

    private ApplicationType(Integer type) {
        this.type = type;
    }

    /**
     * 类型定义
     */
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
