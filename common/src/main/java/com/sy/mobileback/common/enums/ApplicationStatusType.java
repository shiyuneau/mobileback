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
    HasApply(1),
    /**
     * 审批通过
     */
    ApplySuccess(2),

    /**
     * 审批被拒绝
     */
    ApplyFail(3),

    /**
     * 用户取消申请
     */
    UserCancelApply(4);

    private ApplicationStatusType(Integer type) {
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
