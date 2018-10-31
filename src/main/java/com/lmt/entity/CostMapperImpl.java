package com.lmt.entity;

import com.lmt.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 张洲徽 on 2018/10/31.
 */
//传统的做法是要实现CostMapper的，但是使用Mapper映射器则不用自己写实现类
public class CostMapperImpl implements CostMapper {
    SqlSession session= MyBatisUtil.getSqlSession();
    public void save(Cost cost) {
        session.insert("save",cost);
        session.commit();
        session.close();
    }

    public List<Cost> findAll() {
        List<Cost> list=session.selectList("findAll");
        return list;
    }

    public List<Cost> findByPage(HashMap map) {
        List<Cost> list=session.selectList("findByPage",map);
        return list;
    }

    public int findTotalPage(int pageSize) {
        int totalPage=session.selectOne("findTotalPage",pageSize);
        return totalPage;
    }

    public List<CostSimple> findAllCostSimple() {
        List<CostSimple> list=session.selectList("findAllCostSimple");
        return list;
    }
}
