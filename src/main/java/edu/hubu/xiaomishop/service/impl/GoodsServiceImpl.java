package edu.hubu.xiaomishop.service.impl;

import edu.hubu.xiaomishop.mapper.GoodsMapper;
import edu.hubu.xiaomishop.model.Goods;
import edu.hubu.xiaomishop.service.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

/**
 * @author moonlan
 * date 2021/1/12 上午11:21
 */
@SuppressWarnings(value = "unused")
@Service
@Transactional
public class GoodsServiceImpl implements IService<Goods> {
    private final GoodsMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

    public GoodsServiceImpl(GoodsMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean deleteById(String id) {
        try {
            int delete = mapper.deleteByPrimaryKey(id);
            return delete > 0;
        } catch (Exception e) {
            logger.error("删除id = {}的商品失败，原因为{}", id, e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(Goods goods) {
        try {
            int insertSelective = mapper.insertSelective(goods);
            return insertSelective > 0;
        } catch (Exception e) {
            logger.error("保存商品失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Goods selectById(String id) {
        Goods goods;
        try {
            goods = mapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error("查询id = {}的商品失败，原因为{}", id, e.toString());
            throw new RuntimeException(e);
        }
        if (goods == null) {
            logger.error("id = " + id + "未找到");
            throw new RuntimeException("id = " + id + "未找到");
        }
        return goods;
    }

    @Override
    public Goods updateById(Goods goods) {
        try {
            mapper.updateByPrimaryKeySelective(goods);
            return selectById(goods.getGoodsId());
        } catch (Exception e) {
            logger.error("更新id = {}的商品失败，原因为{}", goods.getGoodsId(), e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Goods> selectList(int currentPage, int pageSize) {
        try {
            return mapper.selectList((currentPage - 1) * pageSize, pageSize);
        } catch (Exception e) {
            logger.error("查询商品失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Goods> selectListLike(int currentPage, int pageSize, Goods goods) {
        try {
            return mapper.selectListLike((currentPage - 1) * pageSize, pageSize, goods);
        } catch (Exception e) {
            logger.error("查询商品失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Goods> selectAll() {
        try {
            return mapper.selectAll();
        } catch (Exception e) {
            logger.error("查询商品失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }
    
    public List<Goods> selectListByType(int currentPage, int pageSize, String typeId) {
        try {
            return mapper.selectListByType((currentPage - 1) * pageSize, pageSize, typeId);
        } catch (Exception e) {
            logger.error("查询商品失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }

    public List<Goods> selectAllByType(String typeId) {
        try {
            return mapper.selectAllByType(typeId);
        } catch (Exception e) {
            logger.error("查询商品失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }
}
