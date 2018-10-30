package com.lmt.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 热带雨林 on 2018/10/30.
 */
public class CostSimple implements Serializable{
    private Integer id;
    private String name;
    private String status;
    private Timestamp createTime;

    public CostSimple() {
    }

    public CostSimple(Integer id, String name, String status, Timestamp createTime) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
