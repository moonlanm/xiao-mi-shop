package edu.hubu.xiaomishop;

import edu.hubu.xiaomishop.mapper.GoodsMapper;
import edu.hubu.xiaomishop.mapper.ManagerMapper;
import edu.hubu.xiaomishop.mapper.TypeMapper;
import edu.hubu.xiaomishop.model.Goods;
import edu.hubu.xiaomishop.model.Manager;
import edu.hubu.xiaomishop.model.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.net.URL;
import java.util.List;

@SpringBootTest
class XiaoMiShopApplicationTests {

    @Autowired TypeMapper typeMapper;

    @Autowired ManagerMapper managerMapper;

    @Autowired GoodsMapper goodsMapper;


    @Test
    void contextLoads() {
        Type type = new Type();
        type.setTypeName("a");
        List<Type> types = typeMapper.selectListLike(0, 5, type);
        types.forEach(System.out::println);
    }

    @Test
    void test2() {
        List<Type> types = typeMapper.selectList(0, 5);
        System.out.println(types);
    }

    @Test
    void test3() {
        List<Manager> managers = managerMapper.selectList(0, 5);
        managers.forEach(System.out::println);
    }

    @Test
    void test4() {
        Manager manager = new Manager();
        manager.setMgrName("a");
        List<Manager> managers = managerMapper.selectListLike(0, 5, manager);
        managers.forEach(System.out::println);
    }

    @Test
    void test5() {
        Goods goods = new Goods();
        goods.setGoodsName("10");
        List<Goods> list = goodsMapper.selectListLike(0, 5, goods);
        list.forEach(System.out::println);
    }

    @Test
    void test6() {
        URL url = getClass().getResource("/");
        System.out.println(url.getPath());
    }

    @Test
    void test7() {
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }
}
