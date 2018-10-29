import com.lmt.entity.Cost;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by 张洲徽 on 2018/10/29.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        SqlSession session=MyBatisUtil.getSqlSession();

        /*
        Dept dept = new Dept(60,"caigou","beijing");
        session.insert("addDept",dept);   //SqlMap.xml定义见上
        */
        //session.delete("deleteDept",10);
        //session.update("updateDept",dept);
/*
        Dept dept = (Dept)session.selectOne("findDeptById",10);
        System.out.println(dept.getDname());
*/
/*
        List<Dept> list = session.selectList("findAllDept");
        for(Dept d:list){
            System.out.println(d.getDname());
        }
        */
        Timestamp ts = Timestamp.valueOf("2018-09-23 20:03:48");
        Timestamp ts2 = Timestamp.valueOf("2019-09-23 20:03:48");
        Cost cost=new Cost(100,"包月",(long)123,1000.00,10.00,"1","包月很爽",ts,ts2,"1");
        session.insert("save",cost);
        /*
        List<Cost> list = session.selectList("findAll");
        for(Cost c:list){
            System.out.println(c.getCost_id()+c.getName());
        }
         */

        session.commit();
        session.close();
    }
}
