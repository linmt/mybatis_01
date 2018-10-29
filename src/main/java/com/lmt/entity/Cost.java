package com.lmt.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 张洲徽 on 2018/10/23.
 */
public class Cost implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cost_id;
    private String name;
    private Long base_duration;
    private Double base_cost;
    private Double unit_cost;
    private String status;
    private String descr;
    private Timestamp creat_time;
    private Timestamp start_time;
    private String cost_type;

    public Cost() {
    }

    public Cost(Integer cost_id, String name, Long base_duration, Double base_cost, Double unit_cost, String status, String descr, Timestamp creat_time, Timestamp start_time, String cost_type) {
        this.cost_id = cost_id;
        this.name = name;
        this.base_duration = base_duration;
        this.base_cost = base_cost;
        this.unit_cost = unit_cost;
        this.status = status;
        this.descr = descr;
        this.creat_time = creat_time;
        this.start_time = start_time;
        this.cost_type = cost_type;
    }

    public Integer getCost_id() {
        return cost_id;
    }
    public void setCost_id(Integer costId) {
        cost_id = costId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getBase_duration() {
        return base_duration;
    }
    public void setBase_duration(Long baseDuration) {
        base_duration = baseDuration;
    }
    public Double getBase_cost() {
        return base_cost;
    }
    public void setBase_cost(Double baseCost) {
        base_cost = baseCost;
    }
    public Double getUnit_cost() {
        return unit_cost;
    }
    public void setUnit_cost(Double unitCost) {
        unit_cost = unitCost;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDescr() {
        return descr;
    }
    public void setDescr(String descr) {
        this.descr = descr;
    }
    public Timestamp getCreat_time() {
        return creat_time;
    }
    public void setCreat_time(Timestamp creatTime) {
        creat_time = creatTime;
    }
    public Timestamp getStart_time() {
        return start_time;
    }
    public void setStart_time(Timestamp startTime) {
        start_time = startTime;
    }
    public String getCost_type() {
        return cost_type;
    }
    public void setCost_type(String costType) {
        cost_type = costType;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    @Override
    public String toString() {
        return "Cost [base_cost=" + base_cost + ", base_duration="
                + base_duration + ", cost_id=" + cost_id + ", cost_type="
                + cost_type + ", creat_time=" + creat_time + ", descr=" + descr
                + ", name=" + name + ", start_time=" + start_time + ", status="
                + status + ", unit_cost=" + unit_cost + "]";
    }
}
