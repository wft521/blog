package com.lrm.dao;

import com.lrm.po.Tag;
import com.lrm.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author wu
 * @date 2022-01-18 11:49
 */
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
