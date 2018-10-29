package com.lmt.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张洲徽 on 2018/10/29.
 */
public interface CostMapper {
    void save(Cost cost);
    List<Cost> findAll();
    List<Cost> findByPage(ArrayList list);
    int findTotalPage(int pageSize);
}
