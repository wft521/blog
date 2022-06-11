package com.lrm.service;

import com.lrm.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author wu
 * @date 2022-01-17 18:58
 */
public interface TypeService {
    //新增
    Type saveType(Type type);
    //查找
    Type getType(Long id);
    //分页 pageable获取数据所有信息
    Page<Type> listType(Pageable pageable);
    //改变
    Type updateType(Long id,Type type);
    //删除
    void deleteType(Long id);
    //通过名称查找
    Type getTypeByName(String name);

    //查询所有数据
    List<Type> listType();
    //为首页右侧分类做服务
    List<Type> listTypeTop(Integer size);



}
