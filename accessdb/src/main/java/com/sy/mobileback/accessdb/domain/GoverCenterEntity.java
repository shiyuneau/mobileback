package com.sy.mobileback.accessdb.domain;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-18 22:37
 */
public class GoverCenterEntity {
    private Integer Com_Id;
    /**
     * 父级ID
     */
    private Integer Com_Fid;
    /**
     * 分类名称
     */
    private String Com_Stye;

    public List<GoverCenterEntity> getChildren() {
        return children;
    }

    public void setChildren(List<GoverCenterEntity> children) {
        this.children = children;
    }

    private List<GoverCenterEntity> children;

    public Integer getCom_Id() {
        return Com_Id;
    }

    public void setCom_Id(Integer com_Id) {
        Com_Id = com_Id;
    }

    public Integer getCom_Fid() {
        return Com_Fid;
    }

    public void setCom_Fid(Integer com_Fid) {
        Com_Fid = com_Fid;
    }

    public String getCom_Stye() {
        return Com_Stye;
    }

    public void setCom_Stye(String com_Stye) {
        Com_Stye = com_Stye;
    }
}
