package edu.hubu.xiaomishop.mapper;

import edu.hubu.xiaomishop.model.Goods;
import edu.hubu.xiaomishop.model.Manager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerMapper {
    int deleteByPrimaryKey(String mgrId);

    int insertSelective(@Param("record") Manager record);

    Manager selectByPrimaryKey(String mgrId);

    int updateByPrimaryKeySelective(@Param("record") Manager record);

    List<Manager> selectList(@Param("from") int from, @Param("size") int size);

    List<Manager> selectListLike(@Param("from") int from, @Param("size") int size, @Param("manager") Manager manager);

    Manager login(@Param("account") String account, @Param("pwd") String password);

    List<Manager> selectAll();
}