package com.lmt.dao;

import com.lmt.entity.Cost;
import com.lmt.entity.CostRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 张洲徽 on 2018/10/23.
 */
@Repository
public class CostDao {
    @Resource
    private JdbcTemplate template;
    public List<Cost> findAll() {
        String sql="select * from cost";
        CostRowMapper rowMapper=new CostRowMapper();
        List<Cost> list=template.query(sql,rowMapper);
        return list;
    }

    public void save(Cost cost){
        if(cost == null){
            return;
        }
        String sql = "insert into cost values(cost_seq.nextval,?,?,?,?,'1',?,sysdate,null,?)";
        Object[] param={cost.getName(),cost.getBase_duration(),cost.getBase_cost(),cost.getUnit_cost(),
                        cost.getDescr(),cost.getCost_type()};
        template.update(sql,param);
    }
}
