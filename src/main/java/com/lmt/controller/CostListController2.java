package com.lmt.controller;

import com.lmt.entity.Cost;
import com.lmt.entity.CostMapper;
import com.lmt.entity.CostSimple;
import com.lmt.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张洲徽 on 2018/10/31.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/cost")
public class CostListController2{
    //CostMapper dao=new CostMapperImpl();
    SqlSession session= MyBatisUtil.getSqlSession();
    CostMapper dao=session.getMapper(CostMapper.class);
    @RequestMapping("/list2.form")
    public String findCost(HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws Exception {
        int page;
        if(request.getParameter("page")==null){
            page=1;
        }else {
            page=Integer.parseInt(request.getParameter("page"));
        }
        int pageSize=3;

        int totalPage=dao.findTotalPage(pageSize);

        int nextMin = page*pageSize + 1;
        int lastMax = (page-1)*pageSize;
        Map fenyeMap=new HashMap<String, Integer>();
        fenyeMap.put("nextMin",nextMin);
        fenyeMap.put("lastMax",lastMax);
        List<Cost> costList=dao.findByPage((HashMap) fenyeMap);

        model.put("page", page);
        model.put("totalPage", totalPage);
        model.put("costs", costList);

        List<CostSimple> list=dao.findAllCostSimple();
        for(CostSimple cs:list){
            System.out.println(cs.getId()+"  "+cs.getName()+"  "+cs.getStatus()+"  "+cs.getCreateTime());
        }
        return "cost/cost_list2";
    }
}
