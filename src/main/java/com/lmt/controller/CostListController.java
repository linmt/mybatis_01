package com.lmt.controller;

import com.lmt.entity.Cost;
import com.lmt.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张洲徽 on 2018/10/29.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/cost")
public class CostListController{
    SqlSession session= MyBatisUtil.getSqlSession();

    @RequestMapping("/list.form")
    public String findCost(HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws Exception {
        /*
        int page;
        if(request.getParameter("page")==null){
            page=1;
        }else {
            page=Integer.parseInt(request.getParameter("page"));
        }
        int pageSize=3;

        int totalPage=session.selectOne("findTotalPage",pageSize);
        List list=new ArrayList();
        list.add(page);
        list.add(pageSize);
        List<Cost> costList=session.selectList("findByPage",list);
        */
        List<Cost> costList=session.selectList("findAll");
        for(Cost c:costList){
            System.out.println(c.getCost_id()+c.getName());
        }
        //model.put("page", page);
        //model.put("totalPage", totalPage);
        model.put("costs", costList);
        return "cost/cost_list";
    }
}
