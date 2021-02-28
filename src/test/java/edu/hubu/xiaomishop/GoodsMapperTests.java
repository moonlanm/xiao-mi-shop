package edu.hubu.xiaomishop;

import edu.hubu.xiaomishop.mapper.GoodsMapper;
import edu.hubu.xiaomishop.model.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author moonlan
 * date 2021/1/12 下午2:26
 */
@SuppressWarnings(value = "unused")
@SpringBootTest
public class GoodsMapperTests {

    @Autowired
    private GoodsMapper mapper;

    @Test
    public void testInsert() {
        Goods goods = new Goods();
        goods.setGoodsName("HelloWorld");
        goods.setGoodsDesc("HelloWorld");
        goods.setGoodsDetail("HelloWorld");
        goods.setGoodsImg("HelloWorld");
        goods.setGoodsNum(10);
        goods.setGoodsPrice(100.0);
        goods.setGoodsTypeId("1");
        goods.setGoodsId("2");
        int i = mapper.insertSelective(goods);
        System.out.println(i);
    }

    @Test
    public void testUpdate() {
        Goods goods = mapper.selectByPrimaryKey("2");
        goods.setGoodsName("HHHHHHHHHHHHH");
        int update = mapper.updateByPrimaryKeySelective(goods);
        System.out.println(update);
    }

    @Test
    public void testSelectList() {
        List<Goods> goods = mapper.selectList(0, 5);
        goods.forEach(System.out::println);
    }

    @Test
    public void testSelectOne() {
        Goods goods = mapper.selectByPrimaryKey("1");
        System.out.println(goods);
    }
    
    @Test
    public void testSelectListLike() {
        Goods goods1 = new Goods();
        goods1.setGoodsName("H");
        List<Goods> goods = mapper.selectListLike(0, 5, goods1);
        goods.forEach(System.out::println);
    }
    
    @Test
    public void testDelete() {
        int delete = mapper.deleteByPrimaryKey("2");
        System.out.println(delete);
    }
    
}
