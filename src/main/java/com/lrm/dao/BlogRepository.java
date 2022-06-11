package com.lrm.dao;

import com.lrm.po.Blog;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wu
 * @date 2022-01-18 14:00
 */
public interface BlogRepository extends JpaRepository<Blog,Long> {
    @Query("select b from Blog b where b.recommend = true")
    List<Blog> findTop(Pageable pageable);

    //全局搜索
    @Query("select b from Blog b where b.title like ?1 or b.content like ?1 or b.description like ?1")
    Page<Blog> findByQuery(String query,Pageable pageable);


    @Transactional
    @Modifying
    @Query("update Blog b set b.views = b.views+1 where b.id = ?1")
    int updateViews(Long id);
    //查询博客的所有年份（归档）
    @Query(value = "select date_format(b.update_time,'%Y') as year from t_blog b GROUP BY year order by year desc",nativeQuery = true)
    List<String> findGroupYear();
    //查找年份对应的博客（归档）
    @Query("select b from Blog b where function('date_format',b.updateTime,'%Y') = ?1")
    List<Blog> findByYear(String year);

    Page<Blog> findAll(Specification<Blog> blogSpecification, Pageable pageable);
}
