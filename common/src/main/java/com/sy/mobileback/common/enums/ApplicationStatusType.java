package com.sy.mobileback.common.enums;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-06 11:26
 */
public enum ApplicationStatusType {
    /**
     * 已提交申请
     */
    HasApply(1,"待审核"),
    /**
     * 审批通过
     */
    ApplySuccess(2,"审批通过"),

    /**
     * 审批被拒绝
     */
    ApplyFail(3,"拒绝审批"),

    /**
     * 用户取消申请
     */
    UserCancelApply(4,"用户取消审批");

    private ApplicationStatusType(Integer type , String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * 类型定义
     */
    private Integer type;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
