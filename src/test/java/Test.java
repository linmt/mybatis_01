import com.lmt.entity.Dept;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * Created by 张洲徽 on 2018/10/29.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        SqlSession session=MyBatisUtil.getSqlSession();

        Dept dept = new Dept(60,"caigou","beijing");
        session.insert("addDept",dept);   //SqlMap.xml定义见上
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
        session.commit();
        session.close();
    }
}
