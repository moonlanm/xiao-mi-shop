package edu.hubu.xiaomishop.service.impl;

import edu.hubu.xiaomishop.mapper.TypeMapper;
import edu.hubu.xiaomishop.model.Type;
import edu.hubu.xiaomishop.service.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moonlan
 * date 2021/1/12 上午11:23
 */
@SuppressWarnings(value = "unused")
@Service
public class TypeServiceImpl implements IService<Type> {

    private final TypeMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);

    public TypeServiceImpl(TypeMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean deleteById(String id) {
        try {
            int delete = mapper.deleteByPrimaryKey(id);
            return delete > 0;
        } catch (Exception e) {
            logger.error("删除id = {}的类型失败，原因为{}", id, e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(Type type) {
        try {
            int insertSelective = mapper.insertSelective(type);
            return insertSelective > 0;
        } catch (Exception e) {
            logger.error("保存类型失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Type selectById(String id) {
        Type type;
        try {
            type = mapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error("查询id = {}的类型失败，原因为{}", id, e.toString());
            throw new RuntimeException(e);
        }
        if (type == null) {
            logger.error("id = " + id + "未找到");
            throw new RuntimeException("id = " + id + "未找到");
        }
        return type;
    }

    @Override
    public Type updateById(Type type) {
        try {
            mapper.updateByPrimaryKeySelective(type);
            return selectById(type.getTypeId());
        } catch (Exception e) {
            logger.error("更新id = {}的类型失败，原因为{}", type.getTypeId(), e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Type> selectList(int currentPage, int pageSize) {
        try {
            return mapper.selectList((currentPage - 1) * pageSize, pageSize);
        } catch (Exception e) {
            logger.error("查询类型失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Type> selectListLike(int currentPage, int pageSize, Type type) {
        try {
            return mapper.selectList((currentPage - 1) * pageSize, pageSize);
        } catch (Exception e) {
            logger.error("查询类型失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Type> selectAll() {
        try {
            return mapper.selectAll();
        } catch (Exception e) {
            logger.error("查询类型失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }

    public Type selectByName(String name) {
        try {
            return mapper.selectByName(name);
        } catch (Exception e) {
            logger.error("查询类型失败，原因为{}", e.toString());
            throw new RuntimeException(e);
        }
    }
}