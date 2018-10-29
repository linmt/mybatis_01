package com.lmt.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 张洲徽 on 2018/10/23.
 */
public class CostRowMapper implements RowMapper<Cost> {
    public Cost mapRow(ResultSet rs, int index) throws SQLException {
        Cost cost = new Cost();
        cost.setCost_id(rs.getInt("cost_id"));
        cost.setName(rs.getString("name"));
        cost.setBase_duration(rs.getLong("base_duration"));
        cost.setBase_cost(rs.getDouble("base_cost"));
        cost.setUnit_cost(rs.getDouble("unit_cost"));
        cost.setStatus(rs.getString("status"));
        cost.setDescr(rs.getString("descr"));
        cost.setCreat_time(rs.getTimestamp("creat_time"));
        cost.setStart_time(rs.getTimestamp("start_time"));
        cost.setCost_type(rs.getString("cost_type"));
        return cost;
    }
}
