package edu.hubu.xiaomishop;

import edu.hubu.xiaomishop.mapper.ManagerMapper;
import edu.hubu.xiaomishop.model.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author moonlan
 * date 2021/1/12 下午2:52
 */
@SuppressWarnings(value = "unused")
@SpringBootTest
public class ManagerMapperTest {

    @Autowired
    public ManagerMapper mapper;

    @Test
    public void testInsert() {
        Manager manager = new Manager();
        manager.setMgrName("HelloWorld");
        manager.setMgrAccount("HelloWorld");
        manager.setMgrId("1111");
        manager.setMgrImg("HelloWorld");
        manager.setMgrTel("HelloWorld");
        manager.setMgrPwd("HelloWorld");
        mapper.insertSelective(manager);
    }

    @Test
    public void testUpdate() {
        Manager manager = mapper.selectByPrimaryKey("1111");
        manager.setMgrName("HHHHHHHHHHHHHHHHH");
        mapper.updateByPrimaryKeySelective(manager);
    }

    @Test
    public void testSelectOne() {
        Manager manager = mapper.selectByPrimaryKey("1111");
        System.out.println(manager);
    }

    @Test
    public void testSelectList() {
        List<Manager> managers = mapper.selectList(0, 5);
        managers.forEach(System.out::println);
    }

    @Test
    public void testSelectListLike() {
        Manager manager = new Manager();
        manager.setMgrName("H");
        List<Manager> managers = mapper.selectListLike(0, 5, manager);
        managers.forEach(System.out::println);
    }

    @Test
    public void testDelete() {
        int delete = mapper.deleteByPrimaryKey("1111");
        System.out.println(delete);
    }
    
}
