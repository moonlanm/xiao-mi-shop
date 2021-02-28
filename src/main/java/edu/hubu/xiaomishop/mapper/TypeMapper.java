package edu.hubu.xiaomishop.mapper;

import edu.hubu.xiaomishop.model.Goods;
import edu.hubu.xiaomishop.model.Type;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeMapper {
    int deleteByPrimaryKey(String typeId);

    int insertSelective(@Param("record") Type record);

    Type selectByPrimaryKey(String typeId);

    int updateByPrimaryKeySelective(@Param("record") Type record);

    List<Type> selectList(@Param("from") int from, @Param("size") int size);

    List<Type> selectListLike(@Param("from") int from, @Param("size") int size, @Param("type") Type type);

    Type selectByName(@Param("name") String name);

    List<Type> selectAll();
}