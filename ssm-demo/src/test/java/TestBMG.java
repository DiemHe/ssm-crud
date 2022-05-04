import com.xjhqre.crud.mapper.DepartmentMapper;
import com.xjhqre.crud.pojo.Department;
import com.xjhqre.crud.pojo.DepartmentExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestBMG {
    @Test
    public void testMbg() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-congfig.xml");
        SqlSession sqlSession =new SqlSessionFactoryBuilder().build(is).openSession(true);
        DepartmentMapper departmentMapper =sqlSession.getMapper(DepartmentMapper.class);
        DepartmentExample departmentExample=new DepartmentExample();
        departmentExample.createCriteria();
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        System.out.println(departments);
    }

}
