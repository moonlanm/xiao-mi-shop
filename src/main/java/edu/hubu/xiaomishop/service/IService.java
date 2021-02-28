package edu.hubu.xiaomishop.service;


import java.util.List;

/**
 * @author moonlan
 * date 2021/1/12 上午11:20
 */
@SuppressWarnings(value = "unused")
public interface IService<T> {
    boolean deleteById(String id);

    boolean save(T t);

    T selectById(String id);

    T updateById(T t);

    List<T> selectList(int currentPage, int pageSize);

    List<T> selectListLike(int currentPage, int pageSize, T t);

    List<T> selectAll();
}
