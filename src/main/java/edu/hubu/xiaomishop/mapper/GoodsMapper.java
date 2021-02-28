package edu.hubu.xiaomishop.mapper;

import edu.hubu.xiaomishop.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(String goodsId);

    int insertSelective(@Param("record") Goods record);

    Goods selectByPrimaryKey(String goodsId);

    int updateByPrimaryKeySelective(@Param("record") Goods record);

    List<Goods> selectList(@Param("from") int from, @Param("size") int size);

    List<Goods> selectListLike(@Param("from") int from, @Param("size") int size, @Param("goods") Goods goods);

    List<Goods> selectAll();

    List<Goods> selectListByType(@Param("from") int from, @Param("size") int size, @Param("typeId") String typeId);

    List<Goods> selectAllByType(@Param("typeId") String typeId);
}