package edu.hubu.xiaomishop;

import edu.hubu.xiaomishop.mapper.TypeMapper;
import edu.hubu.xiaomishop.model.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author moonlan
 * date 2021/1/13 上午11:53
 */
@SuppressWarnings(value = "unused")
@SpringBootTest
public class TypeMapperTests {

    @Autowired
    TypeMapper mapper;

    @Test
    void update() {
        Type type = new Type();
        type.setTypeId("1");
        type.setTypeName("小米系列");
        mapper.updateByPrimaryKeySelective(type);
    }

}
