package com.sy.mobileback.common.enums;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-06 11:26
 */
public enum ApplicationStatusType {

    /**
     * 重新填写申请
     */
    ApplyRewrite(-1,"申请重新填写"),

    /**
     * 已提交申请，也代表 高校待审核
     */
    HasApply(1,"待审核"),
    /**
     * 高校审批通过，也代表教委待审核
     */
    SCHOOLApplySuccess(2,"高校审批通过既高校待审核"),

    /**
     * 高校拒绝审批
     */
    SCHOOLApplyFail(3,"高校拒绝审批"),
    /**

    /**
     * 用户取消申请
     */
    UserCancelApply(4,"用户取消审批"),

    /**
     * 教委审批通过
     */
    JWApplySuccess(5,"教委审批通过"),

    /**
     * 教委拒绝审批
     */
    JWApplyFail(6,"教委拒绝审批");


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
