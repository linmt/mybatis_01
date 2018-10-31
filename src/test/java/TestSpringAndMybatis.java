import com.lmt.entity.CostMapper;
import com.lmt.entity.CostSimple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 张洲徽 on 2018/10/31.
 */
public class TestSpringAndMybatis {
    public static void main(String[] args){
        String cfg = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(cfg);
        CostMapper dao=ac.getBean("CostMapperImpl",CostMapper.class);
        System.out.println(dao.getClass().getName());
        List<CostSimple> list=dao.findAllCostSimple();
        for (CostSimple c:list){
            System.out.println(c.getId()+"  "+c.getName());
        }
    }
}
