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
        //主键值需要手动添加
        /*
        Timestamp ts = Timestamp.valueOf("2018-09-23 20:03:48");
        Timestamp ts2 = Timestamp.valueOf("2019-09-23 20:03:48");
        Cost cost=new Cost(100,"包月",(long)123,1000.00,10.00,"1","包月很爽",ts,ts2,"1");
        session.insert("save",cost);
        */
        //主键非自增，在xml文件中配置实现自增

        Timestamp ts = Timestamp.valueOf("2018-09-23 20:03:48");
        Timestamp ts2 = Timestamp.valueOf("2019-09-23 20:03:48");
        Cost cost=new Cost(null,"包月",(long)123,1000.00,10.00,"1","包月很爽",ts,ts2,"1");
        int cost_id=session.insert("save",cost);
        System.out.println("cost_id :" + cost_id); //  1
        System.out.println("新增数据的主键 :" + cost.getCost_id());

        //主键自增，在xml中配置
        /*
        Timestamp ts = Timestamp.valueOf("2018-09-23 20:03:48");
        Timestamp ts2 = Timestamp.valueOf("2019-09-23 20:03:48");
        Cost cost=new Cost(null,"包月",(long)123,1000.00,10.00,"1","包月很爽",ts,ts2,"1");
        session.insert("save",cost);
        */
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
