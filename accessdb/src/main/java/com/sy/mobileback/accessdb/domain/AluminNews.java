package com.sy.mobileback.accessdb.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-23 16:17
 */
public class AluminNews implements Serializable {
    /**
     *
     */
    private String guid;
    /**
     *
     */
    private String title;
    /**
     *
     */
    private Date createdtime;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }
}
