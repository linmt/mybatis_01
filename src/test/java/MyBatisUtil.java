import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by 张洲徽 on 2018/10/29.
 */
public class  MyBatisUtil{
    public static SqlSession getSqlSession(){
        String conf = "SqlMapConfig.xml";
        //Reader reader = Resources.getResourceAsReader(conf);
        InputStream is=MyBatisUtil.class.getClassLoader().getResourceAsStream(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(is);
        //创建Session
        SqlSession session = sf.openSession();
        return session;
    }
}
