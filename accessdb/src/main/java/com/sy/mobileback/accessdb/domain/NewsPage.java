package com.sy.mobileback.accessdb.domain;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-28 17:09
 */
public class NewsPage {
    private String N_Id;
    /**
     * 标题
     */
    private String N_Title;
    /**
     * 发布时间
     */
    private String N_Date;

    public String getN_Id() {
        return N_Id;
    }

    public void setN_Id(String n_Id) {
        N_Id = n_Id;
    }

    public String getN_Title() {
        return N_Title;
    }

    public void setN_Title(String n_Title) {
        N_Title = n_Title;
    }

    public String getN_Date() {
        return N_Date;
    }

    public void setN_Date(String n_Date) {
        N_Date = n_Date;
    }
}
